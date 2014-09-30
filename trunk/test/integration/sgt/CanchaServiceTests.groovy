package sgt

import static org.junit.Assert.*

import org.junit.*

class CanchaServiceTests {

	def canchaService
	
    @Before
    void setUp() {
    	Cancha c1 = new Cancha(nombre: "cancha 1", tipoSuelo: "Parquet", techada: true, numero: 1)
		Cancha c2 = new Cancha(nombre: "cancha 2", tipoSuelo: "Parquet", techada: true, numero: 2)
		Club c = new Club(nombre: "nuevo_club",validado: false)
		c.addToCanchas(c1)
		c.addToCanchas(c2)
		c.save(failOnError: true)
    }

    @After
    void tearDown() {
    }

    @Test
    void crearCanchaTest() {
		Club c = Club.findByNombre("nuevo_club")
        
		Cancha res = canchaService.crearCancha(c)
		Assert.assertEquals(3, res.numero)
    }
	
	@Test
	void registrarCanchaTest() {
		Club c = Club.findByNombre("nuevo_club")
		Cancha cancha = canchaService.crearCancha(c)
		cancha.tipoSuelo = "Parquet"
		
		Assert.assertEquals(2,c.canchas.size())
		Assert.assertEquals(3,cancha.numero)
		Assert.assertFalse(c.canchas.contains(cancha))
		canchaService.registrarCancha(c,cancha)
		Assert.assertEquals(3,c.canchas.size())
		Assert.assertEquals(3,cancha.numero)
		Assert.assertTrue(c.canchas.contains(cancha))
	}
	
	@Test
	void getCanchasClubTest() {
		Club club = Club.findByNombre("nuevo_club")
		Cancha cancha = canchaService.crearCancha(club)
		cancha.tipoSuelo = "Parquet"
		canchaService.registrarCancha(club,cancha)
		
		def canchas = canchaService.getCanchasClub(club)
		Assert.assertNotNull(canchas)
		Assert.assertEquals(3,canchas.size())
		int numero = 0
		for(Cancha iCancha : canchas) {
			numero++
			Assert.assertEquals(numero, iCancha.numero)
		}
	}
	
	@Test
	void eliminarCanchaTest() {
		Club club = Club.findByNombre("nuevo_club")
		Cancha cancha = canchaService.crearCancha(club)
		cancha.tipoSuelo = "Parquet"
		//cancha.disponibilidad = new Disponibilidad(fechaActualizacion: new Date()).save(failOnError: true)
		canchaService.registrarCancha(club,cancha)
		
		Assert.assertEquals(3, club.canchas.size())
		def canchas = canchaService.getCanchasClub(club)
		int numero = 0
		for(Cancha iCancha : canchas) {
			numero++
			Assert.assertEquals(numero, iCancha.numero)
		}
				
		cancha = Cancha.findByNombre("cancha 2")
		canchaService.eliminarCancha(club,cancha)
		
		Assert.assertEquals(2, club.canchas.size())
		canchas = canchaService.getCanchasClub(club)
		numero = 0
		for(Cancha iCancha : canchas) {
			numero++
			Assert.assertEquals(numero, iCancha.numero)
		}
	}
	
	@Test
	void getCanchaClubTest() {
		def club = Club.findByNombre("nuevo_club")
		def cancha = Cancha.findByNombre("cancha 2")
		
		def res = canchaService.getCanchaClub(club,cancha)
		Assert.assertEquals(cancha, res)
		
		res = canchaService.getCanchaClub(club,new Cancha())
		Assert.assertNull(res)
	}
	
	@Test
	void updateCanchaTest() {
		def club = Club.findByNombre("nuevo_club")
		def cancha = Cancha.findByNombre("cancha 2")
		
		Assert.assertEquals("cancha 2", cancha.nombre)
		
		cancha.nombre = "modificado"
		canchaService.updateCancha(cancha)
		
		cancha = Cancha.findByNombre("modificado")
		Assert.assertNotNull(cancha)
		Assert.assertEquals("modificado", cancha.nombre)
	}
}
