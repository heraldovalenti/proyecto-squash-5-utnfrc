package sgt

class TorneoPuntuable {
	
	String nombre
	Date inicio
	Date fin
	Integer ordenAnual
	Puntaje puntajeTorneo
	
	static hasMany = [instanciasTorneo: Torneo]

    static constraints = {
    }
}
