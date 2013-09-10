package sgt

import org.springframework.dao.DataIntegrityViolationException

class RankingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [rankingInstanceList: Ranking.list(params), rankingInstanceTotal: Ranking.count()]
    }

    def create() {
        [rankingInstance: new Ranking(params)]
    }

    def save() {
        def rankingInstance = new Ranking(params)
        if (!rankingInstance.save(flush: true)) {
            render(view: "create", model: [rankingInstance: rankingInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ranking.label', default: 'Ranking'), rankingInstance.id])
        redirect(action: "show", id: rankingInstance.id)
    }

    def show(Long id) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        [rankingInstance: rankingInstance]
    }

    def edit(Long id) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        [rankingInstance: rankingInstance]
    }

    def update(Long id, Long version) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (rankingInstance.version > version) {
                rankingInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ranking.label', default: 'Ranking')] as Object[],
                          "Another user has updated this Ranking while you were editing")
                render(view: "edit", model: [rankingInstance: rankingInstance])
                return
            }
        }

        rankingInstance.properties = params

        if (!rankingInstance.save(flush: true)) {
            render(view: "edit", model: [rankingInstance: rankingInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ranking.label', default: 'Ranking'), rankingInstance.id])
        redirect(action: "show", id: rankingInstance.id)
    }

    def delete(Long id) {
        def rankingInstance = Ranking.get(id)
        if (!rankingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
            return
        }

        try {
            rankingInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ranking.label', default: 'Ranking'), id])
            redirect(action: "show", id: id)
        }
    }
}
