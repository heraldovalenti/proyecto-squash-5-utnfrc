package sgt

import com.sun.istack.internal.Nullable;

class Torneo {
	
	String nombre
	Date fechaAlta
	Date fechaInicioTorneo
	Date fechaFinTorneo
	Date fechaInicioInscripcion
	Date fechaFinInscripcion
	String estado
	Club club
	Boolean puntuable
	
	static hasMany = [detalles: DetalleTorneo]
	
	String toString()
	{
		return nombre + " " + fechaInicioTorneo.getYear()
	}

    static constraints = {
		nombre blank: false, maxSize: 150
		fechaAlta nullable: false
		fechaInicioInscripcion nullable: false
		fechaFinInscripcion nullable: false
		fechaInicioTorneo nullable: false
		fechaFinTorneo nullable: false	
		club nullable:true
		estado blank: false, inList:["Creado","Inscripcion Abierta","Inscripcion Cerrada",
			"Diagramado","En Curso","Finalizado", "Ranking Actualizado"]
    }
	
}
	
	
