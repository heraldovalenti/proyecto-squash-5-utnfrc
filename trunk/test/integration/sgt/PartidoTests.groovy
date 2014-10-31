package sgt

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PartidoTests {
	
	static transactional = true
	
	def diagramacionService
	def sqlLoaderService
	
	@Before
	void setUp() {
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("torneos.sql")
		Categoria c = Categoria.get(1)
		Torneo t = Torneo.get(7)
		String e = "Creado" 
		//final
		Partido p31 = new Partido(categoria: c, torneo: t, ordenPartido: 7, estado: e).save(failOnError: true, flush: true)
		//semis
		Partido p22 = new Partido(categoria: c, torneo: t, ordenPartido: 6, estado: e, siguientePartido: p31).save(failOnError: true, flush: true)
		Partido p21 = new Partido(categoria: c, torneo: t, ordenPartido: 5, estado: e, siguientePartido: p31).save(failOnError: true, flush: true)
		//cuartos
		Partido p14 = new Partido(categoria: c, torneo: t, ordenPartido: 4, estado: e, siguientePartido: p22).save(failOnError: true, flush: true)
		Partido p13 = new Partido(categoria: c, torneo: t, ordenPartido: 3, estado: e, siguientePartido: p22).save(failOnError: true, flush: true)
		Partido p12 = new Partido(categoria: c, torneo: t, ordenPartido: 2, estado: e, siguientePartido: p21).save(failOnError: true, flush: true)
		Partido p11 = new Partido(categoria: c, torneo: t, ordenPartido: 1, estado: e, siguientePartido: p21).save(failOnError: true, flush: true)
	}

	@After
	void tearDown() {
	}
	
	@Test
	void cantidadRondasCategoriaTorneoTest() {
		Categoria c = Categoria.get(1)
		Torneo t = Torneo.get(7)
		Partido p = new Partido(categoria: c, torneo: t)
		Assert.assertEquals(3, p.cantidadRondasCategoriaTorneo())
	}
	
	@Test
	void rondaPartidoTest1() {
		Categoria c = Categoria.get(1)
		Torneo t = Torneo.get(7)
		Partido p = Partido.createCriteria().get() {
			eq("torneo", t)
			and {
				eq("categoria", c)
				eq("ordenPartido", 1)
			}
		}
		Assert.assertEquals(3, p.rondaPartido())
		Assert.assertEquals("4tos de final", p.rondaPartidoString())
	}
	
	@Test
	void rondaPartidoTest2() {
		Categoria c = Categoria.get(1)
		Torneo t = Torneo.get(7)
		Partido p = Partido.createCriteria().get() {
			eq("torneo", t)
			and {
				eq("categoria", c)
				eq("ordenPartido", 5)
			}
		}
		Assert.assertEquals(2, p.rondaPartido())
		Assert.assertEquals("Semi-Final", p.rondaPartidoString())
	}
	
	@Test
	void rondaPartidoTest3() {
		Categoria c = Categoria.get(1)
		Torneo t = Torneo.get(7)
		Partido p = Partido.createCriteria().get() {
			eq("torneo", t)
			and {
				eq("categoria", c)
				eq("ordenPartido", 7)
			}
		}
		Assert.assertEquals(1, p.rondaPartido())
		Assert.assertEquals("Final", p.rondaPartidoString())
	}
	
	@Test
	void crearTest() {
		Partido p = new Partido()
		Assert.assertFalse(p.creado())
		p.crear()
		Assert.assertTrue(p.creado())
	}
	
	@Test
	void finalizarTest() {
		Partido p = new Partido()
		Assert.assertFalse(p.finalizado())
		p.finalizar()
		Assert.assertFalse(p.finalizado())
		p.crear()
		p.finalizar()
		Assert.assertTrue(p.finalizado())
	}
	
	@Test
	void comenzarTest() {
		Partido p = new Partido()
		Assert.assertFalse(p.enCurso())
		p.comenzar()
		Assert.assertFalse(p.enCurso())
		p.crear()
		p.comenzar()
		Assert.assertTrue(p.enCurso())
	}
    
}
