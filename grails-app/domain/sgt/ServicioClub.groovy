package sgt

class ServicioClub {
	
	String nombre
	String descripcion

    static constraints = {
		nombre blank:false, maxSize: 50
		descripcion blank: false, maxSize: 250
    }
}
