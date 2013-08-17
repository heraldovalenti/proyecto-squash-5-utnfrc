package modelo

class Disponibilidad {
	
	Date fechaActualizacion
	
	static hasMany = [detalles: DetalleDisponibilidad]

    static constraints = {
		
    }
}
