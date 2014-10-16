package sgt

import java.util.Scanner;



class DiagramacionService {
	
		
	/*
     * Calcula la cantidad de Rondas a jugar en  base a la cantidad de Jugadores Inscriptos
     */
    int calcularRondas(){
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
	 * Ordena Jugadores con su posicion
	 */
	Jugador[] ordenarJugadores(Jugador[] jugadores,Categoria categoria){
		Jugador aux;
		for (int i = 0; i < jugadores.length - 1; i++) {
			for (int x = i + 1; x < jugadores.length; x++) {
				if (jugadores[x].getPosicionRankingCategoria(categoria) < jugadores[i].getPosicionRankingCategoria(categoria)) {
					aux = jugadores[i];
					jugadores[i] = jugadores[x];
					jugadores[x] = aux;
				}
			}
		}
		return jugadores
	}

}
