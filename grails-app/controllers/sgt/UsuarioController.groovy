package sgt

import grails.converters.JSON
import grails.validation.ValidationException

class UsuarioController {
	
	def usuarioService
	
	def listarPersonas() {
		def usuarios = Usuario.list()
		render usuarios as JSON
	}
	
	def index() {
		redirect(action:'loginForm')
	}
	
	def registro() {
		
	}

	def loginForm() {
		session.removeAttribute("userLogon")
		render(view: 'loginForm')
	}

	def menu() {
		return [user: session.getAttribute("userLogon")]
	}

	def login() {
		String nombreUsuario = params.nombreUsuario
		String password = params.password

		def Usuario u = sgt.Usuario.findByNombreUsuarioAndPassword(nombreUsuario,password)

		//si el usuario se ha encontrado, pero esta deshabilitado:
		if (u && !u.activo) {
			flash.message = message(code: 'iniciosesion.error.usuario.inactivo')
			render(view: 'loginForm')
			return
		}
		
		def loginRedirect = session.getAttribute("loginRedirect")
		
		//si se encontro el usuario y es un Club/Encargado
		def rolJugador = Rol.findByNombre('Jugador')
		if (u && (u.esClub() || u.esEncargado() ) ) {
			session.setAttribute("userLogon", u)
			if (loginRedirect) redirect(loginRedirect)
			else redirect(controller: "club")
			return
		}
		//si se encontro el usuario y es un Jugador		
		if (u && u.esJugador()) {
			session.setAttribute("userLogon", u)
			if (loginRedirect) redirect(loginRedirect)
			else redirect(controller: "jugador")
			return
		}
		//si se encontro el usuario y es un Administrador
		if (u && u.esAdministrador()) {
			session.setAttribute("userLogon", u)
			if (loginRedirect) redirect(loginRedirect)
			else redirect(controller: "administracion")
			return
		}
				
		//si no se encontro el usuario
		flash.message = message(code: 'iniciosesion.error.usuariopassword.invalido')
		render(view: 'loginForm')
		return
	}

	def logout() {
		session.invalidate()
		redirect(url: "/")
	}
	
	def registrar() {		
		def u = new sgt.Usuario(
			nombreUsuario: params.nombreUsuario, 
			password: params.password, 
			correo: params.correo,
			activo: true) 
		if (u.validate()) {
			u.save()
			redirect(action: 'loginForm')
		} else {
			redirect(action: 'registro')
			return [usuario: u]
		}
	}
	
	def create() {
		def usuarioInstance = new Usuario(params)
		render(view: 'registro', model: [usuarioInstance: usuarioInstance])
		return
	}
	
	def save() {
		try {
			usuarioService.registrarUsuario(params.nombreUsuario,
				params.password,
				params.password2,
				params.correo)
		} catch (ValidationException e) {
			response.status = org.springframework.http.HttpStatus.PRECONDITION_FAILED.value
			render e.errors as JSON
		} catch (e) {
			response.status = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value
			render e as JSON
		}
		
		render "Registro completado exitosamente"
	}
	
	def edit(){

		if(session.getAttribute("userLogon")!=null){

			def usuarioInstance = (sgt.Usuario)session.getAttribute("userLogon")
			usuarioInstance = Usuario.get(usuarioInstance.id)

			render(view: "edit", model: [usuarioInstance: usuarioInstance])
		}
		else{
			redirect(action: 'loginForm')
		}


	}
	
	def update(){

		if(session.getAttribute("userLogon")!=null){

			def usuario = (sgt.Usuario)session.getAttribute("userLogon")
			usuario = Usuario.get(usuario.id)
			
			
			try{
			 usuarioService.modificarUsuario(usuario.id,params.password,params.password2,params.correo)
				flash.message="Los datos se han actualizado correctamente"
			}
			catch (ValidationException e) {				
				flash.errors=e.errors.allErrors
			} catch (e) {
				flash.exception=e
			}


			render(view: "edit", model: [usuarioInstance: usuario])
		}
		else{
			redirect(action: 'loginForm')
		}

	}
	
	def obtenerDatosUsuario(){
		
		if(session.getAttribute("userLogon")!=null){

			def u = (sgt.Usuario)session.getAttribute("userLogon")
			u = Usuario.get(u.id)

			return u
		}
		else{
			redirect(action: 'loginForm')
		}
		
		
	}
	
	def show(){

		def usuarioInstance= obtenerDatosUsuario()

		if(usuarioInstance!=null){

			render(view: "show", model: [usuarioInstance: usuarioInstance])
		}
		else{
			redirect(action: 'loginForm')
		}
	}
	
	
	def configuracionCuenta() {
		
		render(view: 'configuracionCuenta', model: [layout: 'jugador'])
	}
}
