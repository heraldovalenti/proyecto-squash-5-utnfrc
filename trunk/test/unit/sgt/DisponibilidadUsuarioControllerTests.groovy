package sgt



import grails.test.mixin.*
import org.junit.*

@TestFor(DisponibilidadUsuarioController)
class DisponibilidadUsuarioControllerTests {
	
	

  void testIndex() {
        controller.index()
        assert "/disponibilidadUsuario/show" == response.redirectedUrl
    }
}
