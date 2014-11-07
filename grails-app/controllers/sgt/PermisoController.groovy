package sgt

import org.springframework.dao.DataIntegrityViolationException

class PermisoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [permisoInstanceList: Permiso.list(params), permisoInstanceTotal: Permiso.count()]
    }

    def create() {
        [permisoInstance: new Permiso()]
    }

    def save() {
        def permisoInstance = new Permiso(params)
		permisoInstance.controller = params._controller
		permisoInstance.action = params._action
        if (!permisoInstance.save(flush: true)) {
            render(view: "create", model: [permisoInstance: permisoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'permiso.label', default: 'Permiso'), permisoInstance.id])
        redirect(action: "show", id: permisoInstance.id)
    }

    def show(Long id) {
        def permisoInstance = Permiso.get(id)
        if (!permisoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'permiso.label', default: 'Permiso'), id])
            redirect(action: "list")
            return
        }

        [permisoInstance: permisoInstance]
    }

    def edit(Long id) {
        def permisoInstance = Permiso.get(id)
        if (!permisoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'permiso.label', default: 'Permiso'), id])
            redirect(action: "list")
            return
        }

        [permisoInstance: permisoInstance]
    }

    def update(Long id, Long version) {
        def permisoInstance = Permiso.get(id)
        if (!permisoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'permiso.label', default: 'Permiso'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (permisoInstance.version > version) {
                permisoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'permiso.label', default: 'Permiso')] as Object[],
                          "Another user has updated this Permiso while you were editing")
                render(view: "edit", model: [permisoInstance: permisoInstance])
                return
            }
        }

        permisoInstance.properties = params
		permisoInstance.controller = params._controller
		permisoInstance.action = params._action

        if (!permisoInstance.save(flush: true)) {
            render(view: "edit", model: [permisoInstance: permisoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'permiso.label', default: 'Permiso'), permisoInstance.id])
        redirect(action: "show", id: permisoInstance.id)
    }

    def delete(Long id) {
        def permisoInstance = Permiso.get(id)
        if (!permisoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'permiso.label', default: 'Permiso'), id])
            redirect(action: "list")
            return
        }

        try {
            permisoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'permiso.label', default: 'Permiso'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'permiso.label', default: 'Permiso'), id])
            redirect(action: "show", id: id)
        }
    }
}
