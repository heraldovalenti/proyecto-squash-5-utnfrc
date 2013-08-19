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
}
