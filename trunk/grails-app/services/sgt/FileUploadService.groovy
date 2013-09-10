package sgt
import org.springframework.web.multipart.MultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder

public class FileUploadService {
	
	boolean transactional = true
	
	   def String uploadFile(MultipartFile file, String name, String destinationDirectory) {
	
		   def servletContext = ServletContextHolder.servletContext
		   def storagePath = servletContext.getRealPath(destinationDirectory)
	
		   // Create storage path directory if it does not exist
		   //def storagePathDirectory = new File(storagePath)
		   def storagePathDirectory = new File("d:/imagenes")
		   if (!storagePathDirectory.exists()) {
			   print "CREATING DIRECTORY ${storagePath}: "
			   if (storagePathDirectory.mkdirs()) {
				   println "SUCCESS"
			   } else {
				   println "FAILED"
			   }
		   }
	
		   // Store file
		   if (!file.isEmpty()) {
			   file.transferTo(new File("d:/imagenes/asdasd.png"))
			   println "Saved file: ${storagePath}/${name}"
			   return "${storagePath}/${name}"
	
		   } else {
			   println "File ${file.inspect()} was empty!"
			   return null
		   }
	   }
    
}
