package sgt

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DiagramacionServiceTests {
	
	static transactional = true
	
	def diagramacionService
	def sqlLoaderService
	
	@Before
	void setUp() {
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("torneos.sql")
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
		sqlLoaderService.loadInsertFile("rankings-jugadores.sql")
		sqlLoaderService.loadInsertFile("inscripciones-jugadores.sql")
	}

	@After	
	void tearDown() {
	}
	
	/** Se tienen 7 jugadores en la categoria primera del torneo, por lo tanto,
	 * se deberian generar 4 partidos, uno de ellos con un solo jugador.
	 * El orden de los partidos deberia ser de cuartos de final (3 rondas).
	 * Los rankings de los jugadores son: [1,2,3,4,5,6,7]; los cruces deberian ser:
	 * [1 - null] [2 - 7] [3 - 6] [4 - 5]
	 */
	@Test
	void generarPartidosPrimeraRonda_CategoriaPrimera_Test() {
		DetalleTorneo detallePrimera = DetalleTorneo.get(1)
		Torneo torneo = Torneo.get(7)
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		diagramacionService.generarPartidosPrimeraRonda(detallePrimera)
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(4, partidosTorneo.size())
		Collections.sort(partidosTorneo, new Comparator<Partido>() {
			@Override
			int compare(Partido p1, Partido p2) {
				int rankingPartido1 = p1.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				int rankingPartido2 = p2.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				return ( rankingPartido1 - rankingPartido2 )
			}
		})
		Assert.assertTrue(partidosTorneo[0].jugador2 == null)
		Assert.assertEquals(1, partidosTorneo[0].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(2, partidosTorneo[1].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(7, partidosTorneo[1].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(3, partidosTorneo[2].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(6, partidosTorneo[2].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(4, partidosTorneo[3].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(5, partidosTorneo[3].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(0, partidosTorneo[0].ordenPartido)
		Assert.assertEquals(1, partidosTorneo[1].ordenPartido)
		Assert.assertEquals(2, partidosTorneo[2].ordenPartido)
		Assert.assertEquals(3, partidosTorneo[3].ordenPartido)
		
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[0].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[1].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[2].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[3].categoria)
	}
	
	/** Se tienen 6 jugadores en la categoria primera del torneo, por lo tanto,
	 * se deberian generar 4 partidos, dos de ellos con un solo jugador.
	 * El orden de los partidos deberia ser de cuartos de final (3 rondas).
	 * Los rankings de los jugadores son: [1,2,3,4,5,6]; los cruces deberian ser:
	 * [1 - null] [2 - null] [3 - 6] [4 - 5]
	 */
	@Test
	void generarPartidosPrimeraRonda_CategoriaPrimera_Test2() {
		DetalleTorneo detallePrimera = DetalleTorneo.get(1)
		Torneo torneo = Torneo.get(7)
		InscripcionTorneo inscripcion7 = InscripcionTorneo.get(7)
		inscripcion7.delete()
		
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		
		diagramacionService.generarPartidosPrimeraRonda(detallePrimera)
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(4, partidosTorneo.size())
		Collections.sort(partidosTorneo, new Comparator<Partido>() {
			@Override
			int compare(Partido p1, Partido p2) {
				int rankingPartido1 = p1.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				int rankingPartido2 = p2.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				return ( rankingPartido1 - rankingPartido2 )
			}
		})
		Assert.assertTrue(partidosTorneo[0].jugador2 == null)
		Assert.assertEquals(1, partidosTorneo[0].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertTrue(partidosTorneo[1].jugador2 == null)
		Assert.assertEquals(2, partidosTorneo[1].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(3, partidosTorneo[2].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(6, partidosTorneo[2].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(4, partidosTorneo[3].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(5, partidosTorneo[3].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(0, partidosTorneo[0].ordenPartido)
		Assert.assertEquals(1, partidosTorneo[1].ordenPartido)
		Assert.assertEquals(2, partidosTorneo[2].ordenPartido)
		Assert.assertEquals(3, partidosTorneo[3].ordenPartido)
		
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[0].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[1].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[2].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[3].categoria)
	}
	
	/** Se tienen 6 jugadores en la categoria primera del torneo, por lo tanto,
	 * se deberian generar 4 partidos, dos de ellos con un solo jugador.
	 * El orden de los partidos deberia ser de cuartos de final (3 rondas).
	 * Los rankings de los jugadores son: [1,2,3,5,6,7]; los cruces deberian ser:
	 * [1 - null] [2 - null] [3 - 7] [5 - 6]
	 */
	@Test
	void generarPartidosPrimeraRonda_CategoriaPrimera_Test3() {
		DetalleTorneo detallePrimera = DetalleTorneo.get(1)
		Torneo torneo = Torneo.get(7)
		
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		
		diagramacionService.generarPartidosPrimeraRonda(detallePrimera)
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(4, partidosTorneo.size())
		Collections.sort(partidosTorneo, new Comparator<Partido>() {
			@Override
			int compare(Partido p1, Partido p2) {
				int rankingPartido1 = p1.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				int rankingPartido2 = p2.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				return ( rankingPartido1 - rankingPartido2 )
			}
		})
		Assert.assertTrue(partidosTorneo[0].jugador2 == null)
		Assert.assertEquals(1, partidosTorneo[0].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertTrue(partidosTorneo[1].jugador2 == null)
		Assert.assertEquals(2, partidosTorneo[1].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(3, partidosTorneo[2].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(7, partidosTorneo[2].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(5, partidosTorneo[3].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		Assert.assertEquals(6, partidosTorneo[3].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria))
		
		Assert.assertEquals(0, partidosTorneo[0].ordenPartido)
		Assert.assertEquals(1, partidosTorneo[1].ordenPartido)
		Assert.assertEquals(2, partidosTorneo[2].ordenPartido)
		Assert.assertEquals(3, partidosTorneo[3].ordenPartido)
		
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[0].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[1].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[2].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[3].categoria)
	}

}
