package sgt

import static org.junit.Assert.*

import org.junit.*

import sgt.exceptions.UnregisteredJugadorException

class CategoriaJugadorServiceTests {

	static transactional = true
	
	def sqlLoaderService
	def categoriaJugadorService
	
    @Before
    void setUp() {
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("jugadores.sql")
    }

    @After
    void tearDown() {
		CategoriaJugador.deleteAll(CategoriaJugador.list())
    }
	
	@Test
	void getCategoriaJugadorTest() {
		CategoriaJugador categoriaJugador = categoriaJugadorService.getCategoriaJugador(1)
		Assert.assertNotNull(categoriaJugador)
		Assert.assertEquals("Asignada", categoriaJugador.estado)
		Assert.assertEquals("Primera", categoriaJugador.categoria.nombre)
	}
	
	@Test
	void getCategoriaJugadorFailTest() {
		Exception result = null
		try {
			CategoriaJugador categoriaJugador = categoriaJugadorService.getCategoriaJugador(10)
		} catch (e) {
			result = e
		}
		Assert.assertNotNull(result)
		Assert.assertEquals("UnregisteredJugadorException", result.getClass().getSimpleName())
		Assert.assertEquals(UnregisteredJugadorException.msg, result.getMessage())
	}
	
	@Test
	void getCategoriaJugadorNullTest() {
		Jugador heraldov = Jugador.get(1)
		CategoriaJugador categoriaHeraldov = CategoriaJugador.get(1)
		categoriaHeraldov.delete(flush: true)
		
		CategoriaJugador categoriaJugador = categoriaJugadorService.getCategoriaJugador(1)
		Assert.assertNull(categoriaJugador)
	}
	
	@Test
	void getHistorialCategoriaJugadorTest() {
		Usuario heraldov = Usuario.get(1)
		CategoriaJugador segunda = new CategoriaJugador(categoria: Categoria.get(2), estado: "De baja", 
			fechaInicio: new Date(), fechaFin: new Date(), 
			jugador: heraldov.jugador).save(failOnError: true, flush: true)
		CategoriaJugador tercera = new CategoriaJugador(categoria: Categoria.get(3), estado: "De baja", 
			fechaInicio: new Date(new Date().getTime() - 20000), fechaFin: new Date(new Date().getTime() - 20000), 
			jugador: heraldov.jugador).save(failOnError: true, flush: true)
			
		def historial = categoriaJugadorService.getHistorialCategoriaJugador(1)
		Assert.assertEquals(2, historial.size())
		Assert.assertEquals("Tercera", historial[0].categoria.nombre)
		Assert.assertEquals("Segunda", historial[1].categoria.nombre)
	}
	
	@Test
	void getSolicitudCategoriaJugadorTest() {
		Usuario heraldov = Usuario.get(1)
		CategoriaJugador segunda = new CategoriaJugador(categoria: Categoria.get(2), estado: "Solicitada",
			fechaInicio: new Date(), fechaFin: new Date(),
			jugador: heraldov.jugador).save(failOnError: true, flush: true)
			
		def solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(1)
		Assert.assertNotNull(solicitud)
		Assert.assertEquals("Segunda", solicitud.categoria.nombre)
	}
	
	@Test
	void saveSolicitudCategoriaTest() {
		Usuario heraldov = Usuario.get(1)
		
		def solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(1)
		Assert.assertNull(solicitud)
		
		categoriaJugadorService.saveSolicitudCategoria(1,2)
		def categoriasJugador = CategoriaJugador.createCriteria().list {
			eq("jugador", heraldov)
		}
		solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(1)
		Assert.assertEquals("Segunda", solicitud.categoria.nombre)
		Assert.assertEquals(2, categoriasJugador.size())
		
		categoriaJugadorService.saveSolicitudCategoria(1,3)
		categoriasJugador = CategoriaJugador.createCriteria().list {
			eq("jugador", heraldov)
		}
		solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(1)
		Assert.assertEquals("Tercera", solicitud.categoria.nombre)
		Assert.assertEquals(2, categoriasJugador.size())
	}
	
	@Test
	void cancelarSolicitudCategoriaTest() {
		Usuario heraldov = Usuario.get(1)
		CategoriaJugador segunda = new CategoriaJugador(categoria: Categoria.get(2), estado: "Solicitada",
			fechaInicio: new Date(), fechaFin: new Date(),
			jugador: heraldov.jugador).save(failOnError: true, flush: true)
		
		def solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(1)
		Assert.assertNotNull(solicitud)
		
		categoriaJugadorService.cancelarSolicitudCategoria(1)
		solicitud = categoriaJugadorService.getSolicitudCategoriaJugador(1)
		Assert.assertNull(solicitud)
	}
	
