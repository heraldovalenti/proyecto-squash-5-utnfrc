package modelo

class Cancha {

    Float ancho
	Float largo
    Boolean techada
    String tipoSuelo
    String paredes

	static belongsTo = Club	
		
	String toString()
	{
		return ancho +" x "+ largo
	}
    static constraints = {
		ancho blank:false, min: 0.0f
		largo blank:false, min: 0.0f
    }
}
