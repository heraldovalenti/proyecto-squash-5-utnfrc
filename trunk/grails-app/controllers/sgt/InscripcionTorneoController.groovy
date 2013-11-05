package sgt

class InscripcionTorneoController {
		
	def inscripcionTorneo(Long id) {
		def userLogon = session.getAttribute("userLogon")
		if (!userLogon) {
			flash.message = "Debe iniciar sesión primero"
			redirect(controller: "usuario", action: "loginForm")
			return
		}
		
		def torneoInstance = Torneo.get(id)
		session.setAttribute("idTorneo", torneoInstance.id)
		def detalleTorneoInstanceList = torneoInstance?.getDetalles()
		
		render(view: "/inscripcionTorneo/inscripcion", model: [detalleTorneoInstanceList: detalleTorneoInstanceList])
	}
	
	def inscribir(Long id) {
		def detalleTorneoInstance = DetalleTorneo.get(id)
		def idTorneo = session.getAttribute("idTorneo")
		def userLogon = session.getAttribute("userLogon")
		userLogon = Usuario.get(userLogon.id)
		def categoriaJugadorInstance = userLogon.getCategoriaActual()
		
		if(detalleTorneoInstance.jugadorInscripto(userLogon)) {
			flash.message = "Ya se encuentra inscripto en esa categoría"
			redirect(action: "inscripcionTorneo", id: idTorneo)
			return
		}
		
		/*if (!categoriaJugadorInstance || !categoriaJugadorInstance.categoria.equals(detalleTorneoInstance.categoria)) {
			flash.message = "La categoría seleccionada no corresponde a la suya"
			redirect(action: "inscripcionTorneo", id: idTorneo)
			return
		}*/
		
		def inscripcionTorneoInstance = new InscripcionTorneo()
		inscripcionTorneoInstance.setFecha(new Date())
		inscripcionTorneoInstance.setUsuario(userLogon)
		inscripcionTorneoInstance.setDetalleTorneo(detalleTorneoInstance)
		inscripcionTorneoInstance.vincular()
		inscripcionTorneoInstance.save(failOnError: true)
		
		flash.message = "Inscripción realizada con éxito"
		render(view: "/inscripcionTorneo/inscripcionRealizada")
	}
	
	def cancelarInscripcion(Long id) {
		def inscripcionTorneoInstance = InscripcionTorneo.get(id)
		
		if (!inscripcionTorneoInstance) {
			flash.message = "No se ha encontrado la inscripcion"
			redirect(controller: "inscripciones", action: "index")
			return
		}
		
		if (!inscripcionTorneoInstance.puedeCancelar()) {
			flash.message = "No se puede cancelar la inscripcion"
			redirect(controller: "inscripciones", action: "index")
			return
		}
		
		inscripcionTorneoInstance.cancelar()
		inscripcionTorneoInstance.save()
		
		flash.message = "Inscripcion cancelada"
		redirect(controller: "inscripciones", action: "index")
	}
}


