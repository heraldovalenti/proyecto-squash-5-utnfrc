package sgt

import static org.junit.Assert.*

import org.junit.*

import sgt.exceptions.UnregisteredJugadorException

class JugadorServiceTests {

	def sqlLoaderService
	def jugadorService
	
    @Before
    void setUp() {
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
    }

    @After
    void tearDown() {
    }
	
	@Test
	void getDatosPersonalesTest() {
		Usuario heraldov = Usuario.get(1)
		Assert.assertNull(heraldov.persona)
		
		Persona p = jugadorService.getDatosPersonales(heraldov)
		Assert.assertNull(p)
		
		p = new Persona(nombre: "heraldo", apellido: "valenti", sexo: "Masculino", fechaNacimiento: new Date())
		p.save(failOnError: true, flush: true)
		heraldov.persona = p
		heraldov.save(failOnError: true, flush: true)
		Assert.assertNotNull(heraldov.persona)
		
		p = jugadorService.getDatosPersonales(heraldov)
		Assert.assertNotNull(p)
		Assert.assertEquals("heraldo", p.nombre)
		Assert.assertEquals("valenti", p.apellido)
	}
	
	@Test
	void saveDatosPersonalesTest() {
		Usuario brendam = Usuario.get(5)
		Assert.assertNull(brendam.persona)
		Assert.assertNull(brendam.jugador)
		
		Persona p = new Persona(nombre: "Brenda Ayelen", apellido: "Molinari", 
			sexo: "Femenino", fechaNacimiento: new Date())
		jugadorService.saveDatosPersonales(brendam,p)
		
		brendam = Usuario.get(5)
		Assert.assertNotNull(brendam.persona)
		Assert.assertEquals(brendam.persona.nombre, "Brenda Ayelen")
		Assert.assertEquals(brendam.persona.apellido, "Molinari")
		Assert.assertEquals(brendam.persona.sexo, "Femenino")
		Assert.assertNotNull(brendam.jugador)
		Assert.assertFalse(brendam.jugador.checkDatosCompletados())
	}
	
	@Test
	void getDatosJugadorTest() {
		Jugador j = null
		
		Usuario brendam = Usuario.get(5)
		brendam.jugador = new Jugador().save(failOnError: true, flush: true)
		j = jugadorService.getDatosJugador(brendam)
		Assert.assertNotNull(j)
		Assert.assertFalse(j.checkDatosCompletados())
		
		Usuario lucilav = Usuario.get(6)
		j = jugadorService.getDatosJugador(lucilav)
		Assert.assertNull(j)
		
		Usuario heraldov = Usuario.get(1)
		j = jugadorService.getDatosJugador(heraldov)
		Assert.assertNotNull(j)
		Assert.assertEquals(j.altura, 169.0, 0.1)		
	}
	
	@Test
	void saveDatosJugadorTest() {
		Usuario heraldov = Usuario.get(1)
		Persona p = new Persona(nombre: "Heraldo", apellido: "Valenti", 
			sexo: "Masculino", fechaNacimiento: new Date()).save(failOnError: true, flush: true)
		heraldov.persona = p
		heraldov.save(failOnError: true, flush: true)
		
		Jugador j = jugadorService.getDatosJugador(heraldov)
		Assert.assertNotNull(j)
		Assert.assertEquals("Derecho", j.brazo)
		j.brazo = "Ambidiestro"
		jugadorService.saveDatosJugador(heraldov, j, null)
		
		j = jugadorService.getDatosJugador(heraldov)
		Assert.assertNotNull(j)
		Assert.assertEquals("Ambidiestro", j.brazo)
	}
	
	@Test
	void getDomicilioTest() {
		Usuario heraldov = Usuario.get(1)
		Domicilio d = jugadorService.getDomicilio(heraldov)
		Assert.assertNull(d)
		
		Persona p = new Persona(nombre: "Heraldo", apellido: "Valenti", 
			sexo: "Masculino", fechaNacimiento: new Date()).save(failOnError: true, flush: true)
		d = new Domicilio(calle: "San Juan", numero: "19", piso: 12, departamento: "12A TIII",
			codigoPostal: 5000, provincia: "Cordoba", ciudad: "Cordoba").save(failOnError: true, flush: true)
		heraldov.persona = p
		heraldov.persona.domicilio = d
		heraldov.persona.save(failOnError: true, flush: true)
		heraldov.save(failOnError: true, flush: true)
		
		d = jugadorService.getDomicilio(heraldov)
		Assert.assertNotNull(d)
		Assert.assertEquals("San Juan", d.calle)
		Assert.assertEquals("19", d.numero)
	}
	
	@Test
	void saveDomicilioTest() {
		Usuario heraldov = Usuario.get(1)
		Persona p = new Persona(nombre: "Heraldo", apellido: "Valenti",
			sexo: "Masculino", fechaNacimiento: new Date()).save(failOnError: true, flush: true)
		heraldov.persona = p
		heraldov.persona.save(failOnError: true, flush: true)
		heraldov.save(failOnError: true, flush: true)
		
		Domicilio d = new Domicilio(calle: "San Juan", numero: "19", piso: 12, departamento: "12A TIII",
			codigoPostal: 5000, provincia: "Cordoba", ciudad: "Cordoba").save(failOnError: true, flush: true)
		jugadorService.saveDomicilio(heraldov, d)
		
		Assert.assertNotNull(heraldov.persona.domicilio)
		Assert.assertEquals("San Juan", heraldov.persona.domicilio.calle)
		Assert.assertEquals("19", heraldov.persona.domicilio.numero)
	}
}
