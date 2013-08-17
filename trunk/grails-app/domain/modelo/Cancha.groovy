package modelo

import modelo.Disponibilidad

class Cancha {

    Float ancho
	Float largo
    Boolean techo
    String tipoSuelo
    String paredes
	String nombre
	Disponibilidad disponibilidad
	
	static belongsTo = Club	
	
    static constraints = {
		ancho blank:false, min: 0.0f
		largo blank:false, min: 0.0f
		nombre blank:false, maxSize: 50
		tipoSuelo blank:false, inList:["Parquet","Cemento","Cesped","Carpeta"]
		disponibilidad nullable: false
    }
}
