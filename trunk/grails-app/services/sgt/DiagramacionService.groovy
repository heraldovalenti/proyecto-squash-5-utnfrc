package sgt

import java.util.Calendar;

import grails.validation.ValidationException
import logica.CalculosTorneo
import logica.Diagramacion
import logica.HorarioCanchaPartido

import org.hibernate.Criteria
import org.hibernate.criterion.Restrictions

import sgt.exceptions.DiagramacionException
import sgt.exceptions.TorneoNotFoundException

class DiagramacionService {
	
	static transactional = true
	
	def sessionFactory
	
	def generarPartidosPrimeraRonda(DetalleTorneo torneo) {
		def inscripcionesDetalleTorneo = InscripcionTorneo.createCriteria().list() {
			eq("detalleTorneo", torneo)
			and {
				eq("estado", "Vinculada")
			}
		}
		List<logica.Jugador> jugadores = new ArrayList<logica.Jugador>() 	
		for (InscripcionTorneo inscripcion : inscripcionesDetalleTorneo) {
			logica.Jugador jugador = new logica.Jugador()
			jugador.id = inscripcion.usuario.jugador.id
			jugador.pos = inscripcion.usuario.jugador.getPosicionRankingCategoria(torneo.categoria)
			jugadores.add(jugador)
		}
		logica.Jugador[] aux = jugadores.toArray()
		Set<logica.Partido> primeraRonda = CalculosTorneo.generarPrimeraRonda(aux)
		for(logica.Partido partido : primeraRonda) {
			Usuario jugador1 = Usuario.findByJugador(Jugador.get(partido.jugador1.id))
			Usuario jugador2 = (partido.directo) ? null : Usuario.findByJugador(Jugador.get(partido.jugador2.id))
			Torneo t = torneo.torneo
			Integer ordenPartido = partido.numero
			Partido p = new Partido(jugador1: jugador1, jugador2: jugador2, 
				torneo: t, ordenPartido: ordenPartido, categoria: torneo.categoria)
			p.crear()
			p.save(failOnError: true)
		}
	}
	
	def generarRondasSiguientes(DetalleTorneo detalle) {
		def partidos = Partido.createCriteria().list() {
			eq("torneo", detalle.torneo)
			and {
				eq("categoria", detalle.categoria)
			}
			order("ordenPartido", "asc")
		}
		generarPartidosSiguientes(partidos, partidos.size())
	}
	
	private void generarPartidosSiguientes(List<Partido> partidos, int siguienteOrden) {
		if (partidos.size() <= 1) return
		Torneo t = partidos[0].torneo
		Categoria c = partidos[0].categoria
		List<Partido> partidosSiguientes = new ArrayList()
		for(int i = 0; i < partidos.size(); i += 2) {
			Partido p1 = partidos[i]
			Partido p2 = partidos[i + 1]
			Partido partidoSiguiente = new Partido(torneo: t, categoria: c, ordenPartido: siguienteOrden)
			partidoSiguiente.crear()
			partidoSiguiente.save(failOnError: true)
			partidosSiguientes.add(partidoSiguiente)
			siguienteOrden++
			p1.siguientePartido = partidoSiguiente
			p2.siguientePartido = partidoSiguiente
			p1.save(failOnError: true)
			p2.save(failOnError: true)
		}
		generarPartidosSiguientes(partidosSiguientes, siguienteOrden)
	}
	
	def finalizarPartidosSingles(Torneo t) {
		def partidosSingle = Partido.createCriteria().list {
			eq("torneo", t)
			and {
				isNotNull("jugador1")
				isNull("jugador2")
			}
		}
		for (p in partidosSingle) {
			ResultadoPartido resultado = new ResultadoPartido(ganador: p.jugador1, partido: p)
			p.resultado = resultado
			p.finalizar()
			Partido siguiente = p.siguientePartido
			if (siguiente) {
				if (!siguiente.jugador1) siguiente.jugador1 = p.jugador1
				else siguiente.jugador2 = p.jugador1
				siguiente.save(failOnError: true)
			}
			resultado.save(failOnError: true)
			p.save(failOnError: true)
		}
	}
	
	def generarDiagramacion(Long id)
		throws TorneoNotFoundException, DiagramacionException, ValidationException {
		Torneo torneo = getTorneo(id)
		if (!torneo.esDiagramable()) {
			throw new DiagramacionException(DiagramacionException.DIAGRAMACION_NO_PERMITIDA)
		}
		if (!torneo.clubAsignado()) {
			throw new DiagramacionException(DiagramacionException.TORNEO_SIN_CLUB)
		}
		if (torneo.club.cantidadCanchas() == 0) {
			throw new DiagramacionException(DiagramacionException.CLUB_SIN_CANCHAS)
		}
		if (torneo.getTotalInscriptos() == 0) {
			throw new DiagramacionException(DiagramacionException.TORNEO_SIN_INSCRIPTOS)
		}
		if (!torneo.partidosGenerados()) {
			for (detalle in torneo.detalles) {
				if (detalle.cantidadInscriptos() > 0) {
					generarPartidosPrimeraRonda(detalle)
					generarRondasSiguientes(detalle)
				}
			}
			//finalizar partidos y adelantar jugadores
			finalizarPartidosSingles(torneo)
			//estado torneo a diagramado
			torneo.diagramar()
			torneo.save(failOnError: true)
			return true
		}
	}
	
