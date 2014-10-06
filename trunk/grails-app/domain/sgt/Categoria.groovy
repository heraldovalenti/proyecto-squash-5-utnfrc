package sgt

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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Categoria)) return false
		Categoria other = obj
		if (this.nombre == null || this.modalidadCategoria == null) return false
		return ( this.nombre.equals(other.nombre) && this.modalidadCategoria.equals(other.modalidadCategoria) )
	}
}
