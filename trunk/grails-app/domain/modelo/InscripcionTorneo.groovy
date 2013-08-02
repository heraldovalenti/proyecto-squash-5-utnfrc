package modelo


class InscripcionTorneo {

		Torneo torneo
		Date fechaInscripcion
		boolean inscripto
   
	
	String toString()
	{
		return torneo +" "+inscripto
	}

	static constraints = {
		torneo Nullable:false		
	}
}