	def saveDiagramacion(List<Partido> diagramacion) throws ValidationException {
		for (p in diagramacion) {
			p.save(failOnError: true)
		}
	}
	
	def generarHorarios(Long id, List<Partido> partidos, Date inicioDiagramacion, Date finDiagramacion) 
		throws TorneoNotFoundException, DiagramacionException {
		Torneo t = getTorneo(id)
		if (!inicioDiagramacion || !finDiagramacion 
			|| inicioDiagramacion.before(t.fechaInicioTorneo) || finDiagramacion.after(t.fechaFinTorneo)
			|| inicioDiagramacion.after(finDiagramacion) || inicioDiagramacion.equals(finDiagramacion) ) {
			throw new DiagramacionException(DiagramacionException.FECHAS_DIAGRAMACION_INVALIDAS)
		}
		if (partidos.isEmpty()) {
			throw new DiagramacionException(DiagramacionException.SIN_PARTIDOS_SELECCIONADOS)
		}
		int diaSemanalInicioDiagramacion = diaSemanal(inicioDiagramacion)
		int duracionDiagramacion = duracionDiagramacion(inicioDiagramacion, finDiagramacion)
		int horasDiagramacion = 16
		
		Date fechaInicioDiagramacion = inicioDiagramacion
		Diagramacion d = new Diagramacion()
		logica.Partido[] _partidos = new logica.Partido[partidos.size()]
		for (int i = 0; i < partidos.size(); i++) {
			Partido p = partidos[i]
			Categoria c = p.categoria
			logica.Jugador _jugador1 = new logica.Jugador()
			logica.Jugador _jugador2 = new logica.Jugador()
			boolean[][] disponibilidadJugador1 = cargarHorarios(p.jugador1.jugador)
			boolean[][] disponibilidadJugador2 = cargarHorarios(p.jugador2.jugador)
			logica.DisponibilidadHoraria _disponibilidadJugador1 = 
				d.cargarHorarioDisponibilidad(_jugador1, disponibilidadJugador1, 
				horasDiagramacion, duracionDiagramacion, diaSemanalInicioDiagramacion)
			logica.DisponibilidadHoraria _disponibilidadJugador2 = 
				d.cargarHorarioDisponibilidad(_jugador2, disponibilidadJugador2, 
				horasDiagramacion, duracionDiagramacion, diaSemanalInicioDiagramacion)
			d.cargarJugador(_jugador1, _disponibilidadJugador1, p.jugador1.jugador.getPosicionRankingCategoria(c))
			d.cargarJugador(_jugador2, _disponibilidadJugador2, p.jugador2.jugador.getPosicionRankingCategoria(c))
			logica.Partido _partido = d.cargarPartido(_jugador1, _jugador2)
			_partido.id = p.id
			_jugador1.id = p.jugador1.id
			_jugador2.id = p.jugador2.id
			_partidos[i] = _partido
		}
		Club club = t.club
		def canchas = club.canchas
		logica.Cancha[] _canchas = new logica.Cancha[canchas.size()]
		int i = 0
		for (cancha in canchas) {
			boolean[][] disponibilidadCancha = cargarHorarios(cancha)
			logica.Cancha _cancha = new logica.Cancha()
			logica.DisponibilidadHoraria _disponibilidadCancha = 
				d.cargarHorarioDisponibilidad(_cancha, disponibilidadCancha, 
				horasDiagramacion, duracionDiagramacion, diaSemanalInicioDiagramacion)
			d.cargarCancha(_cancha, _disponibilidadCancha)
			_cancha.id = cancha.id
			_canchas[i] = _cancha
			i++
		}
		logica.Club _club = d.cargarClub(_canchas)
		ArrayList<logica.HorarioCanchaPartido>[][] _diagramacion = 
			d.generarDiagramacion(horasDiagramacion, duracionDiagramacion, _club, _partidos)
		int k = 0, j = 0
		for (ArrayList<logica.HorarioCanchaPartido>[] a : _diagramacion) {
			for (ArrayList<logica.HorarioCanchaPartido> b : a) {
				for (logica.HorarioCanchaPartido c : b) {
					Partido partido = Partido.get(c.partido.id)
					Cancha cancha = Cancha.get(c.cancha.id)
					Calendar fecha = Calendar.getInstance()
					fecha.setTime(fechaInicioDiagramacion)
					fecha.add(Calendar.DATE, c.diaSemana)
					String horaDesde = ( c.horaInicio + 8 ) + ""
					String horaHasta = ( c.horaInicio + 9 ) + ""
					def solapamiento = Partido.createCriteria().list {
						eq("torneo", t)
						and {
							eq("cancha", cancha)
							eq("fecha", fecha.getTime())
							eq("horaDesde", horaDesde)
							eq("horaHasta", horaHasta)
						}
					}
					if (!solapamiento.isEmpty()) continue
					partido.horaDesde = horaDesde
					partido.horaHasta = horaHasta
					partido.cancha = cancha
					partido.fecha = fecha.getTime()
					partido.save(failOnError: true)
				}
				if (j == 6) j = -1
				j++
			}
			k++
		}
	}
		
