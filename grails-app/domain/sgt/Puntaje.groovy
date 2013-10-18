package sgt

class Puntaje {
	
	Categoria categoria
	
	static belongsTo = TorneoPuntuable
	
	static hasMany = [detalles: DetallePuntaje]

    static constraints = {
		
		categoria nullable:true;
    }
}
