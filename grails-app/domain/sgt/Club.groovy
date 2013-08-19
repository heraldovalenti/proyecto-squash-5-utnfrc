package sgt

class Club {

    String nombre
    String razonSocial
    String telefono
    String domicilio
    String correo
	Boolean activo
    Persona encargado
    
	static hasMany = [canchas: Cancha]
	
    static constraints = {
		nombre blank: false, unique: true, maxSize: 50
		razonSocial blank: false, unique: true, maxSize: 50
		telefono maxSize: 50
		domicilio maxSize: 250
		correo email:true, blank: false, maxSize: 100
		encargado nullable: true
    }
	
	String toString() {
		return nombre
	}
}
