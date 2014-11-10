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
		sqlLoaderService.loadInsertFile("clubes.sql")
	}

	@After	
	void tearDown() {
		Partido.executeUpdate("delete from Partido")
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
		
		InscripcionTorneo inscripcion4 = InscripcionTorneo.get(4)
		inscripcion4.delete()
		
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
		def expected = [1,null,2,null,3,7,5,6]
		def j1 = (partidosTorneo[0].jugador1) ? partidosTorneo[0].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j2 = (partidosTorneo[0].jugador2) ? partidosTorneo[0].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j3 = (partidosTorneo[1].jugador1) ? partidosTorneo[1].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j4 = (partidosTorneo[1].jugador2) ? partidosTorneo[1].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j5 = (partidosTorneo[2].jugador1) ? partidosTorneo[2].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j6 = (partidosTorneo[2].jugador2) ? partidosTorneo[2].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j7 = (partidosTorneo[3].jugador1) ? partidosTorneo[3].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j8 = (partidosTorneo[3].jugador2) ? partidosTorneo[3].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def actual = [j1,j2,j3,j4,j5,j6,j7,j8]
		Assert.assertEquals(expected, actual)
		
		Assert.assertEquals(0, partidosTorneo[0].ordenPartido)
		Assert.assertEquals(1, partidosTorneo[1].ordenPartido)
		Assert.assertEquals(2, partidosTorneo[2].ordenPartido)
		Assert.assertEquals(3, partidosTorneo[3].ordenPartido)
		
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[0].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[1].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[2].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[3].categoria)
	}
	
	/** Se tienen 7 jugadores en la categoria segunda del torneo, por lo tanto,
	 * se deberian generar 4 partidos, uno de ellos con un solo jugador.
	 * El orden de los partidos deberia ser de cuartos de final (3 rondas).
	 * Los rankings de los jugadores son: [1,2,3,4] y 3 no rankeados. 
	 * Los cruces deberian ser: [1 - null] [2 - 0] [3 - 0] [4 - 0]
	 */
	@Test
	void generarPartidosPrimeraRonda_CategoriaSegunda_Test() {
		DetalleTorneo detallePrimera = DetalleTorneo.get(2)
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
		def expected = [1,null,2,0,3,0,4,0]
		def j1 = (partidosTorneo[0].jugador1) ? partidosTorneo[0].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j2 = (partidosTorneo[0].jugador2) ? partidosTorneo[0].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j3 = (partidosTorneo[1].jugador1) ? partidosTorneo[1].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j4 = (partidosTorneo[1].jugador2) ? partidosTorneo[1].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j5 = (partidosTorneo[2].jugador1) ? partidosTorneo[2].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j6 = (partidosTorneo[2].jugador2) ? partidosTorneo[2].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j7 = (partidosTorneo[3].jugador1) ? partidosTorneo[3].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j8 = (partidosTorneo[3].jugador2) ? partidosTorneo[3].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def actual = [j1,j2,j3,j4,j5,j6,j7,j8]
		Assert.assertEquals(expected, actual)
		
		Assert.assertEquals(0, partidosTorneo[0].ordenPartido)
		Assert.assertEquals(1, partidosTorneo[1].ordenPartido)
		Assert.assertEquals(2, partidosTorneo[2].ordenPartido)
		Assert.assertEquals(3, partidosTorneo[3].ordenPartido)
		
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[0].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[1].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[2].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[3].categoria)
	}
	
	/** Se tienen 12 jugadores en la categoria tercera del torneo, por lo tanto,
	 * se deberian generar 8 partidos, cuatro de ellos con un solo jugador.
	 * El orden de los partidos deberia ser de octavos de final (4 rondas).
	 * Los rankings de los jugadores son: [1,2,3,4,5,6,19,20] y 4 no rankeados.
	 * Los cruces deberian ser: [1 - null] [2 - null] [3 - null] [4 - null] [5 - 0] [6 - 0] [19 - 0] [20 - 0]
	 */
	@Test
	void generarPartidosPrimeraRonda_CategoriaTercera_Test() {
		DetalleTorneo detallePrimera = DetalleTorneo.get(3)
		Torneo torneo = Torneo.get(7)
		
		def partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(0, partidosTorneo.size())
		
		
		diagramacionService.generarPartidosPrimeraRonda(detallePrimera)
		partidosTorneo = Partido.findAllByTorneo(torneo)
		Assert.assertEquals(8, partidosTorneo.size())
		Collections.sort(partidosTorneo, new Comparator<Partido>() {
			@Override
			int compare(Partido p1, Partido p2) {
				int rankingPartido1 = p1.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				int rankingPartido2 = p2.jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria)
				return ( rankingPartido1 - rankingPartido2 )
			}
		})
		def expected = [1,null,2,null,3,null,4,null,5,0,6,0,19,0,20,0]
		def j1 = (partidosTorneo[0].jugador1) ? partidosTorneo[0].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j2 = (partidosTorneo[0].jugador2) ? partidosTorneo[0].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j3 = (partidosTorneo[1].jugador1) ? partidosTorneo[1].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j4 = (partidosTorneo[1].jugador2) ? partidosTorneo[1].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j5 = (partidosTorneo[2].jugador1) ? partidosTorneo[2].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j6 = (partidosTorneo[2].jugador2) ? partidosTorneo[2].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j7 = (partidosTorneo[3].jugador1) ? partidosTorneo[3].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j8 = (partidosTorneo[3].jugador2) ? partidosTorneo[3].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j9 = (partidosTorneo[4].jugador1) ? partidosTorneo[4].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j10 = (partidosTorneo[4].jugador2) ? partidosTorneo[4].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j11 = (partidosTorneo[5].jugador1) ? partidosTorneo[5].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j12 = (partidosTorneo[5].jugador2) ? partidosTorneo[5].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j13 = (partidosTorneo[6].jugador1) ? partidosTorneo[6].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j14 = (partidosTorneo[6].jugador2) ? partidosTorneo[6].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j15 = (partidosTorneo[7].jugador1) ? partidosTorneo[7].jugador1.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def j16 = (partidosTorneo[7].jugador2) ? partidosTorneo[7].jugador2.jugador.getPosicionRankingCategoria(detallePrimera.categoria) : null
		def actual = [j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14,j15,j16]
		Assert.assertEquals(expected, actual)
		
		Assert.assertEquals(0, partidosTorneo[0].ordenPartido)
		Assert.assertEquals(1, partidosTorneo[1].ordenPartido)
		Assert.assertEquals(2, partidosTorneo[2].ordenPartido)
		Assert.assertEquals(3, partidosTorneo[3].ordenPartido)
		Assert.assertEquals(4, partidosTorneo[4].ordenPartido)
		Assert.assertEquals(5, partidosTorneo[5].ordenPartido)
		Assert.assertEquals(6, partidosTorneo[6].ordenPartido)
		Assert.assertEquals(7, partidosTorneo[7].ordenPartido)
		
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[0].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[1].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[2].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[3].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[4].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[5].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[6].categoria)
		Assert.assertEquals(detallePrimera.categoria, partidosTorneo[7].categoria)
	}
	
	@Test
	void generarRondasSiguientesTest() {
		DetalleTorneo d = DetalleTorneo.get(1)
		Torneo t = d.torneo
		Categoria c = d.categoria
		String e = "Creado"
		Assert.assertEquals(0, Partido.findAllByTorneo(t).size())
		Partido p1 = new Partido(categoria: c, torneo: t, estado: e, ordenPartido: 0).save(failOnError: true)
		Partido p2 = new Partido(categoria: c, torneo: t, estado: e, ordenPartido: 1).save(failOnError: true)
		Partido p3 = new Partido(categoria: c, torneo: t, estado: e, ordenPartido: 2).save(failOnError: true)
		Partido p4 = new Partido(categoria: c, torneo: t, estado: e, ordenPartido: 3).save(failOnError: true)
		Assert.assertEquals(4, Partido.findAllByTorneo(t).size())
		diagramacionService.generarRondasSiguientes(d)
		List<Partido> partidos = Partido.findAllByTorneo(t)
		Assert.assertEquals(7, partidos.size())
		Collections.sort(partidos, new Comparator<Partido>() {
			@Override
			int compare(Partido obj1, Partido obj2) {
				return obj1.ordenPartido - obj2.ordenPartido	
			}
		})
		List<Integer> ordenes = new ArrayList<Integer>()
		for (p in partidos) {
			ordenes.add(p.ordenPartido)
		}
		def expected = [0,1,2,3,4,5,6]
		Assert.assertEquals(expected, ordenes)
	}
}
