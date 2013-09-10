package sgt

class ResultadosPartido {

   Persona ganador;
   
	static hasMany = [detalles: DetalleResultados]
	
	String toString() {
		return detalleResultados.toString()
	}
	

    static constraints = {
		
		ganador blank:false;
    }
}
