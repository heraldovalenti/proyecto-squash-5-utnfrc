package sgt

class ListaTorneoController {

    static defaultAction = "listaTorneos"
	
	def listaTorneos() {
		def torneoInstanceList = Torneo.list()
		render(view: "/torneo/listaTorneos", model: [torneoInstanceList: torneoInstanceList])
	}
	
}
