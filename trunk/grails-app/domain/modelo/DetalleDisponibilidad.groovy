package modelo

class DetalleDisponibilidad {
	
	String dia
	Integer desde
	Integer hasta

    static constraints = {
		dia blank: false, inList:["Lu","Ma","Mi","Ju","Vi","Sa","Do"]
		desde range: 0..1439
		hasta range: 0..1439
		hasta validator: {
			if (it.hasta >= desde) return false
		}
		desde validator: {
			if (desde <= hasta) return false
		}
    }
}
