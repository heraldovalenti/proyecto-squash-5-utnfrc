package sgt

class TorneoController {

    static scaffold = sgt.Torneo
	
	static defaultAction = "verTorneos"
	
	def verTorneos = {
		def torneos = sgt.Torneo.findAll([sort: "fechaInicioInscripcion", order: "asc"])
		
		return [torneos: torneos]
	}
	
}
