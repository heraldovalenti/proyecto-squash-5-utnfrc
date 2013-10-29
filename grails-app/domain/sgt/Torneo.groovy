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
	
	String toString()
	{
		return nombre + " " + fechaInicioTorneo.getYear()
	}

    static constraints = {
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
	
	def String fechasCorrectas() {
		def Calendar open = new GregorianCalendar()
		open.setTime(this.fechaInicioInscripcion)
		
		def Calendar close = new GregorianCalendar()
		close.setTime(this.fechaFinInscripcion)
		
		def Calendar init = new GregorianCalendar()
		init.setTime(this.fechaInicioTorneo)
		
		def Calendar finish = new GregorianCalendar()
		finish.setTime(this.fechaFinTorneo)
		
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
		if (Math.abs(open.getTime() - close.getTime()) < (24 * 60 * 60 * 1000)) {
		//if (open.YEAR == close.YEAR && open.DAY_OF_YEAR == close.DAY_OF_YEAR) {
			return "Debe haber al menos un dia entre la apertura y el cierre de inscripcion"
		}
		
		//cierre de insripcion e inicio del torneo el mismo dia
		if (Math.abs(close.getTime() - init.getTime()) < (24 * 60 * 60 * 1000)) {
		//if (close.YEAR == init.YEAR && close.DAY_OF_YEAR == init.DAY_OF_YEAR) {
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
	
}
	
	
