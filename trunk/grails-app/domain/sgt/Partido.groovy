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

    static constraints = {
    	fecha nullable: true
		horaDesde nullable: true
		horaHasta nullable: true
		jugador1 nullable: true
		jugador2 nullable: true
		arbitro nullable: true
		cancha nullable: true
		estado blank: false, inList:["Creado", "Ejecucion", "Finalizado", "Cancelado", "Suspendido"]		
		resultado nullable: true
	}
}
