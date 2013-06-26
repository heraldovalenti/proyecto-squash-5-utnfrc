package modelo

class Torneo {
	
	String nombre
	Date fechaAlta
	Date fechaInicioInscripcion
	Date fechaFinInscripcion
	Date fechaInicioTorneo
	Date fechaFinTorneo
	Categoria categoria
	String estado //puede ser implementado con una clase de java y patron State
	Integer cupoMaximo
	Boolean puntuable
	
	String toString()
	{
		return nombre
	}

    static constraints = {
		nombre blank: false, maxSize: 150
		fechaAlta nullable: false
		fechaInicioInscripcion nullable: false
		fechaFinInscripcion nullable: false
		fechaInicioTorneo nullable: false
		fechaFinTorneo nullable: false
		categoria nullable: false
		estado blank: false
		cupoMaximo min: 2		
    }
}
