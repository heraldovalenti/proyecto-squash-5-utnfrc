package controlador

class UsuarioController {

	static scaffold = modelo.Usuario
	
	def index() {
		redirect(action:loginForm)
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

		def u = modelo.Usuario.findByNombreUsuarioAndPassword(nombreUsuario,password)

		if (u) {
			session.setAttribute("userLogon", u)
			redirect(url: "/")
		}
		else {
			redirect(action: loginForm)
		}

	}

	def logout() {
		session.invalidate()
		redirect(url: "/")
	}
	
	def registrar() {		
		def u = new modelo.Usuario(
			nombreUsuario: params.nombreUsuario, 
			password: params.password, 
			correo: params.correo,
			activo: true) 
		if (u.validate()) {
			u.save()
			redirect(action: loginForm)
		} else {
			redirect(action: registro)
			return [usuario: u]
		}
	}
}