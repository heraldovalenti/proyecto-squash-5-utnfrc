package sgt

class Jugador {
	
	String brazo
	Double altura
	Double peso
	Date juegaDesde
	Imagen imagen
	Disponibilidad disponibilidad
	
	static hasMany = [rankings: Ranking, categoriasJugador: CategoriaJugador]

    static constraints = {
		brazo nullable: true, inList: ["Derecho","Izquierdo","Ambidiestro"]
		altura nullable: true
		peso nullable: true
		juegaDesde nullable: true
		disponibilidad nullable: true
		imagen nullable: true
    }
	
	boolean checkDatosCompletados() {
		return ( brazo || altura || peso || juegaDesde || imagen )
	}
}
