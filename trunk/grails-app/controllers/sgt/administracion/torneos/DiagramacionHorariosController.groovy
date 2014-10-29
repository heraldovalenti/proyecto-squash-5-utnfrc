package sgt.administracion.torneos

import grails.converters.JSON
import grails.validation.ValidationException;

import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.web.json.JSONObject

import sgt.Cancha
import sgt.Club
import sgt.Partido
import sgt.Torneo

class DiagramacionHorariosController {
	
	static defaultAction = "index"
	
	def diagramacionHorariosService
		
	def index() {
		render(view: "/administracion/diagramacion/diagramacionTorneo", model: ["":""])
	}
	
	Torneo getTorneo() {
		return Torneo.get(7)
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
			diagramacionHorariosService.saveDiagramacion(diagramacion)
			render "OK"
		} catch (ValidationException ex) {
			render ex.errors.allErrors as JSON
		}
	}
}