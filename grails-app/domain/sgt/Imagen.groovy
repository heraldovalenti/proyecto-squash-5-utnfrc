package sgt

class Imagen {
	
	String nombre
	String formato
	Date fechaAlta

    static constraints = {
		nombre blank: false, maxSize: 50
		formato blank: false, maxSize: 10
    }
}
