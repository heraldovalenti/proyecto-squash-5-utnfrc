package sgt.administracion.torneos
import sgt.TorneoPuntuable
import sgt.Torneo

import org.springframework.dao.DataIntegrityViolationException

class TorneoPuntuableController {

	static namespace = "admin"
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def torneoPuntuableService
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
        render(view: "/administracion/torneosPuntuables/list", model: [torneoPuntuableInstanceList: TorneoPuntuable.list(params), torneoPuntuableInstanceTotal: TorneoPuntuable.count(), ordenesAnualesValidos: torneoPuntuableService.checkOrders()])
    }

    def create() {
        render(view: "/administracion/torneosPuntuables/create", model: [torneoPuntuableInstance: new TorneoPuntuable(params)])
    }

    def save(Long id) {
		def torneoPuntuableInstance = new TorneoPuntuable(params)
		if (params.activo) torneoPuntuableInstance.setActivo(true)
        if (!torneoPuntuableInstance.save(flush: true)) {
            render(view: "/administracion/torneosPuntuables/create", model: [torneoPuntuableInstance: torneoPuntuableInstance])
            return
        }
        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: torneoPuntuableInstance.id)
    }

    def show(Long id) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/administracion/torneosPuntuables/show", model: [torneoPuntuableInstance: torneoPuntuableInstance])
    }

    def edit(Long id) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/administracion/torneosPuntuables/edit", model: [torneoPuntuableInstance: torneoPuntuableInstance])
    }

    def update(Long id, Long version) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (torneoPuntuableInstance.version > version) {
                torneoPuntuableInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable')] as Object[],
                          "Another user has updated this TorneoPuntuable while you were editing")
                render(view: "/administracion/torneosPuntuables/edit", model: [torneoPuntuableInstance: torneoPuntuableInstance])
                return
            }
        }

        torneoPuntuableInstance.properties = params
		if (params.activo) torneoPuntuableInstance.setActivo(true)

        if (!torneoPuntuableInstance.save(flush: true)) {
            render(view: "/administracion/torneosPuntuables/edit", model: [torneoPuntuableInstance: torneoPuntuableInstance])
            return
        }

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: torneoPuntuableInstance.id)
    }

    def delete(Long id) {
        def torneoPuntuableInstance = TorneoPuntuable.get(id)
        if (!torneoPuntuableInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        try {
            torneoPuntuableInstance.delete(flush: true)
            flash.message = message(code: 'sgt.registrodatos.exito', args: [message(code: 'torneoPuntuable.label', default: 'TorneoPuntuable'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = "No se puede eliminar este Torneo Puntuable"
            redirect(action: "show", id: id)
        }
    }
}
