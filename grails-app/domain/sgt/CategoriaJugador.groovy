package sgt

class CategoriaJugador {
	
	Categoria categoria
	String descripcion
	String estado
	Date fechaInicio
	Date fechaFin
	
	static belongsTo = [jugador: Jugador]

    static constraints = {
		descripcion nullable: true, maxSize: 250
		estado inList: ["Solicitada","Anulada","Asignada","De baja"]
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
		if (this.estado.equals("Asignada")) {
			this.estado = "De baja"
			this.fechaFin = new Date()
		}
	}
	
	def void asignar() {
		if (this.estado.equals("Solicitada")) {
			this.estado = "Asignada"
			this.fechaInicio = new Date()
			this.fechaFin = null
		}
	}
	
	def void solicitar() {
		if (!this.estado) this.estado = "Solicitada"
	}
}
