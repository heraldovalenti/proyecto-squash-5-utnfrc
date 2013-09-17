package sgt

import org.springframework.web.multipart.MultipartFile
import org.codehaus.groovy.grails.web.context.ServletContextHolder

public class FileUploadService {
	
	boolean transactional = true
	
	   def String uploadFile(MultipartFile file, String name, String destinationDirectory) {
	
		   def servletContext = ServletContextHolder.servletContext
		   def storagePath = servletContext.getRealPath(destinationDirectory)
	
		   // Create storage path directory if it does not exist
		   def storagePathDirectory = new File(storagePath)
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
			   def extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length())
			   def temp = new File("${storagePath}/${name}${extension}")
			   file.transferTo(temp)
			   println "Saved file: ${storagePath}/${name}${extension}"
			   return "${name}${extension}"
	
		   } else {
			   println "File ${file.inspect()} was empty!"
			   return null
		   }
	   }
	   
	   def Boolean isImage(MultipartFile file) {
		   if (!file.isEmpty()) return file.getContentType().compareTo("image/jpeg") == 0
		   else return false
	   }
}
