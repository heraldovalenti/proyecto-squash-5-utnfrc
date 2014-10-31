package sgt

class ResultadoPartido {

    Usuario ganador
   
	static belongsTo = [partido: Partido]
	static hasMany = [detalles: DetalleResultados]	
	
	String toString() {
		return detalles.toString()
	}

    static constraints = {
		ganador nullable: true
    }
}
