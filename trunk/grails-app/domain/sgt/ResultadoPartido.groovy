package sgt

import java.util.concurrent.ForkJoinPool;

class ResultadoPartido {

    Usuario ganador	
   
	static belongsTo = [partido: Partido]
	static hasMany = [detalles: DetalleResultados]	
	
	int resultadoJugador1() {
		int res = 0
		for (d in detalles) {
			if (d.jugador1 > d.jugador2) res++
		}
		return res
	}
	
	int resultadoJugador2() {
		int res = 0
		for (d in detalles) {
			if (d.jugador2 > d.jugador1) res++
		}
		return res
	}
	
	String toString() {
		return detalles.toString()
	}

    static constraints = {
		ganador nullable: true
    }
	
	def calcularSets(){
		
		def resultados=[]
		
		int setJugador1=0
		int setJugador2=0		
		
		if(this.detalles==null){
			
			resultados.add(null)
			resultados.add(null)
			
		}
		else{
		
		for (DetalleResultados d : this.detalles){		
			if(d.jugador1 > d.jugador2){
				setJugador1 ++;
			}
			else
			setJugador2 ++;
			
		}
		
		resultados.add(setJugador1)
		resultados.add(setJugador2)
		}
		
		return resultados
	}
}
