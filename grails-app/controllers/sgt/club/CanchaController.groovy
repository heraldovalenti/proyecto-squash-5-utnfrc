package sgt.club

import grails.validation.ValidationException

import org.springframework.dao.DataIntegrityViolationException

import sgt.*
import sgt.exceptions.UnregisteredClubException;

class CanchaController {
	
	static defaultAction = "list"
	
	def clubService
	def canchaService

	def list() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		
		try {
			def canchas = canchaService.getCanchasClub(club)
			render(view: "/club/canchas/list", model: [canchas: canchas])			
		} catch (UnregisteredClubException e) {
			flash.message = "Deben registrarse los datos del club para gestionar las canchas"
			forward controller: "club", action: "datosClub"
		} catch (e) {
			flash.message = "Deben registrarse los datos del club para gestionar las canchas"
			forward controller: "club", action: "datosClub"
		}
	}
	
	def create() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)	
		Cancha c = canchaService.crearCancha(club) 
		render(view: "/club/canchas/create", model: [cancha: c])
	}
	
	def save() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		def cancha = new Cancha(params)
		try {
			canchaService.registrarCancha(club, cancha)
			flash.message = "Cancha registrada"
			redirect(action: "show", params: [cancha: cancha.id])
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "/club/canchas/create", model: [cancha: cancha])
		} catch (e) {
			flash.exception = e
			render(view: "/club/canchas/create", model: [cancha: cancha])
		}
	}
	
	def show() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		def cancha = canchaService.getCanchaClub(club, Cancha.get(params.cancha))
		if (!cancha) {
			flash.message = "Cancha no encontrada"
			redirect(action: "list")
		}
		render(view: "/club/canchas/show", model: [cancha: cancha])
	}
	
	def edit() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		def cancha = canchaService.getCanchaClub(club, Cancha.get(params.cancha))
		if (!cancha) {
			flash.message = "Cancha no encontrada"
			redirect(action: "list")
		}
		render(view: "/club/canchas/edit", model: [cancha: cancha])
	}
	
	def update() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		def cancha = canchaService.getCanchaClub(club, Cancha.get(params.cancha))
		
		if (!cancha) {
			flash.message = "Cancha no encontrada"
			redirect(action: "list")
		}
		
		bindData(cancha, params, [exclude: ["numero"]])
		
		try {
			canchaService.updateCancha(cancha)
			flash.message = "Cancha actualizada"
			redirect(action: "show", params: [cancha: cancha.id])
		} catch (ValidationException e) {
			flash.errors = e.errors.allErrors
			render(view: "/club/canchas/edit", model: [cancha: cancha])
		} catch (e) {
			flash.exception = e
			render(view: "/club/canchas/edit", model: [cancha: cancha])
		}
	}
	
	def delete() {
		Usuario userLogon = session.getAttribute("userLogon")
		Club club = clubService.clubLogon(userLogon)
		def cancha = canchaService.getCanchaClub(club, Cancha.get(params.cancha))
		
		if (!cancha) {
			flash.message = "Cancha no encontrada"
			redirect(action: "list")
		}
			
		canchaService.eliminarCancha(club,cancha)
		flash.message = "Cancha eliminada"
		redirect(action: "list")
	}
}
