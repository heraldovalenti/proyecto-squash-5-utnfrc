package modelo

class Categoria {
	
	String nombre
	String descripcion
	String modalidadCategoria
	
	String toString()
	{
		return nombre
	}

    static constraints = {
		nombre blank: false, unique: true, maxSize: 50
		descripcion blank: false, maxSize: 250
		modalidadCategoria blank: false, inList: ["Masculino", "Femenino", "Doble Masculino", "Doble Femenino", "Doble Mixto"]
		
    }
}
