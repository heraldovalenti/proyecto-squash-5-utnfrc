package sgt



import grails.test.mixin.*
import org.junit.*

import sgt.Rol;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Rol)
class RolTests {

    @Test
    void equalityTest() {
       Rol r1 = new Rol(nombre: "rol1")
	   Rol r2 = new Rol(nombre: "rol2")
	   Rol r3 = new Rol(nombre: "rol1")
	   
	   Assert.assertFalse(r1.equals(r2))
	   Assert.assertTrue(r1.equals(r3))
    }
}
