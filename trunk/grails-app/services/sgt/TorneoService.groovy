package sgt

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
				return t1.fechaInicioTorneo.getTime() - t2.fechaInicioTorneo.getTime()
			}
		})
		return results
	}
}
