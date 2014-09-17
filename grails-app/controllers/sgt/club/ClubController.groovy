package sgt.club

import grails.converters.JSON
import grails.validation.ValidationException
import sgt.Club
import sgt.Usuario

class ClubController {
	
	def clubService
	def filesService
		
	def index() {
		def Usuario u = session.getAttribute("userLogon")
		
		if (!u) {
			redirect(url: "/")
			return
		}
		
		u = Usuario.get(u.id)
		render(view: "inicioClub")
		return
	}
	
	def datosClub() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club c = clubService.clubLogon(userLogon)
		if (c) {
			redirect(action: "show")
			return
		} else {
			redirect(action: "create")
			return
		}
	}

	/* METODOS PARA GESTION DE DATOS DE CLUB*/
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [clubInstanceList: Club.list(params), clubInstanceTotal: Club.count()]
    }

    def create() {
        render (view: "create", model: [clubInstance: new Club(params)])
    }
	
	def show() {
		Usuario userLogon = session.getAttribute("userLogon")
		def club = clubService.clubLogon(userLogon)
		def clubLogo = (club.imagen != null) ? club.imagen.nombre : null
		def imagesDir = filesService.retrieveImagesDir()
		render(view: "show", model: [clubInstance: club, imagesDir: imagesDir, clubLogo : clubLogo])
	}
	
	def edit() {
		Usuario userLogon = session.getAttribute("userLogon")
		def club = clubService.clubLogon(userLogon)
		def clubLogo = (club.imagen != null) ? club.imagen.nombre : null
		def imagesDir = filesService.retrieveImagesDir()
		render(view: "edit", model: [clubInstance: club, imagesDir: imagesDir, clubLogo : clubLogo])
	}

    def save() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club clubInstance = clubService.clubLogon(userLogon)
		def logoClub = request.getFile("logoClub")
		try {
			clubService.registrarDatosClub(userLogon, clubInstance, logoClub)
			flash.message = "Datos de club registrados"
			redirect(action: "show")
		} catch (ValidationException e) {
			flash.errors = e.errors
			render (view: "create", model: [clubInstance: clubInstance])
		} catch (e) {
			flash.exception = e
			render (view: "create", model: [clubInstance: clubInstance])
		}
    }

    def update() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club clubInstance = clubService.clubLogon(userLogon)
		bindData(clubInstance,params)
		def logoClub = request.getFile("logoClub")
		try {
			clubService.actualizarDatosClub(clubInstance, logoClub)
			flash.message = "Datos de club registrados"
			redirect(action: "show")
		} catch (ValidationException e) {
			flash.errors = e.errors
			render (view: "edit", model: [clubInstance: clubInstance])
		} catch (e) {
			flash.exception = e
			render (view: "edit", model: [clubInstance: clubInstance])
		}
    }
}
