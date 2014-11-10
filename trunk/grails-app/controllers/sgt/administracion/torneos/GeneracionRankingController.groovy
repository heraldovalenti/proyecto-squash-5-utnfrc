package sgt.administracion.torneos

import sgt.exceptions.RankingException
import sgt.exceptions.TorneoNotFoundException

class GeneracionRankingController {
	
	def rankingService
	
	def generarRanking(Long id) {
		try {
			rankingService.generarRanking(id)
			flash.message = "Rankings actualizados"
		} catch (TorneoNotFoundException ex) {
			flash.exception = ex
		} catch (RankingException ex) {
			flash.exception = ex
		} 
//		catch (ex) {
//			flash.exception = ex
//		}
		redirect(controller: "torneo", action: "show", id: id)
	}

}
