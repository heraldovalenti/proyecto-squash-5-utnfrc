package sgt

class Partido {

    Torneo torneo
	Date fecha
	String horaDesde
	String horaHasta
	Usuario jugador1
	Usuario jugador2
	Usuario arbitro
	Cancha cancha
	Categoria categoria
	String estado
	ResultadoPartido resultado
	Integer ordenPartido
	Partido siguientePartido

    static constraints = {
    	fecha nullable: true
		horaDesde nullable: true
		horaHasta nullable: true
		jugador1 nullable: true
		jugador2 nullable: true
		arbitro nullable: true
		cancha nullable: true
		estado blank: false, inList: ["Creado", "Ejecucion", "Finalizado", "Cancelado", "Suspendido"]
		resultado nullable: true
		siguientePartido nullable: true
	}
	
	int cantidadRondasCategoriaTorneo() {
		def partidos = Partido.createCriteria().list() {
			eq("torneo", this.torneo)
			and {
				eq("categoria", this.categoria)
			}
		}
		int cantidadPartidos = partidos.size()
		return ( (Math.log(cantidadPartidos + 1)) / (Math.log(2)) )
	}
	
	int rondaPartido() {
		int ronda = cantidadRondasCategoriaTorneo()
		Partido aux = siguientePartido
		while(aux != null) {
			aux = aux.siguientePartido
			ronda--
		}
		return ronda
	}
	
	String rondaPartidoString() {
		int cantidad = cantidadRondasCategoriaTorneo()
		int ronda = rondaPartido()
		int diff = Math.abs(ronda - cantidad)
		if (diff == 0) return "Final"
		if (diff == 1) return "Semi-Final"
		if (diff == 2) return "4tos de final"
		if (diff == 3) return "8vos de final"
		return ( (diff - 3) + "º Ronda")
	}
}
