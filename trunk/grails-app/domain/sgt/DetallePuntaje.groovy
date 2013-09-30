package sgt

class DetallePuntaje {
	
	Integer puesto
	Double puntaje	
	String descripcion
	
	static belongsTo = Puntaje
	
	String toString()
	{
		return descripcion + " = " + puntaje + "pts"
	}
	

    static constraints = {
    }
}
