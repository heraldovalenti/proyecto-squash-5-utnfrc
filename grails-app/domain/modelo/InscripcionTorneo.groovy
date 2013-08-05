package modelo

import modelo.disponibilidadhoraria.DisponibilidadHoraria;


class InscripcionTorneo {
	
	Usuario usuario
	String estado
	Date fecha
	DisponibilidadHoraria disponibilidad
   
	static belongsTo = DetalleTorneo
		
	static constraints = {
		usuario nullable:false
		fecha nullable:false
		estado blanck:false, inList:["Creada","Vinculada","Cerrada","Cancelada","Diagramada"]
		disponibilidad nullable: false
	}
}
