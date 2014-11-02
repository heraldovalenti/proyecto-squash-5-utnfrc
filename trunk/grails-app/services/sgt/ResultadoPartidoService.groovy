package sgt

import sgt.exceptions.PartidoException;
import grails.validation.ValidationException;

class ResultadoPartidoService {
	
	static transactional = true
	
	def partidoService
	
	def guardarResultadoPartido(def params) throws ValidationException, PartidoException {
		Partido p = Partido.get(params.partido)
		if (p.finalizado()) {
			throw new PartidoException(PartidoException.PARTIDO_FINALIZADO)
		}
		ResultadoPartido r = p.resultado
		if (!r) {
			r = new ResultadoPartido()
			p.resultado = r
			p.save(failOnError: true, flush: true)
		}
		if (params.nuevo_set) {
			DetalleResultados nuevoSet = new DetalleResultados()
			nuevoSet.nroSet = (r.detalles) ? r.detalles.size() + 1 : 1
			nuevoSet.jugador1 = Integer.parseInt(params.nuevo_set_1)
			nuevoSet.jugador2 = Integer.parseInt(params.nuevo_set_2)
			nuevoSet.resultado = r
			nuevoSet.save(failOnError: true)
		}
		for (DetalleResultados d : r.detalles) {
			Integer set = d.nroSet
			d.jugador1 = Integer.parseInt(params.get(set + "set_1"))
			d.jugador2 = Integer.parseInt(params.get(set + "set_2"))
			d.save(failOnError: true)
		}
		if (params.ganador && params.finalizar_partido) {
			Long idGanador = Long.parseLong(params.ganador)
			partidoService.registrarGanadorPartido(p.id, idGanador)
		}
	}
	
	def agregarSet(def params) throws ValidationException {
		Partido p = Partido.get(params.partido)
		DetalleResultados nuevoSet = new DetalleResultados()
		nuevoSet.nroSet = p.resultado.detalles.size() + 1
		return nuevoSet
	}
	
	def eliminarSet(def params) throws ValidationException {
		Partido p = Partido.get(params.partido)
		ResultadoPartido r = p.resultado
		List<DetalleResultados> d = new ArrayList<DetalleResultados>()
		d.addAll(p.resultado.detalles)
		Collections.sort(d)
		def last = d.get(d.size() - 1)
		r.detalles.remove(last)
		last.delete()
	}

}
