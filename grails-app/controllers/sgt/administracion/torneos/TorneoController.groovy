package sgt.administracion.torneos

import sgt.Torneo;
import sgt.TorneoPuntuable
import org.springframework.dao.DataIntegrityViolationException



class TorneoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	
	def listaFechasPuntuables() {
		
	}

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view: "/administracion/torneos/list", model: [torneoInstanceList: Torneo.list(params), torneoInstanceTotal: Torneo.count()])
    }
	
	def nuevoTorneo() {
		redirect(action: 'listadoTorneosPuntuables')
	}

    def listadoTorneosPuntuables() {
		def torneoPuntuableInstanceList
		
		if (params.activos) {
			torneoPuntuableInstanceList = TorneoPuntuable.findAllByActivo(true, [params])
		} else {
			torneoPuntuableInstanceList = TorneoPuntuable.list(params)
		}
		render(view: "/administracion/torneos/listadoTorneosPuntuables", model: [torneoPuntuableInstanceList: torneoPuntuableInstanceList, torneoPuntuableInstanceTotal: torneoPuntuableInstanceList.size()])
    }
	
	def seleccionarTorneoPuntuable(Long id) {
		session.setAttribute("idTorneoPuntuable", id)
		create()	
	}
	
	def create() {
		def torneoInstance = new Torneo(params)
		render(view: "/administracion/torneos/create", model: [torneoInstance: torneoInstance])
	}

    def save() {
		def idTorneoPuntuable = session.getAttribute("idTorneoPuntuable")
		def torneoPuntuableInstance = TorneoPuntuable.get(idTorneoPuntuable)
		def torneoInstance = new Torneo(params)
		torneoInstance.setFechaAlta(new Date())
		torneoInstance.setEstado("Creado")
		if (torneoPuntuableInstance) torneoInstance.setPuntuable(true)
		
        if (!torneoInstance.save(flush: true)) {
            render(view: "/administracion/torneos/create", model: [torneoInstance: torneoInstance])
            return
        }
		
		if (torneoPuntuableInstance) {
			torneoPuntuableInstance.addToInstanciasTorneo(torneoInstance)
			torneoPuntuableInstance.save()
		}

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: torneoInstance.id)
    }

    def show(Long id) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/administracion/torneos/show", model: [torneoInstance: torneoInstance])
    }

    def edit(Long id) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        render(view: "/administracion/torneos/edit", model: [torneoInstance: torneoInstance])
    }

    def update(Long id, Long version) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (torneoInstance.version > version) {
                torneoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'torneo.label', default: 'Torneo')] as Object[],
                          "Another user has updated this Torneo while you were editing")
                render(view: "/administracion/torneos/edit", model: [torneoInstance: torneoInstance])
                return
            }
        }

        torneoInstance.properties = params

        if (!torneoInstance.save(flush: true)) {
            render(view: "/administracion/torneos/edit", model: [torneoInstance: torneoInstance])
            return
        }

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: torneoInstance.id)
    }

    def delete(Long id) {
        def torneoInstance = Torneo.get(id)
        if (!torneoInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

		if (torneoInstance.estado != "Creado") {
			flash.message = "El estado del torneo no permite que sea eliminado"
			redirect(action: "list")
			return
		}
		
        try {
            torneoInstance.delete(flush: true)
            flash.message = message(code: 'sgt.registrodatos.exito')
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'sgt.registrodatos.fallo')
            redirect(action: "show", id: id)
        }
    }
}
