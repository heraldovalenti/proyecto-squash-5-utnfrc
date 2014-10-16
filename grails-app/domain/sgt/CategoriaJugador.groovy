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
		estado inList: ["Solicitada","Rechazada","Asignada","De baja"]
		fechaFin nullable: true
    }
	
	boolean esAsignada() {
		if (this.estado.equals("Asignada")) return true
		return false
	}
	
	boolean esSolicitada() {
		if (this.estado.equals("Solicitada")) return true
		return false
	}
	
	void denegar() {
		if (this.estado.equals("Solicitada")) this.estado = "Rechazada"
	}
	
	void darBaja() {
		if (this.estado.equals("Asignada")) {
			this.estado = "De baja"
			this.fechaFin = new Date()
		}
	}
	
	void asignar() {
		if (this.estado.equals("Solicitada")) {
			this.estado = "Asignada"
			this.fechaInicio = new Date()
			this.fechaFin = null
		}
	}
	
	void solicitar() {
		if (!this.estado) this.estado = "Solicitada"
	}
}
