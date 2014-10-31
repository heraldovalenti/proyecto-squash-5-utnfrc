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
		sqlLoaderService.loadInsertFile("ejemplos-usuarios.sql")
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
	
	@Test
	void getTotalInscriptosTest() {
		Torneo t = Torneo.get(8)
		DetalleTorneo d4 = DetalleTorneo.get(4)
		DetalleTorneo d5 = DetalleTorneo.get(5)
		DetalleTorneo d6 = DetalleTorneo.get(6)
		Usuario u1 = Usuario.get(1)
		Usuario u2 = Usuario.get(2)
		Usuario u3 = Usuario.get(3)
		Usuario u4 = Usuario.get(4)
		String e = "Vinculada"
		Date d = new Date()
		InscripcionTorneo i1, i2, i3, i4

		i1 = new InscripcionTorneo(usuario: u1, estado: e, fecha: d)
		i2 = new InscripcionTorneo(usuario: u2, estado: e, fecha: d)
		d4.addToInscripciones(i1)
		d4.addToInscripciones(i2)
		d4.save(failOnError: true, flush: true)
		Assert.assertEquals(2, d4.cantidadInscriptos())
		Assert.assertEquals(2, t.getTotalInscriptos())

		i3 = new InscripcionTorneo(usuario: u3, estado: e, fecha: d)
		d5.addToInscripciones(i3)
		d5.save(failOnError: true, flush: true)
		Assert.assertEquals(1, d5.cantidadInscriptos())
		Assert.assertEquals(3, t.getTotalInscriptos())
		
		i4 = new InscripcionTorneo(usuario: u4, estado: e, fecha: d)
		d6.addToInscripciones(i4)
		d6.save(failOnError: true, flush: true)
		Assert.assertEquals(1, d6.cantidadInscriptos())
		Assert.assertEquals(4, t.getTotalInscriptos())
	}
	
}
