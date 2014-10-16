package sgt.administracion
import grails.validation.ValidationException;

import java.util.Date;

import sgt.SolicitudCategoria
import sgt.CategoriaJugador
import sgt.Categoria
import sgt.Usuario
import sgt.Persona

class SolicitudCategoriaController {

	def categoriaJugadorService
	
    def list() {
		def res = categoriaJugadorService.listaSolicitudesCategorias(params)
		render(view: "/administracion/categoriaJugador/listadoSolicitudes", model: [solicitudes: res.solicitudes, total: res.total])
	}
	
	def aceptarSolicitud(Long id) {
		try {
			categoriaJugadorService.aceptarSolicitudCategoria(id)
			flash.message = "Solicitud aceptada"
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors	
		} catch (e) {
			flash.exception = e
		}
		redirect(action: "list")
	}
	
	def rechazarSolicitud(Long id) {
		try {
			categoriaJugadorService.rechazarSolicitudCategoria(id)
			flash.message = "Solicitud rechazada"
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors	
		} catch (e) {
			flash.exception = e
		}
		redirect(action: "list")
	}
}
