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
	
	def Boolean esVinculada() {
		return this.estado.equals("Vinculada")
	}
	
	def void diagramar() {
		if (this.estado.equals("Vinculada")) this.estado = "Diagramada"
	}
	
	def Boolean puedeCancelar() {
		return this.estado.equals("Vinculada")
	}
	
	def void cancelar() {
		if (this.estado.equals("Vinculada")) this.estado = "Cancelada"
	}
	
	def void vincular() {
		if (!this.estado) this.estado = "Vinculada"
	}
}
