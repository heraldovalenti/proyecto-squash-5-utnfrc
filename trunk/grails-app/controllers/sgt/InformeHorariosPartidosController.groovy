package sgt



class InformeHorariosPartidosController {

    def index() { }
	
	def report() {
	
		def partidos = Partido.list()
        chain(controller:'jasper',action:'index',model:[data:partidos],params:params)
    }
		
	
	
}
