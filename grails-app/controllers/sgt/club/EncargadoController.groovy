package sgt.club
import sgt.*

class EncargadoController {

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
}
