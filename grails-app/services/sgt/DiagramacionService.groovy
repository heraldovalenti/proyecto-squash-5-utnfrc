package sgt

import java.util.Comparator;

import logica.CalculosTorneo

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
		/*Collections.sort(jugadores, new Comparator<logica.Jugador>() {
			@Override
			int compare(logica.Jugador j1, logica.Jugador j2) {
				return ( j1.pos - j2.pos)
			}
		})
		for (int i = 0; i < jugadores.size() && jugadores[i].pos > 0; i++) {
			jugadores[i].pos = (i + 1)
		}*/
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
	
}
