package sgt.administracion.torneos

import grails.validation.ValidationException;

import java.util.List;

import sgt.Partido;
import sgt.Torneo
import sgt.exceptions.DiagramacionException;
import sgt.exceptions.TorneoNotFoundException;

class DiagramacionHorariosService {
	
	Torneo getTorneoDiagramacion(Long id) 
		throws TorneoNotFoundException, DiagramacionException {
		Torneo torneo = Torneo.get(id)
		if (!torneo) {
			throw new TorneoNotFoundException()	
		}
		if (!torneo.esDiagramable()) {
			throw new DiagramacionException(DiagramacionException.DIAGRAMACION_NO_PERMITIDA)
		}
		if (!torneo.clubAsignado()) {
			throw new DiagramacionException(DiagramacionException.TORNEO_SIN_CLUB)
		}
		if (torneo.club.cantidadCanchas() == 0) {
			throw new DiagramacionException(DiagramacionException.CLUB_SIN_CANCHAS)
		}
	}
			
	def guardarDiagramacion(List<Partido> diagramacion) throws ValidationException {
		for (Partido p : diagramacion) {
			p = p.merge()
			p.save(failOnError: true)
		}
	}
}