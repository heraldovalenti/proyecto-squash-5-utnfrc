package sgt

class Jugador {
	
	String imagen
	String brazo
	Double altura
	Double peso
	Date juegaDesde
	Disponibilidad disponibilidad
	
	static hasMany = [rankings: Ranking, categoriasJugador: CategoriaJugador]

    static constraints = {
		brazo nullable: true, inList: ["Derecho","Izquierdo","Ambidiestro"]
		imagen nullable: true
		altura nullable: true
		peso nullable: true
		juegaDesde nullable: true
		disponibilidad nullable: true
    }
}
