package sgt

class DetalleTorneo {

	Categoria categoria
	Integer cupoMaximo
	
	static belongsTo = Torneo
	String toString(){return categoria.nombre}
	
	static hasMany = [inscripciones: InscripcionTorneo] 
	
    static constraints = {
		categoria nullable:false
		cupoMaximo min:2
    }
	
	def Boolean jugadorInscripto(Usuario usuario) {
		def Iterator<InscripcionTorneo> inscripcionTorneoIterator = this.getInscripciones().iterator()
		while (inscripcionTorneoIterator.hasNext()) {
			InscripcionTorneo aux = inscripcionTorneoIterator.next()
			if (aux.usuario.equals(usuario)) return true
		}
		return false
	}
}
