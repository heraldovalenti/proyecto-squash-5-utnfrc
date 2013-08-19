package sgt

import sgt.Disponibilidad;


class InscripcionTorneo {
	
	Usuario usuario
	String estado
	Date fecha
	Disponibilidad disponibilidad
   
	static belongsTo = DetalleTorneo
		
	static constraints = {
		usuario nullable:false
		fecha nullable:false
		estado blanck:false, inList:["Creada","Vinculada","Cerrada","Cancelada","Diagramada"]
		disponibilidad nullable: false
	}
}
