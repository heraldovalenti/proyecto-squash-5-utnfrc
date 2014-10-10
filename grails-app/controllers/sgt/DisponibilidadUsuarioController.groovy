package sgt

import grails.converters.JSON

import org.springframework.dao.DataIntegrityViolationException

import sgt.exceptions.PersonaException


class DisponibilidadUsuarioController {
	
	def index() {
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)
		def disp = (sgt.Disponibilidad)this.disponibilidaUusuarioLogueado()
		if (!disp) {
			if(!u.jugador){
				flash.message = PersonaException.SIN_DATOS_PERSONALES
				redirect(controller: "jugador", action: "datosPersonales")
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
			def detallesDisp= u.jugador.disponibilidad.detalles.findAll()
			u.jugador.disponibilidad.detalles.removeAll(detallesDisp)		
			u.save(flush: true,failOnError: true)
		}		

		def arrayDisponibilidad= request.JSON
		def detalle

		for(int i =0; i<arrayDisponibilidad.size();i++ ){

			detalle= new DetalleDisponibilidad()
			def horaCortada= arrayDisponibilidad[i].hora.split(':')			
			detalle.hora=  horaCortada[0] as int
			detalle.dia= arrayDisponibilidad[i].dia
			
			u.jugador.disponibilidad.addToDetalles(detalle)
		}

		u.jugador.disponibilidad.setFechaActualizacion(new Date())
		u.save(flush: true,failOnError: true)
		render u.jugador.disponibilidad as JSON
	}

	def show(){

		render(view: "/disponibilidadUsuario/show")
	}

	def delete(){

		def disp = (sgt.Disponibilidad)this.disponibilidaUusuarioLogueado()
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
			u.save(flush: true,failOnError: true)
			render u.jugador as JSON
		}
		catch (DataIntegrityViolationException e) {
		}
	}

	def obtenerDisponibilidad(){
		def u = (sgt.Usuario)session.getAttribute("userLogon")
		u = Usuario.get(u.id)

		if (!u.jugador.disponibilidad) {
			return
		}
		Disponibilidad disp= u.jugador.disponibilidad
		def arrayDisp = disp.getDetalles()

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

	
