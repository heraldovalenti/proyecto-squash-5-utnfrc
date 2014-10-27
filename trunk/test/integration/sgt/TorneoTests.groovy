package sgt

import java.text.SimpleDateFormat

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TorneoTests {

	static transactional = true
	
	def sqlLoaderService
	
	@Before
	void setUp() {
		sqlLoaderService.loadInsertFile("categorias.sql")
		sqlLoaderService.loadInsertFile("torneos.sql")
	}

	@After
	void tearDown() {
	}
	
	@Test
	void getDuracionDiasTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
		Date inicio = sdf.parse("01/01/2014")
		Date fin =    sdf.parse("01/01/2014")
		Torneo t = new Torneo(fechaInicioTorneo: inicio, fechaFinTorneo: fin)
		Assert.assertEquals(1, t.getDuracionDias())
		
		inicio = sdf.parse("01/01/2014")
		fin =    sdf.parse("05/01/2014")
		t = new Torneo(fechaInicioTorneo: inicio, fechaFinTorneo: fin)
		Assert.assertEquals(5, t.getDuracionDias())
		
		inicio = sdf.parse("20/01/2014")
		fin =    sdf.parse("05/02/2014")
		t = new Torneo(fechaInicioTorneo: inicio, fechaFinTorneo: fin)
		Assert.assertEquals(17, t.getDuracionDias())
	}
	
	@Test
	void getFechaDiaTorneoTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")
		Calendar c1 = Calendar.getInstance()
		Calendar c2 = Calendar.getInstance()
		Date inicio = sdf.parse("01/01/2014")
		Torneo t = new Torneo(fechaInicioTorneo: inicio)
		
		Date selected = sdf.parse("01/01/2014")
		c1.setTime(selected)
		c2.setTime(t.getFechaDiaTorneo(1))
		Assert.assertEquals(c1.get(Calendar.DAY_OF_YEAR ), c2.get(Calendar.DAY_OF_YEAR))
		
		selected = sdf.parse("02/01/2014")
		c1.setTime(selected)
		c2.setTime(t.getFechaDiaTorneo(2))
		Assert.assertEquals(c1.get(Calendar.DAY_OF_YEAR ), c2.get(Calendar.DAY_OF_YEAR))
		
		selected = sdf.parse("31/01/2014")
		c1.setTime(selected)
		c2.setTime(t.getFechaDiaTorneo(31))
		Assert.assertEquals(c1.get(Calendar.DAY_OF_YEAR ), c2.get(Calendar.DAY_OF_YEAR))
	}
	
}
