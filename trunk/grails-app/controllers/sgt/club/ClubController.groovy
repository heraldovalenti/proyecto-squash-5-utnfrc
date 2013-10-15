package sgt.club

import org.springframework.dao.DataIntegrityViolationException

import sgt.Cancha;
import sgt.Club;
import sgt.Persona;
import sgt.Usuario;

class ClubController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	static defaultAction = 'index'
	
	static namespace = 'club'
	
	def index() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		render(view: 'inicioClub')
		return
	}
	
	def datosClub() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (u.getClub()) {
			redirect(action: 'show', id: u.getClub().id)
			return
		} else {
			redirect(action: 'create')
			return
		}
	}

	/* METODOS PARA GESTION DE DATOS DE CLUB*/
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [clubInstanceList: Club.list(params), clubInstanceTotal: Club.count()]
    }

    def create() {
        [clubInstance: new Club(params)]
    }

    def save() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
        def Club clubInstance = new Club(params)
		clubInstance.validado = false
        if (!clubInstance.save(flush: true)) {
            render(view: "create", model: [clubInstance: clubInstance])
            return
        }
		
		u.setClub(clubInstance)
		u.save()

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: clubInstance.id)
    }

    def show(Long id) {
        def clubInstance = Club.get(id)
        if (!clubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'club.label', default: 'Club'), id])
            redirect(action: "list")
            return
        }

        [clubInstance: clubInstance]
    }

    def edit(Long id) {
        def clubInstance = Club.get(id)
        if (!clubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'club.label', default: 'Club'), id])
            redirect(action: "list")
            return
        }

        [clubInstance: clubInstance]
    }

    def update(Long id, Long version) {
        def clubInstance = Club.get(id)
        if (!clubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'club.label', default: 'Club'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (clubInstance.version > version) {
                clubInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'club.label', default: 'Club')] as Object[],
                          "Another user has updated this Club while you were editing")
                render(view: "edit", model: [clubInstance: clubInstance])
                return
            }
        }
		
        clubInstance.properties = params

        if (!clubInstance.save(flush: true)) {
            render(view: "edit", model: [clubInstance: clubInstance])
            return
        }

        flash.message = message(code: 'sgt.registrodatos.exito')
        redirect(action: "show", id: clubInstance.id)
    }
}
