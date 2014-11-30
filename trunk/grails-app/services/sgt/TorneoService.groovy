package sgt

import grails.validation.ValidationException;
import sgt.exceptions.EstadoTorneoException
import sgt.exceptions.RankingException;
import sgt.exceptions.TorneoNotFoundException;

import com.sun.org.apache.bcel.internal.generic.RETURN;


class TorneoService {
	
	static transactional = true
	def notificacionesTorneoService
	
	def actualizarEstados() {
		abrirInscripcionesTorneo()
		cerrarInscripcionesTorneo()
	}

    def abrirInscripcionesTorneo() {
		Date hoy = new Date()
		List<Torneo> torneosCreados = Torneo.findAllWhere(estado: "Creado")
		for (torneo in torneosCreados) {
			if (torneo.fechaInicioInscripcion.before(hoy)) {
				torneo.abrirInscripcion()
				torneo.save(failOnError: true)
				notificacionesTorneoService.generarNotificacionInscripcionTorneoAbierta(torneo)
			}
		}
    }
	
	
	def cerrarInscripcionesTorneo() {
		Date hoy = new Date()
		List<Torneo> inscripcionesAbiertas = Torneo.findAllWhere(estado: "Inscripcion Abierta")
		for (torneo in inscripcionesAbiertas) {
			if (torneo.fechaFinInscripcion.before(hoy)) {
				torneo.cerrarInscripcion()
				torneo.save(failOnError: true)
				notificacionesTorneoService.generarNotificacionInscripcionTorneoFinalizada(torneo)
			}
		}
	}
	
	def listaTorneos(Integer year) {
		def results = new LinkedList()
		for (Torneo t : Torneo.all) {
			def torneoYear = t.fechaInicioInscripcion.toCalendar().get(Calendar.YEAR)
			if (torneoYear.equals(year)) {
				results.add(t)
			}
		}
		Collections.sort(results, new Comparator<Torneo>() {
			@Override
			int compare(Torneo t1, Torneo t2) {
				long diff = t1.fechaInicioTorneo.getTime() - t2.fechaInicioTorneo.getTime()
				if (diff == 0) return 0
				if (diff > 0) return 1
				if (diff < 0) return -1
			}
		})
		return results
	}
	
	def listarPosicionesTorneo(Torneo t,Categoria categoria) throws TorneoNotFoundException,EstadoTorneoException {
		if (!t) {
			throw new TorneoNotFoundException()
		}
		if (!t.finalizado() || !t.rankingActualizado()) {
			throw new EstadoTorneoException()
		}
		return listaPosiciones(t,categoria)
	}
	
	def listaPosiciones(Torneo t,Categoria cat) {
		def partidos = Partido.createCriteria().list() {
			and {
				eq("torneo", t)
				eq("categoria", cat)
			}
			order("ordenPartido", "desc")
		}
		List jugadores = new ArrayList()
		for (Partido p : partidos){

			if(!(jugadores.contains(p.jugador1)) && !(jugadores.contains(p.jugador2))){


				if(p.resultado?.ganador==p.jugador1 && p.jugador1!=null){
					jugadores.add(p.jugador1)
					if(p.jugador2!=null){
						jugadores.add(p.jugador2)
					}
				}
				else{
					if(p.jugador1!=null)
						jugadores.add(p.jugador2)
					if(p.jugador2!=null){
						jugadores.add(p.jugador1)
					}
				}
			}
			else if(!(jugadores.contains(p.jugador1)) && (jugadores.contains(p.jugador2)) && (p.jugador1!=null) ){
				jugadores.add(p.jugador1)
			}
			else if(!(jugadores.contains(p.jugador2)) && (jugadores.contains(p.jugador1)) && (p.jugador2!=null)){
				jugadores.add(p.jugador2)
			}
		}
		return jugadores
	}
	
	Torneo torneoActual() {
		def results = Torneo.createCriteria().list() {
			or {
				eq("estado", "En Curso")
				gt("fechaInicioTorneo", new Date())
			}
			order("fechaInicioTorneo","asc")
		}
		if (results && !results.isEmpty()) return results[0]
	}
	
	def torneosEnCurso() {
		def results = Torneo.createCriteria().list() {
			or {
				eq("estado", "En Curso")
				eq("estado", "Inscripcion Abierta")
				eq("estado", "Inscripcion Cerrada")
				eq("estado", "Inscripcion Finalizada")
				eq("estado", "Finalizado")
				eq("estado", "Diagramado")
				gt("fechaInicioTorneo", new Date())
			}
			order("fechaInicioTorneo","asc")
		}
		return results
	}
	
	def obtenerInscriptosTorneoPorAnio(Integer year){
		
		def torneos=listaTorneos(year)
		
		List inscripcionesAnuales = new ArrayList()
		List torneosAnuales = new ArrayList()
		List insc = new ArrayList()
		
		
		for(Torneo t:torneos){
			
			def inscripciones=0
			
			def detalles= t?.detalles			
			
			for(DetalleTorneo dt: detalles){
				
				inscripciones+=dt.inscripciones.size()				
				
			}
			if(inscripciones>0){
				torneosAnuales.add(t.nombre)
				insc.add(inscripciones)
			}			
		}
		
		inscripcionesAnuales.add(insc)
		inscripcionesAnuales.add(torneosAnuales)
		
		return inscripcionesAnuales
		
	}
	
	def diagramacionTorneoPorFecha(Torneo t) {
		def partidos = Partido.createCriteria().list {
			and {
				eq("torneo", t)
				isNotNull("fecha")
				isNotNull("horaDesde")
			}
		}
		Map<Date,List<Partido>> partidosPorFecha = new HashMap<Date,List<Partido>>()
		for (p in partidos) {
			Date d = p.fecha
			List<Partido> partidosParaFecha = partidosPorFecha.get(d)
			if (!partidosParaFecha) {
				partidosParaFecha = new ArrayList<Partido>()
				partidosPorFecha.put(d, partidosParaFecha)
			}
			partidosParaFecha.add(p)
		}
		List<Date> keyFechas = new ArrayList<Date>(partidosPorFecha.keySet())
		Collections.sort(keyFechas)
		List<Map<Date,List<Partido>>> res = new ArrayList()
		for (d in keyFechas) {
			List<Partido> partidosParaFecha = partidosPorFecha.get(d)
			Collections.sort(partidosParaFecha, new Comparator<Partido>() {
				@Override
				int compare(Partido p1, Partido p2) {
					try {
						int horaDesde1 = Integer.parseInt(p1.horaDesde)
						int horaDesde2 = Integer.parseInt(p2.horaDesde)
						return (horaDesde1 - horaDesde2)
					} catch (e) {}
					return 0
				}
			})
			res.add([fecha: d, partidos: partidosPorFecha.get(d)])
		}
		return res
	}
}
