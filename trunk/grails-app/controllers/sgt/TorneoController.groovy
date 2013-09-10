package sgt

import org.springframework.dao.DataIntegrityViolationException

class TorneoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	
	
    def index() {
        redirect(action: "list", params: params)
    }
	
	def listaFechasPuntuables() {
		
	}

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [torneoInstanceList: Torneo.list(params), torneoInstanceTotal: Torneo.count()]
    }

    def create() {
        [torneoInstance: new Torneo(params)]
    }

    def save() {
        def torneoInstance = new Torneo(params)
        if (!torneoInstance.save(flush: true)) {
            render(view: "create", model: [torneoInstance: torneoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'torneo.label', default: 'Torneo'), torneoInstance.id])
        redirect(action: "show", id: torneoInstance.id)
    }

    def show(Long id) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneo.label', default: 'Torneo'), id])
            redirect(action: "list")
            return
        }

        [torneoInstance: torneoInstance]
    }

    def edit(Long id) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneo.label', default: 'Torneo'), id])
            redirect(action: "list")
            return
        }

        [torneoInstance: torneoInstance]
    }

    def update(Long id, Long version) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneo.label', default: 'Torneo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (torneoInstance.version > version) {
                torneoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'torneo.label', default: 'Torneo')] as Object[],
                          "Another user has updated this Torneo while you were editing")
                render(view: "edit", model: [torneoInstance: torneoInstance])
                return
            }
        }

        torneoInstance.properties = params

        if (!torneoInstance.save(flush: true)) {
            render(view: "edit", model: [torneoInstance: torneoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'torneo.label', default: 'Torneo'), torneoInstance.id])
        redirect(action: "show", id: torneoInstance.id)
    }

    def delete(Long id) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneo.label', default: 'Torneo'), id])
            redirect(action: "list")
            return
        }

        try {
            torneoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'torneo.label', default: 'Torneo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'torneo.label', default: 'Torneo'), id])
            redirect(action: "show", id: id)
        }
    }
}
