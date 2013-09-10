package sgt

class Jugador {
	
	String brazo
	Double altura
	Double peso

    static constraints = {
		brazo blank:false, inList: ["Derecho","Izquierdo","Ambidiestro"]
    }
}
