package sgt

class DetallePuntaje {
	
	Integer puesto
	Double puntos	
	String descripcion
	
	static belongsTo = [puntaje: Puntaje]
	
	String toString()
	{
		return descripcion + " = " + puntos + "pts"
	}
	

    static constraints = {
		descripcion blank: false, maxSize: 50
    }
}
