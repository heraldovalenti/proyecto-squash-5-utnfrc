package sgt

import org.springframework.dao.DataIntegrityViolationException

class ServicioClubController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [servicioClubInstanceList: ServicioClub.list(params), servicioClubInstanceTotal: ServicioClub.count()]
    }

    def create() {
        [servicioClubInstance: new ServicioClub(params)]
    }

    def save() {
        def servicioClubInstance = new ServicioClub(params)
        if (!servicioClubInstance.save(flush: true)) {
            render(view: "create", model: [servicioClubInstance: servicioClubInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), servicioClubInstance.id])
        redirect(action: "show", id: servicioClubInstance.id)
    }

    def show(Long id) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), id])
            redirect(action: "list")
            return
        }

        [servicioClubInstance: servicioClubInstance]
    }

    def edit(Long id) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), id])
            redirect(action: "list")
            return
        }

        [servicioClubInstance: servicioClubInstance]
    }

    def update(Long id, Long version) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (servicioClubInstance.version > version) {
                servicioClubInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'servicioClub.label', default: 'ServicioClub')] as Object[],
                          "Another user has updated this ServicioClub while you were editing")
                render(view: "edit", model: [servicioClubInstance: servicioClubInstance])
                return
            }
        }

        servicioClubInstance.properties = params

        if (!servicioClubInstance.save(flush: true)) {
            render(view: "edit", model: [servicioClubInstance: servicioClubInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), servicioClubInstance.id])
        redirect(action: "show", id: servicioClubInstance.id)
    }

    def delete(Long id) {
        def servicioClubInstance = ServicioClub.get(id)
        if (!servicioClubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), id])
            redirect(action: "list")
            return
        }

        try {
            servicioClubInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'servicioClub.label', default: 'ServicioClub'), id])
            redirect(action: "show", id: id)
        }
    }
}
