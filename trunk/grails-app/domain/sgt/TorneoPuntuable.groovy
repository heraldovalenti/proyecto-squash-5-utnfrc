package sgt

class TorneoPuntuable {
	
	String nombre
	Integer ordenAnual
	Boolean activo
	
	static hasMany = [instanciasTorneo: Torneo, puntajes: Puntaje]
	
	String toString()
	{
		return nombre
	}

    static constraints = {
		nombre blank: false, maxSize: 250
		ordenAnual nullable:true, min: 0
		activo nullable: false
    }
}
