package sgt.exceptions;

public class DiagramacionException extends Exception {

	private String msg;
	private static final long serialVersionUID = 1L;
	public static final String DIAGRAMACION_NO_PERMITIDA = "El estado del torneo no permite diagramacion";
	public static final String TORNEO_SIN_CLUB = "El torneo no tiene un club asignado";
	public static final String CLUB_SIN_CANCHAS = "El club asignado no tiene canchas disponibles";

	public DiagramacionException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
	
}
