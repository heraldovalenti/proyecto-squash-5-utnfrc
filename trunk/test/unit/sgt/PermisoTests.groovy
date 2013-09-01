package sgt

import grails.test.mixin.*
import org.junit.*

import sgt.Permiso;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Permiso)
class PermisoTests {

    def testSetterNombre(){
		def permiso = new Permiso()
		def n ="Marcos"
		permiso.nombre=n
		assert permiso.nombre.equals(n)
	}
	
}
