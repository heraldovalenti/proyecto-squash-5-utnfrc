package modelo

class Inscripcion {
	
	Date fechaInscripcion
	Usuario usuario
	Torneo torneo 
	String registroMedico
	Float pagoTorneo
	String estado
	

    static constraints = {
		
		
		usuario nullable: false
		torneo nullable: false
		fechaInscripcion nullable: false
		pagoTorneo nullable: false, min: 0.0f 
		
    }
}
