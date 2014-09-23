package sgt.exceptions;

public class UnregisteredClubException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String msg = "Deben registrarse los datos del club";
	
	@Override
	public String getMessage() {
		return msg;
	}
}
