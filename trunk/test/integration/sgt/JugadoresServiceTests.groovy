package sgt

import static org.junit.Assert.*
import org.junit.*
import sgt.util.SqlLoaderService

class JugadoresServiceTests {

	def sqlLoaderService
	def jugadoresService
	
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
    void listarJugadoresPorCategoriaTest() {
		def results1 = jugadoresService.listarJugadoresPorCategoria("Primera",[a: "", b: ""])
		Assert.assertEquals(9, results1.size())
		
		def results2 = jugadoresService.listarJugadoresPorCategoria("Tercera",[a: "", b: ""])
		Assert.assertEquals(6, results2.size())
    }
}
