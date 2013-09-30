package sgt

class Puntaje {
	
	Categoria categoria
	
	static belongsTo = TorneoPuntuable
	
	static hasMany = [detalles: DetallePuntaje]
	
	String toString()
	{
		return detallePuntaje.toString()
	}

    static constraints = {
    }
}
