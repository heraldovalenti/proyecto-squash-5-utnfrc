package sgt

import static org.junit.Assert.*

import org.junit.*

class InscripcionTorneoServiceTests {

	def sqlLoaderService
	def inscripcionTorneoService
	
    @Before
    void setUp() {
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
		sqlLoaderService.loadInsertFile("torneos.sql")
    }

    @After
    void tearDown() {
    }

    @Test
    void getCategoriasDeTorneoParaInscripcionTest() {
		def categoriasTorneo7 = inscripcionTorneoService.getCategoriasDeTorneoParaInscripcion(7)
		Assert.assertEquals(3, categoriasTorneo7.size())
		
		def categoriasTorneo10 = inscripcionTorneoService.getCategoriasDeTorneoParaInscripcion(10)
		Assert.assertEquals(5, categoriasTorneo10.size())
		
		def categoriaPrimera = null
		for (Categoria c : categoriasTorneo10) {
			if (c.id == 1) {
				categoriaPrimera = c;
				break;	
			}
		}
		Assert.assertNotNull(categoriaPrimera)
		Assert.assertEquals("Primera categoria de masculinos", categoriaPrimera.descripcion)
    }
	
	@Test
	void inscribirJugadorTorneoTest() {
		DetalleTorneo detalle = DetalleTorneo.get(4)
		Assert.assertEquals(0,detalle.inscripciones.size())
		
		inscripcionTorneoService.inscribirJugadorTorneo(8,1)
		
		detalle = DetalleTorneo.get(4)
		Assert.assertEquals(1,detalle.inscripciones.size())
		InscripcionTorneo inscripcionTorneo = detalle.inscripciones.iterator().next()
		Assert.assertTrue(inscripcionTorneo.esVinculada())
	}
	
	@Test
	void cancelarInscripcionTorneoTest() {
		DetalleTorneo detalle = DetalleTorneo.get(4)
		Usuario usuario = Usuario.get(1)
		InscripcionTorneo inscripcionTorneo = new InscripcionTorneo()
		inscripcionTorneo.usuario = usuario
		inscripcionTorneo.fecha = new Date()
		inscripcionTorneo.detalleTorneo = detalle
		inscripcionTorneo.vincular()
		inscripcionTorneo.save(failOnError: true, flush: true)
		
		Assert.assertTrue(inscripcionTorneo.esVinculada())
		Assert.assertTrue(inscripcionTorneo.id != null)
		
		inscripcionTorneoService.cancelarInscripcionTorneo(inscripcionTorneo.id)
		
		inscripcionTorneo = InscripcionTorneo.get(inscripcionTorneo.id)
		Assert.assertTrue(inscripcionTorneo.esCancelada())
	}
	
	@Test
	void getInscripcionActivasUsuarioTest() {
		DetalleTorneo detalle = DetalleTorneo.get(4)
		Usuario usuario = Usuario.get(1)
		
		def results1 = inscripcionTorneoService.getInscripcionActivasUsuario(usuario.id)
		Assert.assertEquals(0, results1.size())
		
		InscripcionTorneo inscripcionVinculada = new InscripcionTorneo(usuario: usuario,
			fecha: new Date(), detalleTorneo: detalle, estado: "Vinculada").save(flush: true, failOnError: true)
		def results2 = inscripcionTorneoService.getInscripcionActivasUsuario(usuario.id)
		Assert.assertEquals(1, results2.size())
			
		InscripcionTorneo inscripcionCancelada = new InscripcionTorneo(usuario: usuario,
			fecha: new Date(), detalleTorneo: detalle, estado: "Cancelada").save(flush: true, failOnError: true)
		def results3 = inscripcionTorneoService.getInscripcionActivasUsuario(usuario.id)
		Assert.assertEquals(1, results3.size())
	}
}
