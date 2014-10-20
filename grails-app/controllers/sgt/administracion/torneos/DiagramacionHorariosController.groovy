package sgt.administracion.torneos

import sgt.Cancha
import sgt.Club

class DiagramacionHorariosController {
	
	static defaultAction = "index"
	
	def diagramacionHorariosService
	
	def index() {
		Cancha c1 = new Cancha(techada: true, numero: 1, tipoSuelo: "Parquet")
		Cancha c2 = new Cancha(techada: true, numero: 2, tipoSuelo: "Parquet")
		Cancha c3 = new Cancha(nombre: "Alpha", techada: true, numero: 3, tipoSuelo: "Parquet")
		
		render(view: "/administracion/diagramacion/diagramacionTorneo", model: [canchas: [c1,c2,c3]])
	}

}
