package sgt

import sgt.Disponibilidad;

class Cancha {

	String nombre
	String tipoSuelo
    Float ancho
	Float largo
    Boolean techo
    String paredes
	Disponibilidad disponibilidad
	
	static belongsTo = Club	
	String toString() {
		return nombre
	}
	
    static constraints = {
		paredes nullable: true, blank: false
		techo nullable: true
		ancho nullable: true, min: 0.0f
		largo nullable: true, min: 0.0f
		nombre blank:false, maxSize: 50, nullable: false
		tipoSuelo blank:false, inList:["Parquet","Cemento","Cesped","Carpeta","Otro"]
		disponibilidad nullable: true
    }
}
