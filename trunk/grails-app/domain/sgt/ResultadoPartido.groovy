package sgt

import java.util.concurrent.ForkJoinPool;

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
