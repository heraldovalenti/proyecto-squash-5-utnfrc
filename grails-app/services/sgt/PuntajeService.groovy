package sgt

class PuntajeService {

    def String agregarPuntajeTorneo(Long idTorneo, Puntaje puntaje) {
		def TorneoPuntuable torneoPuntuableInstance = TorneoPuntuable.get(idTorneo)
		if (!torneoPuntuableInstance) return "No se encuentra el torneo indicado"
		def puntajeList = torneoPuntuableInstance.getPuntajes()
		
		def Iterator<Puntaje> iter = puntajeList.iterator()
		while(iter.hasNext()) {
			def Puntaje aux = iter.next()
			if (puntaje.categoria.id == aux.categoria.id) {
				return "El torneo ya cuenta con un puntaje para esa categoria"
			}
		}
		
		/*for (int i = 0; i < puntajeList.size(); i++) {
			def Puntaje aux = puntajeList.get(i)
			if (puntaje.categoria.id == aux.categoria.id) {
				return "El torneo ya cuenta con un puntaje para esa categoria"
			}
		}*/
		
		puntaje.save()
		torneoPuntuableInstance.addToPuntajes(puntaje)
		torneoPuntuableInstance.save()
		
		return null
    }
	
	def String agregarDetallePuntaje(Long idPuntaje, DetallePuntaje detallePuntaje) {
		def Puntaje puntajeInstance = Puntaje.get(idPuntaje)
		if (!puntajeInstance) return "No se encuentra el puntaje indicado"
		
		def detallePuntajeList = puntajeInstance.getDetalles()
		def Iterator<DetallePuntaje> iter = detallePuntajeList.iterator()
		while(iter.hasNext()) {
			def DetallePuntaje aux = iter.next()
			if (detallePuntaje.puesto == aux.puesto) {
				return "Ya exsite un puntaje para ese puesto"
			}
		}
		
		detallePuntaje.save()
		puntajeInstance.addToDetalles(detallePuntaje)
		puntajeInstance.save()
		
		return null
	}
}
