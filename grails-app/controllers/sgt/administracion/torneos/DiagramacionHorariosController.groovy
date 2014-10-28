package sgt.administracion.torneos

import grails.converters.JSON
import sgt.Cancha
import sgt.Club
import sgt.Partido
import sgt.Torneo

class DiagramacionHorariosController {
	
	static defaultAction = "index"
	
	def diagramacionHorariosService
	
	def index() {
		Cancha c1 = new Cancha(techada: true, numero: 1, tipoSuelo: "Parquet")
		Cancha c2 = new Cancha(techada: true, numero: 2, tipoSuelo: "Parquet")
		Cancha c3 = new Cancha(nombre: "Alpha", techada: true, numero: 3, tipoSuelo: "Parquet")
		
		render(view: "/administracion/diagramacion/diagramacionTorneo", model: [canchas: [c1,c2,c3]])
	}
	
	private Torneo getTorneo() {
		return Torneo.get(1)
	}
	
	def getCanchas() {
		Torneo t = getTorneo()
		Club club = t.club
		List<Cancha> canchas = new ArrayList<Cancha>(club.canchas)
		Collections.sort(canchas)
		render canchas as grails.converters.deep.JSON
	}
	
	def getDuracionDiasTorneo() {
		Torneo t = getTorneo()
		render t.getDuracionDias()
	}
	
	def getFechaDiaTorneo() {
		Integer numeroDia = Integer.parseInt(params.numeroDia)
		Torneo t = getTorneo()
		/*JSON.registerObjectMarshaller(Date) {
			return it?.format("mm/dd/yyyy")
		}*/
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
				cancha: it.cancha.id,
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

}
