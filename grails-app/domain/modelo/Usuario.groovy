package modelo

class Usuario {

    Persona persona
    String nombreUsuario
    String password
    Rol rol
    Boolean activo
	
	String toString()
	{
		return nombreUsuario
	}

    static constraints = {
		
		
    }
}
