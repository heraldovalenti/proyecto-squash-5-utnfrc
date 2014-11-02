package sgt

import grails.validation.ValidationException

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

}
