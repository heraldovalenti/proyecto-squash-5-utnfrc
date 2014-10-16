package sgt

class AcsInfoController {

    def index() { 
		render(view: "/acsInfo/InformeAnual")
	}
	
	def reglamentoSingles(){
		render(view: "/acsInfo/ReglamentoSingles")
	}
	
	def reglamentodobles(){
		render(view: "/acsInfo/ReglamentoDobles")
	}
	
	def informeanual(){
		render(view: "/acsInfo/InformeAnual")
	}
	
	def quienesSomos(){
		render(view: "/acsInfo/QuienesSomos")
	}
}
