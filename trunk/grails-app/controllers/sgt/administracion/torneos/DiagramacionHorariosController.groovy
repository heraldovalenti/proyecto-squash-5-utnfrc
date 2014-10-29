package sgt.administracion.torneos

import grails.converters.JSON

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
		render(view: "/administracion/diagramacion/diagramacionTorneo")
	}
	
	Torneo getTorneo() {
		return Torneo.get(7)
	}
	
	def getCanchas() {
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
			Long idPartido = partidosJson[i].id
			Partido p = Partido.get(idPartido)
			
			Long idCancha = (JSONObject.NULL != partidosJson[i].cancha) ? Long.parseLong(partidosJson[i].cancha) : null
			p.cancha = Cancha.get(idCancha)
			 
			String fechaString = (JSONObject.NULL != partidosJson[i].fecha) ? fechaString.substring(0, 9) : null
			Date fecha = (fechaString) ? sdf.parse(fechaString) : null
			p.fecha = fecha
			
			p.horaDesde = partidosJson[i].inicio
			
			p.horaHasta = partidosJson[i].fin
			diagramacion.add(p)
		}
	}
}
