package modelo.disponibilidadhoraria

class DisponibilidadDia {
	
	String dia

	static hasMany = [disponibilidades: DisponibilidadHora]
	
    static constraints = {
		dia blank: false, inList:["Lun","Mar","Mie","Jue","Vie","Sab","Dom"]
    }
}
