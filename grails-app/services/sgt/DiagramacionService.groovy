package sgt

import java.util.Scanner;

class DiagramacionService {
	
		
	/*
     * Calcula la cantidad de Rondas a jugar en  base a la cantidad de Jugadores Inscriptos
     */
    int calcularRondas(Jugador[] jugadores){
        double cantJug=jugadores.length
		int cantRondas=0
        while(cantJug>1)
        {
            cantRondas++
            cantJug=cantJug/2      
        }
		return cantRondas            
    }
	
	/*
	 * Rellena con Jugadores vacios
	 */
	Jugador [] generarJugadoresVacios(Jugador[] jugadores1,Categoria categoria){
		Jugador [] jugadoresDestino;
		Jugador [] jugadores=this.ordenarJugadores(jugadores1, categoria)
		int maxJugPriRonda= (int)Math.pow(2, calcularRondas(jugadores1));
		jugadoresDestino=new Jugador[maxJugPriRonda];
		int maxPos=0;
		for (int i=0;i<jugadores.length;i++)
		{
			jugadoresDestino[i] = jugadores[i];
			if(jugadores[i].getPosicionRankingCategoria(categoria)()>=maxPos){
				maxPos=jugadores[i].getPosicionRankingCategoria(categoria)+2;
			}
		}
		
		for (int i=jugadores.length;i<jugadoresDestino.length;i++)
		{
			
			jugadoresDestino[i]=new Jugador(maxPos);
			jugadoresDestino[i].setVacio(true);
			maxPos++;
		}
		return jugadoresDestino;
	}
	
	
	
	/*
	 * Ordena Jugadores con su posicion
	 */
	Jugador[] ordenarJugadores(Jugador[] jugadores,Categoria categoria){
		Jugador aux;
		for (int i = 0; i < jugadores.length - 1; i++) {
			for (int x = i + 1; x < jugadores.length; x++) {
				if (jugadores[x].getPosicionRankingCategoria(categoria) == 0) {
					aux = jugadores[i];
					jugadores[i] = jugadores[x];
					jugadores[x] = aux;
				}
			    else if (jugadores[x].getPosicionRankingCategoria(categoria) < jugadores[i].getPosicionRankingCategoria(categoria)) {
					aux = jugadores[i];
					jugadores[i] = jugadores[x];
					jugadores[x] = aux;
				}
			}
		}
		return jugadores
	}
	
	/*
	 * Cruza Jugadores con su posicion
	 */
	Partido [] cruzarJugadores(Jugador[] jugadores1,Categoria categoria){
		int maxJugPriRonda= (int)Math.pow(2, calcularRondas(jugadores1));
		int cantPart=maxJugPriRonda/2;
		Partido [] partidosPrimeraRonda=new Partido[cantPart];
		Jugador [] jugadores= this.generarJugadoresVacios(jugadores1, categoria)
		for (int i=0;i<partidosPrimeraRonda.length;i++)
		{
			partidosPrimeraRonda[i]=new Partido(jugadores[i],jugadores[jugadores.length-i-1]);
		}
		return partidosPrimeraRonda
	}

}
