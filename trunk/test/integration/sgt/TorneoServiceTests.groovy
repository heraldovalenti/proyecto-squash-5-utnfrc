package sgt

import static org.junit.Assert.*
import org.junit.*

class TorneoServiceTests {

	static transactional = true	
	def torneoService
	
	@Test
	void testAbrirInscripcionesTorneo() {
		Date hoy = new Date()
		Date aperturaInscripcion = new Date(hoy.getTime() - (1000 * 60 * 60 * 24)) //la fecha de hoy MENOS un dia
		Date clausuraInscripcion = new Date(hoy.getTime() + (1000 * 60 * 60 * 24)) //la fecha de hoy MAS un dia
		Torneo unTorneo = new Torneo(
				nombre: "Torneo 1",
				fechaAlta: hoy,
				fechaInicioInscripcion: aperturaInscripcion,
				fechaFinInscripcion: clausuraInscripcion,
				fechaInicioTorneo: hoy,
				fechaFinTorneo: hoy,
				club: null,
				estado: "Creado",
				puntuable: false
				);
		unTorneo.save(failOnError: true)
		assertTrue(unTorneo.creado())
		torneoService.actualizarEstados()
		assertTrue(unTorneo.inscripcionAbierta())
	}
	
	@Test
	void testCerrarInscripcionesTorneo() {
		Date hoy = new Date()
		Date clausuraInscripcion = new Date(hoy.getTime() - (1000 * 60 * 60 * 24)) //la fecha de hoy MENOS un dia
		Torneo unTorneo = new Torneo(
				nombre: "Torneo 1",
				fechaAlta: hoy,
				fechaInicioInscripcion: hoy,
				fechaFinInscripcion: clausuraInscripcion,
				fechaInicioTorneo: hoy,
				fechaFinTorneo: hoy,
				club: null,
				estado: "Inscripcion Abierta",
				puntuable: false
				);
		unTorneo.save(failOnError: true)
		assertTrue(unTorneo.inscripcionAbierta())
		torneoService.actualizarEstados()
		assertTrue(unTorneo.inscripcionCerrada())
	}
	
	@Test
	void testTorneoCreadoPeroInscripcionNoParaAbrirTodavia() {
		Date hoy = new Date()
		Date aperturaInscripcion = new Date(hoy.getTime() + (1000 * 60 * 60 * 24)) //la fecha de hoy MAS un dia
		Torneo unTorneo = new Torneo(
				nombre: "Torneo 1",
				fechaAlta: hoy,
				fechaInicioInscripcion: aperturaInscripcion,
				fechaFinInscripcion: hoy,
				fechaInicioTorneo: hoy,
				fechaFinTorneo: hoy,
				club: null,
				estado: "Creado",
				puntuable: false
				);
		unTorneo.save(failOnError: true)
		assertTrue(unTorneo.creado())
		torneoService.actualizarEstados()
		assertTrue(unTorneo.creado())
	}
	
	@Test
	void testTorneoInscripcionAbiertaPeroInscripcionNoParaCerrarTodavia() {
		Date hoy = new Date()
		Date clausuraInscripcion = new Date(hoy.getTime() + (1000 * 60 * 60 * 24)) //la fecha de hoy MAS un dia
		Torneo unTorneo = new Torneo(
				nombre: "Torneo 1",
				fechaAlta: hoy,
				fechaInicioInscripcion: hoy,
				fechaFinInscripcion: clausuraInscripcion,
				fechaInicioTorneo: hoy,
				fechaFinTorneo: hoy,
				club: null,
				estado: "Inscripcion Abierta",
				puntuable: false
				);
		unTorneo.save(failOnError: true)
		assertTrue(unTorneo.inscripcionAbierta())
		torneoService.actualizarEstados()
		assertTrue(unTorneo.inscripcionAbierta())
	}
	
    @Before
    void setUp() {
        
    }

    @After
    void tearDown() {
        
    }

}
