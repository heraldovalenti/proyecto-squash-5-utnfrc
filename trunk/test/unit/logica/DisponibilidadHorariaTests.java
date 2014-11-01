package logica;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DisponibilidadHorariaTests {
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void newDisponibilidadTest_1() {
		DisponibilidadHoraria d = new DisponibilidadHoraria(5,5);
		Assert.assertEquals(5, d.getHorarios().length);
		Assert.assertEquals(5, d.getHorarios()[0].length);
		Assert.assertTrue(d.getHorarios()[0][0].isEmpty());
		Horario h = new Horario();
		d.getHorarios()[0][0].add(h);
		Assert.assertEquals(1,d.getHorarios()[0][0].size());
		
	}
	
	@Test
	public void newDisponibilidadTest_2() {
		DisponibilidadHoraria d = new DisponibilidadHoraria();
		Assert.assertEquals(16, d.getHorarios().length);
		Assert.assertEquals(7, d.getHorarios()[0].length);
		Assert.assertTrue(d.getHorarios()[0][0].isEmpty());
		Horario h = new Horario();
		d.getHorarios()[0][0].add(h);
		Assert.assertEquals(1,d.getHorarios()[0][0].size());
		
	}

}
