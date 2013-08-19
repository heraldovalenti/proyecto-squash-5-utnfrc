package sgt

class Rol {

    String nombre
    static hasMany = [permisos: Permiso]

    static constraints = {	
		nombre blank: false		
	}
	
	String toString() {
		return nombre
	}
}
