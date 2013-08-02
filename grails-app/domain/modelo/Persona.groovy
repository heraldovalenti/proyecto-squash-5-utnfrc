package modelo

class Persona {

    String nombre
    String apellido
	String nombreUsuario
	String email
    Date fechaNacimiento
	String tipoDocumento
	Integer numeroDocumento
	String sexo
    String telefono
    String domicilio
	
	String toString()
	{
		return nombre + " " + apellido
	}

    static constraints = {
		tipoDocumento blank: false, inList: ["DNI","CI","Pasaporte","Libreta Civil"]
		sexo blank: false, inList: ["Masculino","Femenino"]
    }
}
