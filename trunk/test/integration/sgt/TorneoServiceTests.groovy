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

	@Test
	void testListaTorneos() {
		Calendar c = Calendar.getInstance()
		def year = c.get(Calendar.YEAR)
		Date hoy = c.getTime()
		c.add(Calendar.YEAR, -1)
		Date pastYear = c.getTime()
		Torneo torneo1 = new Torneo(
				nombre: "Torneo 1",
				fechaAlta: hoy,
				fechaInicioInscripcion: hoy,
				fechaFinInscripcion: hoy,
				fechaInicioTorneo: hoy,
				fechaFinTorneo: hoy,
				club: null,
				estado: "Inscripcion Abierta",
				puntuable: false
				);
		Torneo torneo2 = new Torneo(
				nombre: "Torneo 2",
				fechaAlta: hoy,
				fechaInicioInscripcion: hoy,
				fechaFinInscripcion: hoy,
				fechaInicioTorneo: hoy,
				fechaFinTorneo: hoy,
				club: null,
				estado: "Inscripcion Abierta",
				puntuable: false
				);
		Torneo torneo3 = new Torneo(
				nombre: "Torneo 3",
				fechaAlta: pastYear,
				fechaInicioInscripcion: pastYear,
				fechaFinInscripcion: pastYear,
				fechaInicioTorneo: pastYear,
				fechaFinTorneo: pastYear,
				club: null,
				estado: "Inscripcion Abierta",
				puntuable: false
				);
		torneo1.save(failOnError: true)
		torneo2.save(failOnError: true)
		torneo3.save(failOnError: true)
		
		def results = torneoService.listaTorneos(year)
		assertEquals(2, results.size())
		
		results = torneoService.listaTorneos(year - 1)
		assertEquals(1, results.size())
		
		results = torneoService.listaTorneos(year - 2)
		assertEquals(0, results.size())
		
		results = torneoService.listaTorneos(year + 1)
		assertEquals(0, results.size())
	}

	@Before
	void setUp() {
	}

	@After
	void tearDown() {
	}
}
