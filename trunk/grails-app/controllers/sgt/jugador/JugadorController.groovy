package sgt.jugador

import grails.converters.JSON
import java.rmi.server.UID;

import sgt.CategoriaJugador
import sgt.FilesService;
import sgt.Jugador;
import sgt.JugadoresService;
import sgt.PerfilJugador;
import sgt.Usuario;

class JugadorController {

	static defaultAction ='index'
	def jugadoresService
	
    def index() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u?.id)
		if(!u) {
			redirect(url: "/")
			return
		}
		render(view: '/jugador/inicioJugador')
		return
	}
	
	def datosPersonales() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.persona) {
			redirect(controller: 'persona', action:'create')
			return
		} else {
			redirect(controller: 'persona', action: 'show', id: u.persona.id)
			return
		}
	}
	
	def datosJugador() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.jugador) {
			redirect(action:'create')
			return
		} else {
			redirect(action: 'show', id: u.jugador.id)
			return
		}
	}
	
	def datosDomicilio() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.domicilio) {
			redirect(controller: 'domicilio', action:'create')
			return
		} else {
			redirect(controller: 'domicilio', action: 'show', id: u.persona.id)
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
		def filesService = new FilesService()
		
		if (filesService.isImage(imagenPerfil)) {
			def res = filesService.uploadFile(imagenPerfil,"${u.id}","images/perfiles")
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
	
	def usuarioActual(){
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		return u
		
	}
	
	def showPerfil(Usuario u) {
				
		if (u && u.persona) {
			def perfil = new PerfilJugador()
			if (u.persona?.nombre) perfil.setNombre(u.persona.nombre)
			if (u.persona?.apellido) perfil.setApellido(u.persona.apellido)
			if (u.persona?.lugarNacimiento) perfil.setLugarNacimiento(u.persona.lugarNacimiento)
			if (u.persona?.fechaNacimiento) perfil.setFechaNacimiento(u.persona.fechaNacimiento)
			if (u.jugador?.altura) perfil.setAltura(u.jugador.altura)
			if (u.jugador?.peso) perfil.setPeso(u.jugador.peso)
			if (u.jugador?.brazo) perfil.setBrazo(u.jugador.brazo)
			if (u.jugador?.juegaDesde) perfil.setJuegaDesde(u.jugador.juegaDesde)
			if (u.domicilio) perfil.setResidencia(u.domicilio.toString())
			if (u.jugador?.imagen) { 
				perfil.setImagenPerfil(u.jugador.imagen) 
			} else {
				perfil.setImagenPerfil("default.jpg")
			}
			if (u.getCategoriaActual()) {
				perfil.setCategoria(u.getCategoriaActual()?.categoria?.toString())
			}
			
			render(view: '/jugador/showPerfil', model: [perfil: perfil, layout: 'jugador'])
			return
		}
		
		render(view: '/jugador/showPerfil', model: [layout: 'jugador'])
		return
	}
	
	
	/* ACCIONES PARA DATOS DE JUGADOR */
	
	def create() {
		[jugadorInstance: new Jugador(params)]
	}
	
	def save() {
		def u = (sgt.Usuario) session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		def jugadorInstance = new Jugador(params)
		if (!jugadorInstance.save(flush: true)) {
			render(view: "create", model: [jugadorInstance: jugadorInstance])
			return
		}
		
		u.setJugador(jugadorInstance)
		u.save()

		flash.message = message(code: 'default.created.message', args: [message(code: 'jugador.label', default: 'Jugador'), jugadorInstance.id])
		redirect(action: "show", id: jugadorInstance.id)
	}

	def show(Long id) {
		def jugadorInstance = Jugador.get(id)
		if (!jugadorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'jugador.label', default: 'Jugador'), id])
			redirect(action: "list")
			return
		}

		[jugadorInstance: jugadorInstance]
	}

	def edit(Long id) {
		def jugadorInstance = Jugador.get(id)
		if (!jugadorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'jugador.label', default: 'Jugador'), id])
			redirect(action: "list")
			return
		}

		[jugadorInstance: jugadorInstance]
	}

	def update(Long id, Long version) {
		def u = (sgt.Usuario) session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		def jugadorInstance = Jugador.get(id)
		if (!jugadorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'jugador.label', default: 'Jugador'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (jugadorInstance.version > version) {
				jugadorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'jugador.label', default: 'Jugador')] as Object[],
						  "Another user has updated this Jugador while you were editing")
				render(view: "edit", model: [jugadorInstance: jugadorInstance])
				return
			}
		}

		jugadorInstance.properties = params

		if (!jugadorInstance.save(flush: true)) {
			render(view: "edit", model: [jugadorInstance: jugadorInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'jugador.label', default: 'Jugador'), jugadorInstance.id])
		redirect(action: "show", id: jugadorInstance.id)
	}
	
	def obtenerJugadores(){
				
		def categoria= params.categoria
		
		def tipo="jugador"		
		
		def jugadoresCategoria= jugadoresService.listarJugadoresPorCategoria(categoria)
		
		def categorias=jugadoresService.obtenerCategorias()
		
		render(view: "jugadoresPorCategoria", model: [jugadores: jugadoresCategoria , categorias:categorias, categoriaSeleccionada:categoria, tipo:tipo])
		
	}
	
	def obtenerRankingJugadores(){
		
		def categoria= params.categoria		
		
		def tipo="ranking"
		
		def rankingJugadores= jugadoresService.listarJugadoresPorRankingYCategoria(categoria)
				
		def categorias=jugadoresService.obtenerCategorias()
		
		render(view: "jugadoresPorRankingYCategoria", model: [jugadores: rankingJugadores , categorias:categorias, categoriaSeleccionada:categoria, tipo:tipo])
		
	}
	
	def cargarPerfilCompleto(){
		
		def idUsuario= params.usuario
		
		def categoria= params.categoria	
		
		def tipo=params.tipo
		
		def usuario= Usuario.get(idUsuario)
		
		def categorias=jugadoresService.obtenerCategorias()
		
		def edad= jugadoresService.calcularEdad(usuario.persona.fechaNacimiento)		
		
		render(view: "perfilCompletoJugador", model: [usuarioInstance: usuario, edad:edad, categorias:categorias, categoriaSeleccionada:categoria, tipo:tipo])
		
		
	}
}
