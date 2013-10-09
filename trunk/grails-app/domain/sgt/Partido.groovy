package sgt

import java.util.Date;

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
		categoria nullable: true
		estado blank:false, inList:["Creado", "Ejecucion", "Finalizado", "Cancelado", "Suspendido"]		
		arbitro nullable: true
		resultado nullable:true

	}	
}
