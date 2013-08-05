package controlador

class UsuarioController {

	static scaffold = modelo.Usuario
	
	
	
	def index = {
		redirect(action:loginForm)
	}

	def loginForm = {
		if (session.getAttribute("userLogon") != null) {
			redirect(action:menu)
		}
	}

	def menu = {
		return [user: session.getAttribute("userLogon")]
	}

	def login() {
		String nombreUsuario = params.nombreUsuario
		String password = params.password

		def u = modelo.Usuario.findByNombreUsuarioAndPassword(nombreUsuario,password)

		if (u) {
			session.setAttribute("userLogon", u)
			redirect(action:menu)
		}
		else {
			redirect(action: loginForm)
		}

	}

	def logout() {
		session.invalidate()
		redirect(action: loginForm)
	}
}
