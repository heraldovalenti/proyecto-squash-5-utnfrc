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

    static constraints = {
		estado blank:false, inList:["Diagramado","En ejecución","Suspendido","Finalizado","Cancelado"]
		arbitro nullable: true
	}	
}
