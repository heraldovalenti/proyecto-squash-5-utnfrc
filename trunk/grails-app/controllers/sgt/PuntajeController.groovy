package sgt

import org.springframework.dao.DataIntegrityViolationException

class PuntajeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	static idTorneo
	
	def cargarPuntaje(Long id) 
	{
		def torneoPuntuableInstance = TorneoPuntuable.get(id)
		
		if (!torneoPuntuableInstance.getPuntajeTorneo()) {
			def puntajeInstance = new Puntaje().save()
			torneoPuntuableInstance.setPuntajeTorneo(puntajeInstance)
			torneoPuntuableInstance.save()
			idTorneo= torneoPuntuableInstance.id
		}
		if(!torneoPuntuableInstance.getPuntajeTorneo().getDetalles()) {
			redirect(controller: 'detallePuntaje', action:'create', id: torneoPuntuableInstance.getPuntajeTorneo().id)
		}
		else {
			redirect(controller: 'detallePuntaje', action:'listarDetalles', id: id)
		}
	}
	

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [puntajeInstanceList: Puntaje.list(params), puntajeInstanceTotal: Puntaje.count()]
    }

    def create() {
        [puntajeInstance: new Puntaje(params)]
    }

    def save(Long id) {
		def torneoPuntuableInstance = TorneoPuntuable.get(idTorneo)
        def puntajeInstance = new Puntaje(params)
        if (!puntajeInstance.save(flush: true)) {
            render(view: "create", model: [puntajeInstance: puntajeInstance])						
            return
        }
		torneoPuntuableInstance.setPuntajeTorneo(puntajeInstance)
        flash.message = message(code: 'default.created.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), puntajeInstance.id])
        redirect(action: "show", id: puntajeInstance.id)
    }

    def show(Long id) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        [puntajeInstance: puntajeInstance]
    }

    def edit(Long id) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        [puntajeInstance: puntajeInstance]
    }

    def update(Long id, Long version) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (puntajeInstance.version > version) {
                puntajeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'puntaje.label', default: 'Puntaje')] as Object[],
                          "Another user has updated this Puntaje while you were editing")
                render(view: "edit", model: [puntajeInstance: puntajeInstance])
                return
            }
        }

        puntajeInstance.properties = params

        if (!puntajeInstance.save(flush: true)) {
            render(view: "edit", model: [puntajeInstance: puntajeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), puntajeInstance.id])
        redirect(action: "show", id: puntajeInstance.id)
    }

    def delete(Long id) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        try {
            puntajeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "show", id: id)
        }
    }
}
