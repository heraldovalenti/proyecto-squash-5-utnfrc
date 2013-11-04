package sgt

class InscripcionTorneoController {
		
	def inscripcionTorneo(Long id) {
		def userLogon = session.getAttribute("userLogon")
		if (!userLogon) {
			flash.message = "Debe iniciar sesi�n primero"
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
			flash.message = "Ya se encuentra inscripto en esa categor�a"
			redirect(action: "inscripcionTorneo", id: idTorneo)
			return
		}
		
		if (!categoriaJugadorInstance || !categoriaJugadorInstance?.categoria?.equals(etalleTorneoInstance?.categoria)) {
			flash.message = "La categor�a seleccionada no corresponde a la suya"
			redirect(action: "inscripcionTorneo", id: idTorneo)
			return
		}
		
		def inscripcionTorneoInstance = new InscripcionTorneo()
		inscripcionTorneoInstance.setFecha(new Date())
		inscripcionTorneoInstance.setUsuario(userLogon)
		inscripcionTorneoInstance.setDetalleTorneo(detalleTorneoInstance)
		inscripcionTorneoInstance.vincular()
		inscripcionTorneoInstance.save(failOnError: true)
		
		flash.message = "Inscripci�n realizada con �xito"
		render(view: "/inscripcionTorneo/inscripcionRealizada")
	}
}


