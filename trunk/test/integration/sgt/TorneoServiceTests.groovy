package sgt

import static org.junit.Assert.*
import org.junit.*

class TorneoServiceTests {

	static transactional = true	
	def torneoService
	
	@Test
	void testAbrirInscripcionesTorneo() {
		Date hoy = new Date()
		Date antes = new Date(hoy.getTime() - (1000 * 60 * 60 * 24))
		Torneo unTorneo = new Torneo(
				nombre: "Torneo 1",
				fechaAlta: antes,
				fechaInicioInscripcion: antes,
				fechaFinInscripcion: antes,
				fechaInicioTorneo: antes,
				fechaFinTorneo: antes,
				club: null,
				estado: "Creado",
				puntuable: false
				);
		unTorneo.save(failOnError: true)
		assertTrue(unTorneo.creado())
		torneoService.abrirInscripcionesTorneo()
		assertTrue(unTorneo.inscripcionAbierta())
	}
	
    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

}
