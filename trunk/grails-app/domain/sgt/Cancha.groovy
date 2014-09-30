package sgt

import sgt.Disponibilidad;

class Cancha implements Comparable {

	Integer numero
	String nombre
	String tipoSuelo
    Boolean techada
	Disponibilidad disponibilidad
	
	static belongsTo = [club: Club]
	
    static constraints = {
		numero min: 1
		nombre blank: true, maxSize: 50
		tipoSuelo inList: ["Parquet","Cemento","Cesped","Carpeta","Otro"]
		disponibilidad nullable: true
    }
	
	@Override
	public int hashCode() {
		int res = (nombre != null) ? nombre.hashCode() : 0
		return res
	}
	
	@Override
	public String toString() {
		return numero + " - " + nombre
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Cancha)) {
			return false
		}
		Cancha other = obj
		return other.id == this.id
	}

	@Override
	public int compareTo(Object o) {
		Cancha other = o
		return this.numero - o.numero
	}
	
	
}
