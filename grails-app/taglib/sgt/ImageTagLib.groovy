package sgt

class ImageTagLib {	
	
def filesService
	
def imagenPerfilJugador={ attrs ->
	
	def usuario=attrs.usuario
		
	def dir= filesService.retrieveImagesDir()
	def img= "default.jpg"
	if(usuario.jugador && usuario.jugador.imagen){
		img=usuario.jugador.imagen.nombre
	}	
	out << g.resource (dir:dir,file:img)


}
}
