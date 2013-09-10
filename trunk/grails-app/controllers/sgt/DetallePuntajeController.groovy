package sgt

import org.springframework.dao.DataIntegrityViolationException

class DetallePuntajeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [detallePuntajeInstanceList: DetallePuntaje.list(params), detallePuntajeInstanceTotal: DetallePuntaje.count()]
    }

    def create() {
        [detallePuntajeInstance: new DetallePuntaje(params)]
    }

    def save() {
        def detallePuntajeInstance = new DetallePuntaje(params)
        if (!detallePuntajeInstance.save(flush: true)) {
            render(view: "create", model: [detallePuntajeInstance: detallePuntajeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), detallePuntajeInstance.id])
        redirect(action: "show", id: detallePuntajeInstance.id)
    }

    def show(Long id) {
        def detallePuntajeInstance = DetallePuntaje.get(id)
        if (!detallePuntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), id])
            redirect(action: "list")
            return
        }

        [detallePuntajeInstance: detallePuntajeInstance]
    }

    def edit(Long id) {
        def detallePuntajeInstance = DetallePuntaje.get(id)
        if (!detallePuntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), id])
            redirect(action: "list")
            return
        }

        [detallePuntajeInstance: detallePuntajeInstance]
    }

    def update(Long id, Long version) {
        def detallePuntajeInstance = DetallePuntaje.get(id)
        if (!detallePuntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (detallePuntajeInstance.version > version) {
                detallePuntajeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'detallePuntaje.label', default: 'DetallePuntaje')] as Object[],
                          "Another user has updated this DetallePuntaje while you were editing")
                render(view: "edit", model: [detallePuntajeInstance: detallePuntajeInstance])
                return
            }
        }

        detallePuntajeInstance.properties = params

        if (!detallePuntajeInstance.save(flush: true)) {
            render(view: "edit", model: [detallePuntajeInstance: detallePuntajeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), detallePuntajeInstance.id])
        redirect(action: "show", id: detallePuntajeInstance.id)
    }

    def delete(Long id) {
        def detallePuntajeInstance = DetallePuntaje.get(id)
        if (!detallePuntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), id])
            redirect(action: "list")
            return
        }

        try {
            detallePuntajeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'detallePuntaje.label', default: 'DetallePuntaje'), id])
            redirect(action: "show", id: id)
        }
    }
}
