package sgt

import org.springframework.dao.DataIntegrityViolationException

class DomicilioController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [domicilioInstanceList: Domicilio.list(params), domicilioInstanceTotal: Domicilio.count()]
    }

    def create() {
        [domicilioInstance: new Domicilio(params)]
    }

    def save() {
		def u = (sgt.Usuario) session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
        def domicilioInstance = new Domicilio(params)
        if (!domicilioInstance.save(flush: true)) {
            render(view: "create", model: [domicilioInstance: domicilioInstance])
            return
        }
		
		u.setDomicilio(domicilioInstance)
		u.save()

        flash.message = message(code: 'default.created.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), domicilioInstance.id])
        redirect(action: "show", id: domicilioInstance.id)
    }

    def show(Long id) {
        def domicilioInstance = Domicilio.get(id)
        if (!domicilioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), id])
            redirect(action: "list")
            return
        }

        [domicilioInstance: domicilioInstance]
    }

    def edit(Long id) {
        def domicilioInstance = Domicilio.get(id)
        if (!domicilioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), id])
            redirect(action: "list")
            return
        }

        [domicilioInstance: domicilioInstance]
    }

    def update(Long id, Long version) {
		def u = (sgt.Usuario) session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
        def domicilioInstance = Domicilio.get(id)
        if (!domicilioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (domicilioInstance.version > version) {
                domicilioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'domicilio.label', default: 'Domicilio')] as Object[],
                          "Another user has updated this Domicilio while you were editing")
                render(view: "edit", model: [domicilioInstance: domicilioInstance])
                return
            }
        }

        domicilioInstance.properties = params

        if (!domicilioInstance.save(flush: true)) {
            render(view: "edit", model: [domicilioInstance: domicilioInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), domicilioInstance.id])
        redirect(action: "show", id: domicilioInstance.id)
    }

    def delete(Long id) {
        def domicilioInstance = Domicilio.get(id)
        if (!domicilioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), id])
            redirect(action: "list")
            return
        }

        try {
            domicilioInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'domicilio.label', default: 'Domicilio'), id])
            redirect(action: "show", id: id)
        }
    }
}
