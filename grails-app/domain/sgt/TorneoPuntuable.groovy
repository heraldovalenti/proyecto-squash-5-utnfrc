package sgt

class TorneoPuntuable {
	
	String nombre
	Date inicio
	Date fin
	Integer ordenAnual
	Puntaje puntajeTorneo
	Boolean activo
	
	static hasMany = [instanciasTorneo: Torneo]

    static constraints = {
		puntajeTorneo nullable: true
		ordenAnual min: 0
		inicio validator: { val, obj ->
			return ( ( obj.fin.getTime() - obj.inicio.getTime() ) > 0)
		}
    }
}
