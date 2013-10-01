package sgt

class Persona {

    String nombre
    String apellido
    Date fechaNacimiento
	String tipoDocumento
	Integer numeroDocumento
	String sexo
    String telefono
	String lugarNacimiento	
	
	
    static constraints = {
		nombre blank:false, nullable: false
		apellido blank:false, nullable: false
		fechaNacimiento nullable: false
		tipoDocumento blank: false, inList: ["DNI","CI","Pasaporte","Libreta Civil"]
		sexo blank: false, inList: ["Masculino","Femenino"]
		telefono blank: false, nullable: false
		lugarNacimiento blank:false, nullable: true
    }
	
	String toString() {
		return apellido + ", " + nombre
	}
}
