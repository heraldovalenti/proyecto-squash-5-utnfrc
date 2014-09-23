package sgt.club
import sgt.ServicioClub
import sgt.Usuario
import sgt.Club

import org.springframework.dao.DataIntegrityViolationException

class ServicioClubController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static namespace = "club"

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id) 
		
		if (!u.getClub()) {
			flash.message = "Deben registrarse los datos del club para gestionar los servicios ofrecidos"
			redirect(controller: "club", action: "create", namespace: "club")
			return
		}
		
		def servicioList = u.getClub().getServicios()
		session.setAttribute("idClub", u.getClub().id)
		render(view: "/club/servicios/list", model: [servicioClubInstanceList: servicioList, servicioClubInstanceTotal: servicioList.size()])
	}

    def create() {
        render(view: "/club/servicios/create", model: [servicioClubInstance: new ServicioClub(params)])
    }

    def save() {
        def servicioClubInstance = new ServicioClub(params)
        if (!servicioClubInstance.save(flush: true)) {
            render(view: "/club/sercicios/create", model: [servicioClubInstance: servicioClubInstance])
            return
        }
		
		def idClub = session.getAttribute("idClub")
		def Club clubInstance = Club.get(idClub)
		clubInstance.addToServicios(servicioClubInstance)
		clubInstance.save()

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: servicioClubInstance.id)
    }

    def show(Long id) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/club/servicios/show", model: [servicioClubInstance: servicioClubInstance])
    }

    def edit(Long id) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/club/servicios/edit", model: [servicioClubInstance: servicioClubInstance])
    }

    def update(Long id, Long version) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (servicioClubInstance.version > version) {
                servicioClubInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'servicioClub.label', default: 'ServicioClub')] as Object[],
                          "Another user has updated this ServicioClub while you were editing")
                render(view: "/club/servicios/edit", model: [servicioClubInstance: servicioClubInstance])
                return
            }
        }

        servicioClubInstance.properties = params

        if (!servicioClubInstance.save(flush: true)) {
            render(view: "/club/servicios/edit", model: [servicioClubInstance: servicioClubInstance])
            return
        }

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: servicioClubInstance.id)
    }

    def delete(Long id) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        try {
            servicioClubInstance.delete(flush: true)
            flash.message = message(code: 'sgt.registrodatos.exito')
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'sgt.registrodatos.fallo')
            redirect(action: "show", id: id)
        }
    }
}
