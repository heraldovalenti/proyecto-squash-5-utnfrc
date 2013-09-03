package sgt

class Disponibilidad {
	
	Date fechaActualizacion
	
	static hasMany = [detalles: DetalleDisponibilidad]
	
	String toString() {
		return detalles.toString()
	}

	
    static constraints = {
		fechaActualizacion nullable:true 
    }
	
}
