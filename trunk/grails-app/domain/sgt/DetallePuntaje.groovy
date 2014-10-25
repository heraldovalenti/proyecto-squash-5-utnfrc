package sgt

class DetallePuntaje {
	
	Integer puesto
	Double puntos	
	
	static belongsTo = [puntaje: Puntaje]
	
	String toString()
	{
		return puesto + " : " + puntos + "pts"
	}
	

    static constraints = {
		puesto min: 0
		puntos: min: 0
    }
}
