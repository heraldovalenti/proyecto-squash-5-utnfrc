package sgt

class Disponibilidad {
	
	Date fechaActualizacion
	
	static hasMany = [detalles: DetalleDisponibilidad]
	
	String toString() {
		return detalles.toString()
	}
	
	static mapping = {
		detalles cascade:"all,delete-orphan"		
		}

	
    static constraints = {
		fechaActualizacion nullable:true 
    }
	
}
