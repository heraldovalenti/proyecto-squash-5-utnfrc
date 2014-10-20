package sgt



import grails.test.mixin.*
import org.junit.*

import sgt.Club;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Club)
class ClubTests {
	
	@Before
	void setUp() {
	}
	
	@Test
	void cantidadCanchasTest() {
		Club clubConCanchas = new Club(nombre: "club_nombre", validado: false)
		Cancha c1 = new Cancha(nombre: "c1", techada: true, numero: 1, tipoSuelo: "Parquet")
		Cancha c2 = new Cancha(nombre: "c2", techada: true, numero: 2, tipoSuelo: "Parquet")
		clubConCanchas.addToCanchas(c1)
		clubConCanchas.addToCanchas(c2)
		Assert.assertEquals(2, clubConCanchas.cantidadCanchas())
		
		Club clubSinCanchas = new Club(nombre: "club_sin_canchas", validado: false).save(failOnError: true, flush: true)
		Assert.assertEquals(0, clubSinCanchas.cantidadCanchas())
		
	}
}
