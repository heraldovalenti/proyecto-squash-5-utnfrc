package sgt

import org.springframework.dao.DataIntegrityViolationException

class DetalleResultadosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [detalleResultadosInstanceList: DetalleResultados.list(params), detalleResultadosInstanceTotal: DetalleResultados.count()]
    }

    def create() {
        [detalleResultadosInstance: new DetalleResultados(params)]
    }

    def save() {
        def detalleResultadosInstance = new DetalleResultados(params)
        if (!detalleResultadosInstance.save(flush: true)) {
            render(view: "create", model: [detalleResultadosInstance: detalleResultadosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), detalleResultadosInstance.id])
        redirect(action: "show", id: detalleResultadosInstance.id)
    }

    def show(Long id) {
        def detalleResultadosInstance = DetalleResultados.get(id)
        if (!detalleResultadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), id])
            redirect(action: "list")
            return
        }

        [detalleResultadosInstance: detalleResultadosInstance]
    }

    def edit(Long id) {
        def detalleResultadosInstance = DetalleResultados.get(id)
        if (!detalleResultadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), id])
            redirect(action: "list")
            return
        }

        [detalleResultadosInstance: detalleResultadosInstance]
    }

    def update(Long id, Long version) {
        def detalleResultadosInstance = DetalleResultados.get(id)
        if (!detalleResultadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (detalleResultadosInstance.version > version) {
                detalleResultadosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'detalleResultados.label', default: 'DetalleResultados')] as Object[],
                          "Another user has updated this DetalleResultados while you were editing")
                render(view: "edit", model: [detalleResultadosInstance: detalleResultadosInstance])
                return
            }
        }

        detalleResultadosInstance.properties = params

        if (!detalleResultadosInstance.save(flush: true)) {
            render(view: "edit", model: [detalleResultadosInstance: detalleResultadosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), detalleResultadosInstance.id])
        redirect(action: "show", id: detalleResultadosInstance.id)
    }

    def delete(Long id) {
        def detalleResultadosInstance = DetalleResultados.get(id)
        if (!detalleResultadosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), id])
            redirect(action: "list")
            return
        }

        try {
            detalleResultadosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'detalleResultados.label', default: 'DetalleResultados'), id])
            redirect(action: "show", id: id)
        }
    }
}
