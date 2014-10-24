package sgt

import sgt.Disponibilidad;
import sgt.CategoriaJugador;

class Usuario {

    String nombreUsuario
    String password
	String correo
    Boolean activo
	Persona persona
	Jugador jugador
	Club club
	Rol rol
	Club encargadoEn
	
    static constraints = {
		nombreUsuario blank:false, unique:true, minSize:6, maxSize:25
		password blank:false, minSize:6, maxSize:50, password:true
		correo blank:false, email:true, unique:true
		persona nullable: true, editable: false
		jugador nullable: true, editable: false
		club nullable: true, editable: false
		encargadoEn nullable: true, editable: false
    }
	
	def Integer puestoRanking(Categoria categoria) {
		def c = Ranking.createCriteria()
		def Ranking ranking = c.get() {
			eq("categoria", categoria)
			and {
				eq("usuario", this)
			}
		}
		
		if (ranking) {
			return ranking.puesto
		}
		
		return 0
	}
	
	Boolean esClub() {
		Rol r = Rol.findByNombre("Club")
		return rol.equals(r)
	}
	
	Boolean esJugador() {
		Rol r = Rol.findByNombre("Jugador")
		return rol.equals(r)
	}
	
	Boolean esEncargado() {
		Rol r = Rol.findByNombre("Encargado club")
		return rol.equals(r)
	}
	
	Boolean esAdministrador() {
		Rol r = Rol.findByNombre("Administrador")
		return rol.equals(r)
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Usuario)) return false
		if (obj == null) return false
		Usuario other = obj
		return this.nombreUsuario.equals(other.nombreUsuario)
	}
	
	@Override
	public String toString() {
		if(persona!=null)
			return persona.toString();
	}
}
