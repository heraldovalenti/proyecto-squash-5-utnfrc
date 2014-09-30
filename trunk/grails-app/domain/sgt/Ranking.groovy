package sgt

class Ranking {
	
	Categoria categoria
	Double puntaje
	Integer puesto
	
	static belongsTo = [jugador: Jugador]
	
	static hasMany = [detalles: DetalleRanking]

    static constraints = {
    }
}
