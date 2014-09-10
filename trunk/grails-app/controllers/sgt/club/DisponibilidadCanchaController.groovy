package sgt.club
import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException
import sgt.Cancha
import sgt.Disponibilidad
import sgt.DetalleDisponibilidad

class DisponibilidadCanchaController {

	def index() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		def disp = (sgt.Disponibilidad)this.disponibilidadCanchaSeleccionada()
		if (!disp) {
			if(!u.club){
				redirect(controller:"club",action:"create")
				return
			}
			if(!u.club.cancha[id]){
				redirect(controller:"cancha",action:"create")
				return
			}
			u.club.canchas[id].disponibilidad= new Disponibilidad(fechaActualizacion: new Date()).save()
			u.save()
			render(view: "/disponibilidadCancha/create")
		}
		else{
			render(view: "/disponibilidadCancha/show")
		}
	}

	def save(Long id){

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)

		if(u.club.canchas[id].disponibilidad.detalles!=null){
			u.club.canchas[id].disponibilidad.detalles=null
			u.save()
		}

		def arrayDisponibilidad= request.JSON
		def detalle

		for(int i =0; i<arrayDisponibilidad.size();i++ ){

			detalle= new DetalleDisponibilidad()
			def horaCortada= arrayDisponibilidad[i].hora.split(':')			
			detalle.hora=  horaCortada[0] as int
			detalle.dia= arrayDisponibilidad[i].dia

			if(!detalle.save(flush: true)){
				System.out.println("entro al return")
				flash.message = "No se pudo grabar el detalle de disponibilidad"
				return
			}

			u.club.canchas[id].disponibilidad.addToDetalles(detalle)
		}

		u.club.canchas[id].disponibilidad.setFechaActualizacion(new Date())
		u.save()
		render u.club.canchas[id].disponibilidad as JSON
	}

	def show(){

		render(view: "/disponibilidadCancha/show")
	}

	def delete(){

		def disp = (sgt.Disponibilidad)this.disponibilidadCanchaSeleccionada()		
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if (!disp) {
			flash.message = "No existe la disponibilidad"
			redirect(action: "show")
			return
		}

		try {

			def detalles= disp.detalles.findAll()
			disp.detalles.removeAll(detalles)

			u.club.canchas[id].disponibilidad=null
			u.save()
			render u.club.canchas as JSON
		}
		catch (DataIntegrityViolationException e) {
		}
	}

	def obtenerDisponibilidad(Long id){

		System.out.println("entro al obtener")

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)

		if (!u.club.canchas.disponibilidad) {
			return
		}
		Disponibilidad disp= u.club.canchas[id].disponibilidad
		def arrayDisp = disp.getDetalles()

		render arrayDisp as JSON
	}

	def disponibilidadCanchaSeleccionada(Long id){

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if(!u.club){
			flash.message = "No existe el club"
			return
		}
		else if(u.club.canchas[id]){
			flash.message = "No existe la cancha"
			return
		}
		else if (!u.club.canchas[id].disponibilidad) {
			return null
		}
		else{
			return u.club.canchas[id].disponibilidad
		}
	}
}

	
