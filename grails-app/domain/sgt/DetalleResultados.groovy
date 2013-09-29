package sgt

class DetalleResultados {
   
    String set;
	Integer jugador1;
	Integer jugador2;
	
	static belongsTo = ResultadoPartido
	
	String toString(){return set + "  " + jugador1 + " - " + jugador2}
	

    static constraints = {
					
		jugador1 range: 0..20, validator: { val, obj -> Math.abs(obj.jugador1 - obj.jugador2) > 1 && Math.abs(obj.jugador1 - obj.jugador2) < 3 }
		jugador2 range: 0..20, validator: { val, obj -> Math.abs(obj.jugador1 - obj.jugador2) > 1 && Math.abs(obj.jugador1 - obj.jugador2) < 3 }
		set inList:["1er SET","2do SET","3er SET","4to SET","5to SET"]		
    }
}
