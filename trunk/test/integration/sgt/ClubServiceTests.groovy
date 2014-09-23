package sgt

import static org.junit.Assert.*

import org.junit.*
import org.springframework.transaction.annotation.Transactional

class ClubServiceTests {
	
	def clubService
	
    @Before
    void setUp() {
		Rol clubRol = new Rol(nombre: "Club").save(failOnError: true)
		Rol encargadoRol = new Rol(nombre: "Encargado club").save(failOnError: true)
		Rol jugadorRol = new Rol(nombre: "Jugador").save(failOnError: true)
    	Usuario u1 = new Usuario(nombreUsuario: "nuevo_club",password: "nuevo_club",
			correo: "info@nuevo_club.com",activo: true,rol: clubRol).save(failOnError: true)
		Usuario u2 = new Usuario(nombreUsuario: "nuevo_jugador",password: "nuevo_jugador",
			correo: "info@nuevo_jugador.com",activo: true,rol: jugadorRol).save(failOnError: true)
		Club c = new Club(nombre: "nuevo_club",validado: false).save(failOnError: true)
    }

    @After
    void tearDown() {
    }

    @Test
    void clubLogonTestNullClub() {
		Usuario u = Usuario.findByNombreUsuario("nuevo_club")
		Club c = clubService.clubLogon(u)
		Assert.assertTrue(c == null)
    }
	
	@Test
	void clubLogonTestNotNullClub() {
		Usuario u = Usuario.findByNombreUsuario("nuevo_club")
		Club c = Club.findByNombre("nuevo_club")
		u.club = c
		u.save(flush: true)
		c = clubService.clubLogon(u)
		Assert.assertTrue(c != null)
		Assert.assertEquals("nuevo_club", c.nombre)
	}
	
	@Test
	void registrarDatosClubTest() {
		Usuario u = Usuario.findByNombreUsuario("nuevo_club")
		Club c = new Club(nombre: "el_club",validado: false)
		clubService.registrarDatosClub(u,c,null)
		u = Usuario.findByNombreUsuario("nuevo_club")
		Assert.assertEquals("el_club", u.club.nombre)
	}
	
	@Test
	void registrarDatosClubFallidoTest() {
		Usuario u = Usuario.findByNombreUsuario("nuevo_jugador")
		Club c = new Club(nombre: "el_club",validado: false)
		try {
			clubService.registrarDatosClub(u,c,null)
		} catch (e) { }
		u = Usuario.findByNombreUsuario("nuevo_club")
		Assert.assertTrue(u.club == null)
	}
	
	@Test
	void actualizarDatosClubTest() {
		Club c = Club.findByNombre("nuevo_club")
		c.nombre = "nombre_club_modificado"
		c.validado = true
		clubService.actualizarDatosClub(c,null)
		
		c = Club.findByNombre("nombre_club_modificado")
		Assert.assertTrue(c != null)
		Assert.assertTrue(c.validado)
		Assert.assertEquals("nombre_club_modificado", c.nombre)
	}
	
	@Test
	void actualizarDatosClubFailTest() {
		Club c = Club.findByNombre("nuevo_club")
		c.nombre = null
		try {
			clubService.actualizarDatosClub(c,null)
		} catch (e) { }
		c.refresh()
		Assert.assertTrue(c != null)
		Assert.assertEquals("nuevo_club", c.nombre)
	}
	
	@Test
	void verEncargadosTest() {
		Club c = Club.findByNombre("nuevo_club")
		def encargados = clubService.verEncargados(c)
		Assert.assertTrue(encargados == null)
		
		Usuario u = Usuario.findByNombreUsuario("nuevo_jugador")
		c.addToEncargados(u)
		c.save(flush: true)
		encargados = clubService.verEncargados(c)
		Assert.assertTrue(encargados != null)
		Assert.assertEquals(1, encargados.size())
	}
	
	@Test
	void verEncargadosFailTest() {
		try {
			clubService.verEncargados(null,null)
			fail()
		} catch (e) { }
	}
	
	@Test
	void agregarEncargadoTest() {
		Club c = Club.findByNombre("nuevo_club")
		Assert.assertNull(c.encargados)
		
		Usuario u = new Usuario(nombreUsuario: "nuevo_encargado",password: "nuevo_encargado",
			correo: "info@nuevo_encargado.com")
		Persona p = new Persona(nombre: "Fulano", apellido: "De Tal", 
			tipoDocumento: "DNI", numeroDocumento: 0, 
			sexo: "Masculino", fechaNacimiento: new Date())
			
		clubService.agregarEncargado(c,u,p)
		
		Assert.assertNotNull(c.encargados)
		Assert.assertEquals(1, c.encargados.size())
	}
	
	@Test
	void modificarEncargadoTest() {
		Club c = Club.findByNombre("nuevo_club")
		Rol rolEncargado = Rol.findByNombre("Encargado club")
		Persona p = new Persona(nombre: "Fulano", apellido: "De Tal",
			tipoDocumento: "DNI", numeroDocumento: 0,
			sexo: "Masculino", fechaNacimiento: new Date()).save(flush: true, failOnError: true)
		Usuario u = new Usuario(nombreUsuario: "nuevo_encargado", password: "nuevo_encargado",
				correo: "info@nuevo_encargado.com", persona: p, rol: rolEncargado,
				activo: true).save(flush: true, failOnError: true)
		Assert.assertNull(c.encargados)
		c.addToEncargados(u)
		c.save(flush: true)
		Assert.assertNotNull(c.encargados)
		
		clubService.modificarEncargado([idUsuario: u.id, nombre: "Mengano", password: "le_password"])
		
		u = Usuario.findByNombreUsuario("nuevo_encargado")
		Assert.assertEquals("Mengano", u.persona.nombre)
		Assert.assertEquals("le_password", u.password)
	}
}
