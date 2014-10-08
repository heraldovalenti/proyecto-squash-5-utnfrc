package sgt.exceptions;

public class PersonaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	public static final String SIN_DATOS_PERSONALES = "Deben registrarse los datos personales";
	
	public PersonaException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
}
