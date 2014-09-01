package sgt

import grails.validation.ValidationException

class UsuarioService {
	
	static transactional = true
	
	def registrarUsuario(String nombreUsuario, String password, String passwordConfirm, String correo) {
		def usuarioInstance = new Usuario(
				nombreUsuario: nombreUsuario,
				password: password,
				correo: correo,
				activo: true)
		if (password != passwordConfirm) {
			usuarioInstance.errors.rejectValue("password", "", "Las password no coinciden")
			throw new ValidationException("No se pudo registrar al usuario", usuarioInstance.errors)
		}
		def rolJugador = Rol.findByNombre("Jugador")
		if (!rolJugador) {
			rolJugador = new Rol(nombre: "Jugador")
			rolJugador.save()
		}
		usuarioInstance.setRol(rolJugador)
		if (!usuarioInstance.validate()) {
			throw new ValidationException("No se pudo registrar al usuario", usuarioInstance.errors)
		}
		usuarioInstance.save()
	}
	
}
