package sgt

class CategoriaJugador {
	
	Categoria categoria
	String descripcion
	String estado
	Date fechaInicio
	Date fechaFin

    static constraints = {
		categoria nullable: false
		descripcion nullable: false, blank: false, maxSize: 250
		estado nullable: false, blank: false, inList: ["Solicitada","Anulada","Asignada","De baja"]
		fechaInicio nullable: false
		fechaFin nullable: true
    }
	
	def boolean esAsignada() {
		if (this.estado.equals("Asignada")) return true
		return false
	}
	
	def boolean esSolicitada() {
		if (this.estado.equals("Solicitada")) return true
		return false
	}
	
	def void anular() {
		if (this.estado.equals("Solicitada")) this.estado = "Anulada"
	}
	
	def void darBaja() {
		if (this.estado.equals("Asignada")) this.estado = "De baja"
	}
	
	def void asignar() {
		if (this.estado.equals("Solicitada")) this.estado = "Asignada"
	}
	
	def void solicitar() {
		if (!this.estado) this.estado = "Solicitada"
	}
}
