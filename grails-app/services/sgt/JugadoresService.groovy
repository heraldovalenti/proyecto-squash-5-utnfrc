package sgt

class JugadoresService {

   static transactional = true
   
	def listarJugadoresPorCategoria(String categoria){

		def jugadoresCategoria=[]
		
		def usuarios= Usuario.findAll()

		for(int i =0; i<usuarios.size();i++ ){

			if(usuarios[i].jugador!=null){

				if(usuarios[i].jugador.categoriasJugador!=null){

					def categoriasJugador= usuarios[i].jugador.categoriasJugador

					def Iterator<CategoriaJugador> iter = categoriasJugador.iterator()

					while(iter.hasNext()) {
						def CategoriaJugador cat = iter.next()
						def categoriaActual= cat.categoria.nombre

						if(categoriaActual==categoria){
							jugadoresCategoria.add(usuarios[i])
						}
					}
				}
			}
		}
		return jugadoresCategoria
	}
   
	def obtenerCategorias(){

		def categorias= Categoria.findAll();

		return categorias
	}
}
