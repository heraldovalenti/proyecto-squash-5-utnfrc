package sgt;

public class SolicitudCategoria {
	
	private Long idCategoriaJugador;
	private Long idUsuario;
	private String usuario;
	private String apellido;
	private String nombre;
	private String actual;
	private String solicitada;
	
	public SolicitudCategoria() {
	}
	
	public SolicitudCategoria(Long idCategoriaJugador, Long idUsuario,
			String usuario, String apellido, String nombre,
			String actual, String solicitada) {
		this.idCategoriaJugador = idCategoriaJugador;
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.apellido = apellido;
		this.nombre = nombre;
		this.actual = actual;
		this.solicitada = solicitada;
	}
	
	public Long getIdCategoriaJugador() {
		return idCategoriaJugador;
	}
	public void setIdCategoriaJugador(Long idCategoriaJugador) {
		this.idCategoriaJugador = idCategoriaJugador;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public String getSolicitada() {
		return solicitada;
	}
	public void setSolicitada(String solicitada) {
		this.solicitada = solicitada;
	}

}
