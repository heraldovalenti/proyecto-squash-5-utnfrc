package sgt

class ServicioClubService {

	static transactional = true
	
    def saveServicio(Club club) {
		servicio.save(failOnError: true)
		return servicio
    }
	
	def deleteServicio(ServicioClub servicio) {
		servicio.delete()
	}
	
	def serviciosDisponibles(Club club) {
		Set serviciosDisponibles = ServicioClub.constraints.nombre.inList
		Set serviciosClub = club.servicios
		for (ServicioClub servicio : serviciosClub) {
			serviciosDisponibles.remove(servicio.nombre)
		}
		return serviciosDisponibles
	}
	
	def agregarServicioClub(Club club, ServicioClub servicio) {
		servicio.save(failOnError: true)
		club.addToServicios(servicio)
		club.save(failOnError: true)
	}
	
	def quitarServicioClub(Club club, ServicioClub servicio) {
		club.removeFromServicios(servicio)
		servicio.delete()
		club.save(failOnError: true)	
	}
}
