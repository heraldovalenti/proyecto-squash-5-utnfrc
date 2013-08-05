package modelo

class Categoria {
	
	String nombre
	String descripcion
	String modalidadCategoria

    static constraints = {
		nombre blank: false, unique: true, maxSize: 50
		descripcion blank: false, maxSize: 250
		modalidadCategoria blank: false, inList: ["Masculino", "Femenino",
			"Doble Masculino", "Doble Femenino", "Doble Mixto"]
    }
	
	String toString() {
		return nombre
	}
}
