package modelo

class Rol {

    String nombre
    static hasMany = [permisos: Permiso]
	
	String toString()
	{
		return nombre
	}

    static constraints = {	
		
		
	}
}
