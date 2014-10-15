package sgt

import org.junit.Assert

import sgt.exceptions.InscripcionTorneoException
import sgt.exceptions.TorneoNotFoundException
import sgt.exceptions.UnregisteredJugadorException

class InscripcionTorneoService {

	static transactional = true
	
	def jugadorService
	def categoriaJugadorService
	
    def Boolean aptoParaInscripcion(Long id) {
		return false
    }
	
	def getCategoriasDeTorneoParaInscripcion(Long id) 
		throws TorneoNotFoundException, InscripcionTorneoException {
		Torneo torneo = Torneo.get(id)
		if (!torneo) {
			throw new TorneoNotFoundException()
		}
		def detalles = torneo.detalles
		if (!detalles) {
			throw new InscripcionTorneoException(
				InscripcionTorneoException.TORNEO_SIN_CATEGORIAS)
		}
		def results = new ArrayList()
		for (DetalleTorneo detalle : detalles) {
			results.add(detalle.categoria)
		}
		return results
	}
	
	def inscribirJugadorTorneo(def idTorneo, def idUsuario) 
		throws TorneoNotFoundException, UnregisteredJugadorException, InscripcionTorneoException {
		Torneo torneo = Torneo.get(idTorneo)
		Usuario u = Usuario.get(idUsuario)
		if (!torneo) {
			throw new TorneoNotFoundException()
		}
		if (!torneo.inscripcionAbierta()) {
			throw new InscripcionTorneoException(InscripcionTorneoException.INSCRIPCION_CERRADA)
		}
		if (!u.jugador) {
			throw new UnregisteredJugadorException()
		}
		Jugador jugador = u.jugador
		CategoriaJugador categoriaJugador = categoriaJugadorService.getCategoriaJugador(jugador.id)
		if (!categoriaJugador) {
			throw new InscripcionTorneoException(InscripcionTorneoException.CATEGORIA_NO_PERMITIDA)
		}
		if (!torneo.detalles) {
			throw new InscripcionTorneoException(InscripcionTorneoException.TORNEO_SIN_CATEGORIAS)
		}
		DetalleTorneo detalleTorneoSeleccionado = null
		for (DetalleTorneo detalleTorneo : torneo.detalles) {
			if (detalleTorneo.categoria.equals(categoriaJugador.categoria)) {
				detalleTorneoSeleccionado = detalleTorneo
				break
			}
		}
		if (!detalleTorneoSeleccionado) {
			throw new InscripcionTorneoException(InscripcionTorneoException.CATEGORIA_NO_PERMITIDA)
		}
		int cantidadInscripcionesVinculadas = 0
		for (InscripcionTorneo inscripcionTorneo : detalleTorneoSeleccionado.inscripciones) {
			if (inscripcionTorneo.esVinculada()) cantidadInscripcionesVinculadas++
		}
		if (cantidadInscripcionesVinculadas >= detalleTorneoSeleccionado.cupoMaximo) {
			throw new InscripcionTorneoException(InscripcionTorneoException.CUPO_LLENO)
		}
		for (InscripcionTorneo inscripcionTorneo : detalleTorneoSeleccionado.inscripciones) {
			if (inscripcionTorneo.usuario.equals(u) && inscripcionTorneo.esVinculada()) {
				throw new InscripcionTorneoException(InscripcionTorneoException.JUGADOR_INSCRIPTO)
			}
		}
		InscripcionTorneo inscripcionTorneo = new InscripcionTorneo()
		inscripcionTorneo.usuario = u
		inscripcionTorneo.fecha = new Date()
		inscripcionTorneo.vincular()
		
		detalleTorneoSeleccionado.addToInscripciones(inscripcionTorneo)
		detalleTorneoSeleccionado.save(failOnError: true)
	}
		
	def cancelarInscripcionTorneo(def id) throws InscripcionTorneoException {
		InscripcionTorneo inscripcionTorneo = InscripcionTorneo.get(id)
		if (!inscripcionTorneo) {
			throw new InscripcionTorneoException(InscripcionTorneoException.INSCRIPCION_NO_ENCONTRADA)
		}
		if (!inscripcionTorneo.cancelable()) {
			throw new InscripcionTorneoException(InscripcionTorneoException.INSCRIPCION_NO_CANCELABLE)
		}
		inscripcionTorneo.cancelar()
		inscripcionTorneo.save(failOnError: true)
	}
	
	def getInscripcionActivasUsuario(def idUsuario) {
		Usuario usuario = Usuario.get(idUsuario)
		def c = InscripcionTorneo.createCriteria()
		def results = c.list {
			eq("usuario", usuario)
			and {
				eq("estado", "Vinculada")
			}
		}
		return results
	}
}
