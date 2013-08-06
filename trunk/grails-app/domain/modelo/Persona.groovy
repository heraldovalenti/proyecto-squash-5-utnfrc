package modelo

class Persona {

    String nombre
    String apellido
    Date fechaNacimiento
	String tipoDocumento
	Integer numeroDocumento
	String sexo
    String telefono
    String domicilio

    static constraints = {
		nombre blank:false
		apellido blank:false
		fechaNacimiento nullable: false
		tipoDocumento blank: false, inList: ["DNI","CI","Pasaporte","Libreta Civil"]
		sexo blank: false, inList: ["Masculino","Femenino"]
		telefono blank: false
		domicilio blank: false, maxSize: 250
    }
	
	String toString() {
		return apellido + ", " + nombre
	}
}