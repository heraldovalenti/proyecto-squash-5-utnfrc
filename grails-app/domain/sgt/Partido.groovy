package sgt

import java.util.Date;

class Partido {

    Date fecha;
	String horaDesde;
	String horaHasta;
	Usuario jugador1;
	Usuario jugador2;
	Usuario arbitro;
	Cancha cancha;
	Categoria categoria;
	String estado;
	ResultadoPartido resultado;
	

    static constraints = {

		estado blank:false, inList:["Diagramado"]		
		arbitro nullable: true
		resultado nullable:true

	}	
}
