package sgt

import org.springframework.dao.DataIntegrityViolationException

class PartidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def cargarResultado(Long id)
	{
		def partidoInstance = Partido.get(id)	
		
		if (!partidoInstance.resultado) {
			redirect(controller: 'resultadoPartido', action:'create')
			return
		} else {
			redirect(controller: 'resultadoPartido', action: 'show', id: partidoInstance.resultado.id)
			return
		}
		
	}
	
	
	//Acciones del Scaffold

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [partidoInstanceList: Partido.list(params), partidoInstanceTotal: Partido.count()]
    }

    def create() {
        [partidoInstance: new Partido(params)]
    }

    def save() {
        def partidoInstance = new Partido(params)
        if (!partidoInstance.save(flush: true)) {
            render(view: "create", model: [partidoInstance: partidoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'partido.label', default: 'Partido'), partidoInstance.id])
        redirect(action: "show", id: partidoInstance.id)
    }

    def show(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list")
            return
        }

        [partidoInstance: partidoInstance]
    }

    def edit(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list")
            return
        }

        [partidoInstance: partidoInstance]
    }

    def update(Long id, Long version) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (partidoInstance.version > version) {
                partidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'partido.label', default: 'Partido')] as Object[],
                          "Another user has updated this Partido while you were editing")
                render(view: "edit", model: [partidoInstance: partidoInstance])
                return
            }
        }

        partidoInstance.properties = params

        if (!partidoInstance.save(flush: true)) {
            render(view: "edit", model: [partidoInstance: partidoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'partido.label', default: 'Partido'), partidoInstance.id])
        redirect(action: "show", id: partidoInstance.id)
    }

    def delete(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list")
            return
        }

        try {
            partidoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "show", id: id)
        }
    }
}
