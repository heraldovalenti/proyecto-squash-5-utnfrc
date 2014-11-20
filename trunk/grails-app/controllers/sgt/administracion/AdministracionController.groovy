package sgt.administracion

import sgt.Torneo

class AdministracionController {
	
	def torneoService
	def categoriaJugadorService
	
	def index() {
		Boolean solicitudesPendientes = categoriaJugadorService.listaSolicitudesCategorias().total > 0
		List torneosEnCurso = torneoService.torneosEnCurso()
		render(view: "/administracion/inicio", model: [torneosEnCurso: torneosEnCurso, solicitudesPendientes: solicitudesPendientes])
	}
}
