package sgt

class UsuarioController {

	static scaffold = sgt.Usuario
	
	def index() {
		redirect(action:'loginForm')
	}
	
	def registro() {
		
	}

	def loginForm() {
		
	}

	def menu() {
		return [user: session.getAttribute("userLogon")]
	}

	def login() {
		String nombreUsuario = params.nombreUsuario
		String password = params.password

		def u = sgt.Usuario.findByNombreUsuarioAndPassword(nombreUsuario,password)

		//si el usuario se ha encontrado, pero esta deshabilitado:
		if (u && !u.activo) {
			flash.message = message(code: 'iniciosesion.error.usuario.inactivo')
			render(view: 'loginForm')
			return
		}
		
		//si se encontro el usuario
		if (u) {
			session.setAttribute("userLogon", u)
			render(view: '/jugador/inicioJugador')
			return
		} 
		
		//si no se encontrol el usuario
		else {
			flash.message = message(code: 'iniciosesion.error.usuariopassword.invalido')
			render(view: 'loginForm')
			return
		}

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
		def usuarioInstance = new Usuario(
			nombreUsuario: params.nombreUsuario, 
			password: params.password, 
			correo: params.correo,
			activo: true)
		
		def rolJugador = Rol.findByNombre('Jugador')
		if (!rolJugador) {
			rolJugador = new Rol(nombre: 'Jugador')
			rolJugador.save()
		}
		
		usuarioInstance.addToRoles(rolJugador)
		
		if (!usuarioInstance.save(flush: true)) {
			render(view: 'registro', model: [usuarioInstance: usuarioInstance])
			return
		}
		
		if (params.password != params.password2) {
			usuarioInstance.errors.rejectValue('password',
				'registrousuario.password.errorigualdad')
			render(view: 'registro', model: [usuarioInstance: usuarioInstance])
			return
		}

		flash.message = message(code: 'registrousuario.enviar.exito')
		render(view: 'registro')
	}
}