	@Test
	void getCategoriasSolicitablesTest() {
		Usuario heraldov = Usuario.get(1)
		CategoriaJugador solicitada = new CategoriaJugador(categoria: Categoria.get(2), estado: "Solicitada",
			fechaInicio: new Date(), fechaFin: new Date(),
			jugador: heraldov.jugador).save(failOnError: true, flush: true)
		
		Set results = categoriaJugadorService.getCategoriasSolicitables(1)
		Categoria actual = categoriaJugadorService.getCategoriaJugador(1).categoria
		Categoria segunda = Categoria.get(2)
		Categoria tercera = Categoria.get(3)
		Categoria cuarta = Categoria.get(4)
		Assert.assertTrue(results.size() > 0)
		Assert.assertFalse(results.contains(actual))
		Assert.assertFalse(results.contains(segunda))
		Assert.assertTrue(results.contains(tercera))
		Assert.assertTrue(results.contains(cuarta))
		Assert.assertEquals(12, results.size())
	}
	
	@Test
	void listaSolicitudesCategoriasTest() {
		def results = categoriaJugadorService.listaSolicitudesCategorias()
		Assert.assertEquals(0, results.solicitudes.size())
		Assert.assertEquals(0, results.total)
		
		Usuario heraldov = Usuario.get(1)
		CategoriaJugador solicitada = new CategoriaJugador(categoria: Categoria.get(2), estado: "Solicitada",
			fechaInicio: new Date(), jugador: heraldov.jugador).save(failOnError: true, flush: true)
		
		results = categoriaJugadorService.listaSolicitudesCategorias()
		Assert.assertEquals(1, results.solicitudes.size())
		Assert.assertEquals(1, results.total)
	}
	
	@Test
	void aceptarSolicitudCategoriaTest() {
		Usuario heraldov = Usuario.get(1)
		Jugador j = heraldov.jugador
		CategoriaJugador solicitada = new CategoriaJugador(categoria: Categoria.get(2), estado: "Solicitada",
			fechaInicio: new Date(), jugador: heraldov.jugador).save(failOnError: true, flush: true)
		CategoriaJugador categoriaActual = CategoriaJugador.createCriteria().get() {
			eq("jugador", j)
			and {
				eq("estado", "Asignada")
				isNull("fechaFin")
			}
		}
		Assert.assertNotNull(categoriaActual)
		Assert.assertEquals("Primera", categoriaActual.categoria.nombre)
		Assert.assertNotNull(solicitada)
		Assert.assertEquals("Segunda", solicitada.categoria.nombre)
		
		categoriaJugadorService.aceptarSolicitudCategoria(solicitada.id)
		categoriaActual = CategoriaJugador.createCriteria().get() {
			eq("jugador", j)
			and {
				eq("estado", "Asignada")
				isNull("fechaFin")
			}
		}
		Assert.assertNotNull(categoriaActual)
		Assert.assertEquals("Segunda", categoriaActual.categoria.nombre)
	}
	
	@Test
	void rechazarSolicitudCategoriaTest() {
		Usuario heraldov = Usuario.get(1)
		Jugador j = heraldov.jugador
		CategoriaJugador solicitada = new CategoriaJugador(categoria: Categoria.get(2), estado: "Solicitada",
			fechaInicio: new Date(), jugador: heraldov.jugador).save(failOnError: true, flush: true)
		CategoriaJugador categoriaActual = CategoriaJugador.createCriteria().get() {
			eq("jugador", j)
			and {
				eq("estado", "Asignada")
				isNull("fechaFin")
			}
		}
		Assert.assertNotNull(categoriaActual)
		Assert.assertEquals("Primera", categoriaActual.categoria.nombre)
		Assert.assertNotNull(solicitada)
		Assert.assertEquals("Segunda", solicitada.categoria.nombre)
		
		categoriaJugadorService.rechazarSolicitudCategoria(solicitada.id)
		categoriaActual = CategoriaJugador.createCriteria().get() {
			eq("jugador", j)
			and {
				eq("estado", "Asignada")
				isNull("fechaFin")
			}
		}
		solicitada = CategoriaJugador.createCriteria().get() {
			eq("jugador", j)
			and {
				eq("estado", "Rechazada")
			}
		}
		Assert.assertNotNull(categoriaActual)
		Assert.assertEquals("Primera", categoriaActual.categoria.nombre)
		Assert.assertNotNull(solicitada)
		Assert.assertEquals("Segunda", solicitada.categoria.nombre)
	}
}
