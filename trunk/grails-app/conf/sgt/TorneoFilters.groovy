package sgt

class TorneoFilters {
	
	def filters = {
		//filters here
		filtroAperturaInscripcion(controller: 'torneo', action: '*') {
			before = {
				def torneoInstanceList = Torneo.list()
				def Date hoy = new Date()
				def Iterator<Torneo> iter = torneoInstanceList.iterator()
				while(iter.hasNext()) {
					Torneo aux = iter.next()
					if (aux.getFechaInicioInscripcion().before(hoy)) {
						aux.abrirInscripcion()
					}
				}
			}
		}
		
		filtroClausuraInscripcion(controller: 'torneo', action: '*') {
			before = {
				def torneoInstanceList = Torneo.list()
				def Date hoy = new Date()
				def Iterator<Torneo> iter = torneoInstanceList.iterator()
				while(iter.hasNext()) {
					Torneo aux = iter.next()
					if (aux.getFechaInicioInscripcion().after(hoy)) {
						aux.cerrarInscripcion()
					}
				}
			}
		}
	}

}
