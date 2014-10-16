package sgt

import org.junit.*

class JugadorTests {

	def sqlLoaderService
	
	@Before
    void setUp() {
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
    }

    @After
    void tearDown() {
		CategoriaJugador.deleteAll(CategoriaJugador.list())
    }
	
	@Test
    void checkDatosCompletadosTest() {
       Jugador j = new Jugador()
	   Assert.assertFalse(j.checkDatosCompletados())
	   
	   j = new Jugador(disponibilidad: new Disponibilidad())
	   Assert.assertFalse(j.checkDatosCompletados())
	   
	   j = new Jugador(brazo: "Derecho")
	   Assert.assertTrue(j.checkDatosCompletados())
    }
	
	@Test
	void getCategoriaActualTest() {
		Jugador heraldov = Jugador.get(1)
		Categoria categoriaHeraldov = heraldov.getCategoriaActual()
		Categoria primera = Categoria.get(1)
		Assert.assertEquals(primera, categoriaHeraldov)
	}
	
	@Test
	void getPosicionRankingCategoriaTest() {
		Jugador heraldov = Jugador.get(1)
		Categoria primera = Categoria.get(1)
		
		Assert.assertEquals(0, heraldov.getPosicionRankingCategoria(primera))
		
		Ranking rankingHeraldov = new Ranking(categoria: primera, jugador: heraldov, puesto: 10, puntaje: 1000)
			.save(failOnError: true, flush: true)
		
		Assert.assertEquals(10, heraldov.getPosicionRankingCategoria(primera))
	}
	
	@Test
	void isDisponibleTest() {
		Jugador heraldov = Jugador.get(1)
		Disponibilidad disponibilidad = new Disponibilidad(jugador: heraldov, fechaActualizacion: new Date())
		DetalleDisponibilidad detalle = new DetalleDisponibilidad(hora: 8, dia: "Lunes")
		disponibilidad.addToDetalles(detalle)
		disponibilidad.save(failOnError: true, flush: true)
		heraldov.disponibilidad = disponibilidad
		heraldov.save(failOnError: true, flush: true)
		
		Assert.assertTrue(heraldov.isDisponible("Lunes", 8))
		Assert.assertFalse(heraldov.isDisponible("Lunes", 9))
	}
}
