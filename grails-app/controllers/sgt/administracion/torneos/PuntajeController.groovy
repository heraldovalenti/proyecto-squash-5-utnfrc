package sgt.administracion.torneos
import sgt.Puntaje
import sgt.DetallePuntaje
import sgt.TorneoPuntuable
import sgt.PuntajeService

import org.springframework.dao.DataIntegrityViolationException

class PuntajeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]
	
	static namespace = "admin"
	
	def puntajeService
	
	def verPuntajes(Long id) {
		def TorneoPuntuable torneoPuntuableInstance = TorneoPuntuable.get(id)
		if (!torneoPuntuableInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(controller: "torneoPuntuable", action: "list")
			return
		}
		
		session.setAttribute("idTorneo", torneoPuntuableInstance.id)
		redirect(controller: "puntaje", action: "list")
	}
	
	def volverTorneo() {
		def Long idTorneo = session.getAttribute("idTorneo")
		redirect(controller: "torneoPuntuable", action: "show", id: idTorneo)
	}
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def Long idTorneo = session.getAttribute("idTorneo")
		def TorneoPuntuable torneoPuntuableInstance = TorneoPuntuable.get(idTorneo)
		def puntajeInstanceList = torneoPuntuableInstance?.puntajes
		def puntajeInstanceTotal
		if(!puntajeInstanceList){
			puntajeInstanceTotal=0
		}
		else{
			puntajeInstanceTotal=puntajeInstanceList?.size()
		}
		
		render(view: "/administracion/puntajes/list", model: [puntajeInstanceList: puntajeInstanceList, puntajeInstanceTotal: puntajeInstanceTotal])
	}
	
	def create() {
		render(view: "/administracion/puntajes/create", model: [puntajeInstance: new Puntaje(params)])
	}
	
	def save() {
		def idTorneo = session.getAttribute("idTorneo")
		def puntajeInstance = new Puntaje(params)
		/*if (!puntajeInstance.validate()) {
			render(view: "/administracion/puntajes/create", model: [puntajeInstance: puntajeInstance])
			return
		}*/
		
		def String res = puntajeService.agregarPuntajeTorneo(idTorneo, puntajeInstance)
		if (res != null) {
			flash.message = (res)
			render(view: "/administracion/puntajes/create", model: [puntajeInstance: puntajeInstance])
			return
		}
		
		redirect(action: "verDetalles", id: puntajeInstance.id)
	}
	
	def volverDetalles() {
		def idPuntaje = session.getAttribute("idPuntaje")
		verDetalles(idPuntaje)
	}
	
	def verDetalles(Long id) {
		def Puntaje puntajeInstance = Puntaje.get(id)
		if (!puntajeInstance) {
			flash.message = messsage(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "list")
		}
		
		session.setAttribute("idPuntaje", id)
		List<DetallePuntaje> detallePuntajeInstanceList = new ArrayList(puntajeInstance.detalles)
		Collections.sort(detallePuntajeInstanceList, new Comparator<DetallePuntaje>() {
			@Override
			public int compare( DetallePuntaje d1,  DetallePuntaje d2) {
				return d1.puesto - d2.puesto
			};
		})
		
		def categoriaInstance = puntajeInstance.categoria
		render(view: "/administracion/puntajes/detallesPuntaje", 
			model: [detallePuntajeInstanceList: detallePuntajeInstanceList, 
				puntajeInstanceTotal: detallePuntajeInstanceList.size(), 
				categoriaInstance: categoriaInstance])
	}
	
	def createDetalle() {
		def detallePuntajeInstance = new DetallePuntaje(params)
		render(view: "/administracion/puntajes/createDetalle", model: [detallePuntajeInstance: detallePuntajeInstance])
	}
	
	def agregarDetalle() {
		def DetallePuntaje detallePuntajeInstance = new DetallePuntaje(params)
		/*if (!detallePuntajeInstance.validate()) {
			render(view: "/administracion/puntajes/createDetalle", model: [detallePuntajeInstance: detallePuntajeInstance])
			return
		}*/
		
		def idPuntaje = session.getAttribute("idPuntaje")
		def String res = puntajeService.agregarDetallePuntaje(idPuntaje, detallePuntajeInstance)
		if (res != null) {
			flash.message = (res)
			render(view: "/administracion/puntajes/createDetalle", model: [detallePuntajeInstance: detallePuntajeInstance])
			return
		}
		
		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "verDetalles", id: idPuntaje)
	}
	
	def deleteDetalle(Long id) {
		def idPuntaje = session.getAttribute("idPuntaje")
		def puntajeInstance = Puntaje.get(idPuntaje)
		def detallePuntajeInstance = DetallePuntaje.get(id)
		if (!detallePuntajeInstance || !puntajeInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			volverDetalles()
		}

		try {
			puntajeInstance.removeFromDetalles(detallePuntajeInstance)
			puntajeInstance.save()
			detallePuntajeInstance.delete(flush: true)
			flash.message = message(code: 'sgt.registrodatos.exito')
			volverDetalles()
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'sgt.registrodatos.fallo')
			volverDetalles()
		}
	}
	
	def cargarPuntaje(Long id) 
	{
		def torneoPuntuableInstance = TorneoPuntuable.get(id)
		
		if (!torneoPuntuableInstance.getPuntajeTorneo()) {
			def puntajeInstance = new Puntaje().save()
			torneoPuntuableInstance.setPuntajeTorneo(puntajeInstance)
			torneoPuntuableInstance.save()
			idTorneo= torneoPuntuableInstance.id
		}
		if(!torneoPuntuableInstance.getPuntajeTorneo().getDetalles()) {
			redirect(controller: 'detallePuntaje', action:'create', id: torneoPuntuableInstance.getPuntajeTorneo().id)
		}
		else {
			redirect(controller: 'detallePuntaje', action:'listarDetalles', id: id)
		}
	}
	

    def index() {
        redirect(action: "list", params: params)
    }

    

    def show(Long id) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        [puntajeInstance: puntajeInstance]
    }

    def edit(Long id) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        [puntajeInstance: puntajeInstance]
    }

    def update(Long id, Long version) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (puntajeInstance.version > version) {
                puntajeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'puntaje.label', default: 'Puntaje')] as Object[],
                          "Another user has updated this Puntaje while you were editing")
                render(view: "edit", model: [puntajeInstance: puntajeInstance])
                return
            }
        }

        puntajeInstance.properties = params

        if (!puntajeInstance.save(flush: true)) {
            render(view: "edit", model: [puntajeInstance: puntajeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'puntaje.label', default: 'Puntaje'), puntajeInstance.id])
        redirect(action: "show", id: puntajeInstance.id)
    }

    def delete(Long id) {
        def puntajeInstance = Puntaje.get(id)
        if (!puntajeInstance) {
            flash.message = message(code: 'sgt.registrodatos.noencontrado')
            redirect(action: "list")
            return
        }

        try {
            puntajeInstance.delete(flush: true)
            flash.message = message(code: 'sgt.registrodatos.exito')
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'sgt.registrodatos.fallo')
            redirect(action: "list")
        }
    }
}
