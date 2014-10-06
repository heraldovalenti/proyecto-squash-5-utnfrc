package sgt.exceptions;

public class InscripcionTorneoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public static final String TORNEO_SIN_CATEGORIAS = "El torneo no tiene categorias asignadas";
	public static final String CUPO_LLENO = "Cupo maximo de categoria alcanzado";
	public static final String CATEGORIA_NO_PERMITIDA = "La categoria de jugador no permite la inscripcion al torneo";
	public static final String INSCRIPCION_CERRADA = "La inscripcion al torneo se encuentra cerrada";
	public static final String JUGADOR_INSCRIPTO = "Ya se encuentra inscripto al torneo";
	public static final String INSCRIPCION_NO_ENCONTRADA = "Inscripcion no encontrada";
	public static final String INSCRIPCION_NO_CANCELABLE = "La inscripcion ya no puede cancelarse";
	private String msg;
	
	public InscripcionTorneoException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
