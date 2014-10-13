package sgt

import grails.validation.ValidationException

import org.springframework.web.multipart.MultipartFile

import sgt.exceptions.PersonaException
import sgt.exceptions.UnregisteredJugadorException

class JugadorService {
	
	static transactional = true
	
	def filesService
	
	def getDatosPersonales(Usuario user) {
		Usuario result = Usuario.get(user.id)
		return result.persona
	}
	
	def saveDatosPersonales(Usuario user, Persona p) throws ValidationException {
		Usuario result = Usuario.get(user.id)
		if (!result.persona) {
			result.persona = p
			result.save(failOnError: true)
		}
		p.save(failOnError: true)
		if (!result.jugador) {
			Jugador j = new Jugador()
			j.save(failOnError: true)
			result.jugador = j
			result.save(failOnError: true)
		}
	}
	
	def getDatosJugador(Usuario user) {
		Usuario result = Usuario.get(user.id)
		return result.jugador
	}
	
	def saveDatosJugador(Usuario user, Jugador j, MultipartFile profileImage) 
		throws ValidationException, PersonaException {
		Usuario result = Usuario.get(user.id)
		
		if (!result.persona) {
			throw new PersonaException(PersonaException.SIN_DATOS_PERSONALES)
		}
		
		if (!result.jugador) {
			result.jugador = j
			result.save(failOnError: true)
		}
		
		Imagen imagen = (profileImage != null && !profileImage.isEmpty() && filesService.isImage(profileImage)) ? filesService.uploadImage(profileImage) : null
		if (imagen) j.imagen = imagen
		
		j.save(failOnError: true)
	}
		
	def getDomicilio(Usuario user) {
		Usuario result = Usuario.get(user.id)
		return result?.persona?.domicilio
	}
		
	def saveDomicilio(Usuario user, Domicilio d) throws ValidationException, PersonaException {
		Usuario result = Usuario.get(user.id)
		
		if (!result.persona) {
			throw new PersonaException(PersonaException.SIN_DATOS_PERSONALES)
		}
		
		d.save(failOnError: true)
		
		if (!result.persona.domicilio) {
			result.persona.domicilio = d
			result.persona.save(failOnError: true)
			result.save(failOnError: true)
		}
	}
}
