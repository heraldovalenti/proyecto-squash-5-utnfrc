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
	
	def modificarUsuario(String idUsuario,String password,String passwordConfirm, String correo){
		
		def u = Usuario.get(idUsuario)		
		
		u.password=password
		u.correo=correo
		
		if (password != passwordConfirm) {
			u.errors.rejectValue("password", "", "Las password no coinciden")
			throw new ValidationException("No se pudo modificar al usuario", u.errors)
		}
		
		u.save(flush: true,failOnError: true)	
		
		return u
		
	}
	
	def obtenerDatosUsuario(){
		
		if((sgt.Usuario)session.getAttribute("userLogon")!=null){
			def u = (sgt.Usuario)session.getAttribute("userLogon")
			u = Usuario.get(u.id)

			return u
		}
		else{
			return null;
		}
	}
	
}
