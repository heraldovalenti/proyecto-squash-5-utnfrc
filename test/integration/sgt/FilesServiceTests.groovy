package sgt

import static org.junit.Assert.*

import org.junit.*
import org.springframework.mock.web.MockMultipartFile

class FilesServiceTests {

	static transaction = true
	def filesService
	def grailsApplication
	
    @Before
    void setUp() {
    }

    @After
    void tearDown() {
		String dir = grailsApplication.config.fileuploader.image.path
		File imageTestDir = new File(dir)
		for (File f : imageTestDir.listFiles()) {
			f.delete()
		}
    }
	
    @Test
    void isImageTest() {
		MockMultipartFile file = new MockMultipartFile("name", "orig_name", "image/gif", new Byte[1])
		Assert.assertTrue(filesService.isImage(file))
		
		file = new MockMultipartFile("name", "orig_name", "image/png", new Byte[1])
		Assert.assertTrue(filesService.isImage(file))
		
		file = new MockMultipartFile("name", "orig_name", "image/jpeg", new Byte[1])
		Assert.assertTrue(filesService.isImage(file))
		
		file = new MockMultipartFile("name", "orig_name", "application/json", new Byte[1])
		Assert.assertTrue(!filesService.isImage(file))
    }
	
	@Test
	void formatForTypeTest() {
		Assert.assertEquals("gif", filesService.formatForType("image/gif"))
		Assert.assertEquals("jpeg", filesService.formatForType("image/jpeg"))
		Assert.assertEquals("png", filesService.formatForType("image/png"))
	}
	
	@Test
	void uploadImageTest() {
		MockMultipartFile file = new MockMultipartFile("name", "orig_name.gif", "image/gif", new Byte[1])
		String dir = grailsApplication.config.fileuploader.image.path
		
		Imagen res = filesService.uploadImage(file)
		File f = new File(dir + res.nombre)
		File imageFile = new File(dir).listFiles()[0]
		Assert.assertTrue(f.exists())
		Assert.assertEquals(imageFile.getAbsolutePath(), dir + res.nombre)
		Assert.assertEquals(1, Imagen.list().size())		
	}
	
	@Test
	void testingDirectoryTest() {
		String dir = grailsApplication.config.fileuploader.image.path
		Assert.assertEquals("/home/heril/sgt/images/test/",dir)
	}
}
