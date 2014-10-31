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
		estado blank: false, inList: ["Creado", "En ejecucion", "Finalizado", "Cancelado", "Suspendido"]
		resultado nullable: true
		ordenPartido nullable: true
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
		int ronda = 1
		Partido aux = siguientePartido
		while(aux != null) {
			aux = aux.siguientePartido
			ronda++
		}
		return ronda
	}
	
	String rondaPartidoString() {
		int ronda = rondaPartido()
		if (ronda == 1) return "Final"
		if (ronda == 2) return "Semi-Final"
		if (ronda == 3) return "4tos de final"
		if (ronda == 4) return "8vos de final"
		
		int cantidad = cantidadRondasCategoriaTorneo()
		int diff = Math.abs(ronda - cantidad)
		return ( (diff + 1) + "º Ronda")
	}
	
	boolean creado() {
		return ("Creado").equals(this.estado)
	}
	
	boolean enCurso() {
		return ("En curso").equals(this.estado)
	}
	
	boolean finalizado() {
		return ("Finalizado").equals(this.estado)
	}
	
	void crear() {
		if (!this.estado) {
			this.estado = "Creado"
		}
	}
	
	void comenzar() {
		if (this.creado()) {
			this.estado = "En curso"
		}
	}
	
	void finalizar() {
		if (this.creado() || enCurso()) {
			this.estado = "Finalizado"
		}
	}
}
