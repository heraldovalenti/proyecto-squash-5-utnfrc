package sgt

import grails.validation.ValidationException

import org.junit.Assert
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

import sgt.exceptions.UnregisteredClubException

class ClubService {
	
	def filesService
		
    Club clubLogon(Usuario userLogon) {
		Usuario u = Usuario.get(userLogon.id)
		return u.club
    }
	
	def registrarDatosClub(Usuario userLogon, Club club, MultipartFile logo) {
		userLogon = Usuario.get(userLogon.id)
		if (!userLogon.esClub()) {
			userLogon.errors.rejectValue("club", "", "No es un club")
			throw new ValidationException("No se pudieron registrar los datos de club", userLogon.errors)
		}
		if (logo != null && !logo.isEmpty() && !filesService.isImage(logo) ) {
			club.errors.rejectValue("imagen", "", "Formato no permitido")
			throw new ValidationException("No se pudieron registrar los datos de club", club.errors)
		}
		
		Imagen logoClub = (logo != null && !logo.isEmpty() && filesService.isImage(logo)) ? filesService.uploadImage(logo) : null 
		
		club.validado = false
		club.imagen = logoClub
		club.save(failOnError: true)
		
		userLogon.setClub(club)
		userLogon.save(failOnError: true)
		return club
	}
	
	def actualizarDatosClub(Club club, MultipartFile logo) {
		if (logo != null && !logo.isEmpty() && !filesService.isImage(logo) ) {
			club.errors.rejectValue("imagen", "", "Formato no permitido")
			throw new ValidationException("No se pudieron registrar los datos de club", club.errors)
		}
		
		if (logo != null && !logo.isEmpty() && filesService.isImage(logo)) {
			Imagen logoClub = filesService.uploadImage(logo)
			club.imagen = logoClub
		}
		club.save(failOnError: true)
		
		return club
	}
	
	def verEncargados(Club club) {
		if (club == null) {
			throw new UnregisteredClubException()
		}
		club = Club.get(club.id)
		return club.encargados
	}
	
	Usuario verEncargado(Club club, Usuario usuarioEncargado) {
		def encargados = verEncargados(club)
		for (Usuario encargado : encargados) {
			if (encargado.id == usuarioEncargado.id) {
				return encargado
			}
		}
		return null
	}
	
	def agregarEncargado(Club club, Usuario usuarioEncargado, Persona datosEncargado) {
		if (club == null) {
			throw new UnregisteredClubException()
		}
		datosEncargado.save(failOnError: true)
		
		Rol rolEncargado = Rol.findByNombre("Encargado club")
		usuarioEncargado.persona = datosEncargado
		usuarioEncargado.rol = rolEncargado
		usuarioEncargado.club = club
		usuarioEncargado.activo = true
		usuarioEncargado.save(failOnError: true)
		
		club.addToEncargados(usuarioEncargado)
		club.save(failOnError: true)
	}
	
	def modificarEncargado(Map params) {
		Usuario usuarioEncargado = Usuario.get(params.encargado)
		Persona datosEncargado = usuarioEncargado.persona
		
		usuarioEncargado.properties = params
		datosEncargado.properties = params
		
		datosEncargado.save(failOnError: true)
		usuarioEncargado.save(failOnError: true)
	}
	
	def saveDomicilio(Club club, Domicilio domicilio) {
		if (club == null) {
			throw new UnregisteredClubException()
		}
		
		domicilio.save(failOnError: true)
		club.domicilio = domicilio
		club.save(failOnError: true)
	}
}
