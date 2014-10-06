package sgt

import static org.junit.Assert.*
import org.junit.*

import sgt.exceptions.UnregisteredJugadorException;

class JugadorServiceTests {

	def sqlLoaderService
	def jugadorService
	
    @Before
    void setUp() {
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
    }

    @After
    void tearDown() {
    }

    @Test
    void getCategoriaJugadorTest() {
		CategoriaJugador categoriaJugador = jugadorService.getCategoriaJugador(1)
		Assert.assertNotNull(categoriaJugador)
		Assert.assertEquals("Asignada", categoriaJugador.estado)
		Assert.assertEquals("Primera", categoriaJugador.categoria.nombre)
    }
	
	@Test
	void getCategoriaJugadorFailTest() {
		Exception result = null
		try {
			CategoriaJugador categoriaJugador = jugadorService.getCategoriaJugador(10)
		} catch (e) {
			result = e
		}
		Assert.assertNotNull(result)
		Assert.assertEquals("UnregisteredJugadorException", result.getClass().getSimpleName())
		Assert.assertEquals(UnregisteredJugadorException.msg, result.getMessage())
	}
	
	@Test
	void getCategoriaJugadorNullTest() {
		Jugador heraldov = Jugador.get(1)
		CategoriaJugador categoriaHeraldov = CategoriaJugador.get(1)
		heraldov.removeFromCategoriasJugador(categoriaHeraldov)
		heraldov.save(failOnError: true, flush: true)
		
		CategoriaJugador categoriaJugador = jugadorService.getCategoriaJugador(1)
		Assert.assertNull(categoriaJugador)
	}
}
