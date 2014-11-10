package sgt.administracion.torneos
import grails.converters.JSON
import sgt.Torneo;
import sgt.Partido;
import sgt.Categoria;

class FixtureController {

    def index() {	
		def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")
		torneoInstance = Torneo.get(torneoInstance.id)
		def categorias= torneoInstance?.detalles?.categoria
		render(view:"/administracion/fixture/show", model: [categorias: categorias])
	}
	
	def generarFixturePorCategoria(String categoria){
		
		def categoriaId=categoria.split(' -')		
		def categoriaSeleccionada=Categoria.findByNombre(categoriaId[0])	
		def torneoInstance = (sgt.Torneo)session.getAttribute("torneoSeleccionado")
		torneoInstance = Torneo.get(torneoInstance.id)
		JSON.registerObjectMarshaller(Partido) {
			return [
				id: it.id,
				fecha: it.fecha,
				inicio: it.horaDesde,
				fin: it.horaHasta,
				estado: it.estado,
				jugador1: it.jugador1.toString(),
				jugador2: it.jugador2.toString(),
				cancha: it.cancha?.id,
				categoria: it.categoria.toString(),
				orden: it.ordenPartido,
				ronda: it.rondaPartido(),
				rondaString: it.rondaPartidoString(),
				resultado: it.resultado?.calcularSets(),
				cantidadRondas: it.cantidadRondasCategoriaTorneo()
				]
		}
		def partidos = Partido.createCriteria().list() {
			and{
			eq("categoria", categoriaSeleccionada)
			eq("torneo",torneoInstance)
			}
			order("ordenPartido", "asc")
		}
		
		render partidos  as JSON		
	}
}
