package sgt.exceptions;

public class RankingException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String GENERACION_RANKING_NO_PERMITIDA = "El estado del torneo no permite la generacion de ranking";
	public static final String TORNEO_NO_PUNTUABLE = "El torneo no es un torneo puntuable";

	private String msg;
	
	public RankingException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
	
}
