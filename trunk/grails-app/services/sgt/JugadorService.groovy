package sgt

import sgt.exceptions.UnregisteredJugadorException

class JugadorService {
	
	static transactional = true
	
	def getCategoriaJugador(Long id) throws UnregisteredJugadorException {
		Jugador jugador = Jugador.get(id)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		def categoriasJugador = jugador.categoriasJugador
		CategoriaJugador result = null
		for (CategoriaJugador categoriaJugador : categoriasJugador) {
			if (categoriaJugador.esAsignada()) {
				result = categoriaJugador
				break
			}
		}
		return result
	}
}
