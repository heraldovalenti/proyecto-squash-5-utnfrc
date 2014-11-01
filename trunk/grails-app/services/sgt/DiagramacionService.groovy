package sgt

import java.util.ArrayList;

import grails.validation.ValidationException
import logica.CalculosTorneo
import logica.Diagramacion
import logica.HorarioCanchaPartido;
import sgt.exceptions.DiagramacionException
import sgt.exceptions.TorneoNotFoundException

class DiagramacionService {
	
	static transactional = true
	
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
		generarPartidosSiguientes(partidos)
	}
	
	private void generarPartidosSiguientes(List<Partido> partidos) {
		if (partidos.size() <= 1) return
		Torneo t = partidos[0].torneo
		Categoria c = partidos[0].categoria
		int siguienteOrden = partidos.size() + 1
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
		generarPartidosSiguientes(partidosSiguientes)
	}
	
	Torneo generarDiagramacion(Long id)
		throws TorneoNotFoundException, DiagramacionException, ValidationException {
		Torneo torneo = Torneo.get(id)
		if (!torneo) {
			throw new TorneoNotFoundException()
		}
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
		if (!torneo.diagramado()) {
			for (detalle in torneo.detalles) {
				if (detalle.cantidadInscriptos() > 0) {
					generarPartidosPrimeraRonda(detalle)
					generarRondasSiguientes(detalle)
				}
			}
			//finalizar partidos y adelantar jugadores
			finalizarPartidosSingles(torneo)
			//generar horarios
			generarHorarios(torneo)
			torneo.diagramar()
			torneo.save(failOnError: true)
		}
		return torneo
	}
	
	def saveDiagramacion(List<Partido> diagramacion) throws ValidationException {
		for (p in diagramacion) {
			p.save(failOnError: true)
		}
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
	
	def generarHorarios(Torneo t) {
		Date fechaInicioDiagramacion = t.fechaInicioTorneo
		Diagramacion d = new Diagramacion()
		def partidos = Partido.createCriteria().list {
			eq("torneo", t)
			and {
				isNotNull("jugador1")
				isNotNull("jugador2")
			}
		}
		logica.Partido[] _partidos = new logica.Partido[partidos.size()]
		for (int i = 0; i < partidos.size(); i++) {
			Partido p = partidos[i]
			Categoria c = p.categoria
			logica.Jugador _jugador1 = new logica.Jugador()
			logica.Jugador _jugador2 = new logica.Jugador()
			boolean[][] disponibilidadJugador1 = cargarHorarios(p.jugador1.jugador)
			boolean[][] disponibilidadJugador2 = cargarHorarios(p.jugador2.jugador)
			//el "7" deberia calcularse de acuerdo a la cantidad de partidos a diagramarse y canchas disponibles
			//ejemplo: 2 canchas, 10 partidos : 1 dia
			logica.DisponibilidadHoraria _disponibilidadJugador1 = d.cargarHorarioDisponibilidad(_jugador1, disponibilidadJugador1, 16, 7, 0)
			logica.DisponibilidadHoraria _disponibilidadJugador2 = d.cargarHorarioDisponibilidad(_jugador2, disponibilidadJugador1, 16, 7, 0)
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
			logica.DisponibilidadHoraria _disponibilidadCancha = d.cargarHorarioDisponibilidad(_cancha, disponibilidadCancha, 16, 7, 0)
			d.cargarCancha(_cancha, _disponibilidadCancha)
			_cancha.id = cancha.id
			_canchas[i] = _cancha
			i++
		}
		logica.Club _club = d.cargarClub(_canchas)
		ArrayList<logica.HorarioCanchaPartido>[][] _diagramacion = d.generarDiagramacion(16, 7, _club, _partidos)
		int k = 0, j = 0
		for (ArrayList<logica.HorarioCanchaPartido>[] a : _diagramacion) {
			for (ArrayList<logica.HorarioCanchaPartido> b : a) {
				println "_diagramacion.length["+k+"]["+j+"].size()="+_diagramacion[k][j].size()
				for (logica.HorarioCanchaPartido c : b) {
					Partido partido = Partido.get(c.partido.id)
					Cancha cancha = Cancha.get(c.cancha.id)
					partido.horaDesde = c.horaInicio + 8
					partido.horaHasta = c.horaInicio + 9
					partido.cancha = cancha
					Calendar fecha = Calendar.getInstance()
					fecha.setTime(fechaInicioDiagramacion)
					fecha.add(Calendar.DATE, c.diaSemana)
					partido.fecha = fecha.getTime()
					partido.save(failOnError: true)
					println "partido="+c.partido.id
					println "cancha="+c.cancha.id
					println "hora="+c.horaInicio
					println "dia="+c.diaSemana
					println "-------------"
				}
				j = (j == 6) ? 0 : j++
			}
			k++
		}
		
	}
	
	private boolean[][] cargarHorarios(def jugador_o_cancha) {
		boolean[][] res = new boolean[16][7]
		if (!jugador_o_cancha.disponibilidad) {
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
}