	public int duracionDiagramacion(Date inicio, Date fin) {
		int diff = 0
		Calendar c1 = Calendar.getInstance()
		Calendar c2 = Calendar.getInstance()
		c1.setTime(inicio)
		c2.setTime(fin)
		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
			diff = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR)
		} else {
			int year = c2.get(Calendar.YEAR)
			int diasInicio = c1.get(Calendar.DAY_OF_YEAR)
			int diasFin = c2.get(Calendar.DAY_OF_YEAR)
			if ( (year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0) ) {
				diasFin += 366
			} else {
				diasFin += 365
			}
			diff = diasFin - diasInicio
		}
		if (diff > 7) diff = 7
		return diff	
	}
		
	public int diaSemanal(Date fecha) {
		Calendar util = Calendar.getInstance()
		util.setTime(fecha)
		int diaSemanal = util.get(Calendar.DAY_OF_WEEK)
		if (diaSemanal == Calendar.MONDAY) return 0
		if (diaSemanal == Calendar.TUESDAY) return 1
		if (diaSemanal == Calendar.WEDNESDAY) return 2
		if (diaSemanal == Calendar.THURSDAY) return 3
		if (diaSemanal == Calendar.FRIDAY) return 4
		if (diaSemanal == Calendar.SATURDAY) return 5
		return 6
	}
	
	private boolean[][] cargarHorarios(def jugador_o_cancha) {
		boolean[][] res = new boolean[16][7]
		if (!jugador_o_cancha.disponibilidad || jugador_o_cancha.disponibilidad.detalles.size() == 0) {
			boolean condicion = jugador_o_cancha instanceof Jugador
			for (boolean[] b : res) {
				Arrays.fill(b, condicion);
			}
		} else {
			for(DetalleDisponibilidad d : jugador_o_cancha.disponibilidad.detalles) {
				int hora = d.hora - 8
				int dia = 0;
				if (d.dia.equals("martes")) dia = 1
				else if (d.dia.equals("miercoles")) dia = 2
				else if (d.dia.equals("jueves")) dia = 3
				else if (d.dia.equals("viernes")) dia = 4
				else if (d.dia.equals("sabado")) dia = 5
				else if (d.dia.equals("domingo")) dia = 6
				res[hora][dia] = true
			}
		}
		return res
	}
	
	def listarPartidosTorneo(Long id, def _params) 
		throws TorneoNotFoundException, DiagramacionException, ValidationException {
		Torneo torneo = getTorneo(id)
		def sess = sessionFactory.currentSession
		Criteria c = sess.createCriteria(Partido.class)
		c.add(Restrictions.eq("torneo", torneo))
		c.add(Restrictions.ne("estado", "Finalizado"))
		c.add(Restrictions.isNotNull("jugador1"))
		c.add(Restrictions.isNotNull("jugador2"))
		if (!_params.incluirDiagramados) {
			c.add(Restrictions.isNull("fecha"))
			c.add(Restrictions.isNull("horaDesde"))
			c.add(Restrictions.isNull("horaHasta"))
		}
		if (_params.categoria) c.add(Restrictions.eq("categoria", Categoria.get(_params.categoria)))
		def res = c.list()
		if (_params.ronda) {
			Integer ronda = Integer.parseInt(_params.ronda)
			ArrayList aux = new ArrayList(res)
			for (p in aux) {
				if (p.rondaPartido() != ronda) res.remove(p)
			}
		}
		return res
	}
		
	def getTorneo(Long id) throws TorneoNotFoundException {
		Torneo torneo = Torneo.get(id)
		if (!torneo) {
			throw new TorneoNotFoundException()
		}
		return torneo
	}
	
	def getCategoriasTorneo(Long id) throws TorneoNotFoundException, DiagramacionException {
		Torneo torneo = Torneo.get(id)
		if (torneo.detalles.isEmpty()) {
			throw new DiagramacionException(DiagramacionException.TORNEO_SIN_CATEGORIAS)
		}
		return torneo.detalles.categoria
	}
	
	def getRondasTorneo(Long id) throws TorneoNotFoundException {
		Torneo torneo = Torneo.get(id)
		def partidos = Partido.createCriteria().list {
			eq("torneo", torneo)
		}
		Map<Integer,String> rondas = new HashMap<Integer,String>()
		for (p in partidos) {
			rondas.put(p.rondaPartido(), p.rondaPartidoString())
		}
		List<String> values = new ArrayList<String>()
		List<Integer> keys = rondas.keySet().asList()
		Collections.sort(keys)
		List<String> res = new ArrayList()
		for (k in keys) {
			values.add(rondas.get(k))
		}
		return [keys: keys, values: values]
	}
}