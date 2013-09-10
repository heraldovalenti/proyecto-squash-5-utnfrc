package sgt

class Ranking {
	
	Categoria categoria
	Double puntaje
	Integer puesto
	
	static belongsTo = Usuario
	
	static hasMany = [detalles: DetalleRanking]

    static constraints = {
    }
}
