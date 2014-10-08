package sgt.jugador

import grails.validation.ValidationException
import sgt.Domicilio
import sgt.Jugador
import sgt.PerfilJugador
import sgt.Persona
import sgt.Usuario
import sgt.exceptions.PersonaException

class JugadorController {

	static defaultAction ='index'
	def jugadoresService
	def jugadorService
	
    def index() {
		Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u?.id)
		if(!u) {
			redirect(url: "/")
			return
		}
		render(view: '/jugador/inicioJugador')
		return
	}
	
	def datosPersonales() {
		Usuario userLogon = session.getAttribute("userLogon")
		Persona p = jugadorService.getDatosPersonales(userLogon)
		if (p) {
			render(view: "/jugador/showDatosPersonales", model: [persona: p])
		} else {
			render(view: "/jugador/editDatosPersonales", model: [persona: p])
		}
	}
	
	def saveDatosPersonales() {
		Usuario userLogon = session.getAttribute("userLogon")
		Persona p = jugadorService.getDatosPersonales(userLogon)
		if (p) {
			bindData(p,params)
		} else {
			p = new Persona(params)
		}
		try {
			jugadorService.saveDatosPersonales(userLogon, p)
			flash.message = "Datos personales registrados"
			redirect(action: "datosPersonales")
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "/jugador/editDatosPersonales", model: [persona: p])
		} catch (e) {
			flash.exception = e
			render(view: "/jugador/editDatosPersonales", model: [persona: p])
		}
	}
	
	def datosJugador() {
		Usuario userLogon = session.getAttribute("userLogon")
		
		if (!jugadorService.getDatosPersonales(userLogon)) {
			flash.message = "Debe registrar sus datos personales para gestionar sus datos de jugador"
			redirect(action: "datosPersonales")
			return
		}
		
		Jugador j = jugadorService.getDatosJugador(userLogon)
		if (j && j.checkDatosCompletados()) {
			render(view: "/jugador/showDatosJugador", model: [jugador: j])
		} else {
			render(view: "/jugador/editDatosJugador", model: [jugador: j])
		}
	}
	
	def saveDatosJugador() {
		Usuario userLogon = session.getAttribute("userLogon")
		Jugador j = jugadorService.getDatosPersonales(userLogon)
		def profileImage = request.getFile("profileImage")
		if (j) {
			bindData(j,params)
		} else {
			j = new Jugador(params)
		}
		try {
			jugadorService.saveDatosJugador(userLogon, j, profileImage)
			flash.message = "Datos de jugador registrados"
			redirect(action: "datosJugador")
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "/jugador/editDatosJugador", model: [jugador: j])
		} catch (PersonaException e) {
			flash.exception = e
			redirect(action: "datosPersonales")
		} catch (e) {
			flash.exception = e
			render(view: "/jugador/editDatosJugador", model: [jugador: j])
		}
	}
	
	def datosDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		
		if (!jugadorService.getDatosPersonales(userLogon)) {
			flash.message = "Deben registrarse los datos personales para gestionar el domicilio"
			redirect(action: "datosPersonales")
			return
		}
		
		Domicilio d = jugadorService.getDomicilio(userLogon)
		if (!d) d = new Domicilio()
		if (!userLogon.persona.domicilio) {
			render(view: "/jugador/showDomicilio", model: [domicilio: d])
		} else {
			render(view: "/jugador/editDomicilio", model: [domicilio: d])
		}
	}
	
	def saveDatosDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Domicilio d = jugadorService.getDomicilio(userLogon)
		if (!d) {
			d = new Domicilio(params)
		} else {
			bindData(d,params)
		}
		try {
			jugadorService.saveDomicilio(userLogon, d)
			flash.message = "Datos de domicilio registrados"
			redirect(action: "datosDomicilio")
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "/jugador/editDomicilio", model: [domicilio: d])
		} catch (PersonaException e) {
			flash.exception = e
			redirect(action: "datosPersonales")
		} catch (e) {
			flash.exception = e
			render(view: "/jugador/editDomicilio", model: [jugador: d])
		}
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
	
	/* Metodos de listados de jugadores */
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
