package sgt



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Jugador)
class JugadorTests {

	@Test
    void checkDatosCompletadosTest() {
       Jugador j = new Jugador()
	   Assert.assertFalse(j.checkDatosCompletados())
	   
	   j = new Jugador(disponibilidad: new Disponibilidad())
	   Assert.assertFalse(j.checkDatosCompletados())
	   
	   j = new Jugador(brazo: "Derecho")
	   Assert.assertTrue(j.checkDatosCompletados())
    }
}
