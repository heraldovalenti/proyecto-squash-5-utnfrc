package sgt

import static org.junit.Assert.*
import org.junit.*

class CanchaTests {

	def sqlLoaderService
	
	@Before
	void setUp() {
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		Club c = new Club(nombre: "club_nombre", validado: false).save(failOnError: true, flush: true)
		new Cancha(nombre: "c1", techada: true, numero: 1, tipoSuelo: "Parquet", club: c).save(failOnError: true, flush: true)
		new Cancha(nombre: "c2", techada: true, numero: 2, tipoSuelo: "Parquet", club: c).save(failOnError: true, flush: true)		
	}
	
	@Test
    void testEquality() {
		Cancha c1 = Cancha.findByNombre("c1")
		Cancha c2 = Cancha.findByNombre("c2")
		Cancha c3 = Cancha.findByNombre("c2")
		
		Assert.assertNotNull(c1)
		Assert.assertNotNull(c2)
		Assert.assertNotNull(c3)
		Assert.assertFalse(c1.equals(c2))
		Assert.assertTrue(c2.equals(c3))
	}
}