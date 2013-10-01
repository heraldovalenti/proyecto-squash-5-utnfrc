package sgt

import org.springframework.dao.DataIntegrityViolationException

class ClubController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	static defaultAction = 'index'
	
	def index() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (u.getClub()) {
			render(view: 'inicioClub')
			return
		}
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

    def delete(Long id) {
        def clubInstance = Club.get(id)
        if (!clubInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'club.label', default: 'Club'), id])
            redirect(action: "list")
            return
        }

        try {
            clubInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'club.label', default: 'Club'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'club.label', default: 'Club'), id])
            redirect(action: "show", id: id)
        }
    }
	
	/* METODOS PARA CONTROL DE ENCARGADO DE CLUB */
	def datosEncargado() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		if (u.getPersona()) {
			render(view: '/club/encargado/show', model: [personaInstance: u.getPersona()])
			return
		} else {
			render(view: '/club/encargado/create', model: [personaInstance: new Persona(), parentId: u.id])
			return
		}
	}
	
	def saveEncargado() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		def personaInstance = new Persona(params)
		if (!personaInstance.save(flush: true)) {
			render(view: "create", model: [personaInstance: personaInstance, parentId: params.parentId])
			return
		}

		u.setPersona(personaInstance)
		u.save()
		
		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "showEncargado", id: personaInstance.id)
	}
	
	def showEncargado(Long id) {
		def personaInstance = Persona.get(id)
		if (!personaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "datosEncargado")
			return
		}
		render(view: "/club/encargado/show", model: [personaInstance: personaInstance])
	}
	
	def editEncargado(Long id) {
		def personaInstance = Persona.get(id)
		if (!personaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "datosEncargado")
			return
		}
		render(view: "/club/encargado/edit", model: [personaInstance: personaInstance])
	}
	
	def updateEncargado(Long id, Long version) {
		def personaInstance = Persona.get(id)
		if (!personaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "datosEncargado")
			return
		}

		if (version != null) {
			if (personaInstance.version > version) {
				personaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'sgt.registrodatos.fallo')] as Object[],
						  "Another user has updated this Encargado while you were editing")
				render(view: "/club/encargado/edit", model: [personaInstance: personaInstance])
				return
			}
		}
		
		personaInstance.properties = params

		if (!personaInstance.save(flush: true)) {
			render(view: "/club/encargado/edit", model: [personaInstance: personaInstance])
			return
		}

		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "showEncargado", id: personaInstance.id)
	}
	
	/* METODOS PARA GESTION DE CANCHAS DE CLUB */
	def listarCanchas() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id) 
		
		if (!u.getClub()) {
			flash.message = "Deben registrarse los datos del club para gestionar las canchas"
			render(view: "create", model: [clubInstance: new Club(params)])
			return
		}
		
		def canchaList = u.getClub().getCanchas()
		render(view: "/club/canchas/list", model: [canchaInstanceList: canchaList, canchaInstanceTotal: canchaList.size()])
	}
	
	def createCancha() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		render(view: "/club/canchas/create", model: [canchaInstance: new Cancha(params), parentId: u.club.id])
	}
	
	def saveCancha() {
		def Club clubInstance = Club.get(params.parentId)
		def canchaInstance = new Cancha(params)
		if (!canchaInstance.save(flush: true && !canchaInstance)) {
			render(view: "/club/canchas/create", model: [clubInstance: clubInstance, parentId: params.parentId])
			return
		}
		
		clubInstance.addToCanchas(canchaInstance)
		clubInstance.save()	

		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "listarCanchas")
	}
	
	def showCancha(Long id) {
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "listarCancha")
			return
		}
		render(view: "/club/canchas/show", model: [canchaInstance: canchaInstance])
	}
	
	def editCancha(Long id) {
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "listarCanchas")
			return
		}
		render(view: "/club/canchas/edit", model: [canchaInstance: canchaInstance])
	}
	
	def updateCancha(Long id, Long version) {
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "datosEncargado")
			return
		}

		if (version != null) {
			if (canchaInstance.version > version) {
				canchaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'sgt.registrodatos.fallo')] as Object[],
						  "Another user has updated this Cancha while you were editing")
				render(view: "/club/cancha/edit", model: [canchaInstance: canchaInstance])
				return
			}
		}
		
		canchaInstance.properties = params

		if (!canchaInstance.save(flush: true)) {
			render(view: "/club/cancha/edit", model: [canchaInstance: canchaInstance])
			return
		}

		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "showCancha", id: canchaInstance.id)
	}
}
