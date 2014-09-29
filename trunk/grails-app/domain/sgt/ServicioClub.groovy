package sgt

class ServicioClub {
	
	String nombre

    static constraints = {
		nombre blank: false, maxSize: 50, inList: ["Sanitarios","Cantina",
			"Restaurant","Estacionamiento","Guarderia","Lockers","Duchas",
			"Kiosko","Sport shopping", "Tienda de recuerdos"]
    }
	
	@Override
	public int hashCode() {
		return nombre.hashCode()
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ServicioClub)) {
			return false
		}
		ServicioClub other = o;
		return this.nombre.equals(other.nombre)
	}
}