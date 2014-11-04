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

}
