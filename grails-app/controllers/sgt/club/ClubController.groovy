package sgt.club

import grails.validation.ValidationException
import sgt.Club
import sgt.Domicilio
import sgt.ServicioClub
import sgt.Usuario

class ClubController {
	
	def clubService
	def filesService
	def servicioClubService
		
	def index() {
		def Usuario u = session.getAttribute("userLogon")
		
		if (!u) {
			redirect(url: "/")
			return
		}
		
		def club = clubService.clubLogon(u)
		render(view: "inicioClub", model: [club: club])
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
		Club clubInstance = new Club(params)
		def logoClub = request.getFile("logoClub")
		try {
			clubService.registrarDatosClub(userLogon, clubInstance, logoClub)
			flash.message = "Datos de club registrados"
			redirect(action: "show")
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
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
			flash.errors = e.errors.allErrors
			render (view: "edit", model: [clubInstance: clubInstance])
		} catch (e) {
			flash.exception = e
			render (view: "edit", model: [clubInstance: clubInstance])
		}
    }
	
	def showDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club clubInstance = clubService.clubLogon(userLogon)
		
		if (!clubInstance) {
			flash.message = "Deben registrarse los datos del club para gestionar el domicilio"
			forward controller: "club", action: "datosClub"
			return
		}
		
		if (clubInstance.domicilio) {
			render(view: "/club/domicilio/show", model: [domicilioInstance: clubInstance.domicilio])			
		} else {
			render(view: "/club/domicilio/edit", model: [domicilioInstance: new Domicilio()])
		}
	}
	
	def editDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club clubInstance = clubService.clubLogon(userLogon)
		Domicilio domicilioClub = clubInstance.domicilio
		render(view: "/club/domicilio/edit", model: [domicilioInstance: domicilioClub])
	}
	
	def saveDomicilio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club clubInstance = clubService.clubLogon(userLogon)
		Domicilio domicilioClub = (clubInstance.domicilio) ? clubInstance.domicilio : new Domicilio()
		bindData(domicilioClub,params)
		try {
			clubService.saveDomicilio(clubInstance, domicilioClub)
			flash.message = "Domicilio registrado"
			render(view: "/club/domicilio/show", model: [domicilioInstance: clubInstance.domicilio])
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "/club/domicilio/edit", model: [domicilioInstance: domicilioClub])
		} catch (e) {
			flash.exception = e
			render(view: "/club/domicilio/edit", model: [domicilioInstance: domicilioClub])
		}
	}
	
	def serviciosClub() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club clubInstance = clubService.clubLogon(userLogon)
		if (!clubInstance) {
			flash.message = "Deben registrarse los datos del club para gestionar los servicios"
			forward controller: "club", action: "datosClub"
			return
		}
		def serviciosClub = clubInstance.servicios
		def serviciosDisponibles = servicioClubService.serviciosDisponibles(clubInstance)
		render(view: "/club/servicios/list", model: [serviciosClub: serviciosClub, 
			serviciosDisponibles: serviciosDisponibles])
	}
	
	def agregarServicio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		ServicioClub servicio = new ServicioClub(params)
		try {
			servicioClubService.agregarServicioClub(club, servicio)
			flash.message = "Servicio registrado"
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
		} catch (e) {
			flash.exception = e
		}
		forward controller: "club", action: "serviciosClub"
	}
	
	def quitarServicio() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		ServicioClub servicio = ServicioClub.get(params.servicio)
		if (!servicio) {
			flash.message = "Servicio no encontrado"
			forward controller: "club", action: "serviciosClub"
			return
		}
		try {
			servicioClubService.quitarServicioClub(club, servicio)
			flash.message = "Servicio eliminado"
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
		} catch (e) {
			flash.exception = e
		}
		forward controller: "club", action: "serviciosClub"
	}
	
	def listarClubes(){

		def club

		if(!params.club){
			club=clubService.obtenerClubInicio()
		}
		else{
			def id= params.club
			club=Club.get(id)
		}

		def clubes=clubService.listarClubes()

		render(view:"listadoClub",model:[listadoClub:clubes,club:club])
	}
}
