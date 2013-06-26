package modelo

class Persona {

    String nombre
    String apellido
    String email
    Date fechaNacimiento
    String telefono
    String domicilio
    String nombreUsuario
    String tipoDocumento
    Integer numeroDocumento
    String sexo
	
	String toString()
	{
		return nombre + " " + apellido
	}

    static constraints = {
		tipoDocumento blank: false, inList: ["DNI","CI","Pasaporte","Libreta Civil"]
		sexo blank: false, inList: ["Masculino","Femenino"]
    }
}
