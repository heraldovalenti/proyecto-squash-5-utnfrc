package sgt

import org.springframework.dao.DataIntegrityViolationException

class DetalleRankingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [detalleRankingInstanceList: DetalleRanking.list(params), detalleRankingInstanceTotal: DetalleRanking.count()]
    }

    def create() {
        [detalleRankingInstance: new DetalleRanking(params)]
    }

    def save() {
        def detalleRankingInstance = new DetalleRanking(params)
        if (!detalleRankingInstance.save(flush: true)) {
            render(view: "create", model: [detalleRankingInstance: detalleRankingInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), detalleRankingInstance.id])
        redirect(action: "show", id: detalleRankingInstance.id)
    }

    def show(Long id) {
        def detalleRankingInstance = DetalleRanking.get(id)
        if (!detalleRankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), id])
            redirect(action: "list")
            return
        }

        [detalleRankingInstance: detalleRankingInstance]
    }

    def edit(Long id) {
        def detalleRankingInstance = DetalleRanking.get(id)
        if (!detalleRankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), id])
            redirect(action: "list")
            return
        }

        [detalleRankingInstance: detalleRankingInstance]
    }

    def update(Long id, Long version) {
        def detalleRankingInstance = DetalleRanking.get(id)
        if (!detalleRankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (detalleRankingInstance.version > version) {
                detalleRankingInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'detalleRanking.label', default: 'DetalleRanking')] as Object[],
                          "Another user has updated this DetalleRanking while you were editing")
                render(view: "edit", model: [detalleRankingInstance: detalleRankingInstance])
                return
            }
        }

        detalleRankingInstance.properties = params

        if (!detalleRankingInstance.save(flush: true)) {
            render(view: "edit", model: [detalleRankingInstance: detalleRankingInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), detalleRankingInstance.id])
        redirect(action: "show", id: detalleRankingInstance.id)
    }

    def delete(Long id) {
        def detalleRankingInstance = DetalleRanking.get(id)
        if (!detalleRankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), id])
            redirect(action: "list")
            return
        }

        try {
            detalleRankingInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'detalleRanking.label', default: 'DetalleRanking'), id])
            redirect(action: "show", id: id)
        }
    }
}
