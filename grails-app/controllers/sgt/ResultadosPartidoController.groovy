package sgt

import org.springframework.dao.DataIntegrityViolationException

class ResultadosPartidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [resultadosPartidoInstanceList: ResultadosPartido.list(params), resultadosPartidoInstanceTotal: ResultadosPartido.count()]
    }

    def create() {
        [resultadosPartidoInstance: new ResultadosPartido(params)]
    }

    def save() {
        def resultadosPartidoInstance = new ResultadosPartido(params)
        if (!resultadosPartidoInstance.save(flush: true)) {
            render(view: "create", model: [resultadosPartidoInstance: resultadosPartidoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), resultadosPartidoInstance.id])
        redirect(action: "show", id: resultadosPartidoInstance.id)
    }

    def show(Long id) {
        def resultadosPartidoInstance = ResultadosPartido.get(id)
        if (!resultadosPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), id])
            redirect(action: "list")
            return
        }

        [resultadosPartidoInstance: resultadosPartidoInstance]
    }

    def edit(Long id) {
        def resultadosPartidoInstance = ResultadosPartido.get(id)
        if (!resultadosPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), id])
            redirect(action: "list")
            return
        }

        [resultadosPartidoInstance: resultadosPartidoInstance]
    }

    def update(Long id, Long version) {
        def resultadosPartidoInstance = ResultadosPartido.get(id)
        if (!resultadosPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (resultadosPartidoInstance.version > version) {
                resultadosPartidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'resultadosPartido.label', default: 'ResultadosPartido')] as Object[],
                          "Another user has updated this ResultadosPartido while you were editing")
                render(view: "edit", model: [resultadosPartidoInstance: resultadosPartidoInstance])
                return
            }
        }

        resultadosPartidoInstance.properties = params

        if (!resultadosPartidoInstance.save(flush: true)) {
            render(view: "edit", model: [resultadosPartidoInstance: resultadosPartidoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), resultadosPartidoInstance.id])
        redirect(action: "show", id: resultadosPartidoInstance.id)
    }

    def delete(Long id) {
        def resultadosPartidoInstance = ResultadosPartido.get(id)
        if (!resultadosPartidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), id])
            redirect(action: "list")
            return
        }

        try {
            resultadosPartidoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'resultadosPartido.label', default: 'ResultadosPartido'), id])
            redirect(action: "show", id: id)
        }
    }
	def mostrar(){}
}
