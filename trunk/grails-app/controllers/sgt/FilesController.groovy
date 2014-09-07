package sgt

import grails.converters.JSON
import grails.validation.ValidationException

import java.nio.file.NoSuchFileException

import org.springframework.web.multipart.MultipartFile

class FilesController {

	def filesService
	def grailsApplication
    
	def uploadImage() {
		try {
			MultipartFile imagen = request.getFile("imagen")
			Imagen res = filesService.uploadImage(imagen)
			render res as JSON
		} catch (ValidationException e) {
			response.status = org.springframework.http.HttpStatus.PRECONDITION_FAILED.value
			render e.errors as JSON
		} catch (e) {
			response.status = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value
			render e as JSON
		}
	}
	
	def retrieveImage(Long id) {
		try {
			Imagen imagen = Imagen.get(id)
			byte[] res = filesService.retrieveImageFile(id)
			
			response.setContentType(imagen.getFormato())
			response.setContentLength(res.length)
			
			OutputStream out = response.getOutputStream()
			out.write(res)
			out.close()
		} catch (e) {
			response.status = org.springframework.http.HttpStatus.NOT_FOUND.value
			render "No encontrado"
		}
	}
}
