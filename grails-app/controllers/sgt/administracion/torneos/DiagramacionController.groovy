package sgt.administracion.torneos

import grails.converters.JSON
import grails.validation.ValidationException

import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.web.json.JSONObject

import sgt.Cancha
import sgt.Club
import sgt.Partido
import sgt.Torneo
import sgt.Usuario
import sgt.exceptions.DiagramacionException
import sgt.exceptions.TorneoNotFoundException

class DiagramacionController {
		
	def diagramacionService
	
	def diagramacionTorneo(Long id) {
		try {
			Torneo t = diagramacionService.getTorneo(id)
			session.setAttribute("torneoSeleccionado", t)
			if (diagramacionService.generarDiagramacion(id)) flash.message = "Partidos de torneo generados"
			redirect(action: "seleccionarPartidos", id: id)
		} catch(TorneoNotFoundException ex) {
			flash.exception = ex
			redirect(controller: "torneo", action: "list")
		} catch (ValidationException ex) {
			flash.errors = ex.errors.allErrors
			redirect(controller: "torneo", action: "show", id: id)
		} 
		catch (DiagramacionException ex) {
			flash.exception = ex
			redirect(controller: "torneo", action: "show", id: id)
		}
	}
		
	def seleccionarPartidos(Long id) {
		try {
			Torneo t = diagramacionService.getTorneo(id)
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
			Date fechaInicio = (params.fechaInicio) ? sdf.parse(params.fechaInicio) : null
			Date fechaFin = (params.fechaFin) ? sdf.parse(params.fechaFin) : null
			def categorias = diagramacionService.getCategoriasTorneo(id)
			def rondas = diagramacionService.getRondasTorneo(id)
			def partidos = diagramacionService.listarPartidosTorneo(id, params)
			render(view: "/administracion/diagramacion/seleccionPartidos", model: [torneo: t, partidos: partidos, 
				incluirDiagramados: params.incluirDiagramados, 
				categorias: categorias, categoria: params.categoria,
				keysRonda: rondas.keys, valuesRonda: rondas.values, ronda: params.ronda, 
				fechaInicio: fechaInicio, fechaFin: fechaFin])
		} catch(TorneoNotFoundException ex) {
			flash.exception = ex
			redirect(controller: "torneo", action: "list")
		}
	}
	
	def generarDiagramacion(Long id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
		Date fechaInicio = (params.fechaInicio) ? sdf.parse(params.fechaInicio) : null
		Date fechaFin = (params.fechaFin) ? sdf.parse(params.fechaFin) : null
		try {
			List<Partido> partidos = new ArrayList<Partido>()
			for (String p : params) {
				if ( p.length() > 8 && p.startsWith("partido-") && p.endsWith("=on") ) {
					String idPartidoString = p.split("-")[1]
					idPartidoString = idPartidoString.split("=")[0]
					Long idPartido = Long.parseLong(idPartidoString)
					Partido partido = Partido.get(idPartido)
					if (partido) partidos.add(partido)
				}
			}
			diagramacionService.generarHorarios(id, partidos, fechaInicio, fechaFin)
			redirect(action: "diagramacionHorarios", id: id)
		} catch(TorneoNotFoundException ex) {
			flash.exception = ex
			redirect(controller: "torneo", action: "list")
		} catch (DiagramacionException ex) {
			flash.exception = ex
			redirect(action: "seleccionarPartidos", id: id)
		} 
		catch (ex) {
			flash.exception = ex
			redirect(action: "seleccionarPartidos", id: id)
		}
	}
	
	def diagramacionHorarios(Long id) {
		render(view: "/administracion/diagramacion/diagramacionTorneo", model: ["": ""])
	}
	
	private Torneo getTorneo() {
		Torneo t = session.getAttribute("torneoSeleccionado")
		return Torneo.get(t.id)
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
				jugador1_id: it.jugador1?.id,
				jugador2_id: it.jugador2?.id,
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
	
	def verDisponibilidadHorariaJugador(Long id) {
		Usuario u = Usuario.get(id)
		Torneo t = getTorneo()
		int[][] disponibilidad = null
		if (u.jugador.disponibilidad && !u.jugador.disponibilidad?.detalles?.isEmpty() ) {
			disponibilidad = new int[16][7]
			for (d in u.jugador.disponibilidad.detalles) {
				int hora = d.hora - 8
				int dia = 0; //lunes
				if ("martes".equals(d.dia)) dia = 1
				if ("miercoles".equals(d.dia)) dia = 2
				if ("jueves".equals(d.dia)) dia = 3
				if ("viernes".equals(d.dia)) dia = 4
				if ("sabado".equals(d.dia)) dia = 5
				if ("domingo".equals(d.dia)) dia = 6
				disponibilidad[hora][dia] = 1
			}
		}
		render(view: "/administracion/diagramacion/disponibilidadJugador", model:[torneo: t, usuario: u, disponibilidad: disponibilidad])
	}
	
	def getDisponibilidadJugador(Long id) {
		Usuario u = Usuario.get(id)
		def jugador = u?.toString()
		def disponibilidad = u?.jugador?.disponibilidad?.detalles
		def res = [jugador: null, disponibilidad: null]
		if ( jugador ) res.jugador = jugador.toString()
		if ( disponibilidad ) res.disponibilidad = disponibilidad
		render res as JSON
	}
}