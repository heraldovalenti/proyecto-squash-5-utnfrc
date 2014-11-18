package sgt

class TorneoActualTagLib {
	
	def torneoService
	def filesService
	
	def torneoActual = {
		Torneo t = torneoService.torneoActual()
		out << t?.id
	}
	
	def logoTorneoActual = { attrs ->
		def img = "default.jpg"
		def dir = filesService.retrieveImagesDir()
		Torneo t = torneoService.torneoActual()
		if(t.imagen){
			img = t.imagen.nombre
		}
		out << g.resource(dir: dir, file: img)
	}
	
	def nombreTorneoActual = { attrs ->
		Torneo t = torneoService.torneoActual()
		if (t.club) {
			out << t.toString() + " - " + t.club.toString()		
		} else {
			out << t
		}
	}
	
	def fechasTorneoActual = { attrs ->
		Torneo t = torneoService.torneoActual()
		String f = "dd-MM-yyyy"
		out << g.formatDate(date: t.fechaInicioTorneo, format: f)
		out << " al "
		out << g.formatDate(date: t.fechaFinTorneo, format: f)
	}

}
