package modelo

class Club {

    String nombre
    String razonSocial
    String telefono
    String domicilio
    String email
	Boolean activo
    Persona encargado
    
	static hasMany = [canchas: Cancha]
    
	String toString()
	{
		return nombre
	}
	
    static constraints = {
		nombre blank: false, unique: true, maxSize: 50
		razonSocial blank: false, unique: true, maxSize: 50
		telefono maxSize: 50
		domicilio maxSize: 250
		email blank: false, maxSize: 100
    }
}
