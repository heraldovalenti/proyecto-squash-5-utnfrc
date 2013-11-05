package sgt.administracion.torneos

import sgt.Torneo
import sgt.DetalleTorneo
import sgt.InscripcionTorneo
import logica.Jugador
import logica.Partido
import logica.CalculosTorneo
import java.util.TreeSet

class DiagramacionController {

    def generarDiagramacion(Long id) {
		def torneoInstance = Torneo.get(id)
		if (!torneoInstance.inscripcionCerrada() || !torneoInstance.diagramado()) {
			flash.message = "El estado del torneo no permite diagramación"
			redirect(controller: "torneo", action: "show", id: id)
		}
		
		session.setAttribute("idTorneo", id)
		def detallesInstanceList = torneoInstance.getDetalles()
		
		render(view: "/administracion/diagramacion/seleccionCategoria", model: [detallesInstanceList: detallesInstanceList, torneoInstance: torneoInstance])
	}
	
	def generarSembrado(Long id) {
		def detalleInstance = DetalleTorneo.get(id)
		if (detalleInstance.cantidadInscriptos() < 2) {
			flash.message = "Debe haber al menos dos inscriptos"
			redirect(action: "generarDiagramacion", id: session.getAttribute("idTorneo"))
			return
		}
		
		def Jugador[] jugadores = new Jugador[detalleInstance.cantidadInscriptos()]
		def Iterator<InscripcionTorneo> inscripcionIterator = detalleInstance.getInscripciones().iterator()
		def int i = 0
		while(inscripcionIterator.hasNext()) {
			def InscripcionTorneo aux = inscripcionIterator.next()
			def Jugador jugador = new Jugador()
			jugador.setId(aux.usuario.id)
			jugador.setPos(aux.usuario.puestoRanking(detalleInstance.categoria))
			jugadores[i] = jugador
			i++
		}
		
		def TreeSet<Partido> resultado = CalculosTorneo.generarPrimeraRonda(jugadores)
		render resultado
	}
}
