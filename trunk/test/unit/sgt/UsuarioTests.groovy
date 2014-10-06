package sgt



import grails.test.mixin.*
import org.junit.*

import sgt.Usuario;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Usuario)
class UsuarioTests {

	@Test
    void equalityTest() {
       Usuario u1 = new Usuario(nombreUsuario: "heraldov")
	   Usuario u2 = new Usuario(nombreUsuario: "brendam")
	   Usuario u3 = new Usuario(nombreUsuario: "heraldov")
	   
	   Assert.assertFalse(u1.equals(u2))
	   Assert.assertTrue(u1.equals(u3))
    }
}
