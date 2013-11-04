package sgt.administracion
import java.util.Date;

import sgt.SolicitudCategoria
import sgt.CategoriaJugador
import sgt.Categoria
import sgt.Usuario
import sgt.Persona

class SolicitudCategoriaController {

    def index() {
		def categoriaJugadorInstanceList = CategoriaJugador.findAllByEstado("Solicitada")
		def Iterator<CategoriaJugador> categoriaJugadorIterator = categoriaJugadorInstanceList.iterator()
		def List<SolicitudCategoria> solicitudInstanceList = new LinkedList()
		while(categoriaJugadorIterator.hasNext()) {
			def CategoriaJugador aux = categoriaJugadorIterator.next()
			def SolicitudCategoria solicitud = new SolicitudCategoria()
			
			def Usuario usuarioAux = aux.usuario
			
			def CategoriaJugador categoriaAux = usuarioAux.getCategoriaActual()
			def String actual = (categoriaAux != null) ? categoriaAux.categoria.toString() : "N/A"
			
			def Persona personaAux = usuarioAux.persona
			def String nombre = (personaAux != null) ? personaAux.nombre : "N/A"
			def String apellido = (personaAux != null) ? personaAux.apellido : "N/A"
			
			solicitud.setIdUsuario(usuarioAux.id)
			solicitud.setIdCategoriaJugador(aux.id)
			solicitud.setUsuario(usuarioAux.nombreUsuario)
			solicitud.setApellido(apellido)
			solicitud.setNombre(nombre)
			solicitud.setActual(actual)
			solicitud.setSolicitada(aux.categoria.toString())
			
			solicitudInstanceList.add(solicitud)
		}
		render(view: "/administracion/categoriaJugador/listadoSolicitudes", model: [solicitudInstanceList: solicitudInstanceList])
	}
	
	def aceptarSolicitud(Long id) {
		def CategoriaJugador categoriaJugadorInstance = CategoriaJugador.get(id)
		def Usuario usuarioAux = categoriaJugadorInstance.usuario
		def CategoriaJugador categoriaPreviaInstance = usuarioAux.getCategoriaActual()
		
		if (categoriaPreviaInstance) {
			categoriaPreviaInstance.darBaja()
			categoriaPreviaInstance.save(failOnError: true)
		}
		
		categoriaJugadorInstance.asignar()
		categoriaJugadorInstance.save(failOnError: true)
		
		flash.message = "Solicitud aceptada con éxito"
		redirect(action: "index")
	}
	
	def denegarSolicitud(Long id) {
		def CategoriaJugador categoriaJugadorInstance = CategoriaJugador.get(id)
		
		categoriaJugadorInstance.anular()
		categoriaJugadorInstance.save(failOnError: true)
		
		flash.message = "Solicitud denegada con éxito"
		redirect(action: "index")
	}
}
