package sgt.club
import grails.validation.ValidationException
import sgt.Club
import sgt.ServicioClub
import sgt.Usuario

class ServicioClubController {

	static defaultAction = "list"
	
	def clubService
	def servicioClubService
	
    def list() {
		def serviciosList = ServicioClub.list()
		render(view: "/administracion/serviciosClub/list", model: [serviciosList: serviciosList])
	}
	
	def create() {
		render(view: "/administracion/serviciosClub/create", model: [servicio: new ServicioClub()])
	}
	
	def save() {
		def servicio = new ServicioClub(params)
		try {
			servicio = servicioClubService.saveServicio(servicio)
			flash.message = "Servicio registrado"
			render(view: "/administracion/serviciosClub/show", model: [servicio: servicio])
		} catch (ValidationException e) {
			flash.errors = e.errors
			render(view: "/administracion/serviciosClub/create", model: [servicio: servicio])
		} catch (e) {
			flash.exception = e
			render(view: "/administracion/serviciosClub/create", model: [servicio: servicio])
		}
	}
	
	def show() {
		def servicio = ServicioClub.get(params.servicio)
		if (!servicio) {
			flash.message = "Servicio no encontrado"
			redirect(action: "list")
		} else {
			render(view: "/administracion/serviciosClub/show", model: [servicio: servicio])
		}
	}
	
    def edit() {
        def servicio = ServicioClub.get(params.servicio)
        render(view: "/administracion/serviciosClub/edit", model: [servicio: servicio])
    }

    def update() {
        def servicio = ServicioClub.get(params.servicio)
		bindData(servicio,params)
		try {
			servicio = servicioClubService.saveServicio(servicio)
			flash.message = "Servicio actualizado"
			render(view: "/administracion/serviciosClub/show", model: [servicio: servicio])
		} catch (ValidationException e) {
			flash.errors = e.errors
			render(view: "/administracion/serviciosClub/edit", model: [servicio: servicio])
		} catch (e) {
			flash.exception = e
			render(view: "/administracion/serviciosClub/edit", model: [servicio: servicio])
		}
    }

    def delete() {
		def servicio = ServicioClub.get(params.servicio)
		try {
			servicio = servicioClubService.deleteServicio(servicio)
			flash.message = "Servicio eliminado"
			redirect(action: "list")
		} catch (ValidationException e) {
			flash.errors = e.errors
			render(view: "/administracion/serviciosClub/show", model: [servicio: servicio])
		} catch (e) {
			flash.exception = e
			render(view: "/administracion/serviciosClub/show", model: [servicio: servicio])
		}
    }
}
