package sgt

class ListaTorneoController {

	def torneoService
    static defaultAction = "listaTorneos"
	
	def listaTorneos() {
		Integer year = (params.year != null && !params.year.isEmpty()) ? 
			Integer.parseInt(params.year) : Calendar.getInstance().get(Calendar.YEAR);
		def torneoInstanceList = torneoService.listaTorneos(year)
		render(view: "/torneo/listaTorneos", model: [torneoInstanceList: torneoInstanceList, year: year])
	}
	
}
