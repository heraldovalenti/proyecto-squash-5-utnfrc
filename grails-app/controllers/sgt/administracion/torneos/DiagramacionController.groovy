package sgt.administracion.torneos

import grails.converters.JSON
import grails.validation.ValidationException

import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.web.json.JSONObject

import sgt.Cancha
import sgt.Club
import sgt.Partido
import sgt.Torneo
import sgt.exceptions.DiagramacionException;
import sgt.exceptions.TorneoNotFoundException;

class DiagramacionController {
		
	def diagramacionService
	
	def generarDiagramacion(Long id) {
		try {
			Torneo t = diagramacionService.generarDiagramacion(id)
			session.setAttribute("torneoDiagramacion", t)
			render(view: "/administracion/diagramacion/diagramacionTorneo", model: ["":""])
		} catch(TorneoNotFoundException ex) {
			flash.exception = ex
			redirect(controller: "torneo", action: "list")
		} catch (ValidationException ex) {
			flash.errors = ex.errors.allErrors
			redirect(controller: "torneo", action: "show", id: id)
		} catch (DiagramacionException ex) {
			flash.exception = ex
			redirect(controller: "torneo", action: "show", id: id)
		}
	}
	
	private Torneo getTorneo() {
		Torneo t = session.getAttribute("torneoDiagramacion")
		t = t.merge()
	}
	
	def getCanchas() {
		JSON.registerObjectMarshaller(Cancha) {
			return [
				id: it.id,
				club: it.club.id,
				nombre: it.nombre,
				numero: it.numero,
				techada: it.techada,
				tipoSuelo: it.tipoSuelo,
				disponibilidad: [detalles: it.disponibilidad?.detalles] ]
		}
		Torneo t = getTorneo()
		Club club = t.club
		List<Cancha> canchas = new ArrayList<Cancha>(club.canchas)
		Collections.sort(canchas)
		render canchas as JSON
	}
	
	def getDuracionDiasTorneo() {
		Torneo t = getTorneo()
		render t.getDuracionDias()
	}
	
	def getFechaDiaTorneo() {
		Integer numeroDia = Integer.parseInt(params.numeroDia)
		Torneo t = getTorneo()
		Date fecha = t.getFechaDiaTorneo(numeroDia) 
		def res = [fechaDia: fecha]
		render res as JSON
	}
	
	def getDatosTorneo() {
		render getTorneo() as JSON
	}
	
	def getPartidos() {
		JSON.registerObjectMarshaller(Partido) {
			return [
				id: it.id,
				fecha: it.fecha,
				inicio: it.horaDesde,
				fin: it.horaHasta,
				estado: it.estado,
				jugador1: it.jugador1.toString(),
				jugador2: it.jugador2.toString(),
				cancha: it.cancha?.id,
				categoria: it.categoria.toString(),
				orden: it.ordenPartido,
				ronda: it.rondaPartido(),
				rondaString: it.rondaPartidoString()
				]
		}
		Torneo t = getTorneo()
		def partidos = Partido.createCriteria().list() {
			eq("torneo", t)
		}
		render partidos as JSON
	}
	
	def savePartidos() {
		List<Partido> diagramacion = new ArrayList<Partido>()
		def partidosJson = request.JSON
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
		for (int i = 0; i < partidosJson.size(); i++) {
			Partido p = Partido.get(partidosJson[i].id)
			p.cancha = (JSONObject.NULL.equals(partidosJson[i].cancha)) ? null : 
				Cancha.get( partidosJson[i].cancha )
			p.fecha = (JSONObject.NULL.equals(partidosJson[i].fecha)) ? null :
				sdf.parse( ( (String)partidosJson[i].fecha).substring(0, 10) )			
			p.horaDesde = (JSONObject.NULL.equals(partidosJson[i].inicio)) ? null : ((String)partidosJson[i].inicio)
			p.horaHasta = (JSONObject.NULL.equals(partidosJson[i].fin)) ? null : ((String)partidosJson[i].fin)
			diagramacion.add(p)
		}
		try {
			diagramacionService.saveDiagramacion(diagramacion)
			render "OK"
		} catch (ValidationException ex) {
			render ex.errors.allErrors as JSON
		}
	}
	
	def verTorneo() {
		Torneo t = getTorneo()
		chain(controller: "torneo", action: "show", id: t.id)
	}
}