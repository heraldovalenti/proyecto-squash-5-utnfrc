package sgt

class ListaTorneoController {

    static defaultAction = "listaTorneos"
	
	def listaTorneos() {
		def Integer year = params.year
		def Boolean soloPuntuables = params.soloPuntuables
		def torneoInstanceList = Torneo.list()
		render(view: "/torneo/listaTorneos", model: [torneoInstanceList: torneoInstanceList, year: year, soloPuntuables: soloPuntuables])
	}
	
}
