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

    static constraints = {
		nombre blank: false, maxSize: 150
		fechaAlta nullable: false
		fechaInicioInscripcion nullable: false
		fechaFinInscripcion nullable: false
		fechaInicioTorneo nullable: false
		fechaFinTorneo nullable: false	
		club Nullable:false
		estado blank: false, inList:["Creado","Inscripcion Abierta","Inscripcion Cerrada",
			"Diagramado","En Curso","Finalizado", "Ranking Actualizado"]
    }
	
	String toString() {
		return nombre
	}
}
