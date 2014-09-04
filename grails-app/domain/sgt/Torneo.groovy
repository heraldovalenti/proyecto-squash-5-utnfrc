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
	Imagen imagen
	
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
		estado blank: false, inList:["Creado","Club Asignado",
			"Inscripcion Abierta","Inscripcion Cerrada","Inscripcion Finalizada",
			"Diagramado","En Curso","Finalizado", "Ranking Actualizado", "Suspendido"]
		imagen nullable: true
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
	
	def asignarClub(Club club) {
		if (this.estado.equals("Creado")) {
			this.club = club
			this.estado = "Club Asignado"
		}
	}
	
	def abrirInscripcion() {
		if (this.estado.equals("Creado") || this.estado.equals("Inscripcion Cerrada")) {
			this.estado = "Inscripcion Abierta"
		}
	}
	
	def cerrarInscripcion() {
		if (this.estado.equals("Inscripcion Abierta")) {
			this.estado = "Inscripcion Cerrada"
		}
	}
	
	def finalizarInscripcion() {
		if (this.estado.equals("Inscripcion Cerrada") || this.estado.equals("Inscripcion Abierta")) {
			this.estado = "Inscripcion Finalizada"
		}
	}
	
	def diagramar() {
		if (this.estado.equals("Inscripcion Finalizada")) {
			this.estado = "Diagramado"
		}
	}
	
	def comenzarTorneo() {
		if (this.estado.equals("Diagramado")) {
			this.estado = "En Curso"
		}
	}
	
	def finalizarTorneo() {
		if (this.estado.equals("En Curso")) {
			this.estado = "Finalizado"
		}
	}
	
	def actualizarRankings() {
		if (this.estado.equals("Finalizado")) {
			this.estado = "Ranking Actualizado"
		}
	}
	
	def suspender() {
		if (this.estado.equals("En Curso")) {
			this.estado = "Suspendido"
		}
	}
	
	Boolean creado() {
		return this.estado.equals("Creado")
	}
	
	Boolean esPostulable() {
		return this.creado() && !this.clubAsignado()
	}
	
	Boolean clubAsignado() {
		return this.club != null
	}
	
	Boolean inscripcionAbierta() {
		return this.estado.equals("Inscripcion Abierta")
	}
	
	Boolean inscripcionCerrada() {
		return this.estado.equals("Inscripcion Cerrada")
	}
	
	Boolean inscripcionFinalizada() {
		return this.estado.equals("Inscripcion Finalizada")
	}
	
	Boolean diagramado() {
		return this.estado.equals("Diagramado")
	}
	
	Boolean enCurso() {
		return this.estado.equals("En Curso")
	}
	
	Boolean finalizado() {
		return this.estado.equals("Finalizado")
	}
	
	Boolean rankingActualizado() {
		return this.estado.equals("Ranking Actualizado")
	}
	
	Boolean suspendido() {
		return this.estado.equals("Suspendido")
	}
}
	
	
