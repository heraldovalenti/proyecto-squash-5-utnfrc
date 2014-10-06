package sgt

import sgt.exceptions.InscripcionTorneoException
import sgt.exceptions.TorneoNotFoundException
import sgt.exceptions.UnregisteredJugadorException

class InscripcionTorneoController {
	
	def inscripcionTorneoService
		
	def inscribirJugadorTorneo() {
		Usuario userLogon = session.getAttribute("userLogon")
		def idTorneo = params.idTorneo
		
		if (!userLogon) {
			def loginRedirect = [controller: "torneo", action: "verTorneo", params: [idTorneo: idTorneo] ]
			session.setAttribute("loginRedirect", loginRedirect)
			chain(controller: "usuario", action: "loginForm")
			return
		}
		
		Torneo torneo = Torneo.get(idTorneo)
		def idUsuario = userLogon.id
		
		try {
			inscripcionTorneoService.inscribirJugadorTorneo(idTorneo, idUsuario)
			flash.message = "Inscripcion realizada"
			chain(action: "inscripcionesJugador")
		} catch (TorneoNotFoundException e) {
			flash.exception = e
			render(view: "/torneo/verTorneo", model: [torneo: torneo])
		} catch (UnregisteredJugadorException e) {
			flash.exception = e
			redirect(controller: "jugador", action: "datosJugador")
		} catch(InscripcionTorneoException e) {
			flash.exception = e
			render(view: "/torneo/verTorneo", model: [torneo: torneo])
		} catch (e) {
			flash.exception = e
			render(view: "/torneo/verTorneo", model: [torneo: torneo])
		}
	}
	
	def cancelarInscripcion() {
		def idInscripcion = params.idInscripcion
		try {
			inscripcionTorneoService.cancelarInscripcionTorneo(idInscripcion)
			flash.message = "Inscripcion cancelada"
		} catch(InscripcionTorneoException e) {
			flash.exception = e
		} catch (e) {
			flash.exception = e
		}
		chain(action: "inscripcionesJugador")
	}
	
	def inscripcionesJugador() {
		Usuario userLogon = session.getAttribute("userLogon")
		def res = inscripcionTorneoService.getInscripcionActivasUsuario(userLogon.id)
		render(view: "/jugador/inscripcion/listadoInscripcion", model: [inscripciones: res])
	}
}