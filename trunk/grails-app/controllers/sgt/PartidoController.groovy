package sgt

import org.springframework.dao.DataIntegrityViolationException

class PartidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def cargarResultado(Long id)
	{
		def partidoInstance = Partido.get(id)
		redirect(controller: 'resultadoPartido', action:'cargarResultado', id: id)
		return
	}
	
	
	//Acciones del Scaffold

    def index() {
        redirect(action: "list1", params: params)
    }

    def list1(Integer max) {
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
        redirect(action: "show1", id: partidoInstance.id)
    }

    def show1(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        [partidoInstance: partidoInstance]
    }

    def edit(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        [partidoInstance: partidoInstance]
    }

    def update(Long id, Long version) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
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
        redirect(action: "show1", id: partidoInstance.id)
    }

    def delete(Long id) {
        def partidoInstance = Partido.get(id)
        if (!partidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
            return
        }

        try {
            partidoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "list1")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'partido.label', default: 'Partido'), id])
            redirect(action: "show1", id: id)
        }
    }
}
