package sgt

import sgt.Disponibilidad;

class Usuario {

    String nombreUsuario
    String password
	String correo
    Boolean activo
	Disponibilidad disponibilidad
	Persona persona
	
	static hasMany = [roles: Rol]
	
    static constraints = {
		nombreUsuario blank:false, unique:true, minSize:6, maxSize:25
		password blank:false, minSize:6, maxSize:50, password:true
		correo blank:false, email:true, unique:true
		disponibilidad nullable: true
		persona nullable: true
    }
	
	
}
