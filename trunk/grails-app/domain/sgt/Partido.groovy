package sgt

import java.util.Date;

class Partido {

    Date fecha;
	String horaDesde;
	String horaHasta;
	Persona jugador1;
	Persona jugador2;
	Persona arbitro;
	Cancha cancha;
	Categoria categoria;
	String estado;

    static constraints = {
		estado blank:false, inList:["Diagramado","En ejecución","Suspendido","Finalizado","Cancelado"]
	}	
}
