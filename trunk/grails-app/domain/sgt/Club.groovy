package sgt

class Club {

    String nombre
    String telefono
    Domicilio domicilio
	String sitioWeb
    String correo
	Boolean validado
	Imagen imagen
    
	static hasMany = [canchas: Cancha, servicios: ServicioClub, postulaciones: PostulacionTorneo, encargados: Usuario]
	
	static mappedBy = [encargados: 'encargadoEn']
	
	
    static constraints = {
		nombre blank: false, unique: true, maxSize: 250
		telefono nullable: true, blank: false, maxSize: 100
		domicilio nullable: true
		sitioWeb nullable: true, blank: false, maxSize: 250
		correo nullable: true, email:true, blank: false, maxSize: 100
		validado nullable: false
		imagen nullable: true
    }
	
	String toString() {
		return nombre
	}
}
