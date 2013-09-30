package sgt

import sgt.Disponibilidad;

class Usuario {

    String nombreUsuario
    String password
	String correo
    Boolean activo
	Disponibilidad disponibilidad
	Categoria categoria
	Persona persona
	Jugador jugador
	Domicilio domicilio
	
	String toString()
	{
		return persona.toString()
	}
		
	static hasMany = [roles: Rol, rankings: Ranking]
	
    static constraints = {
		nombreUsuario blank:false, unique:true, minSize:6, maxSize:25
		password blank:false, minSize:6, maxSize:50, password:true
		correo blank:false, email:true, unique:true
		disponibilidad nullable: true
		persona nullable: true
		jugador nullable: true
		categoria nullable: true
		domicilio nullable: true
    }
	
	
}
