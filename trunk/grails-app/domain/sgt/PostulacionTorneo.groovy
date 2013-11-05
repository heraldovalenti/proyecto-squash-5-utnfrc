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
	
	def void solicitar() {
		this.estado = "Solicitado"
	}
	
	def void rechazar() {
		this.estado = "Rechazado"
	}
	
	def void aceptar() {
		this.estado = "Aceptado"
	}
	
	def Boolean puedeCancelarse() {
		return this.estado.equals("Solicitado")
	}
}
