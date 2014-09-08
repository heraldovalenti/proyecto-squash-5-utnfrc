package sgt

import grails.converters.JSON
import grails.web.JSONBuilder
import org.springframework.dao.DataIntegrityViolationException


class DisponibilidadUsuarioController {
	
	def index() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		def disp = (sgt.Disponibilidad)this.disponibilidaUusuarioLogueado()
		if (!disp) {
			if(!u.jugador){
				redirect(controller:"jugador",action:"create")
				return
			}
			u.jugador.disponibilidad= new Disponibilidad(fechaActualizacion: new Date()).save()
			u.save()
			render(view: "/disponibilidadUsuario/create")
		}
		else{
			render(view: "/disponibilidadUsuario/show")
		}
	}

	def save(){

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)

		if(u.jugador.disponibilidad.detalles!=null){
			u.jugador.disponibilidad.detalles=null
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

			u.jugador.disponibilidad.addToDetalles(detalle)
		}

		u.jugador.disponibilidad.setFechaActualizacion(new Date())
		u.save()
		render u.jugador.disponibilidad as JSON
	}

	def show(){

		render(view: "/disponibilidadUsuario/show")
	}

	def delete(){

		def disp = (sgt.Disponibilidad)this.disponibilidaUusuarioLogueado()
		System.out.println("entro a eliminar")
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

			u.jugador.disponibilidad=null
			u.save()
			render u.jugador as JSON
		}
		catch (DataIntegrityViolationException e) {
		}
	}

	def obtenerDisponibilidad(){

		System.out.println("entro al obtener")

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)

		if (!u.jugador.disponibilidad) {
			return
		}
		Disponibilidad disp= u.jugador.disponibilidad
		def arrayDisp = disp.getDetalles()

		System.out.println(arrayDisp.size().toString())

		render arrayDisp as JSON
	}

	def disponibilidaUusuarioLogueado(){

		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		if(!u.jugador){
			flash.message = "No existe el jugador"
			return
		}
		else if (!u.jugador.disponibilidad) {
			return null
		}
		else{
			return u.jugador.disponibilidad
		}
	}
}

	
