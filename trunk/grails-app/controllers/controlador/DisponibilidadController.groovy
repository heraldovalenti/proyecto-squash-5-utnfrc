package controlador

import modelo.Disponibilidad;

import org.springframework.dao.DataIntegrityViolationException

class DisponibilidadController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [disponibilidadInstanceList: Disponibilidad.list(params), disponibilidadInstanceTotal: Disponibilidad.count()]
    }

    def create() {
        [disponibilidadInstance: new Disponibilidad(params)]
    }

    def save() {
        def disponibilidadInstance = new Disponibilidad(params)
        if (!disponibilidadInstance.save(flush: true)) {
            render(view: "create", model: [disponibilidadInstance: disponibilidadInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), disponibilidadInstance.id])
        redirect(action: "show", id: disponibilidadInstance.id)
    }

    def show(Long id) {
        def disponibilidadInstance = Disponibilidad.get(id)
        if (!disponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), id])
            redirect(action: "list")
            return
        }

        [disponibilidadInstance: disponibilidadInstance]
    }

    def edit(Long id) {
        def disponibilidadInstance = Disponibilidad.get(id)
        if (!disponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), id])
            redirect(action: "list")
            return
        }

        [disponibilidadInstance: disponibilidadInstance]
    }

    def update(Long id, Long version) {
        def disponibilidadInstance = Disponibilidad.get(id)
        if (!disponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (disponibilidadInstance.version > version) {
                disponibilidadInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'disponibilidad.label', default: 'Disponibilidad')] as Object[],
                          "Another user has updated this Disponibilidad while you were editing")
                render(view: "edit", model: [disponibilidadInstance: disponibilidadInstance])
                return
            }
        }

        disponibilidadInstance.properties = params

        if (!disponibilidadInstance.save(flush: true)) {
            render(view: "edit", model: [disponibilidadInstance: disponibilidadInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), disponibilidadInstance.id])
        redirect(action: "show", id: disponibilidadInstance.id)
    }

    def delete(Long id) {
        def disponibilidadInstance = Disponibilidad.get(id)
        if (!disponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), id])
            redirect(action: "list")
            return
        }

        try {
            disponibilidadInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'disponibilidad.label', default: 'Disponibilidad'), id])
            redirect(action: "show", id: id)
        }
    }
}
