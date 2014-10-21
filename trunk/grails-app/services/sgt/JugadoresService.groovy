package sgt

import java.util.Calendar;
import java.util.Comparator;

import org.hibernate.criterion.CriteriaSpecification;

class JugadoresService {

   static transactional = true
   
	def listarJugadoresPorCategoria(String categoria,def params){
		def c = Usuario.createCriteria()
		def jugadoresCategoria = c.list(params) {
			createAlias("jugador", "jug", CriteriaSpecification.LEFT_JOIN)
			createAlias("jug.categoriasJugador","catJ", CriteriaSpecification.LEFT_JOIN)
			createAlias("catJ.categoria","cat", CriteriaSpecification.LEFT_JOIN)
			and {
				isNotNull("jugador")
				isNotEmpty("jug.categoriasJugador")
				eq("catJ.estado","Asignada")
				eq("cat.nombre", categoria)
			}
		}
		
		return jugadoresCategoria
	}
   
	def obtenerCategorias(){

		def categorias= Categoria.findAll();

		return categorias
	}
	
	def listarJugadoresPorRankingYCategoria(String categoria,def params){		
		
		def c = Usuario.createCriteria()
		def jugadoresRanking= c.list(params) {
			createAlias("jugador", "jug", CriteriaSpecification.LEFT_JOIN)
			createAlias("jug.categoriasJugador","catJ", CriteriaSpecification.LEFT_JOIN)
			createAlias("catJ.categoria","cat", CriteriaSpecification.LEFT_JOIN)
			createAlias("jug.rankings","rank",CriteriaSpecification.LEFT_JOIN)
			createAlias("rank.categoria","catRank",CriteriaSpecification.LEFT_JOIN)
			and {
				isNotNull("jugador")
				isNotEmpty("jug.categoriasJugador")
				isNotEmpty("jug.rankings")
				isNotNull("rank.categoria")
				eq("catJ.estado","Asignada")
				eq("cat.nombre", categoria)
				eq("catRank.nombre",categoria)
			}
			order("rank.puesto","asc")
		}
				
		return jugadoresRanking
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
	
	def listarJugadores(){
		
		def jugadores= Persona.findAll()		
		return jugadores
	}
}
