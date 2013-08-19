package sgt

class Disponibilidad {
	
	Date fechaActualizacion
	
	static hasMany = [detalles: DetalleDisponibilidad]

    static constraints = {
		fechaActualizacion nullable:true 
    }
}
