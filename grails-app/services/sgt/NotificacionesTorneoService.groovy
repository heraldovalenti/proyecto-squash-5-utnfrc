package sgt

class NotificacionesTorneoService {

	static transactional = true
	
	def generarNotificacionInscripcionTorneoAbierta(Torneo torneo) {
		//notificar que la inscripcion de un torneo ha sido abierta
	}
	
    def generarNotificacionInscripcionTorneoFinalizada(Torneo torneo) {
		//notificar que la inscripcion de un torneo ha sido cerrada automaticamente
		//y se debe finalizar la etapa de inscripcion y realizar la diagramacion del torneo 
    }
}
