package modelo

import org.springframework.dao.DataIntegrityViolationException

class DetalleDisponibilidadController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [detalleDisponibilidadInstanceList: DetalleDisponibilidad.list(params), detalleDisponibilidadInstanceTotal: DetalleDisponibilidad.count()]
    }

    def create() {
        [detalleDisponibilidadInstance: new DetalleDisponibilidad(params)]
    }

    def save() {
        def detalleDisponibilidadInstance = new DetalleDisponibilidad(params)
        if (!detalleDisponibilidadInstance.save(flush: true)) {
            render(view: "create", model: [detalleDisponibilidadInstance: detalleDisponibilidadInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), detalleDisponibilidadInstance.id])
        redirect(action: "show", id: detalleDisponibilidadInstance.id)
    }

    def show(Long id) {
        def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
        if (!detalleDisponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
            redirect(action: "list")
            return
        }

        [detalleDisponibilidadInstance: detalleDisponibilidadInstance]
    }

    def edit(Long id) {
        def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
        if (!detalleDisponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
            redirect(action: "list")
            return
        }

        [detalleDisponibilidadInstance: detalleDisponibilidadInstance]
    }

    def update(Long id, Long version) {
        def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
        if (!detalleDisponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (detalleDisponibilidadInstance.version > version) {
                detalleDisponibilidadInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')] as Object[],
                          "Another user has updated this DetalleDisponibilidad while you were editing")
                render(view: "edit", model: [detalleDisponibilidadInstance: detalleDisponibilidadInstance])
                return
            }
        }

        detalleDisponibilidadInstance.properties = params

        if (!detalleDisponibilidadInstance.save(flush: true)) {
            render(view: "edit", model: [detalleDisponibilidadInstance: detalleDisponibilidadInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), detalleDisponibilidadInstance.id])
        redirect(action: "show", id: detalleDisponibilidadInstance.id)
    }

    def delete(Long id) {
        def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
        if (!detalleDisponibilidadInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
            redirect(action: "list")
            return
        }

        try {
            detalleDisponibilidadInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
            redirect(action: "show", id: id)
        }
    }
}
