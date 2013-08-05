package modelo

class DetalleTorneo {

	Categoria categoria
	Integer cupoMaximo
	
	static belongsTo = Torneo
	
	static hasMany = [inscripciones: InscripcionTorneo] 
	
    static constraints = {
		categoria nullable:false
		cupoMaximo min:2
    }
}
