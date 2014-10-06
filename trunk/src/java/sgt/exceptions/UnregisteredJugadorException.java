package sgt.exceptions;

public class UnregisteredJugadorException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public static final String msg = "Deben registrarse los datos del jugador";
	
	@Override
	public String getMessage() {
		return UnregisteredJugadorException.msg;
	}
}
