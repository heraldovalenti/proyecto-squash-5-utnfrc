package sgt

import org.springframework.dao.DataIntegrityViolationException

class TorneoPuntuableController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def torneoPuntuableService
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [torneoPuntuableInstanceList: TorneoPuntuable.list(params), torneoPuntuableInstanceTotal: TorneoPuntuable.count(), ordenesAnualesValidos: torneoPuntuableService.checkOrders()]
    }

    def create() {
        [torneoPuntuableInstance: new TorneoPuntuable(params)]
    }

    def save(Long id) {
		def puntajeInstance= Puntaje.get(id)
        def torneoPuntuableInstance = new TorneoPuntuable(params)
        if (!torneoPuntuableInstance.save(flush: true)) {
            render(view: "create", model: [torneoPuntuableInstance: torneoPuntuableInstance])
            return
        }
		torneoPuntuableInstance.setPuntajeTorneo(puntajeInstance)
        flash.message = message(code: 'default.created.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), torneoPuntuableInstance.id])
        redirect(action: "show", id: torneoPuntuableInstance.id)
    }

    def show(Long id) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "list")
            return
        }

        [torneoPuntuableInstance: torneoPuntuableInstance]
    }

    def edit(Long id) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "list")
            return
        }

        [torneoPuntuableInstance: torneoPuntuableInstance]
    }

    def update(Long id, Long version) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (torneoPuntuableInstance.version > version) {
                torneoPuntuableInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable')] as Object[],
                          "Another user has updated this TorneoPuntuable while you were editing")
                render(view: "edit", model: [torneoPuntuableInstance: torneoPuntuableInstance])
                return
            }
        }

        torneoPuntuableInstance.properties = params

        if (!torneoPuntuableInstance.save(flush: true)) {
            render(view: "edit", model: [torneoPuntuableInstance: torneoPuntuableInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), torneoPuntuableInstance.id])
        redirect(action: "show", id: torneoPuntuableInstance.id)
    }

    def delete(Long id) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "list")
            return
        }

        try {
            torneoPuntuableInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "show", id: id)
        }
    }
}
