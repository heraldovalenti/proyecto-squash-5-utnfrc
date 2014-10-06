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
		if (obj == null) return false
		Rol other = obj
		return this.nombre.equals(other.nombre)
	}
}
