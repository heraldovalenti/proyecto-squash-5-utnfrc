package sgt.club

import sgt.Usuario
import sgt.PostulacionTorneo
import sgt.Torneo

class PostulacionTorneoController {
	
    def index() { 
		def Usuario usuario = session.getAttribute("userLogon")
		usuario = Usuario.get(usuario?.id)
		if (!usuario) {
			redirect(url: "/")
			return
		}
		
		if (!usuario.club) {
			flash.message = "Deben registrarse los datos del club para realizar postulaciones"
			forward controller: "club", action: "datosClub"
			return
		}
		
		redirect(action: "listadoPostulaciones")
	}
	
	def listadoPostulaciones() {
		def Usuario usuario = session.getAttribute("userLogon")
		usuario = Usuario.get(usuario?.id)
		
		
		def c = PostulacionTorneo.createCriteria() 
		def postulacionInstanceList = c.list(params) {
			eq("club", usuario.club)
		}
		
		render(view: "/club/postulaciones/listadoPostulaciones", model: [postulacionInstanceList: postulacionInstanceList, postulacionInstanceTotal: postulacionInstanceList.size()])
	}
	
	def cancelarPostulacion(Long id) {
		def postulacionInstance = PostulacionTorneo.get(id)
		if (!postulacionInstance) {
			flash.message = "Postulacion no encontrada"
			redirect(action: "listadoPostulaciones")
			return
		}
		
		if(!postulacionInstance.puedeCancelarse()) {
			flash.message = "La postulacion no puede ser cancelada"
			redirect(action: "listadoPostulaciones")
			return
		}
		
		postulacionInstance.delete()
		flash.message = "Postulacion cancelada"
		redirect(action: "listadoPostulaciones")
	}
	
	def postulacion(Long id) {
		def torneoInstance = Torneo.get(id)
		def Usuario usuario = session.getAttribute("userLogon")
		usuario = Usuario.get(usuario?.id)
		
		if (!torneoInstance) {
			flash.message = "Torneo no encontrado"
			redirect(action: "listadoTorneosPostulables")
			return
		}
		
		if (!torneoInstance.esPostulable()) {
			flash.message = "No se pueden realizar postulaciones al torneo"
			redirect(action: "listadoTorneosPostulables")
			return
		}
		
		def c = PostulacionTorneo.createCriteria()
		def res = c.list() {
			eq("club", usuario.club)
			and {
				eq("torneo", torneoInstance)
			}
		}
		
		if (res.size() > 0) {
			flash.message = "Ya se encuentra postulado al torneo seleccionado"
			redirect(action: "listadoTorneosPostulables")
			return
		}
		
		def postulacionInstance = new PostulacionTorneo()
		render(view: "/club/postulaciones/crearPostulacion", model: [postulacionInstance: postulacionInstance, torneoInstance: torneoInstance])	
	}
	
	def save() {
		def postulacionInstance = new PostulacionTorneo(params)
		def torneoInstance = Torneo.get(params.idTorneo)
		def usuario = session.getAttribute("userLogon")
		usuario = Usuario.get(usuario.id)
		def club = usuario.club
		
		if (!torneoInstance) {
			flash.message = "Torneo no encontrado"
			redirect(action: "listadoTorneosPostulables")
			return
		}
		
		postulacionInstance.setTorneo(torneoInstance)
		postulacionInstance.solicitar()
		postulacionInstance.setFecha(new Date())
		postulacionInstance.setClub(club)
		
		if (!postulacionInstance.save()) {
			render(view: "/club/postulaciones/crearPostulaciones", model: [postulacionInstance: postulacionInstance, torneoInstance: torneoInstance])
			return
		}
		
		flash.mesage = "Postulacion registrada"
		redirect(action: "listadoPostulaciones")
	}
	
	def listadoTorneosPostulables() {
		def criteria = Torneo.createCriteria()
		def torneoInstanceList = criteria.list(params) {
			isNull("club")
			and {
				'in'("estado", ["Creado","Inscripcion Abierta","Inscripcion Cerrada"])
			}
		}
		
		render(view: "/club/postulaciones/listadoTorneosPostulables", model: [torneoInstanceList: torneoInstanceList, torneoInstanceTotal: torneoInstanceList.size()])
	}
}
