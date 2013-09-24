package sgt

class TorneoPuntuable {
	
	String nombre
	Integer ordenAnual
	Puntaje puntajeTorneo
	Boolean activo
	
	static hasMany = [instanciasTorneo: Torneo]

    static constraints = {
		nombre blank: false, maxSize: 250
		puntajeTorneo nullable: true
		ordenAnual nullable:true, min: 0
		activo nullable: false
    }
}
