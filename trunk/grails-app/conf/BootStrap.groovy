import java.util.Date;

import sgt.*

class BootStrap {

    def init = { servletContext ->
		cargarUsuarios()
		cargarPartidos()
		cargarPersonas()
    }
	
	def cargarUsuarios() {
		def rolJugador = new Rol(nombre: "Jugador").save()
		def rolAdministrador = new Rol(nombre: "Administrador").save()
		def rolClub = new Rol(nombre: 'Club').save()
		
		def usuarioHeraldov = new Usuario(nombreUsuario: "heraldov", password: "ochoyas", correo: "heraldovalenti@gmail.com",
			activo: true)
		usuarioHeraldov.setRol(rolJugador)
		usuarioHeraldov.save(failOnError: true)	
		
		
		def usuarioAdmin = new Usuario(nombreUsuario: "administrador", password: "administrador", correo: "admin@info.com",
			activo: true)
		usuarioAdmin.setRol(rolAdministrador)
		usuarioAdmin.save(failOnError: true)
		
		def usuarioBoca = new Usuario(nombreUsuario: "bocajr", password: "bocajr", correo: "info@bocajr.com.ar",
			activo: true)
		usuarioBoca.setRol(rolClub)
		usuarioBoca.save(failOnError: true)		
	}
	
	def cargarPartidos()
	{
		def categoria= new Categoria(nombre: "Primera", descripcion: "Primera", modalidadCategoria: "Masculino").save()
		def detalleDisponibilidad= new DetalleDisponibilidad(dia: "Lu", desde: 0, hasta: 100).save()		
		def disponibilidad= new Disponibilidad(fechaActualizacion:  new Date()).save()
		disponibilidad.addToDetalles(detalleDisponibilidad)
		disponibilidad.save()
		
		def cancha= new Cancha(ancho: 5,largo: 5,techo: true, tipoSuelo: "Cemento", paredes: "verdes", nombre: "Fachada1", disponibilidad: disponibilidad ).save()
	}
	
	def cargarPersonas()
	{
		def persona= new Persona(nombre: "Guillermo", apellido: "Fank", fechaNacimiento: new Date(), tipoDocumento: "DNI", numeroDocumento: 35008248, sexo: "Masculino", telefono: "351153199294", lugarNacimiento: "Puerto Rico").save()
		def personita= new Persona(nombre: "Jose", apellido: "Perez", fechaNacimiento: new Date(), tipoDocumento: "DNI", numeroDocumento: 20678549, sexo: "Masculino", telefono: "351155678965", lugarNacimiento: "Villa Allende").save()
	}
	
    def destroy = {
    }
}
