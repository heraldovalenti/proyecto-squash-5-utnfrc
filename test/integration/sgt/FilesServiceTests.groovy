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
		File imageDir = new File(dir)
		
		int initFilesAmount = imageDir.listFiles().length
		Imagen res = filesService.uploadImage(file)
		
		File f = new File(dir + res.nombre)
		Assert.assertTrue(f.exists())
		Assert.assertEquals(f.getAbsolutePath(), dir + res.nombre)	
		Assert.assertEquals(initFilesAmount + 1, imageDir.listFiles().length)
		
		f.delete()
		Assert.assertFalse(f.exists())
		Assert.assertEquals(initFilesAmount, imageDir.listFiles().length)
	}
	
	@Test
	void testingDirectoryTest() {
		String dir = grailsApplication.config.fileuploader.image.path
		Assert.assertTrue(dir.contains("/web-app/images/perfiles/"))
	}
}
