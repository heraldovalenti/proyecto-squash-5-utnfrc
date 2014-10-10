package sgt.club
import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException
import sgt.Cancha
import sgt.ClubService;
import sgt.Disponibilidad
import sgt.DetalleDisponibilidad

class DisponibilidadCanchaController {
	
	ClubService clubService	

	def index() {
		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		
		if (params.idCancha != null) {
			session.setAttribute("idCancha", params.idCancha) 
		}
		
		def idCancha = session.getAttribute("idCancha")

		def canchaInstance = Cancha.get(idCancha)
		
		def disp = (sgt.Disponibilidad)this.disponibilidadCanchaSeleccionada()
		if (!disp) {
			if(!club){
				flash.message = "Deben registrarse los datos del club para gestionar la disponibilidad"
				redirect(controller: "club", action: "datosClub")
				return
			}
			if(!canchaInstance){
				flash.message = "Cancha no encontrada"
				redirect(controller: "cancha", action: "list")
				return
			}
			
			canchaInstance.disponibilidad = new Disponibilidad(fechaActualizacion: new Date()).save(failOnError: true, flush: true)
			canchaInstance.save(failOnError: true, flush: true)
			render(view: "/disponibilidadCancha/create", model: [cancha: canchaInstance])
		}
		else{
			render(view: "/disponibilidadCancha/show", model: [cancha: canchaInstance])
		}
	}

	def save(){
		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		
		def idCancha= session.getAttribute("idCancha")
		
		def canchaInstance = Cancha.get(idCancha)

		if(canchaInstance.disponibilidad.detalles!=null){
			def detallesDisp= canchaInstance.disponibilidad.detalles.findAll()
			canchaInstance.disponibilidad.detalles.removeAll(detallesDisp)
			canchaInstance.save(flush: true,failOnError: true)			
		}

		def arrayDisponibilidad= request.JSON
		def detalle		
		
		for(int i =0; i<arrayDisponibilidad.size();i++ ){

			detalle= new DetalleDisponibilidad()
			def horaCortada= arrayDisponibilidad[i].hora.split(':')			
			detalle.hora=  horaCortada[0] as int
			detalle.dia= arrayDisponibilidad[i].dia
			
			canchaInstance.disponibilidad.addToDetalles(detalle)
		}

		canchaInstance.disponibilidad.setFechaActualizacion(new Date())
		canchaInstance.save(failOnError: true)
		render canchaInstance.disponibilidad as JSON
	}

	def show(){
		 
		def idCancha= session.getAttribute("idCancha")		
		def canchaInstance = Cancha.get(idCancha)
		render(view: "/disponibilidadCancha/show", model: [cancha: canchaInstance])
	}

	def delete(){
		def disp = (sgt.Disponibilidad)this.disponibilidadCanchaSeleccionada()		
		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		def idCancha= session.getAttribute("idCancha")		
		def canchaInstance = Cancha.get(idCancha)
		if (!disp) {
			flash.message = "No existe la disponibilidad"
			redirect(action: "show")
		}

		try {
			//
			canchaInstance.disponibilidad=null
			canchaInstance.save(failOnError: true, flush: true)
			disp.delete()
			render canchaInstance as JSON
			return
			//
			
			def detalles= disp.detalles.findAll()
			disp.detalles.removeAll(detalles)

			canchaInstance.disponibilidad=null
			club.save()
			render canchaInstance as JSON
		}
		catch (DataIntegrityViolationException e) {
		}
	}

	def obtenerDisponibilidad(){
		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		
		if(club==null){
			return
		}		
		def idCancha = session.getAttribute("idCancha")
		
		def canchaInstance = Cancha.get(idCancha)
		
		if (!canchaInstance || !canchaInstance.disponibilidad) {
			return
		}
		Disponibilidad disp= canchaInstance.disponibilidad
		def arrayDisp = disp.getDetalles()

		render arrayDisp as JSON
	}

	def disponibilidadCanchaSeleccionada(){

		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		def idCancha= session.getAttribute("idCancha")		
		def canchaInstance = Cancha.get(idCancha)
		if(!club){
			flash.message = "No existe el club"
			return
		}
		else if(!canchaInstance){
			flash.message = "No existe la cancha"
			return
		}
		else if (!canchaInstance.disponibilidad) {
			return null
		}
		else{
			return canchaInstance.disponibilidad
		}
	}
}