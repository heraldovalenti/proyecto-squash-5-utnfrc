package sgt

class DetallePuntaje {
	
	Integer puesto
	Double puntaje
	String descripcion
	
	static belongsTo = Puntaje

    static constraints = {
    }
}
