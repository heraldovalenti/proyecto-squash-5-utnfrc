package sgt

import grails.validation.ValidationException
import sgt.exceptions.UnregisteredJugadorException

class CategoriaJugadorService {

	static transactional = true
	
	def jugadorService
	
    def getCategoriaJugador(Long id) throws UnregisteredJugadorException {
		Jugador jugador = Jugador.get(id)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		def c = CategoriaJugador.createCriteria()
		def result = c.get {
			eq("jugador", jugador)
			and {
				eq("estado","Asignada")
			}
		}
		return result
	}
	
	def getHistorialCategoriaJugador(Long id) throws UnregisteredJugadorException {
		Jugador jugador = Jugador.get(id)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		def c = CategoriaJugador.createCriteria()
		def results = c.list {
			eq("jugador", jugador)
			and {
				eq("estado","De baja")
				isNotNull("fechaFin")
			}
			order("fechaInicio", "asc")
		}
		return results
	}
	
	def getSolicitudCategoriaJugador(Long id) throws UnregisteredJugadorException {
		Jugador jugador = Jugador.get(id)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		def c = CategoriaJugador.createCriteria()
		def result = c.get {
			eq("jugador", jugador)
			and {
				eq("estado","Solicitada")
			}
		}
		return result
	}
	
	def saveSolicitudCategoria(def idJugador, def idCategoria) 
		throws UnregisteredJugadorException, ValidationException {
		Jugador jugador = Jugador.get(idJugador)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		Categoria categoriaSolicitud = Categoria.get(idCategoria)
		CategoriaJugador solicitud = getSolicitudCategoriaJugador(idJugador)
		if (!solicitud) solicitud = new CategoriaJugador()
		solicitud.jugador = jugador
		solicitud.categoria = categoriaSolicitud
		solicitud.fechaInicio = new Date()
		solicitud.solicitar()
		solicitud.descripcion = null
		solicitud.save(failOnError: true)
	}
	
	def cancelarSolicitudCategoria(Long id) throws UnregisteredJugadorException {
		Jugador jugador = Jugador.get(id)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		CategoriaJugador solicitud = getSolicitudCategoriaJugador(id)
		if (solicitud) {
			solicitud.delete()
		}
	}
	
	def getCategoriasSolicitables(Long id) throws UnregisteredJugadorException {
		Jugador jugador = Jugador.get(id)
		if (!jugador) {
			throw new UnregisteredJugadorException()
		}
		Categoria categoriaActual = getCategoriaJugador(jugador.id)?.categoria
		Categoria categoriaSolicitada = getSolicitudCategoriaJugador(jugador.id)?.categoria
		List results = Categoria.list()
		if (categoriaActual && results.contains(categoriaActual)) {
			results.remove(categoriaActual)
		}
		if (categoriaSolicitada&& results.contains(categoriaSolicitada)) {
			results.remove(categoriaSolicitada)
		}
		return results
	}
	
	def listaSolicitudesCategorias(def params) {
		params = (params) ? params : [max: 10]
		def c = CategoriaJugador.createCriteria()
		def solicitudes = c.list(params) {
			eq("estado","Solicitada")
		}
		def total = solicitudes.getTotalCount()
		ArrayList results = new ArrayList()
		for (categoriaJugador in solicitudes) {
			Jugador j = categoriaJugador.jugador
			Usuario u = Usuario.createCriteria().get {
				eq("jugador", j)
			}
			Persona p = u.persona
			CategoriaJugador a = getCategoriaJugador(j.id)
			results.add([solicitudCategoria: categoriaJugador, categoriaActual: a, persona: p])
		}
		return [solicitudes: results, total: total]
	}
	
	
	def aceptarSolicitudCategoria(Long id) throws ValidationException {
		CategoriaJugador categoriaSolicitada = CategoriaJugador.get(id)
		Jugador j = categoriaSolicitada.jugador
		CategoriaJugador categoriaPrevia = getCategoriaJugador(j.id)
		
		if (categoriaPrevia) {
			categoriaPrevia.darBaja()
			categoriaPrevia.save(failOnError: true)
		}
		
		categoriaSolicitada.asignar()
		categoriaSolicitada.save(failOnError: true)
	}
	
	def rechazarSolicitudCategoria(Long id) throws ValidationException {
		CategoriaJugador solicitud = CategoriaJugador.get(id)
		
		solicitud.denegar()
		solicitud.save(failOnError: true)
	}
}
