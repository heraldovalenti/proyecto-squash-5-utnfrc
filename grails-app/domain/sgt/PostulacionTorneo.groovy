package sgt

class PostulacionTorneo {
	
	Torneo torneo
	Date fecha
	String observaciones
	String estado
	
	static belongsTo = [club: Club]

    static constraints = {
		torneo nullable: false
		fecha nullable: false
		observaciones nullable:true, blank: false, maxSize: 250
		estado nullable: false, blank: false, inList: ["Solicitado","Aceptado","Rechazado"]
		club nullable: false
    }
	
	def solicitar() {
		this.estado = "Solicitado"
	}
	
	def rechazar() {
		this.estado = "Rechazado"
	}
	
	def aceptar() {
		this.estado = "Aceptado"
	}
	
	Boolean puedeCancelarse() {
		return this.estado.equals("Solicitado")
	}
	
	Boolean esPendiente() {
		return this.estado.equals("Solicitado")
	}
	
	Boolean esAceptada() {
		return this.estado.equals("Aceptado")
	}
	
	Boolean esRechazada() {
		return this.estado.equals("Rechazado")
	}
}
