package sgt.administracion.torneos

import sgt.PostulacionTorneo

class PostulacionTorneoService {
	
	static transactional = true

	def rechazarPostulacionTorneo(Long id) {
		//buscar la postulacion
		def postulacionRechazada = PostulacionTorneo.get(id)
		//rechazar la postulacion indicada
		postulacionRechazada.rechazar()
		postulacionRechazada.save(failOnError: true)
	}
	
    def aceptarPostulacionTorneo(Long id) {
		//buscar la postulacion
		def postulacionAceptada = PostulacionTorneo.get(id)
		//traer el torneo y el club
		def torneo = postulacionAceptada.torneo
		def club = postulacionAceptada.club
		//traer las postulaciones del torneo
		def postulacionInstanceList = PostulacionTorneo.createCriteria().list() {
			eq("torneo", torneo)
		}
		//rechazar las postulaciones
		for (def postulacion : postulacionInstanceList) {
			postulacion.rechazar()
			postulacion.save(failOnError: true)
		}
		//aceptar la postulacion indicada
		postulacionAceptada.aceptar()
		postulacionAceptada.save(failOnError: true)
		//asignar el club al torneo
		torneo.asignarClub(club)
		torneo.save(failOnError: true)
    }
}
