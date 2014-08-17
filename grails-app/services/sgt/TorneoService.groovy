package sgt

import org.springframework.transaction.annotation.Transactional

@Transactional
class TorneoService {
	
	def actualizarEstados() {
		abrirInscripcionesTorneo()
		/*cerrarInscripcionesTorneo()*/
	}

    def abrirInscripcionesTorneo() {
		Date hoy = new Date()
		List<Torneo> torneosCreados = Torneo.findAll()
		for (torneo in torneosCreados) {
			println "torneo.nombre=" + torneo.nombre
			println "torneo.estado(before)=" + torneo.estado
			if (torneo.fechaInicioInscripcion.before(hoy)) {
				torneo.abrirInscripcion()
				torneo.save(failOnError: true)
			}
			println "torneo.estado(after)=" + torneo.estado
		}
    }
	
	
	/*def cerrarInscripcionesTorneo() {
		Date hoy = new Date()
		List<Torneo> inscripcionesAbiertas = Torneo.findAllByEstado("Inscripcion Abierta")
		for (torneo in inscripcionesAbiertas) {
			if (torneo.fechaFinInscripcion.before(hoy)) {
				torneo.cerrarInscripcion()
				torneo.save(failOnError: true)
			}
		}
	}*/
}
