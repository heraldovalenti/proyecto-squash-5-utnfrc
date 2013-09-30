package sgt

class ResultadoPartido {

    Persona ganador;
   
	static hasMany = [detalles: DetalleResultados]	
	
	
	String toString() {
		return detalleResultados.toString()
	}
	

    static constraints = {
		
		ganador nullable: true;
    }
}
