package sgt.exceptions;

public class EstadoTorneoException extends Exception{
	private static final long serialVersionUID = 1L;
	private static final String msg = "El torneo no ha finalizado";
	
	@Override
	public String getMessage() {
		return msg;
	}

}
