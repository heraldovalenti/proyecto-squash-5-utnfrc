package sgt

import grails.validation.ValidationException

import org.hibernate.criterion.CriteriaSpecification

import sgt.exceptions.RankingException
import sgt.exceptions.TorneoNotFoundException

class RankingService {
	
	def generarRanking(Long id) throws TorneoNotFoundException, ValidationException, RankingException {
		Torneo t = Torneo.get(id)
		if (!t) {
			throw new TorneoNotFoundException()
		}
		if (!t.finalizado()) {
			throw new RankingException(RankingException.GENERACION_RANKING_NO_PERMITIDA)
		}
		if (!t.puntuable) {
			throw new RankingException(RankingException.TORNEO_NO_PUNTUABLE)
		}
		def detallesTorneo = t.detalles
		for (detalle in detallesTorneo) {
			generarRankingCategoria(detalle)
		}
		t.actualizarRankings()
		t.save(failOnError: true)
	}
	
	def generarRankingCategoria(DetalleTorneo detalle) {
		def inscripcionesDetalleTorneo = InscripcionTorneo.createCriteria().list() {
			eq("detalleTorneo", detalle)
			and {
				eq("estado", "Vinculada")
			}
		}
		List<Usuario> jugadoresCategoria = new ArrayList<Usuario>()
		for (InscripcionTorneo inscripcion : inscripcionesDetalleTorneo) {
			Usuario j = inscripcion.usuario
			actualizarRankingJugador(j, detalle)
			jugadoresCategoria.add(inscripcion.usuario)
		}
		actualizarRankingCategoria(detalle.categoria, jugadoresCategoria)
	}
	
	def actualizarRankingCategoria(Categoria c, List<Usuario> jugadoresCategoria) {
		List puntajes = new ArrayList()
		for (Usuario u : jugadoresCategoria) {
			Ranking r = rankingJugador(u, c)
			Double puntosRanking = DetalleRanking.createCriteria().get() {
				and {
					eq("ranking", r)
					isNull("hasta")	
				}
				projections {
					sum("puntos")
				}
			}
			puntajes.add([ranking: r, puntos: puntosRanking])
		}
		Collections.sort(puntajes, new Comparator() {
			
			@Override
			int compare(def obj1, def obj2) {
				int p1 = (int)obj1.puntos
				int p2 = (int)obj2.puntos
				return (p2 - p1)	
			}
		})
		
		for (int i = 0; i < puntajes.size(); i++) {
			println puntajes[i]
			Ranking r = puntajes[i].ranking
			double puntosRanking = puntajes[i].puntos
			r.puntaje = puntosRanking
			r.puesto = ( i + 1 )
			r.save(failOnError: true)
		}
	}
	
	def actualizarRankingJugador(Usuario j, DetalleTorneo dt) {
		int posicionObtenida = posicionObtenida(j, dt.torneo)
		double puntosGanados = puntosPosicion(dt.torneo, dt.categoria, posicionObtenida)
		Ranking ranking = rankingJugador(j, dt.categoria)
		DetalleRanking nuevoRanking = new DetalleRanking(torneoPuntuable: dt.torneo.torneoPuntuable, torneo: dt.torneo,
			posicionTorneo: posicionObtenida, puntos: puntosGanados, desde: new Date())
		ranking.addToDetalles(nuevoRanking)
		ranking.save(failOnError: true)
	}
	
	def anularRankingActual(Ranking r, TorneoPuntuable tp) {
		DetalleRanking dr = DetalleRanking.createCriteria().get() {
			eq("ranking", r)
			and {
				eq("torneoPuntuable", tp)
				isNull("hasta")
			}
		}
		if (dr) {
			dr.hasta = new Date()
			dr.save(failOnError: true)
		}
	}
	
	Ranking rankingJugador(Usuario j, Categoria c) {
		Ranking rankingJugador = Ranking.createCriteria().get() {
			eq("jugador", j.jugador)
			and {
				eq("categoria", c)
			}
		}
		if (!rankingJugador) {
			rankingJugador = new Ranking(jugador: j.jugador, categoria: c, puntaje: 0, puesto: 0)
			rankingJugador.save(failOnError: true)
		}
		return rankingJugador
	}
	
	double puntosPosicion(Torneo t, Categoria c, int posicion) {
		TorneoPuntuable tp = t.torneoPuntuable
		Puntaje p = Puntaje.createCriteria().get() {
			eq("torneoPuntuable", tp)
			and {
				eq("categoria", c)
			}
		}
		DetallePuntaje dp = DetallePuntaje.createCriteria().get() {
			eq("puntaje", p)
			and {
				eq("puesto", posicion)
			}
		}
		if (dp) return dp.puntos
		else return 0.0
	}
	
	int posicionObtenida(Usuario j, Torneo t) {
		def partidosJugador = Partido.createCriteria().list {
			and {
				eq("torneo", t)
			}
			or {
				eq("jugador1", j)
				eq("jugador2", j)
			}
			order("ordenPartido", "desc")
		}
		Partido ultimoPartido = partidosJugador.get(0)
		int rondaPartido = ultimoPartido.rondaPartido()
		println ultimoPartido.id + " - " + rondaPartido
		if (rondaPartido == 1) {
			if ( j.equals( ultimoPartido.resultado.ganador) ) return 1
			else return 2
		}
		return rondaPartido
	}
}
