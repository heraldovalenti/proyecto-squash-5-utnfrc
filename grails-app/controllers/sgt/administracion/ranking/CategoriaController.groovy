package sgt.administracion.ranking

import org.springframework.dao.DataIntegrityViolationException

import sgt.Categoria;

class CategoriaController {
	
	static namespace = "admin"

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view: "/administracion/ranking/categorias/list", model: [categoriaInstanceList: Categoria.list(params), categoriaInstanceTotal: Categoria.count()])
    }

    def create() {
        render(view: "/administracion/ranking/categorias/create", model: [categoriaInstance: new Categoria(params)])
    }

    def save() {
        def categoriaInstance = new Categoria(params)
        if (!categoriaInstance.save(flush: true)) {
            render(view: "/administracion/ranking/categorias/create", model: [categoriaInstance: categoriaInstance])
            return
        }

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: categoriaInstance.id)
    }

    def show(Long id) {
        def categoriaInstance = Categoria.get(id)
        if (!categoriaInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/administracion/ranking/categorias/show", model: [categoriaInstance: categoriaInstance])
    }

    def edit(Long id) {
        def categoriaInstance = Categoria.get(id)
        if (!categoriaInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/administracion/ranking/categorias/edit", model: [categoriaInstance: categoriaInstance])
    }

    def update(Long id, Long version) {
        def categoriaInstance = Categoria.get(id)
        if (!categoriaInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (categoriaInstance.version > version) {
                categoriaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'categoria.label', default: 'Categoria')] as Object[],
                          "Another user has updated this Categoria while you were editing")
                render(view: "/administracion/ranking/categorias/edit", model: [categoriaInstance: categoriaInstance])
                return
            }
        }

        categoriaInstance.properties = params

        if (!categoriaInstance.save(flush: true)) {
            render(view: "/administracion/ranking/categorias/edit", model: [categoriaInstance: categoriaInstance])
            return
        }

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: categoriaInstance.id)
    }

    def delete(Long id) {
        def categoriaInstance = Categoria.get(id)
        if (!categoriaInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        try {
            categoriaInstance.delete(flush: true)
            flash.message = message(code: 'sgt.registrodatos.exito')
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'sgt.registrodatos.fallo')
            redirect(action: "show", id: id)
        }
    }
}
