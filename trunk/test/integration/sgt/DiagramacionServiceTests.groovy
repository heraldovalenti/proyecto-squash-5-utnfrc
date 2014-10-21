package sgt

import logica.CalculosTorneo

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DiagramacionServiceTests {
	
	def diagramacionService
	def sqlLoaderService
	
	@Before
	void setUp() {
	}

	@After	
	void tearDown() {
	}
	
	@Test
	void calcularRondasTest() {
		//para una cantidad de jugadores de 8, se esperan jugar 3 rondas: final, semis y cuartos
		Jugador[] jugadores = new Jugador[8]
		int cantidadRondas = diagramacionService.calcularRondas(jugadores)
		Assert.assertEquals(3, cantidadRondas)
		
		//para una cantidad de jugadores de 10, se esperan jugar 4 rondas: final, semis,
		//cuartos y una instancia de octavos
		jugadores = new Jugador[10]
		cantidadRondas = diagramacionService.calcularRondas(jugadores)
		Assert.assertEquals(4, cantidadRondas)
		
		//para una cantidad de jugadores de 7, se esperan jugar 3 rondas: final, semis, 
		//y 3 instancias de cuartos y un pase directo a semis
		jugadores = new Jugador[7]
		cantidadRondas = diagramacionService.calcularRondas(jugadores)
		Assert.assertEquals(3, cantidadRondas)
		
		//para 30 jugadores, espero jugar 5 rondas: 15 rondas en 16avos, 8vos, cuartos, semis y final
		jugadores = new Jugador[30]
		cantidadRondas = diagramacionService.calcularRondas(jugadores)
		Assert.assertEquals(5, cantidadRondas)
	}
	
	/**
	 * El mismo test pero usando la clase CalculosTorneo
	 */
	@Test
	void calcularRondasTest2() {
		//para una cantidad de jugadores de 8, se esperan jugar 3 rondas: final, semis y cuartos
		CalculosTorneo.jugadores = new Jugador[8]
		CalculosTorneo.calcularRondas()
		Assert.assertEquals(3, CalculosTorneo.cantRondas)
		
		//para una cantidad de jugadores de 10, se esperan jugar 4 rondas: final, semis,
		//cuartos y una instancia de octavos
		CalculosTorneo.jugadores = new Jugador[10]
		CalculosTorneo.calcularRondas()
		Assert.assertEquals(4, CalculosTorneo.cantRondas)
		
		//para una cantidad de jugadores de 7, se esperan jugar 3 rondas: final, semis,
		//y 3 instancias de cuartos y un pase directo a semis
		CalculosTorneo.jugadores = new Jugador[7]
		CalculosTorneo.calcularRondas()
		Assert.assertEquals(3, CalculosTorneo.cantRondas)
		
		//para 30 jugadores, espero jugar 5 rondas: 15 rondas en 16avos, 8vos, cuartos, semis y final
		CalculosTorneo.jugadores = new Jugador[30]
		CalculosTorneo.calcularRondas()
		Assert.assertEquals(5, CalculosTorneo.cantRondas)
	}
	
	@Test
	void ordenarJugadoresTest() {
		Categoria c = new Categoria(nombre: "1", modalidadCategoria: "Masculino", descripcion: "wtf").save(failOnError: true,flush: true)
		
		Jugador j1 = new Jugador()
		Ranking r1 = new Ranking(categoria: c, puntaje: 1000, puesto: 1)
		j1.addToRankings(r1)
		j1.save(failOnError: true, flush: true)
		
		Jugador j2 = new Jugador()
		Ranking r2 = new Ranking(categoria: c, puntaje: 900, puesto: 2)
		j2.addToRankings(r2)
		j2.save(failOnError: true, flush: true)
		
		Jugador j3 = new Jugador()
		Ranking r3 = new Ranking(categoria: c, puntaje: 800, puesto: 3)
		j3.addToRankings(r3)
		j3.save(failOnError: true, flush: true)
		
		Jugador j4 = new Jugador()
		Ranking r4 = new Ranking(categoria: c, puntaje: 700, puesto: 4)
		j4.addToRankings(r4)
		j4.save(failOnError: true, flush: true)
		
		Jugador[] jugadores = [j2, j3, j1, j4]
		
		jugadores = diagramacionService.ordenarJugadores(jugadores, c)
		
		//el jugador numero 1 deberia estar en la posicion [0]
		Assert.assertEquals(j1, jugadores[0])
		//el jugador numero 2 deberia estar en la posicion [1]
		Assert.assertEquals(j2, jugadores[1])
		//el jugador numero 3 deberia estar en la posicion [2]
		Assert.assertEquals(j3, jugadores[2])
		//el jugador numero 4 deberia estar en la posicion [3]
		Assert.assertEquals(j4, jugadores[3])
	}

}
