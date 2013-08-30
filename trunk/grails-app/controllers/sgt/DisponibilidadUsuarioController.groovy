package sgt

class DisponibilidadUsuarioController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	static defaultAction = 'index'
	
    def index() { 
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u.attach()
		if (!u.disponibilidad) {
			u.disponibilidad = new Disponibilidad(fechaActualizacion: new Date()).save()
			u.merge()
			session.setAttribute("userLogon", u)
		}
		redirect(controller: 'DetalleDisponibilidad', action: 'list', params: [max: 10, detalles: u.disponibilidad.detalles,disponibilidad: u.disponibilidad, cantidad: u.disponibilidad.count ])
	}
}
