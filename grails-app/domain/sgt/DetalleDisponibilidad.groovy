package sgt

class DetalleDisponibilidad {
	
	String dia
	Integer hora
	
	
	static belongsTo = Disponibilidad
	
	String toString() {
		return dia + "--" + hora
	}

    static constraints = {
		dia blank: false
		hora blank:false
		hora range: 8..23
    }
}
