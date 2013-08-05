package modelo.disponibilidadhoraria

class DisponibilidadHoraria {
	
	static hasMany = [disponibilidades: DisponibilidadDia]

    static constraints = {
    }
}
