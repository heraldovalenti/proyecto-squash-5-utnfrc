package sgt.club
import org.springframework.dao.DataIntegrityViolationException
import sgt.*

class CanchaController {
	
	static namespace = 'club'
	
	ClubService clubService
	

    /* METODOS PARA GESTION DE CANCHAS DE CLUB */
	def list() {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id) 
		def club = clubService.clubLogon(u)
		
		if (!club) {
			flash.message = "Deben registrarse los datos del club para gestionar las canchas"
			redirect(controller: 'club', action: 'create', namespace: 'club')
			return
		}
		
		def canchaList = club.canchas
		render(view: "/club/canchas/list", model: [canchaInstanceList: canchaList, canchaInstanceTotal: canchaList.size()])
	}
	
	def create() {
		render(view: "/club/canchas/create", model: [canchaInstance: new Cancha(params)])
	}
	
	def save() {
		def canchaInstance = new Cancha(params)
		if (!canchaInstance.save(flush: true)) {
			render(view: "/club/canchas/create", model: [canchaInstance: canchaInstance])
			return
		}
		
		def Club clubInstance = clubService.clubLogon(session.getAttribute("userLogon"))
		clubInstance.addToCanchas(canchaInstance)
		clubInstance.save()	

		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "list")
	}
	
	def show(Long id) {
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "list")
			return
		}
		render(view: "/club/canchas/show", model: [canchaInstance: canchaInstance])
	}
	
	def edit(Long id) {
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "list")
			return
		}
		render(view: "/club/canchas/edit", model: [canchaInstance: canchaInstance])
	}
	
	def update(Long id, Long version) {
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "list")
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
		redirect(action: "show", id: canchaInstance.id)
	}
	
	def delete(Long id) {
		def Usuario u = session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		def Club clubInstance = u.getClub() 
		
		def canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "list")
			return
		}

		try {
			clubInstance.removeFromCanchas(canchaInstance)
			clubInstance.save()
			canchaInstance.delete(flush: true)
			flash.message = message(code: 'sgt.registrodatos.exito')
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'sgt.registrodatos.fallo')
			redirect(action: "show", id: id)
		}
	}
}
