package sgt

class DetalleDisponibilidad {
	
	String dia
	Integer desde
	Integer hasta
	
	static belongsTo = Disponibilidad

    static constraints = {
		dia blank: false, inList:["Lu","Ma","Mi","Ju","Vi","Sa","Do"]
		desde range: 0..1439, validator: { val, obj ->
			obj.desde < obj.hasta
		}
		hasta range: 0..1439
    }
}
