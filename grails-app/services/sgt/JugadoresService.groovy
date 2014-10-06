package sgt

import java.util.Calendar;
import java.util.Comparator;

class JugadoresService {

   static transactional = true
   
	def listarJugadoresPorCategoria(String categoria, def params){

		def c = Usuario.createCriteria()
		def jugadoresCategoria = c.list(params) {
			isNotNull("jugador")
			and {
				eq("jugador.categoriasJugador.categoria.estado","Asignada")
				eq("jugador.categoriasJugador.categoria.nombre", categoria)
			}
		}
		/*def jugadoresCategoria=[]
		
		def usuarios= Usuario.findAll()

		for(int i =0; i<usuarios.size();i++ ){

			if(usuarios[i].jugador!=null){

				if(usuarios[i].jugador.categoriasJugador!=null){

					def categoriasJugador= usuarios[i].jugador.categoriasJugador

					def Iterator<CategoriaJugador> iter = categoriasJugador.iterator()

					while(iter.hasNext()) {
						def CategoriaJugador cat = iter.next()
						if(cat.estado=="Asignada"){
						
							def categoriaActual= cat.categoria.nombre

							if(categoriaActual==categoria){
							jugadoresCategoria.add(usuarios[i])
							}
						}
					}
				}
			}
		}*/
		return jugadoresCategoria
	}
   
	def obtenerCategorias(){

		def categorias= Categoria.findAll();

		return categorias
	}
	
	def listarJugadoresPorRankingYCategoria(String categoria){	

		def jugadoresRanking=listarJugadoresPorCategoria(categoria)

		def rankingsJugadores= new ArrayList<Ranking>()

		def jugadoresPorRankingYCategoria= []

		def Iterator<Usuario> iter = jugadoresRanking.iterator()

		while(iter.hasNext()) {

			def Usuario user = iter.next()

			def rankingsJugador=user.jugador.rankings

			def Iterator<Ranking> iter1 = rankingsJugador.iterator()

			while(iter1.hasNext()) {

				def Ranking ranking= iter1.next()

				if(ranking.categoria.nombre==categoria){
					rankingsJugadores.add(ranking)
				}
			}
		}
		Collections.sort(rankingsJugadores, new Comparator<Ranking>() {
					@Override
					int compare(Ranking r1, Ranking r2) {					
						
						long diff = r1.puesto - r2.puesto					
						
						if (diff == 0) return 0
						if (diff > 0) return 1
						if (diff < 0) return -1
					}
				})

		def Iterator<Ranking> iter2 = rankingsJugadores.iterator()

		while(iter2.hasNext()) {

			def Ranking rank1= iter2.next()			

			def Iterator<Usuario> iter3 = jugadoresRanking.iterator()

			while(iter3.hasNext()) {

				def Usuario user1= iter3.next()

				if(user1.jugador.rankings.contains(rank1)){

					jugadoresPorRankingYCategoria.add(user1)
				
				}
			}
		}	
		
		return jugadoresPorRankingYCategoria
	}
	
	def calcularEdad(Date fechaNacimiento){
		
		if (fechaNacimiento == null) return null;
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(fechaNacimiento);
		
		int ano = fechaActual.get(Calendar.YEAR)- fechaNac.get(Calendar.YEAR);
		int mes =fechaActual.get(Calendar.MONTH)- fechaNac.get(Calendar.MONTH);
		int dia = fechaActual.get(Calendar.DATE)- fechaNac.get(Calendar.DATE);
		
		//Se ajusta el ano dependiendo el mes y el dia
		if(mes<0 || (mes==0 && dia<0)){
			ano--;
		}
		
		return new Integer(ano);
	}
}
