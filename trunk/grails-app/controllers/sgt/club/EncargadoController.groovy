package sgt.club
import grails.validation.ValidationException
import java.text.SimpleDateFormat
import sgt.*
import sgt.exceptions.UnregisteredClubException

class EncargadoController {
	
	def clubService
	
	def index() {
		Usuario u = session.getAttribute("userLogon")
		Club c = clubService.clubLogon(u)
		try {
			def encargadosClub = clubService.verEncargados(c)
			render(view: "/club/encargado/list", model: [encargadosClub: encargadosClub])
		} catch (UnregisteredClubException e) {
			flash.message = "Deben registrarse los datos del club para gestionar los encargados"
			forward controller: "club", action: "datosClub"
		} catch (e) {
			flash.message = "Deben registrarse los datos del club para gestionar los encargados"
			forward controller: "club", action: "datosClub"
		}
	}
	
	def create() {
		Usuario u = new Usuario(params)
		Persona p = new Persona(params)
		render(view: "/club/encargado/create", model: [usuarioEncargado: u, datosEncargado: p])
	}
	
	def save() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club c = clubService.clubLogon(userLogon)
		params.fechaNacimiento=new SimpleDateFormat("dd/MM/yyyy").parse(params.fechaNacimiento)
		Usuario u = new Usuario(params)
		Persona p = new Persona(params)
		try {
			clubService.agregarEncargado(c, u, p)
			flash.message = "Encargado registrado"
			redirect(action: "index")
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render (view: "/club/encargado/create", model: [usuarioEncargado: u, datosEncargado: p])
		} catch (e) {
			flash.exception = e
			render (view: "/club/encargado/create", model: [usuarioEncargado: u, datosEncargado: p])
		}
	}
	
	def show() {
		Usuario u = Usuario.get(params.encargado)
		Usuario userLogon = session.getAttribute("userLogon")
		Club c = clubService.clubLogon(userLogon)
		u = clubService.verEncargado(c, u)
		if (u != null) {
			render(view: "/club/encargado/show", model: [usuarioEncargado: u, datosEncargado: u.persona])
		} else {
			flash.message = "Encargado no encontrado"
			redirect(action: "index")
		}
	}
	
	def edit() {
		Usuario u = Usuario.get(params.encargado)
		Usuario userLogon = session.getAttribute("userLogon")
		Club c = clubService.clubLogon(userLogon)
		u = clubService.verEncargado(c, u)
		if (u != null) {
			render(view: "/club/encargado/edit", model: [usuarioEncargado: u, datosEncargado: u.persona])
		} else {
			flash.message = "Encargado no encontrado"
			redirect(action: "index")
		}
	}
	
	def update() {
		Usuario u = Usuario.get(params.encargado)
		Usuario userLogon = session.getAttribute("userLogon")
		Club c = clubService.clubLogon(userLogon)
		u = clubService.verEncargado(c, u)
		Persona p = u.persona
		params.fechaNacimiento=new SimpleDateFormat("dd/MM/yyyy").parse(params.fechaNacimiento)
		if (u == null) {
			flash.message = "Encargado no encontrado"
			redirect(action: "index")
		} else {
			try {
				clubService.modificarEncargado(params)
				flash.message = "Encargado actualizado"
				redirect(action: "show", params: params)
			} catch (ValidationException e) {
				flash.errors = e.errors.allErrors
				render (view: "/club/encargado/edit", model: [usuarioEncargado: u, datosEncargado: p])
			} catch (e) {
				flash.exception = e
				render (view: "/club/encargado/edit", model: [usuarioEncargado: u, datosEncargado: p])
			}
		}
	}
}
