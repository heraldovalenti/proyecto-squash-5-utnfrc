package sgt

import org.springframework.transaction.annotation.Transactional

class TorneoService {
	
	static transactional = true
	
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
			}
		}
	}
}
