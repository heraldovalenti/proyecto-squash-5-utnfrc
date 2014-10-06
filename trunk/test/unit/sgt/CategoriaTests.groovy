package sgt



import grails.test.mixin.*
import org.junit.*

import sgt.Categoria;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Categoria)
class CategoriaTests {

	@Test
    void equalitytTest() {
       Categoria c1 = new Categoria(nombre: "Primera", modalidadCategoria: "Masculino")
	   Categoria c2 = new Categoria(nombre: "Segunda", modalidadCategoria: "Masculino")
	   Categoria c3 = new Categoria(nombre: "Primera", modalidadCategoria: "Femenino")
	   Categoria c4 = new Categoria(nombre: "Primera", modalidadCategoria: null)
	   Categoria c5 = new Categoria(nombre: null, modalidadCategoria: "Femenino")
       Categoria c6 = new Categoria(nombre: "Primera", modalidadCategoria: "Masculino")
	   Assert.assertFalse(c1.equals(c2))
	   Assert.assertFalse(c1.equals(c3))
	   Assert.assertFalse(c1.equals(c4))
	   Assert.assertFalse(c1.equals(c5))
	   Assert.assertTrue(c1.equals(c6))
    }
}
