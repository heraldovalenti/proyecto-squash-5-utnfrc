package sgt

import sgt.Disponibilidad;
import sgt.Usuario


class InscripcionTorneo {
	
	Usuario usuario
	String estado
	Date fecha
   
	static belongsTo = [detalleTorneo: DetalleTorneo]
		
	static constraints = {
		usuario nullable:false
		fecha nullable:false
		estado blank:false, inList:["Creada","Vinculada","Cerrada","Cancelada","Diagramada"]
	}
	
	def void diagramar() {
		if (this.estado.equals("Vinculada")) this.estado = "Diagramada"
	}
	
	def void cancelar() {
		if (this.estado.equals("Vinculada")) this.estado = "Cancelada"
	}
	
	def void vincular() {
		if (!this.estado) this.estado = "Vinculada"
	}
}
