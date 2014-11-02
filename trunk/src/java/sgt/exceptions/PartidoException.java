package sgt.exceptions;

public class PartidoException extends Exception {
	
	public static final String PARTIDO_FINALIZADO = "El partido se encuentra finalizado";
	
	private String msg;
	private static final long serialVersionUID = 1L;
	
	public PartidoException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}

}
