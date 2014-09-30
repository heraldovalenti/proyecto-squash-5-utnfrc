package sgt

class ResultadoPartido {

    Jugador ganador;
   
	static belongsTo = [partido: Partido]
	static hasMany = [detalles: DetalleResultados]	
	
	
	String toString() {
		return detalles.toString()
	}
	

    static constraints = {
		ganador nullable: true;
    }
}
