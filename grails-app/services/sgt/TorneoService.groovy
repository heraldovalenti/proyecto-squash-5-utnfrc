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
		if (!t.finalizado()) {
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
				gt("fechaInicioTorneo", new Date())
			}
			order("fechaInicioTorneo","asc")
		}
		return results
	}
}
