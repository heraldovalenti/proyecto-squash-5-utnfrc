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
		persona nullable: true
		jugador nullable: true
		club nullable: true
		encargadoEn nullable: true
    }
	
	def CategoriaJugador getCategoriaActual() {
		def Iterator<CategoriaJugador> categoriaJugadorIterator = this.categoriasJugador.iterator()
		while (categoriaJugadorIterator.hasNext()) {
			def CategoriaJugador aux = categoriaJugadorIterator.next()
			if (aux.esAsignada()) {
				return aux
			}
		}
		return null
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
}
