package sgt

class ListaTorneoController {

    static defaultAction = "listaTorneos"
	
	def listaTorneos() {
		def Integer year = params.year
		def Boolean puntuables = params.puntuables
		def torneoInstanceList = Torneo.list()
		render(view: "/torneo/listaTorneos", model: [torneoInstanceList: torneoInstanceList])
	}
	
}
