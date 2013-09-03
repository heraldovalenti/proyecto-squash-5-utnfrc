package sgt

import org.springframework.dao.DataIntegrityViolationException

class DisponibilidadUsuarioController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	static defaultAction = 'index'
	
    def index() { 
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!u.disponibilidad) {
			u.setDisponibilidad(new Disponibilidad(fechaActualizacion: new Date()).save() )
			u.save()
		}
		redirect(action: 'list')
	}
	
	def list(Integer max) {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		
		params.max = Math.min(max ?: 10, 100)
		
		def total = u.disponibilidad.detalles ? u.disponibilidad.detalles.count : 10 
		
		render(view: '/detalleDisponibilidad/list', model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstanceList: u.disponibilidad.getDetalles(), detalleDisponibilidadInstanceTotal: total, fechaActualizacion: u.disponibilidad.fechaActualizacion])
	}
	
	def create() {
		render(view: '/detalleDisponibilidad/create', model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstance: new DetalleDisponibilidad(params)])
	}
	
	def save() {
		def desde = gestorhorarios.aValor(horas: params.desdeHoras, minutos: params.desdeMinutos)
		def hasta = gestorhorarios.aValor(horas: params.hastaHoras, minutos: params.hastaMinutos)
		
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
			
		def detalleDisponibilidadInstance = new DetalleDisponibilidad(dia: params.dia, desde:desde, hasta:hasta)
		if (!detalleDisponibilidadInstance.save(flush: true)) {
			render(view: "/detalleDisponibilidad/create", model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstance: detalleDisponibilidadInstance])
			return
		}
		u.disponibilidad.addToDetalles(detalleDisponibilidadInstance)
		u.disponibilidad.setFechaActualizacion(new Date())
		u.save()

		flash.message = message(code: 'default.created.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), detalleDisponibilidadInstance.id])
		redirect(action: "show", id: detalleDisponibilidadInstance.id)
	}
	
	def show(Long id) {
		def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
		if (!detalleDisponibilidadInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
			redirect(action: "list")
			return
		}

		render(view: '/detalleDisponibilidad/show', model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstance: detalleDisponibilidadInstance])
	}
	
	def edit(Long id) {
		def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
		if (!detalleDisponibilidadInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
			redirect(action: "list")
			return
		}

		render(view: '/detalleDisponibilidad/edit', model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstance: detalleDisponibilidadInstance])
	}
	
	def update(Long id, Long version) {
		def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
		if (!detalleDisponibilidadInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (detalleDisponibilidadInstance.version > version) {
				detalleDisponibilidadInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad')] as Object[],
						  "Another user has updated this DetalleDisponibilidad while you were editing")
				render(view: "/detalleDisponibilidad/edit", model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstance: detalleDisponibilidadInstance])
				return
			}
		}
		
		
		def desde = gestorhorarios.aValor(horas: params.desdeHoras, minutos: params.desdeMinutos)
		def hasta = gestorhorarios.aValor(horas: params.hastaHoras, minutos: params.hastaMinutos)
		detalleDisponibilidadInstance.properties = [dia: params.dia, desde: desde, hasta: hasta]
		
		if (!detalleDisponibilidadInstance.save(flush: true)) {
			render(view: "/detalleDisponibilidad/edit", model: [controladorDisponibilidad: 'DisponibilidadUsuario', detalleDisponibilidadInstance: detalleDisponibilidadInstance])
			return
		}

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		u.disponibilidad.setFechaActualizacion(new Date())
		u.save()
		flash.message = message(code: 'default.updated.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), detalleDisponibilidadInstance.id])
		redirect(action: "show", id: detalleDisponibilidadInstance.id)
	}
	
	def delete(Long id) {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		def detalleDisponibilidadInstance = DetalleDisponibilidad.get(id)
		if (!detalleDisponibilidadInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
			redirect(action: "list")
			return
		}
		
		try {
			u.disponibilidad.removeFromDetalles(detalleDisponibilidadInstance)
			u.disponibilidad.setFechaActualizacion(new Date())
			u.save()
			detalleDisponibilidadInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'detalleDisponibilidad.label', default: 'DetalleDisponibilidad'), id])
			redirect(action: "show", id: id)
		}
	}
	
	
}
