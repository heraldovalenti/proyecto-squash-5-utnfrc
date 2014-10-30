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
	Domicilio domicilio 
	
    static constraints = {
		nombre blank:false, maxSize: 100
		apellido blank:false, maxSize: 100
		sexo inList: ["Masculino","Femenino"]
		tipoDocumento nullable: true, inList: ["DNI","CI","Pasaporte","Libreta Civil"]
		numeroDocumento nullable: true, min: 0
		telefono nullable: true, maxSize: 100
		lugarNacimiento nullable: true, maxSize: 100
		domicilio nullable: true
		fechaNacimiento range: new Date(-2207520000000) .. new Date() 
    }
	
	String toString() {
		return apellido + ", " + nombre
	}
}
