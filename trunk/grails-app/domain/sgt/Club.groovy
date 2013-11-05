package sgt

class Club {

    String nombre
    String razonSocial
    String telefono
    Domicilio domicilio
	String sitioWeb
    String correo
	Boolean validado
    
	static hasMany = [canchas: Cancha, servicios: ServicioClub, postulaciones: PostulacionTorneo]
	
	
    static constraints = {
		nombre blank: false, unique: true, maxSize: 50
		razonSocial blank: false, unique: true, maxSize: 50
		telefono nullable: true, blank: false, maxSize: 50
		domicilio nullable: true
		correo nullable: true, email:true, blank: false, maxSize: 100
		sitioWeb nullable: true, blank: false, maxSize: 250, url: true
    }
	
	String toString() {
		return razonSocial
	}
}
