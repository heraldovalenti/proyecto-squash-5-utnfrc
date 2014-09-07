package sgt

import grails.validation.ValidationException

import java.nio.file.Files
import java.nio.file.Paths

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.springframework.web.multipart.MultipartFile

public class FilesService {
	
	static transactional = true
	
	def grailsApplication
	
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
			   //if (temp.exists()) temp.delete()
			   file.transferTo(temp)
			   println "Saved file: ${storagePath}/${name}${extension}"
			   return "${name}${extension}"
	
		   } else {
			   println "File ${file.inspect()} was empty!"
			   return null
		   }
	   }
	   
	Boolean isImage(MultipartFile file) {
		def allowedTypes = grailsApplication.config.fileuploader.image.types
		return ( file != null && !file.isEmpty() && allowedTypes.contains(file.getContentType()) )
	}
	   
	def uploadImage(MultipartFile file) {
		Imagen image = new Imagen()
		
		if (!isImage(file)) {
			image.errors.rejectValue("formato", "", "Formato no permitido")
			throw new ValidationException("No se pudo registrar la imagen", image.errors)
		}
		
		Long currentMilis = new Date().getTime()
		String nombreArchivo = currentMilis + "." + formatForType(file.getContentType())
		String nombreArchivoAbsoluto = grailsApplication.config.fileuploader.image.path + nombreArchivo
		File realFile = new File(nombreArchivoAbsoluto)
		
		if (realFile.exists()) {
			image.errors.rejectValue("nombre", "", "Archivo ya existente")
			throw new ValidationException("No se pudo registrar la imagen", image.errors)
		}
		
		image.nombre = nombreArchivo
		image.formato = file.getContentType()
		image.fechaAlta = new Date()
		image.save()
		
		file.transferTo(realFile)
		return image
	}
	
	def retrieveImageFile(Long id) {
		Imagen imagen = Imagen.get(id)
		String imagesDir = grailsApplication.config.fileuploader.image.path
		File imageFile = new File(imagesDir + imagen.nombre)
		return Files.readAllBytes(Paths.get(imageFile.toURI()));
	}
	
	String formatForType(String mimeType) {
		switch(mimeType) {
			case "image/gif" : return "gif"
			case "image/png" : return "png"
			case "image/jpeg" : return "jpeg"
			default : null
		}
	}
}
