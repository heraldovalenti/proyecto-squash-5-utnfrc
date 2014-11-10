package sgt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class DiagramacionService3Tests {
	
	@Test
	public void duracionDiagramacionTest() throws ParseException {
		DiagramacionService service = new DiagramacionService();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date inicio, fin;
		inicio = sdf.parse("01/01/2014");
		fin = sdf.parse("10/01/2014");
		int duracion = service.duracionDiagramacion(inicio, fin);
		Assert.assertEquals(9, duracion);
	}
	
	@Test
	public void diaSemanalTest() throws ParseException {
		DiagramacionService service = new DiagramacionService();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d;
		d = sdf.parse("09/11/2014");
		int diaSemanal = service.diaSemanal(d);
		Assert.assertEquals(6, diaSemanal);
	}
	
	@Test
	public void diaSemanalTest2() throws ParseException {
		DiagramacionService service = new DiagramacionService();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date inicio, fin;
		inicio = sdf.parse("31/12/2014");
		fin = sdf.parse("10/01/2015");
		int duracion = service.duracionDiagramacion(inicio, fin);
		Assert.assertEquals(10, duracion);
	}

}
