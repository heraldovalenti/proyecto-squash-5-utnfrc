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
		
		if (!userLogon.esJugador()) {
			flash.message = "Solo los jugadores pueden inscribirse a torneos"
			redirect(controller: "torneo", action: "verTorneo", params: [idTorneo: idTorneo])
			return
		}
		
		Torneo torneo = Torneo.get(idTorneo)
		def idUsuario = userLogon.id
		
		try {
			inscripcionTorneoService.inscribirJugadorTorneo(idTorneo, idUsuario)
			flash.message = "Inscripcion realizada"
			redirect(action: "inscripcionesJugador")
		} catch (TorneoNotFoundException e) {
			flash.exception = e
			redirect(controller: "torneo", action: "verTorneo", params: [idTorneo: torneo.id])
		} catch (UnregisteredJugadorException e) {
			flash.message = "Debe registrar sus datos personales para poder realizar inscripciones"
			redirect(controller: "jugador", action: "datosPersonales")
		} catch(InscripcionTorneoException e) {
			flash.exception = e
			redirect(controller: "torneo", action: "verTorneo", params: [idTorneo: torneo.id])
		} catch (e) {
			flash.exception = e
			redirect(controller: "torneo", action: "verTorneo", params: [idTorneo: torneo.id])
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