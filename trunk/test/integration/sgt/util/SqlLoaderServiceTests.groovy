package sgt.util

import static org.junit.Assert.*

import org.junit.*

import sgt.Categoria
import sgt.Usuario

class SqlLoaderServiceTests {

    @Before
    void setUp() {
    }

    @After
    void tearDown() {
    }

	def sqlLoaderService
	
    @Test
    void loadInsertFileTest() {
		def userCount = Usuario.count()
		Assert.assertEquals(0, userCount)
		
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		
		userCount = Usuario.count()
		Assert.assertEquals(27, userCount)
		def heraldov = Usuario.findByNombreUsuario("heraldov")
		Assert.assertNotNull(heraldov)
		Assert.assertEquals("heraldovalenti@gmail.com", heraldov.correo)
		
		def categoriaCount = Categoria.count()
		Assert.assertEquals(0, categoriaCount)
		
		sqlLoaderService.loadInsertFile("categorias.sql")
		
		categoriaCount = Categoria.count()
		Assert.assertEquals(14, categoriaCount)
    }
	
	@Test
	void testFiles() {
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
		sqlLoaderService.loadInsertFile("torneos.sql")
	}
}
