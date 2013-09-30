package sgt

import org.springframework.dao.DataIntegrityViolationException

class ResultadoPartidoController {
	
	def cargarResultado(Long id) {
		def partidoInstance = Partido.get(id)
		
		if (!partidoInstance.getResultado()) {
			def resultadoInstance = new ResultadoPartido().save()
			partidoInstance.setResultado(resultadoInstance)
			partidoInstance.save()
		}
		
		if(!partidoInstance.getResultado().getDetalles()) {
			redirect(controller: 'detalleResultados', action:'create', id: id)
		}
		else {
			redirect(controller: 'detalleResultados', action:'listarDetalles', id: id)
		}
	}
	
	def cargarSet(Long id)
	{
		redirect(controller: 'detalleResultados', action:'create', id: id)
	}
	
	//Acciones del Scaffold

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [resultadoPartidoInstanceList: ResultadoPartido.list(params), resultadoPartidoInstanceTotal: ResultadoPartido.count()]
    }

    def create() {
        [resultadoPartidoInstance: new ResultadoPartido(params)]
    }

    def save(Long id) {
		def partidoInstance= Partido.get(id)
		
        def resultadoPartidoInstance = new ResultadoPartido(params)
        if (!resultadoPartidoInstance.save(flush: true)) {
            render(view: "create", model: [resultadoPartidoInstance: resultadoPartidoInstance])
			partidoInstance.setResultado(resultadoPartidoInstance)
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), resultadoPartidoInstance.id])
        redirect(action: "show", id: resultadoPartidoInstance.id)
		
		
    }

    def show(Long id) {
        def resultadoPartidoInstance = ResultadoPartido.get(id)
        if (!resultadoPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), id])
            redirect(action: "list")
            return
        }

        [resultadoPartidoInstance: resultadoPartidoInstance]
    }

    def edit(Long id) {
        def resultadoPartidoInstance = ResultadoPartido.get(id)
        if (!resultadoPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), id])
            redirect(action: "list")
            return
        }

        [resultadoPartidoInstance: resultadoPartidoInstance]
    }

    def update(Long id, Long version) {
        def resultadoPartidoInstance = ResultadoPartido.get(id)
        if (!resultadoPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (resultadoPartidoInstance.version > version) {
                resultadoPartidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'resultadoPartido.label', default: 'ResultadoPartido')] as Object[],
                          "Another user has updated this ResultadoPartido while you were editing")
                render(view: "edit", model: [resultadoPartidoInstance: resultadoPartidoInstance])
                return
            }
        }

        resultadoPartidoInstance.properties = params

        if (!resultadoPartidoInstance.save(flush: true)) {
            render(view: "edit", model: [resultadoPartidoInstance: resultadoPartidoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), resultadoPartidoInstance.id])
        redirect(action: "show", id: resultadoPartidoInstance.id)
    }

    def delete(Long id) {
        def resultadoPartidoInstance = ResultadoPartido.get(id)
        if (!resultadoPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), id])
            redirect(action: "list")
            return
        }

        try {
            resultadoPartidoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'resultadoPartido.label', default: 'ResultadoPartido'), id])
            redirect(action: "show", id: id)
        }
    }
}
