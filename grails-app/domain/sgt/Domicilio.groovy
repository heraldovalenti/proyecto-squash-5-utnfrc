package sgt

class Domicilio {
	
	String domicilio
	String piso
	String dpto
	String ciudad
	String ciudadOrigen
	String provincia
	Integer codPostal
	
	String toString(){
		return domicilio + " " + "(" + ciudad + ")"
	}

    static constraints = {
		
		piso blank:true
		dpto blank:true
		codPostal blank:true
		ciudadOrigen blank:true
		provincia inList:["Córdoba","Santa Fé","San Luis"]	
    }
}
