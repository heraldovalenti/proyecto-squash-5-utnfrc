import sgt.*

class BootStrap {

    def init = { servletContext ->
		cargarUsuarios()
    }
	
	def cargarUsuarios() {
		def rolJugador = new Rol(nombre: "Jugador").save()
		def rolAdministrador = new Rol(nombre: "Administrador").save()
		
		def usuarioHeraldov = new Usuario(nombreUsuario: "heraldov", password: "ochoyas", correo: "heraldovalenti@gmail.com",
			activo: true)
		usuarioHeraldov.addToRoles(rolJugador)
		usuarioHeraldov.addToRoles(rolAdministrador)
		usuarioHeraldov.save()
	}
	
    def destroy = {
    }
}
