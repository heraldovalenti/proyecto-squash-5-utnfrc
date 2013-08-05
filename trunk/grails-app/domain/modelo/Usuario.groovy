package modelo

import modelo.disponibilidadhoraria.DisponibilidadHoraria

class Usuario {

    Persona persona
    String nombreUsuario
    String password
	String correo
    Boolean activo
	DisponibilidadHoraria disponibilidad
	
	static hasMany = [roles: Rol]

    static constraints = {
		nombreUsuario blank:false, unique:true, minSize:6, maxSize:25
		password blank:false, minSize:6, maxSize:50, password:true
		correo blank:false, email:true, unique:true
		disponibilidad nullable: true
		persona nullable:true
    }
	
	String toString() {
		return nombreUsuario
	}
}
