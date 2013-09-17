package sgt

import java.rmi.server.UID;

class JugadorController {

	static defaultAction ='index'
	
    def index() { 
		render(view: '/jugador/inicioJugador')
		return
	}
	
	def datosPersonales() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.persona) {
			redirect(controller: 'persona', action:'create', params: [layout: 'jugador'])
			return
		} else {
			redirect(controller: 'persona', action: 'show', id: u.persona.id, params: [layout: 'jugador'])
			return
		}
	}
	
	def showImagenPerfil() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		def imagenPerfil = "default.jpg"
		if (u.jugador?.imagen) {
			imagenPerfil = u.jugador.imagen
		}
		render(view: 'imagenPerfil', model: [imagenPerfil: imagenPerfil])
	}
	
	def updateImagenPerfil() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.jugador) {
			u.jugador = new Jugador().save(failOnError: true)
			u.save(failOnError: true)
		}
		
		def imagenPerfil = request.getFile("imagenPerfil")
		def fileUploadService = new FileUploadService()
		
		if (fileUploadService.isImage(imagenPerfil)) {
			def res = fileUploadService.uploadFile(imagenPerfil,"${u.id}","images/perfiles")
			u.jugador.imagen = res
			u.jugador.save()
		} else {
			flash.error = "Archivo de imagen no valido"
			redirect(action: 'showImagenPerfil')
			return
		}
		
		flash.message = "Imagen de perfil actualizada"
		redirect(action: 'showImagenPerfil')
		return
	}
}
