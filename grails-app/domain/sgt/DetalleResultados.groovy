package sgt

class DetalleResultados implements Comparable {
   
    Integer nroSet
	Integer jugador1
	Integer jugador2
	
	static belongsTo = [resultado: ResultadoPartido]

    static constraints = {
		jugador1 range: 0..20
		jugador2 range: 0..20
		nroSet range: 1..5
    }
	
	@Override
	public int compareTo(Object obj) {
		DetalleResultados other = obj
		return this.nroSet - other.nroSet
	}
    
	@Override
    String toString() { 
    	return nroSet + "  " + jugador1 + " - " + jugador2 
    }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DetalleResultados)) return false
		DetalleResultados other = obj
		return (this.nroSet == other.nroSet && this.resultado == other.resultado)
	}
	
	String setString() {
		if (this.nroSet == 1) return "1er Set"
		else if (this.nroSet == 2) return "2do Set"
		else if (this.nroSet == 3) return "3er Set"
		else if (this.nroSet == 4) return "4to Set"
		else return "5to Set"
	}
}
