package sgt

import grails.validation.ValidationException
import sgt.exceptions.PartidoException

class ResultadoPartidoController {
		
	def resultadoPartidoService
	
    def cargarResultado(Long id) {
		Partido p = Partido.get(id)
		ResultadoPartido r = p.resultado
		List<DetalleResultados> d = new ArrayList<DetalleResultados>()
		if (r) {
			d.addAll(r.detalles)
			Collections.sort(d)
		}
        render(view: "show", model: [partido: p, resultado: r, detalles: d, nuevoSet: flash.nuevoSet])
    }
	
	def save() {
		def partidoId = params.partido
		try {
			resultadoPartidoService.guardarResultadoPartido(params)
			flash.message = "Resultado guardado"
			redirect(action: "cargarResultado", id: partidoId)
		} catch (PartidoException ex) {
			flash.exception = ex
			chain(action: "cargarResultado", id: partidoId)
		} catch (ValidationException ex) {
			flash.errors = ex.errors.allErrors
			chain(action: "cargarResultado", id: partidoId)
		} catch(ex) {
			flash.exception = ex
			chain(action: "cargarResultado", id: partidoId)
		}
	}
	
	def agregarSet() {
		try {
			flash.nuevoSet = resultadoPartidoService.agregarSet(params)
			redirect(action: "cargarResultado", id: params.partido)
		} catch (ValidationException ex) {
			flash.errors = ex.errors.allErrors
			redirect(action: "cargarResultado", id: params.partido)
		} catch(ex) {
			flash.exception = ex
			redirect(action: "cargarResultado", id: params.partido)
		}
	}
	
	def eliminarSet() {
		try {
			resultadoPartidoService.eliminarSet(params)
			flash.message = "Set eliminado"
			redirect(action: "cargarResultado", id: params.partido)
		} catch (ValidationException ex) {
			flash.errors = ex.errors.allErrors
			redirect(action: "cargarResultado", id: params.partido)
		} catch(ex) {
			flash.exception = ex
			redirect(action: "cargarResultado", id: params.partido)
		}
	}
}
