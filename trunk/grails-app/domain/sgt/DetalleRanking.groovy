package sgt

class DetalleRanking {
	
	TorneoPuntuable torneoPuntuable
	Torneo torneo
	Integer posicionTorneo
	Double puntos
	Date desde
	Date hasta
	
	static belongsTo = [ranking: Ranking]

    static constraints = {
		hasta nullable: true
    }
}
