package sgt.administracion.torneos

import grails.converters.*

import org.springframework.dao.DataIntegrityViolationException

import sgt.Categoria
import sgt.DetalleTorneo
import sgt.InscripcionTorneo
import sgt.PostulacionTorneo
import sgt.Torneo
import sgt.TorneoPuntuable



class TorneoController {
	
	def postulacionTorneoService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        render(view: "/administracion/torneos/list", model: [torneoInstanceList: Torneo.list(params), torneoInstanceTotal: Torneo.count()])
    }
	
	def nuevoTorneo() {
		session.removeAttribute("idTorneoPuntuable")
		redirect(action: "listadoTorneosPuntuables")
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
		torneoInstance.setPuntuable(torneoPuntuableInstance != null)
		torneoInstance.setTorneoPuntuable(torneoPuntuableInstance)
		
		def String msg = torneoInstance.fechasCorrectas()
		
		if (msg != null) {
			flash.message = msg
			render(view: "/administracion/torneos/create", model: [torneoInstance: torneoInstance])
			return
		}
		
        if (!torneoInstance.save(flush: true)) {
            render(view: "/administracion/torneos/create", model: [torneoInstance: torneoInstance])
            return
        }
		
		/*if (torneoPuntuableInstance) {
			torneoPuntuableInstance.addToInstanciasTorneo(torneoInstance)
			torneoPuntuableInstance.save()
		}
		*/
		
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
		
		def detalleInstanceList = torneoInstance.getDetalles()

        render(view: "/administracion/torneos/show", model: [torneoInstance: torneoInstance, detalleInstanceList: detalleInstanceList, detalleInstanceListTotal: detalleInstanceList.size()])
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
		
		if (torneoInstance.estado != "Creado") {
			flash.message = "El estado del torneo no permite que sea actualizado"
			render(view: "/administracion/torneos/edit", model: [torneoInstance: torneoInstance])
			return
		}
		
		def String msg = torneoInstance.fechasCorrectas()
		if (msg != null) {
			flash.message = msg
			render(view: "/administracion/torneos/edit", model: [torneoInstance: torneoInstance])
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
	
	def verDetalles(Long id) {
		def torneoInstance = Torneo.get(id)
		session.setAttribute("idTorneo", id)
		def detalleTorneoInstanceList = torneoInstance.getDetalles()
		render(view: "/administracion/torneos/detallesTorneo", model: [torneoInstance: torneoInstance, detalleTorneoInstanceList: detalleTorneoInstanceList, detalleInstanceTotal: detalleTorneoInstanceList.size()])
	}
	
	def createDetalle() {
		def idTorneo = session.getAttribute("idTorneo")
		def torneoInstance = Torneo.get(idTorneo)
		
		def categoriaInstanceList = Categoria.list()
		def detalleTorneoInstance = new DetalleTorneo(params)
		
		def detalleTorneoInstanceList = torneoInstance.getDetalles()
		def Iterator<DetalleTorneo> iter = detalleTorneoInstanceList.iterator()
		while (iter.hasNext()) {
			def torneoAux = iter.next()
			def categoriaAux = torneoAux.categoria
			categoriaInstanceList.remove(categoriaAux) 
		}	
		
		render(view: "/administracion/torneos/createDetalle", model: [detalleTorneoInstance: detalleTorneoInstance, torneoInstance: torneoInstance, categoriaInstanceList: categoriaInstanceList])
	}
	
	def agregarDetalle() {
		def idTorneo = session.getAttribute("idTorneo")
		def torneoInstance = Torneo.get(idTorneo)
		def detalleTorneoInstance = new DetalleTorneo(params)
		detalleTorneoInstance.setTorneo(torneoInstance)
		
		if (!detalleTorneoInstance.save(flush: true)) {
			def categoriaInstanceList = Categoria.list()
			def detalleTorneoInstanceList = torneoInstance.getDetalles()
			
			def Iterator<DetalleTorneo> iter = detalleTorneoInstanceList.iterator()
			while (iter.hasNext()) {
				def torneoAux = iter.next()
				def categoriaAux = torneoAux.categoria
				categoriaInstanceList.remove(categoriaAux)
			}
			render(view: "/administracion/torneos/createDetalle", model: [detalleTorneoInstance: detalleTorneoInstance, torneoInstance: torneoInstance, categoriaInstanceList: categoriaInstanceList])
			return
		}
		
		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "verDetalles", id: torneoInstance.id)
	}
	
	def deleteDetalle(Long id) {
		def idTorneo = session.getAttribute("idTorneo")
		def torneoInstance = Torneo.get(idTorneo)
		def detalleTorneoInstance = DetalleTorneo.get(id)
		
		if (!detalleTorneoInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "verDetalles", id: idTorneo)
		}
		
		try {
			torneoInstance.removeFromDetalles(detalleTorneoInstance)
			torneoInstance.save()
			detalleTorneoInstance.delete(flush: true)
			flash.message = message(code: 'sgt.registrodatos.exito')
			redirect(action: "verDetalles", id: idTorneo)
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'sgt.registrodatos.fallo')
			redirect(action: "verDetalles", id: idTorneo)
		}
	}
	
	def verPostulaciones(Long id) {
		session.setAttribute("idTorneo", id)
		redirect(action: "listadoPostulaciones")
	}
	
	def listadoPostulaciones() {
		def idTorneo = session.getAttribute("idTorneo")
		def torneoInstance = Torneo.get(idTorneo)
		
		def c = PostulacionTorneo.createCriteria()
		def postulacionInstanceList = c.list(params) {
			eq("torneo", torneoInstance)
		}
		
		render(view: "/administracion/torneos/postulacionesTorneo", model: [postulacionInstanceList: postulacionInstanceList, torneoInstance: torneoInstance])
	}
	
	def aceptarPostulacionTorneo(Long id) {
		postulacionTorneoService.aceptarPostulacionTorneo(id)
		def idTorneo = session.getAttribute("idTorneo")
		flash.message = "El club ha sido asignado al torneo"
		redirect(action: "show", id: idTorneo)
	}
	
	def rechazarPostulacionTorneo(Long id) {
		postulacionTorneoService.rechazarPostulacionTorneo(id)
		flash.message = "Postulacion rechazada"
		redirect(action: "listadoPostulaciones")
	}
	
	def verInscripciones(Long id) {
		session.setAttribute("idTorneo", id)
		redirect(action: "listadoInscripciones")
	}
	
	def listadoInscripciones() {
		def idTorneo = session.getAttribute("idTorneo")
		def torneoInstance = Torneo.get(idTorneo)
		
		def c = InscripcionTorneo.createCriteria()
		def detalleList = torneoInstance.getDetalles()
		def inscripcionInstanceList = c.list(params) {
			'in' ("detalleTorneo", detalleList)
		}
		
		render(view: "/administracion/torneos/inscripcionesTorneo", model: [inscripcionInstanceList: inscripcionInstanceList, torneoInstance: torneoInstance])
	}
	
	def listaPaginada() {
		def result = Torneo.list(params)
		def total = Torneo.count()
		render(view: "lista", model: [torneos: result, torneosTotal: total])
	}
}
