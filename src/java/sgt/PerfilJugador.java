package sgt;

import java.util.Date;
import java.util.Calendar;

public class PerfilJugador {
	
	private String apellido;
	private String nombre;
	private Integer edad;
	private Date fechaNacimiento;
	private String brazo;
	private String lugarNacimiento;
	private String residencia;
	private Double peso;
	private Double altura;
	private Date juegaDesde;
	private String imagenPerfil;
	
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getImagenPerfil() {
		return imagenPerfil;
	}
	public void setImagenPerfil(String imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
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
	public Integer getEdad() {
		if (this.fechaNacimiento == null) return null;
		
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.setTime(this.fechaNacimiento);
		
		int ano = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        //Se ajusta el ano dependiendo el mes y el dia
        if(mes<0 || (mes==0 && dia<0)){
            ano--;
        }
		
		return new Integer(ano);
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getBrazo() {
		return brazo;
	}
	public void setBrazo(String brazo) {
		this.brazo = brazo;
	}
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	public String getResidencia() {
		return residencia;
	}
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Date getJuegaDesde() {
		return juegaDesde;
	}
	public void setJuegaDesde(Date juegaDesde) {
		this.juegaDesde = juegaDesde;
	}

}
