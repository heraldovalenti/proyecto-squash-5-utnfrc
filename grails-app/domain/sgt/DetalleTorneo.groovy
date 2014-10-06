package sgt

class DetalleTorneo {

	Categoria categoria
	Integer cupoMaximo
	
	static belongsTo = [torneo: Torneo]
	
	static hasMany = [inscripciones: InscripcionTorneo] 
	
    static constraints = {
		categoria nullable:false
		cupoMaximo min:2
    }
	
	def Boolean jugadorInscripto(Usuario usuario) {
		def Iterator<InscripcionTorneo> inscripcionTorneoIterator = this.getInscripciones().iterator()
		while (inscripcionTorneoIterator.hasNext()) {
			InscripcionTorneo aux = inscripcionTorneoIterator.next()
			if (aux.usuario.equals(usuario) && aux.esVinculada()) return true
		}
		return false
	}
	
	String toString() { 
		return torneo.toString() + "(en " + categoria.toString() + ")"
	}
	
	def Integer cantidadInscriptos() {
		return this.getInscripciones().size()
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DetalleTorneo)) return false
		DetalleTorneo other = obj
		return (this.id == other.id)
	}
}
