package sgt

import static org.junit.Assert.*

import org.junit.*
import org.springframework.transaction.annotation.Transactional

class ServicioClubServiceTests {
	
	def servicioClubService
	
    @Before
    void setUp() {
		Club c = new Club(nombre: "nuevo_club",validado: false).save(failOnError: true)
    }

    @After
    void tearDown() {
    }

	@Test
	void serviciosDisponiblesTest() {
		Club c = Club.findByNombre("nuevo_club")
		ServicioClub s1 = new ServicioClub(nombre: "Cantina").save(failOnError: true, flush: true)
		ServicioClub s2 = new ServicioClub(nombre: "Sanitarios").save(failOnError: true, flush: true)
		c.addToServicios(s1)
		c.addToServicios(s2)
		c.save(flush: true)
		
		Set serviciosDisponibles = servicioClubService.serviciosDisponibles(c)
		Assert.assertFalse(serviciosDisponibles.contains("Cantina"))
		Assert.assertFalse(serviciosDisponibles.contains("Sanitarios"))
		Assert.assertTrue(serviciosDisponibles.contains("Estacionamiento"))
		Assert.assertTrue(serviciosDisponibles.contains("Kiosko"))
	}
	
	@Test
	void agregarServicioTest() {
		Club c = Club.findByNombre("nuevo_club")
		ServicioClub s1 = new ServicioClub(nombre: "Cantina")
		
		servicioClubService.agregarServicioClub(c,s1)
		
		def serviciosClub = c.servicios
		Assert.assertTrue(serviciosClub.contains(s1))
	}
	
	@Test
	void quitarServicioTest() {
		Club c = Club.findByNombre("nuevo_club")
		ServicioClub s1 = new ServicioClub(nombre: "Cantina")
		s1.save(failOnError: true, flush: true)
		c.addToServicios(s1)
		c.save(failOnError: true, flush: true)
		def serviciosClub = c.servicios
		Assert.assertTrue(serviciosClub.contains(s1))		
		
		servicioClubService.quitarServicioClub(c,s1)
		
		Assert.assertFalse(serviciosClub.contains(s1))
	}
}