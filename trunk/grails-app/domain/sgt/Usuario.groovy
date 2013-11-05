package sgt

import sgt.Disponibilidad;
import sgt.CategoriaJugador;

class Usuario {

    String nombreUsuario
    String password
	String correo
    Boolean activo
	Disponibilidad disponibilidad
	Persona persona
	Jugador jugador
	Domicilio domicilio
	Club club
		
	static hasMany = [roles: Rol, rankings: Ranking, categoriasJugador: CategoriaJugador]
	
    static constraints = {
		nombreUsuario blank:false, unique:true, minSize:6, maxSize:25
		password blank:false, minSize:6, maxSize:50, password:true
		correo blank:false, email:true, unique:true
		disponibilidad nullable: true
		persona nullable: true
		jugador nullable: true
		domicilio nullable: true
		club nullable: true
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
}
