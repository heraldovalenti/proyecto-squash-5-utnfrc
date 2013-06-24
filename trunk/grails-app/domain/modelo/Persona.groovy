package modelo

class Persona {

    String nombre
    String apellido
    String email
    Date fechaNacimiento
    Integer telefono
    String domicilio
    String nombreUsuario
    String tipoDocumento
    Integer numDoc
    String sexo

    static constraints = {
		tipoDocumento blank: false, inList: ["DNI","CI","Pasaporte","Libreta Civil"]
    }
}
