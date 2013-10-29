package sistemagestiontorneo

import static org.junit.Assert.*
import org.junit.*
import sgt.PartidoController
import sgt.UsuarioController

class SgtTests extends GroovyTestCase {

	def sessionFactory
	
    @Before
    void setUp() {
		super.setUp()		
		sessionFactory.currentSession.flush()
		sessionFactory.currentSession.clear()
		
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testLogin() {
		def controller = new UsuarioController();        
        controller.login()
        assert true
    }
}
