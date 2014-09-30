package sgt

import sgt.exceptions.UnregisteredClubException

class CanchaService {

	static transactional = true
	
    Cancha crearCancha(Club club) {
		int cantidadCanchas = (club.canchas != null) ? club.canchas.size() : 0
		int numeroCancha = cantidadCanchas + 1
		String nombreCancha = "Cancha " + numeroCancha
		Cancha res = new Cancha(numero: numeroCancha, nombre: nombreCancha,	techada: true)
		return res
    }
	
	def registrarCancha(Club club, Cancha cancha) {
		int cantidadCanchas = (club.canchas != null) ? club.canchas.size() : 0
		int numeroCancha = (cantidadCanchas + 1)
		cancha.numero = numeroCancha
		club.addToCanchas(cancha)
		club.save(failOnError: true)
	}
	
	def eliminarCancha(Club club, Cancha cancha) {
		club.removeFromCanchas(cancha)
		cancha.delete()
		def canchas = getCanchasClub(club)
		int numero = 0
		for (Cancha c : canchas) {
			numero++
			if (c.numero != numero) {
				c.numero = numero
				c.save()
			}
		}
	}
	
	def getCanchasClub(Club club) {
		if (club == null) {
			throw new UnregisteredClubException()
		}
		def canchas = new ArrayList(club.canchas)
		Collections.sort(canchas)
		return canchas
	}
	
	Cancha getCanchaClub(Club club, Cancha cancha) {
		ArrayList canchas = new ArrayList(club.canchas)
		def index = canchas.indexOf(cancha)
		if (index != -1) return canchas.get(index)
		else return null
	}
	
	def updateCancha(Cancha cancha) {
		cancha.save(failOnError: true)
	}
}
