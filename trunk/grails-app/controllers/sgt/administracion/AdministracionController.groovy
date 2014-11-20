package sgt.administracion

import sgt.Torneo

class AdministracionController {
	
	def torneoService
	def categoriaJugadorService
	def jugadoresService
	def clubService
	
	def index() {
		Boolean solicitudesPendientes = categoriaJugadorService.listaSolicitudesCategorias().total > 0
		List torneosEnCurso = torneoService.torneosEnCurso()
		render(view: "/administracion/inicio", model: [torneosEnCurso: torneosEnCurso, solicitudesPendientes: solicitudesPendientes])
	}
	
	def obtenerJugadores(){

		def categoria= params.categoria

		if(!params.offset){
			params.offset=0
		}
		if(!params.max){
			params.max=10
		}


		def tipo="jugador"

		def jugadoresCategoria= jugadoresService.listarJugadoresPorCategoria(categoria,params)

		def total= jugadoresCategoria.getTotalCount()

		def categorias=jugadoresService.obtenerCategorias()

		render(view: "/administracion/jugadores/jugadoresPorCategoria", model: [jugadores: jugadoresCategoria , categorias:categorias, categoriaSeleccionada:categoria,total:total,tipo:tipo])
	}
	
	def listarClubes(){

		def club

		if(!params.club){
			club=clubService.obtenerClubInicio()
		}
		else{
			def id= params.club
			club=Club.get(id)
		}

		def clubes=clubService.listarClubes()

		render(view:"/administracion/clubes/listadoClub",model:[listadoClub:clubes,club:club])
	}
}
