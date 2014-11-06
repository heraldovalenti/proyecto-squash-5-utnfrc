/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author Matias
 */
public class HorarioCanchaPartido {

    int horaInicio,diaSemana;
    Cancha cancha;
    Partido partido;
    public HorarioCanchaPartido() {
    }

    public HorarioCanchaPartido(int horaInicio, int diaSemana, Cancha cancha, Partido partido) {
        this.horaInicio = horaInicio;
        this.diaSemana = diaSemana;
        this.cancha = cancha;
        this.partido = partido;
    }

    
    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
    public String toString(){
    	return "Partido:"+this.partido.getId()+" Hora="+this.horaInicio+"- dia="+this.diaSemana;
    }
    

    
    
}
