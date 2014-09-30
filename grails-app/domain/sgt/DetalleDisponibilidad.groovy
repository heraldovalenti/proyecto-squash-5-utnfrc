package sgt

class DetalleDisponibilidad {
	
	String dia
	Integer hora
	
	static belongsTo = [disponibilidad: Disponibilidad]
	
	String toString() {
		return dia + "--" + hora
	}

    static constraints = {
		dia blank: false
		hora blank:false
		hora range: 8..23
    }
}
