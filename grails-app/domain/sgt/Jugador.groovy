package sgt

import org.hibernate.criterion.CriteriaSpecification

class Jugador {
	
	String brazo
	Double altura
	Double peso
	Date juegaDesde
	Imagen imagen
	Disponibilidad disponibilidad
	
	static hasMany = [rankings: Ranking, categoriasJugador: CategoriaJugador]

    static constraints = {
		brazo nullable: true, inList: ["Derecho","Izquierdo","Ambidiestro"]
		altura nullable: true
		peso nullable: true
		juegaDesde nullable: true
		disponibilidad nullable: true
		imagen nullable: true
    }
	
	boolean checkDatosCompletados() {
		return ( brazo || altura || peso || juegaDesde || imagen )
	}
	
	Categoria getCategoriaActual() {
		def result = CategoriaJugador.createCriteria().get {
			eq("jugador", this)
			and {
				eq("estado","Asignada")
			}
		}
		return result?.categoria
	}
	
	int getPosicionRankingCategoria(Categoria c) {
		def result = Ranking.createCriteria().get {
			eq("jugador", this)
			and {
				eq("categoria", c)
			}
		}
		def puesto = (result) ? result.puesto : 0
	}
	
	boolean isDisponible(String dia, int hora) {
		def result = Jugador.createCriteria().get {
			createAlias("disponibilidad", "disp", CriteriaSpecification.LEFT_JOIN)
			createAlias("disp.detalles","det", CriteriaSpecification.LEFT_JOIN)
			and {
				isNotNull("disponibilidad")
				isNotEmpty("disp.detalles")
				eq("det.dia", dia)
				eq("det.hora", hora)
			}
		}
		def disponible = (result) ? true : false
	}
}
