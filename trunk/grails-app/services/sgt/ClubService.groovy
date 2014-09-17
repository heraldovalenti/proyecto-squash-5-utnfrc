package sgt

import grails.validation.ValidationException

import org.springframework.web.multipart.MultipartFile

class ClubService {
	
	def filesService
		
    Club clubLogon(Usuario userLogon) {
		userLogon.refresh()
		userLogon = userLogon.merge()
		return userLogon.club
    }
	
	def registrarDatosClub(Usuario userLogon, Club club, MultipartFile logo) {
		userLogon = userLogon.merge()
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
}
