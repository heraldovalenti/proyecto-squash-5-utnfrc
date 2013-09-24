package sgt

public class TorneoPuntuableService {

	boolean transactional = false
	
	/**
	 * Metodo para checkear que los torneos puntuables marcados como activos tengan un orden anual asignado y valido,
	 * esto es, que cada orden sea unico y en orden (1,2,3 -> Valido; 1,1,2,3 -> No valido; 1,2,4 -> No valido).
	 * @return TRUE si todos los torneos marcados como activos tienen un orden anual asignado, FALSE en otro caso.
	 */
    def Boolean checkOrders() {
		def List activesTorneoPuntuable = TorneoPuntuable.findAllByActivo(true, [sort: 'ordenAnual', order: 'asc'])
		def Integer order = 1
		for (activeTorneoPuntuable in activesTorneoPuntuable) {
			if (!activeTorneoPuntuable.ordenAnual) return false
			if (activeTorneoPuntuable.ordenAnual != order) return false
			order++
		}
		return true
    }
}
