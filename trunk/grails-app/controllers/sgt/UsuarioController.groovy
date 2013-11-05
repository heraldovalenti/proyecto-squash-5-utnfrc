package sgt

import grails.converters.JSON

class UsuarioController {
	
	def listarPersonas() {
		def usuarios = Usuario.list()
		System.out.println(usuarios)
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
		
		//si se encontro el usuario y es un Club
		def rolClub = Rol.findByNombre('Club')
		def rolJugador = Rol.findByNombre('Jugador')
		if (u && u.getRoles().contains(rolClub)) {
			session.setAttribute("userLogon", u)
			render(view: '/club/inicioClub')
			return
		}
		//si se encontro el usuario y es un jugador		
		if (u && u.getRoles().contains(rolJugador)) {
			session.setAttribute("userLogon", u)
			render(view: '/jugador/inicioJugador')
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
		redirect(controller: 'usuario', action: 'loginForm')
	}
	
	def configuracionCuenta() {
		render(view: 'configuracionCuenta', model: [layout: 'jugador'])
	}
	
	
	/* METODOS PARA CLUB */
	def loginFormClub() {
		session.removeAttribute("userLogon")
		render(view: 'loginClub')
	}
	
	def loginClub() {
		String nombreUsuario = params.nombreUsuario
		String password = params.password

		def Usuario u = sgt.Usuario.findByNombreUsuarioAndPassword(nombreUsuario,password)

		//si el usuario se ha encontrado, pero esta deshabilitado:
		if (u && !u.activo) {
			flash.message = message(code: 'iniciosesion.error.usuario.inactivo')
			render(view: 'loginForm')
			return
		}
		
		//si se encontro el usuario y es un club
		def rolClub = Rol.findByNombre('Club')
		System.out.println(u.getRoles().contains(rolClub))
		if (u && u.getRoles().contains(rolClub)) {			
			session.setAttribute("userLogon", u)
			render(view: '/club/inicioClub')
			return
		}
		
		//si no se encontro el usuario
		else {
			flash.message = message(code: 'iniciosesion.error.usuariopassword.invalido')
			render(view: 'loginClub')
			return
		}

	}
}