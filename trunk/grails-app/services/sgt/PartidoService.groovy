package sgt

import grails.validation.ValidationException
import org.hibernate.criterion.CriteriaSpecification;
class PartidoService {
	
	static transactional = true
	
	def registrarGanadorPartido(Long idPartido, Long idGanador) throws ValidationException {
		Partido p = Partido.get(idPartido)
		Usuario u = Usuario.get(idGanador)
		ResultadoPartido r = p.resultado
		r.ganador = u
		p.finalizar()
		if (p.siguientePartido) {
			Partido siguiente = p.siguientePartido
			if (!siguiente.jugador1) siguiente.jugador1 = u
			else siguiente.jugador2 = u
			siguiente.save(failOnError: true)
		}
		r.save(failOnError: true)
		p.save(failOnError: true)
	}
	
	def listarEnfrentamientosJugadores(Long idJugador1, Long idJugador2){
		def p = Partido.createCriteria()
		def ids=[idJugador1,idJugador2]
		def enfrentamientos = p.list() {
			createAlias("jugador1", "jug1", CriteriaSpecification.LEFT_JOIN)
			createAlias("jugador2","jug2", CriteriaSpecification.LEFT_JOIN)			
			and {				
				'in'("jug1.id",ids)
				'in'("jug2.id", ids)				
			}			
		}
		
		return enfrentamientos
	}
	
	def listarPartidosJugador(Long idJugador){
		def p = Partido.createCriteria()	
		def partidos = p.list() {
			createAlias("jugador1", "jug1", CriteriaSpecification.LEFT_JOIN)			
			and {
				eq("jug1.id",idJugador)				
			}
		}
		
		return partidos		
	}
	
	def listarFinalesJugador(Long idJugador){
		
		def partidos= listarPartidosJugador(idJugador)
		
		int finales=0
		
		for(Partido p:partidos){
			
			if(p.rondaPartido()==1){
				finales ++
			}			
		}
		return finales
	}
	
	def listarTitulosJugador(Long idJugador){
		
		def partidos= listarPartidosJugador(idJugador)
		
		def jugador= Usuario.get(idJugador)
		
		int titulos=0
		
		for(Partido p:partidos){
			
			if(p?.rondaPartido()==1 && p?.resultado?.ganador==jugador){
				titulos ++
			}
		}
		return titulos
	}
	
	def listarPartidosTorneo(Long idTorneo, Long idCategoria,def params){

		def torneo= Torneo.get(idTorneo)
		def categoriaSeleccionada=Categoria.get(idCategoria)

		def p = Partido.createCriteria()
		def partidos

		if(torneo!=null && categoriaSeleccionada!=null){
			partidos = p.list(params) {
				createAlias("torneo", "torneo", CriteriaSpecification.LEFT_JOIN)
				createAlias("categoria", "categoria", CriteriaSpecification.LEFT_JOIN)
				createAlias("resultado", "resultado", CriteriaSpecification.LEFT_JOIN)

				and {
					eq("torneo",torneo)
					eq("categoria",categoriaSeleccionada)
					isNotNull("resultado")
				}
			}
		}
		else if(torneo!=null){
			partidos = p.list(params) {
				createAlias("torneo", "torneo", CriteriaSpecification.LEFT_JOIN)
				createAlias("resultado", "resultado", CriteriaSpecification.LEFT_JOIN)

				and {
					eq("torneo",torneo)
					isNotNull("resultado")
				}
			}
		}

		return partidos
	}

}
