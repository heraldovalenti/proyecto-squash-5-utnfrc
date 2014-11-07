package sgt

class Permiso {

	String controller
	String action
	String mode
	
	static mappedBy = [roles: 'permisos']

	static constraints = {
		controller blank: false, maxSize: 25
		action blank: false, maxSize: 25
		mode blank: false, inList: ["A","D"]
	}
	
	@Override
	public String toString() {
		return controller + " - " + action + ": " + mode
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Permiso)) return false
		Permiso other = obj
		return ( this.controller.equals(other.controller) 
			&& this.action.equals(other.action) 
			&& this.mode.equals(other.mode) ) 
	}
	
	public boolean allowed() {
		return "A".equals(this.mode)
	}
	
	public boolean matched(String _controller, String _action) {
		return ( 
			this.controller.equalsIgnoreCase(_controller) 
			&& ( this.action.equalsIgnoreCase(_action) || this.action.equalsIgnoreCase("*") ))
	}
}