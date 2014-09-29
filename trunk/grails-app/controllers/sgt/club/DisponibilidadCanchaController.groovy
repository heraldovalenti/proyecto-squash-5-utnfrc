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
		
		session.setAttribute("idCancha", params.idCancha)
		
		def idCancha = session.getAttribute("idCancha")

		def canchaInstance = Cancha.get(idCancha)
		
		def disp = (sgt.Disponibilidad)this.disponibilidadCanchaSeleccionada()
		if (!disp) {
			if(!club){
				flash.message = "Deben registrarse los datos del club para gestionar la disponibilidad"
				redirect(controller: "club", action: "datosClub")
			}
			if(!canchaInstance){
				flash.message = "Cancha no encontrada"
				redirect(controller: "cancha", action: "list")
			}
			
			canchaInstance.disponibilidad = new Disponibilidad(fechaActualizacion: new Date()).save()
			canchaInstance.save()
			render(view: "/disponibilidadCancha/create", model: [idCancha: idCancha])
		}
		else{
			render(view: "/disponibilidadCancha/show", model: [idCancha: idCancha])
		}
	}

	def save(){
		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		
		int idCancha= session.getAttribute("idCancha")
		
		def canchaInstance = Cancha.get(idCancha)

		if(canchaInstance.disponibilidad.detalles!=null){
			canchaInstance.disponibilidad.detalles=null
			canchaInstance.save()
		}

		def arrayDisponibilidad= request.JSON
		def detalle		
		
		for(int i =0; i<arrayDisponibilidad.size();i++ ){

			detalle= new DetalleDisponibilidad()
			def horaCortada= arrayDisponibilidad[i].hora.split(':')			
			detalle.hora=  horaCortada[0] as int
			detalle.dia= arrayDisponibilidad[i].dia

			if(!detalle.save(flush: true)){
				flash.message = "No se pudo grabar el detalle de disponibilidad"
				return
			}

			canchaInstance.disponibilidad.addToDetalles(detalle)
		}

		canchaInstance.disponibilidad.setFechaActualizacion(new Date())
		canchaInstance.save()
		render canchaInstance.disponibilidad as JSON
	}

	def show(){
		render(view: "/disponibilidadCancha/show")
	}

	def delete(){
		def disp = (sgt.Disponibilidad)this.disponibilidadCanchaSeleccionada()		
		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		int idCancha= session.getAttribute("idCancha")		
		def canchaInstance = Cancha.get(idCancha)
		if (!disp) {
			flash.message = "No existe la disponibilidad"
			redirect(action: "show")
		}

		try {

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
		int idCancha= session.getAttribute("idCancha")		
		def canchaInstance = Cancha.get(idCancha)

		if (!canchaInstance.disponibilidad) {
			return
		}
		Disponibilidad disp= canchaInstance.disponibilidad
		def arrayDisp = disp.getDetalles()

		render arrayDisp as JSON
	}

	def disponibilidadCanchaSeleccionada(){

		def club=clubService.clubLogon(session.getAttribute("userLogon"))
		int idCancha= session.getAttribute("idCancha")		
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