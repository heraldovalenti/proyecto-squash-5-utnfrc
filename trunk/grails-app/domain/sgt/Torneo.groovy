package sgt

import com.sun.istack.internal.Nullable;

class Torneo {
	
	String nombre
	Date fechaAlta
	Date fechaInicioTorneo
	Date fechaFinTorneo
	Date fechaInicioInscripcion
	Date fechaFinInscripcion
	String estado
	Club club
	Boolean puntuable
	
	static hasMany = [detalles: DetalleTorneo]
	
	static belongsTo = [torneoPuntuable: TorneoPuntuable]
	
	String toString()
	{
		return nombre
	}

    static constraints = {
		torneoPuntuable nullable: true
		nombre blank: false, maxSize: 150
		fechaAlta nullable: false
		fechaInicioInscripcion nullable: false
		fechaFinInscripcion nullable: false
		fechaInicioTorneo nullable: false
		fechaFinTorneo nullable: false	
		club nullable:true
		estado blank: false, inList:["Creado","Inscripcion Abierta","Inscripcion Cerrada",
			"Diagramado","En Curso","Finalizado", "Ranking Actualizado"]
    }
	
	def Boolean esPostulable() {
		if (club == null) return true
		if (this.creado() || this.inscripcionAbierta() || this.inscripcionCerrada()) {
			return true
		}
		return false
	}
	
	def String fechasCorrectas() {
		def Date open = this.fechaInicioInscripcion
		def Date close = this.fechaFinInscripcion
		def Date init = this.fechaInicioTorneo
		def Date finish = this.fechaFinTorneo
		
		//cierre de insripcion antes que la apertura
		if (open.after(close)) {
			return "El cierre de inscripcion debe estar despues de la apertura"
		}
		
		//fin de torneo antes que el inicio
		if (init.after(finish)) {
			return "El fin del torneo debe estar despues que el inicio"
		}
		
		//solapamiento entre periodo de insripcion y periodo de juego
		if (close.after(init)) {
			return "El periodo de insripcion no debe coincidir con el periodo de juego del torneo"
		}
		
		//apertura y cierre de inscripcion el mismo dia
		if (open.equals(close)) {
			return "Debe haber al menos un dia entre la apertura y el cierre de inscripcion"
		}
		
		//cierre de insripcion e inicio del torneo el mismo dia
		if (close.equals(init)) {
			return "Debe haber al menos un dia entre el cierre de inscripcion y el inicio del torneo"
		}
		
		return null
	}
	
	def void abrirInscripcion() {
		if (this.estado.equals("Creado") || this.estado.equals("Inscripcion Cerrada")) {
			this.estado = "Inscripcion Abierta"
		}
	}
	
	def void cerrarInscripcion() {
		if (this.estado.equals("Inscripcion Abierta")) {
			this.estado = "Inscripcion Cerrada"
		}
	}
	
	def Boolean inscripcionAbierta() {
		if (this.estado.equals("Inscripcion Abierta")) return true
		else return false
	}
	
	def Boolean inscripcionCerrada() {
		if (this.estado.equals("Inscripcion Cerrada")) return true
		else return false
	}
	
	def Boolean creado() {
		if (this.estado.equals("Creado")) return true
		else return false
	}
	
	def Boolean diagramado() {
		if (this.estado.equals("Diagramado")) return true
		else return false
	}
	
}
	
	
