package sgt



import grails.test.mixin.*
import org.junit.*

import sgt.DetalleTorneo;
import sun.font.Type1Font.T1DisposerRecord;

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DetalleTorneo)
class DetalleTorneoTests {

	@Test
    void equalityTest() {
		DetalleTorneo d1 = new DetalleTorneo()
		DetalleTorneo d2 = new DetalleTorneo()
		DetalleTorneo d3 = new DetalleTorneo()
		d1.id = 1
		d2.id = 2
		d3.id = 1
		
		Assert.assertEquals(1,d1.id)
		Assert.assertEquals(2,d2.id)
		Assert.assertEquals(1,d3.id)
		
		Assert.assertFalse(d1.equals(d2))
		Assert.assertTrue(d1.equals(d3))
    }
}
