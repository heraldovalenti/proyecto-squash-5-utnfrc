package sgt

import grails.validation.ValidationException
import logica.CalculosTorneo
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
				torneo: t, ordenPartido: ordenPartido, estado: "Creado", categoria: torneo.categoria)
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
		String e = "Creado"
		int siguienteOrden = partidos.size() + 1
		List<Partido> partidosSiguientes = new ArrayList()
		for(int i = 0; i < partidos.size(); i += 2) {
			Partido p1 = partidos[i]
			Partido p2 = partidos[i + 1]
			Partido partidoSiguiente = new Partido(torneo: t, estado: e, categoria: c, ordenPartido: siguienteOrden)
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
					//finalizar partidos y adelantar jugadores
					//generar horarios
				}
			}
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
}