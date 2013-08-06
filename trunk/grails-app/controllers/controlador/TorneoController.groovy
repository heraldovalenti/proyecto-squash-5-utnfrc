package controlador

class TorneoController {

    static scaffold = modelo.Torneo
	
	static defaultAction = "verTorneos"
	
	def verTorneos = {
		def torneos = modelo.Torneo.findAll([sort: "fechaInicioInscripcion", order: "asc"])
		
		return [torneos: torneos]
	}
	
}
