package sgt

import sgt.Disponibilidad;
import sgt.Usuario


class InscripcionTorneo {
	
	Usuario usuario
	String estado
	Date fecha
   
	static belongsTo = [detalleTorneo: DetalleTorneo]
		
	static constraints = {
		estado inList: ["Vinculada","Cancelada","Diagramada"]
	}
	
	boolean esVinculada() {
		return this.estado.equals("Vinculada")
	}
	
	boolean esCancelada() {
		return this.estado.equals("Cancelada")
	}
	
	boolean cancelable() {
		return this.estado.equals("Vinculada")
	}
	
	void cancelar() {
		if (this.estado.equals("Vinculada")) this.estado = "Cancelada"
	}
	
	void vincular() {
		if (!this.estado) this.estado = "Vinculada"
	}
	
	void diagramar() {
		if (this.estado.equals("Vinculada")) this.estado = "Diagramada"
	}	
}
