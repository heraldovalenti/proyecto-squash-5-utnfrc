package sgt.club
import sgt.Cancha
import sgt.Disponibilidad
import sgt.DetalleDisponibilidad

class DisponibilidadCanchaController {

	static namespace = "club"
	static defaultAction = "disponibilidadCancha"
	
    def disponibilidadCancha(Long id) {
		Cancha canchaInstance = Cancha.get(id)
		if (!canchaInstance) {
			flash.message = "Cancha no encontrada"
			redirect(controller: 'cancha', action: 'list')
			return
		}
		
		if (!canchaInstance.disponibilidad) {
			canchaInstance.disponibilidad = new Disponibilidad().save(failOnError: true)
			canchaInstance.save(failOnError: true)
		}
		
		session.setAttribute("idCancha", canchaInstance.id)
		session.setAttribute("idDisponibilidad", canchaInstance.disponibilidad.id)
		redirect(action: 'list')
	}
	
	def list() {
		def idCancha = session.getAttribute("idCancha")
		def idDisponibilidad = session.getAttribute("idDisponibilidad")
		
		if (!idCancha || !idDisponibilidad) {
			flash.message = "Cancha no encontrada"
			redirect(controller: 'cancha', action: 'list')
			return
		}
		
		def Disponibilidad disponibilidadInstance = Disponibilidad.get(idDisponibilidad)
		def List detalles = disponibilidadInstance.detalles.asList()
		def Date fechaActualizacion = disponibilidadInstance.fechaActualizacion
		
		render(view: '/club/canchas/disponibilidad/list', model: [detalleDisponibilidadInstanceList: detalles, detalleDisponibilidadInstanceTotal: detalles.size(), fechaActualizacion: fechaActualizacion, idCancha: idCancha])
	}
	
	def create() {
		def idCancha = session.getAttribute("idCancha")
		def idDisponibilidad = session.getAttribute("idDisponibilidad")
		
		if (!idCancha || !idDisponibilidad) {
			flash.message = "Cancha no encontrada"
			redirect(controller: 'cancha', action: 'list')
			return
		}
		def detalleDisponibilidadInstance = new DetalleDisponibilidad()
		render(view: '/club/canchas/disponibilidad/create', model: [detalleDisponibilidadInstance: detalleDisponibilidadInstance])
	}
	
	def save() {
		def desde = gestorhorarios.aValor(horas: params.desdeHoras, minutos: params.desdeMinutos)
		def hasta = gestorhorarios.aValor(horas: params.hastaHoras, minutos: params.hastaMinutos)
			
        def detalleDisponibilidadInstance = new DetalleDisponibilidad(dia: params.dia, desde:desde, hasta:hasta)
        if (!detalleDisponibilidadInstance.save(flush: true)) {
            render(view: "/club/canchas/disponibilidad/create", model: [detalleDisponibilidadInstance: detalleDisponibilidadInstance])
            return
        }
		
		def idDisponibilidad = session.getAttribute("idDisponibilidad")
		def Disponibilidad disponibilidadInstance = Disponibilidad.get(idDisponibilidad)
		disponibilidadInstance.addToDetalles(detalleDisponibilidadInstance)
		disponibilidadInstance.fechaActualizacion = new Date()
		disponibilidadInstance.save()	

		flash.message = message(code: 'sgt.registrodatos.exito')
		redirect(action: "list") 
	}
	
	def edit(Long id) {
		def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
		if (!detalleDisponibilidadInstance) {
			flash.message = message(code: 'sgt.registrodatos.noencontrado')
			redirect(action: "list")
			return
		}
		render(view: "/club/canchas/disponibilidad/edit", model: [detalleDisponibilidadInstance: detalleDisponibilidadInstance])
	}
}
