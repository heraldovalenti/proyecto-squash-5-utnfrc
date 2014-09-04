package sgt

class Domicilio {
	
	String calle
	String numero
	String piso
	String departamento
	String ciudad
	Integer codigoPostal
	String provincia

    static constraints = {
		calle blank: false
		numero blank: false
		piso nullable: true
		departamento nullable: true
		ciudad blank: false
		codigoPostal min: 0
		provincia blank: false, inList:["Cordoba","Santa Fe","San Luis",
			"Mendoza","Buenos Aires","La Pampa","Santiago del Estero",
			"San Juan","Catamarca","Salta","Tucuman","La Rioja","Formosa",
			"Entre Rios","Corrientes","Misiones","Rio Negro","Chubut",
			"Santa Cruz","Tierra del Fuego","Neuquen","Chaco","Jujuy"]
    }
	
	String toString(){
		return calle + " " + numero +  "(" + ciudad + ")"
	}
}
