package sgt.exceptions;

public class TorneoNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String msg = "No se ha encontrado el torneo";
	
	@Override
	public String getMessage() {
		return msg;
	}
}
