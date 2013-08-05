package modelo.disponibilidadhoraria

class DisponibilidadHora {

	Date horaInicio
	Date horaFin
	
    static constraints = {
		horaInicio nullable: false
		horaFin nullable: false
    }
}
