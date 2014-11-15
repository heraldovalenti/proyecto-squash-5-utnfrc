package sgt

import java.util.Calendar;
import java.util.Comparator;

import org.hibernate.criterion.CriteriaSpecification;

class JugadoresService {

   static transactional = true
   def torneoService
   
	def listarJugadoresPorCategoria(String categoria,def params){
		def c = Usuario.createCriteria()
		def jugadoresCategoria = c.list(params) {
			createAlias("jugador", "jug", CriteriaSpecification.LEFT_JOIN)
			createAlias("jug.categoriasJugador","catJ", CriteriaSpecification.LEFT_JOIN)
			createAlias("catJ.categoria","cat", CriteriaSpecification.LEFT_JOIN)
			createAlias("persona","pers",CriteriaSpecification.LEFT_JOIN)
			and {
				isNotNull("jugador")
				isNotEmpty("jug.categoriasJugador")
				eq("catJ.estado","Asignada")
				eq("cat.nombre", categoria)
			}
			order("pers.apellido", "asc")
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
	
	def listarJugadoresPorTorneoYCategoria(Long torneo,Long categoria){
		def c = InscripcionTorneo.createCriteria()
		def inscripciones= c.list() {
			//createAlias("usuario", "u", CriteriaSpecification.LEFT_JOIN)
			createAlias("detalleTorneo","det", CriteriaSpecification.LEFT_JOIN)
			createAlias("det.torneo","tor", CriteriaSpecification.LEFT_JOIN)
			createAlias("det.categoria","cat",CriteriaSpecification.LEFT_JOIN)
			and {
				eq("tor.id",torneo)
				eq("cat.id", categoria)
			}
		}
		return inscripciones
	
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
	
	def listaTorneosJugador(Integer year,Usuario usuario) {
		
		def t = Torneo.createCriteria()
		def torneos= t.list() {
			createAlias("detalles","det", CriteriaSpecification.LEFT_JOIN)
			createAlias("det.inscripciones","insc", CriteriaSpecification.LEFT_JOIN)
			and {
				eq("insc.usuario",usuario)				
			}
		}
		def torneosFiltrados = new LinkedList()
		for (Torneo tor : torneos) {
			def torneoYear = tor.fechaInicioInscripcion.toCalendar().get(Calendar.YEAR)
			if (torneoYear.equals(year)) {
				def partido=listarPartidosTorneoJugador(tor,usuario)
				torneosFiltrados.add(partido)
			}
		}
		
		return torneosFiltrados		
		
	}
	
	def listarPartidosTorneoJugador(Torneo t, Usuario usuario){
		
		def partidos = Partido.createCriteria().list() {			
			and {
				eq("torneo", t)
				or{
					eq("jugador1",usuario)
					eq("jugador2",usuario)
					}
			}
			order("ordenPartido", "desc")
		}
		
		System.out.println(partidos.toString())
		
		if(partidos.size()>0){
			return partidos.first()
		}
		else{
			return null;
		}
		
		
	}
}
