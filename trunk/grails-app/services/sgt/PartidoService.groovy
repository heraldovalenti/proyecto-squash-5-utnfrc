package sgt

import grails.validation.ValidationException

import org.hibernate.criterion.CriteriaSpecification

import sgt.exceptions.DiagramacionException
class PartidoService {
	
	static transactional = true
	
	def registrarGanadorPartido(Long idPartido, Long idGanador) throws ValidationException {
		Partido p = Partido.get(idPartido)
		Usuario u = Usuario.get(idGanador)
		ResultadoPartido r = p.resultado
		r.ganador = u
		p.finalizar()
		if (p.siguientePartido) {
			Partido siguiente = p.siguientePartido
			if (!siguiente.jugador1) siguiente.jugador1 = u
			else siguiente.jugador2 = u
			siguiente.save(failOnError: true)
		}
		r.save(failOnError: true)
		p.save(failOnError: true)
	}
	
	def listarEnfrentamientosJugadores(Long idJugador1, Long idJugador2){
		def p = Partido.createCriteria()
		def ids=[idJugador1,idJugador2]
		def enfrentamientos = p.list() {
			createAlias("jugador1", "jug1", CriteriaSpecification.LEFT_JOIN)
			createAlias("jugador2","jug2", CriteriaSpecification.LEFT_JOIN)			
			and {				
				'in'("jug1.id",ids)
				'in'("jug2.id", ids)				
			}			
		}
		
		return enfrentamientos
	}
	
	def listarPartidosJugador(Long idJugador){
		def p = Partido.createCriteria()	
		def partidos = p.list() {
			createAlias("jugador1", "jug1", CriteriaSpecification.LEFT_JOIN)
			createAlias("jugador2","jug2", CriteriaSpecification.LEFT_JOIN)			
			and {
				or{				
				eq("jug1.id",idJugador)
				eq("jug2.id",idJugador)
				}				
			}
		}
		
		return partidos		
	}
	
	def listarFinalesJugador(Long idJugador){	
		
		def partidos= listarPartidosJugador(idJugador)	
		
		def jugador= Usuario.get(idJugador)
		
		List finales= new LinkedList()
		
		for(Partido p:partidos){
			
			if(p.rondaPartido()==1 && p?.resultado?.ganador!=jugador){
				finales.add(p)
			}			
		}
		return finales
	}
	
	def listarTitulosJugador(Long idJugador){
		
		def partidos= listarPartidosJugador(idJugador)
		
		def jugador= Usuario.get(idJugador)
		
		List titulos= new LinkedList()
		
		for(Partido p:partidos){
			
			if(p?.rondaPartido()==1 && p?.resultado?.ganador==jugador){
				titulos.add(p)
			}
		}
		return titulos
	}
	
	def listarPartidosTorneo(Long idTorneo, Long idCategoria,def params){

		def torneo= Torneo.get(idTorneo)
		def categoriaSeleccionada=Categoria.get(idCategoria)

		def p = Partido.createCriteria()
		def partidos

		if(torneo!=null && categoriaSeleccionada!=null){
			partidos = p.list(params) {
				createAlias("torneo", "torneo", CriteriaSpecification.LEFT_JOIN)
				createAlias("categoria", "categoria", CriteriaSpecification.LEFT_JOIN)
				createAlias("resultado", "resultado", CriteriaSpecification.LEFT_JOIN)

				and {
					eq("torneo",torneo)
					eq("categoria",categoriaSeleccionada)
					isNotNull("resultado")
				}
			}
		}
		else if(torneo!=null){
			partidos = p.list(params) {
				createAlias("torneo", "torneo", CriteriaSpecification.LEFT_JOIN)
				createAlias("resultado", "resultado", CriteriaSpecification.LEFT_JOIN)

				and {
					eq("torneo",torneo)
					isNotNull("resultado")
				}
			}
		}

		return partidos
	}
	
	def savePartido(Partido p) throws ValidationException, DiagramacionException {
		esPosibleDiagramar(p)
		p.save(failOnError: true)
	}
	
	def esPosibleDiagramar(Partido p) throws DiagramacionException {
		Torneo torneo = p.torneo
		if (!torneo.esDiagramable()) {
			throw new DiagramacionException(DiagramacionException.DIAGRAMACION_NO_PERMITIDA)
		}
		if (!torneo.clubAsignado()) {
			throw new DiagramacionException(DiagramacionException.TORNEO_SIN_CLUB)
		}
		if (torneo.club.cantidadCanchas() == 0) {
			throw new DiagramacionException(DiagramacionException.CLUB_SIN_CANCHAS)
		}
		if (torneo.getTotalInscriptos() == 0) {
			throw new DiagramacionException(DiagramacionException.TORNEO_SIN_INSCRIPTOS)
		}
	}
	
	def listarPartidosTorneoJugador(Torneo t,Usuario j){
		def p = Partido.createCriteria()
		def partidos = p.list() {
			and {
				eq("torneo",t)
				or{
				eq("jugador1",j)
				eq("jugador2",j)
				}
			}
			order("categoria", "asc")
			order("ordenPartido", "asc")			
		}
		
		return partidos		
		
	}

}
