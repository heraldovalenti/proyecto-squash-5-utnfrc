package sgt.jugador

import grails.validation.ValidationException
import sgt.CategoriaJugador
import sgt.Domicilio
import sgt.Jugador
import sgt.PerfilJugador
import sgt.Persona
import sgt.Usuario
import sgt.exceptions.PersonaException
import sgt.exceptions.UnregisteredJugadorException

class JugadorController {

	static defaultAction = 'index'
	
	def jugadoresService
	def jugadorService
	def categoriaJugadorService
	
	def index() {
		Usuario userLogon = session.getAttribute("userLogon")
		Persona p = jugadorService.getDatosPersonales(userLogon)
		if (p) {
			chain(action: "perfilJugador")
		} else {
			chain(action: "datosPersonales")
		}
	}
	
	def datosPersonales() {
		Usuario userLogon = session.getAttribute("userLogon")
		Persona p = jugadorService.getDatosPersonales(userLogon)
		if (p) {
			render(view: "/jugador/datosPersonales/show", model: [persona: p])
		} else {
			render(view: "/jugador/datosPersonales/edit", model: [persona: new Persona()])
		}
	}
	
	def editDatosPersonales() {
		Usuario userLogon = session.getAttribute("userLogon")
		Persona p = jugadorService.getDatosPersonales(userLogon)
		render(view: "/jugador/datosPersonales/edit", model: [persona: p])
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
			render(view: "/jugador/datosPersonales/edit", model: [persona: p])
		} catch (e) {
			flash.exception = e
			render(view: "/jugador/datosPersonales/edit", model: [persona: p])
		}
	}
	
	def datosJugador() {
		Usuario userLogon = session.getAttribute("userLogon")
		
		if (!jugadorService.getDatosPersonales(userLogon)) {
			flash.message = "Debe registrar sus datos personales para gestionar los datos de jugador"
			redirect(action: "datosPersonales")
			return
		}
		
		Jugador j = jugadorService.getDatosJugador(userLogon)
		if (j && j.checkDatosCompletados()) {
			render(view: "/jugador/datosJugador/show", model: [jugador: j])
		} else {
			render(view: "/jugador/datosJugador/edit", model: [jugador: j])
		}
	}
	
	def editDatosJugador() {
		Usuario userLogon = session.getAttribute("userLogon")
		Jugador j = jugadorService.getDatosJugador(userLogon)
		render(view: "/jugador/datosJugador/edit", model: [jugador: j])
	}
	
	def saveDatosJugador() {
		Usuario userLogon = session.getAttribute("userLogon")
		Jugador j = jugadorService.getDatosJugador(userLogon)
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
			render(view: "/jugador/datosJugador/edit", model: [jugador: j])
		} catch (PersonaException e) {
			flash.exception = e
			redirect(action: "datosPersonales")
		} catch (e) {
			flash.exception = e
			render(view: "/jugador/datosJugador/edit", model: [jugador: j])
		}
	}
	
	def datosDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		
		if (!jugadorService.getDatosPersonales(userLogon)) {
			flash.message = "Debe registrar sus datos personales para gestionar el domicilio"
			redirect(action: "datosPersonales")
			return
		}
		
		Domicilio d = jugadorService.getDomicilio(userLogon)
		if (d) {
			render(view: "/jugador/domicilio/show", model: [domicilio: d])
		} else {
			render(view: "/jugador/domicilio/edit", model: [domicilio: new Domicilio()])
		}
	}
	
	def editDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Domicilio d = jugadorService.getDomicilio(userLogon)
		render(view: "/jugador/domicilio/edit", model: [domicilio: d])
	}
	
	def saveDomicilio() {
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
			render(view: "/jugador/domicilio/edit", model: [domicilio: d])
		} catch (PersonaException e) {
			flash.exception = e
			redirect(action: "datosPersonales")
		} catch (e) {
			flash.exception = e
			render(view: "/jugador/domicilio/edit", model: [jugador: d])
		}
	}
	
	def categorias() {
		Usuario userLogon = session.getAttribute("userLogon")
		
		if (!jugadorService.getDatosPersonales(userLogon)) {
			flash.message = "Debe registrar sus datos personales para gestionar la categoria"
			chain(action: "datosPersonales")
			return
		}
		
		def jugador = jugadorService.getDatosJugador(userLogon)
		def historial = categoriaJugadorService.getHistorialCategoriaJugador(jugador.id)
		def categoria = categoriaJugadorService.getCategoriaJugador(jugador.id)
		def solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(jugador.id)
		
		render(view: "/jugador/categoria/categorias", 
			model: [categoria: categoria, historial: historial, solicitud: solicitud])
	}
	
	def solicitudCategoria() {
		Usuario userLogon = session.getAttribute("userLogon")
		def jugador = jugadorService.getDatosJugador(userLogon)
		CategoriaJugador categoriaJugador = new CategoriaJugador()
		def categorias = categoriaJugadorService.getCategoriasSolicitables(jugador.id)
		render(view: "/jugador/categoria/solicitudCategoria", model: [categorias: categorias])
	}
	
	def saveSolicitudCategoria() {
		Usuario userLogon = session.getAttribute("userLogon")
		def jugador = jugadorService.getDatosJugador(userLogon)
		def idCategoria = params.idCategoria
		try {
			categoriaJugadorService.saveSolicitudCategoria(jugador.id, idCategoria)
			flash.message = "Solicitud registrada"
			chain(action: "categorias")
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			def categorias = categoriaJugadorService.getCategoriasSolicitables(jugador.id)
			render(view: "/jugador/categoria/solicitudCategoria", model: [categorias: categoria])
		} catch (UnregisteredJugadorException e) {			
			flash.message = "Debe registrar sus datos personales para gestionar la categoria"
			chain(action: "datosPersonales")
		}
	}
	
	def cancelarSolicitudCategoria() {
		Usuario userLogon = session.getAttribute("userLogon")
		def jugador = jugadorService.getDatosJugador(userLogon)
		def idCategoria = params.idCategoria		
		categoriaJugadorService.cancelarSolicitudCategoria(jugador.id)
		flash.message = "Solicitud cancelada"
		chain(action: "categorias")
	}
	
	def perfilJugador() {
		Usuario u = Usuario.get(params.idUsuario)
		if (!u) {
			u = session.getAttribute("userLogon")
			u = Usuario.get(u.id)
		}
		def datosPersonales = jugadorService.getDatosPersonales(u)
		if (u && datosPersonales) {
			def perfil = new PerfilJugador()
			if (u.persona?.nombre) perfil.setNombre(u.persona.nombre)
			if (u.persona?.apellido) perfil.setApellido(u.persona.apellido)
			if (u.persona?.lugarNacimiento) perfil.setLugarNacimiento(u.persona.lugarNacimiento)
			if (u.persona?.fechaNacimiento) perfil.setFechaNacimiento(u.persona.fechaNacimiento)
			if (u.jugador?.altura) perfil.setAltura(u.jugador.altura)
			if (u.jugador?.peso) perfil.setPeso(u.jugador.peso)
			if (u.jugador?.brazo) perfil.setBrazo(u.jugador.brazo)
			if (u.jugador?.juegaDesde) perfil.setJuegaDesde(u.jugador.juegaDesde)
			if (u.persona?.domicilio) perfil.setResidencia(u.persona?.domicilio.toString())
	
			String imagenPerfil = g.imagenPerfilJugador(jugador: u.jugador).toString()
			perfil.setImagenPerfil(imagenPerfil)
			
			def categoriaJugador = categoriaJugadorService.getCategoriaJugador(u.jugador.id)
			if (categoriaJugador) {
				perfil.setCategoria(categoriaJugador.categoria?.toString())
			}
			
			render(view: '/jugador/showPerfil', model: [perfil: perfil, layout: 'jugador'])
		} else {
			flash.message = "Debe registrar sus datos personales para generar el perfil de jugador"
			chain(action: "datosPersonales")
		}		
	}
	
	/* Metodos de listados de jugadores */
	def obtenerJugadores(){
				
		def categoria= params.categoria
		
		if(!params.offset){
			params.offset=0
		}
		if(!params.max){
			params.max=10
		}
		
		
		def tipo="jugador"		
		
		def jugadoresCategoria= jugadoresService.listarJugadoresPorCategoria(categoria,params)
			
		def total= jugadoresCategoria.getTotalCount()
		
		def categorias=jugadoresService.obtenerCategorias()
		
		render(view: "jugadoresPorCategoria", model: [jugadores: jugadoresCategoria , categorias:categorias, categoriaSeleccionada:categoria,total:total,tipo:tipo])
		
	}
	
	def obtenerRankingJugadores(){
		
		def categoria= params.categoria	
		
		if(!params.offset){
			params.offset=0
		}
		if(!params.max){
			params.max=10
		}
		
		def tipo="ranking"
		
		def rankingJugadores= jugadoresService.listarJugadoresPorRankingYCategoria(categoria,params)
		
		def total= rankingJugadores.getTotalCount()
				
		def categorias=jugadoresService.obtenerCategorias()
		
		render(view: "jugadoresPorRankingYCategoria", model: [jugadores: rankingJugadores , categorias:categorias, categoriaSeleccionada:categoria,total:total, tipo:tipo])
		
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
