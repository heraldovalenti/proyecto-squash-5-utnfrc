package sgt

class Jugador {
	
	String brazo
	Double altura
	Double peso
	Date juegaDesde
	Disponibilidad disponibilidad
	Imagen imagen
	
	static hasMany = [rankings: Ranking, categoriasJugador: CategoriaJugador]

    static constraints = {
		brazo nullable: true, inList: ["Derecho","Izquierdo","Ambidiestro"]
		altura nullable: true
		peso nullable: true
		juegaDesde nullable: true
		disponibilidad nullable: true
		imagen nullable: true
    }
}
