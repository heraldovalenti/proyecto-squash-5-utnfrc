package logica;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class CalendarTest {
	
	@Test
	public void calendarTest() {
		Assert.assertEquals(1, Calendar.SUNDAY);
		Assert.assertEquals(2, Calendar.MONDAY);
		Assert.assertEquals(3, Calendar.TUESDAY);
		Assert.assertEquals(4, Calendar.WEDNESDAY);
		Assert.assertEquals(5, Calendar.THURSDAY);
		Assert.assertEquals(6, Calendar.FRIDAY);
		Assert.assertEquals(7, Calendar.SATURDAY);
	}

}
