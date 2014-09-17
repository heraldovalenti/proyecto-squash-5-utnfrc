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
	
	boolean equals(Object obj) {
		if ( !(obj instanceof Rol) ) return false
		Rol other = obj
		return other.id == this.id
	}
}
