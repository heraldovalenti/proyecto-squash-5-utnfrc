/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;

/**
 *
 * @author Matias
 */
public class Diagramacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
            
    /**
     * 
     * @param elemento (cancha - partido - jugador)
     * @param horario el horario de lunes a domingo
     * @param horas las horas del dia
     * @param dias la cant de dias a evaluar
     * @param diaComienzo 0 lunes - 1 martes -2 mierc- 3 jue - 4 vie - 5 sab - 6 dom
     * @return La Disponibilidad Horaria de ese elemento repartido en los dias a evaluar
     */
    public DisponibilidadHoraria cargarHorarioDisponibilidad(IDisponible elemento,boolean[][] horario,int horas, int dias,int diaComienzo)
    {
        DisponibilidadHoraria disponibilidad=cargarDisponibilidad( horas, dias);
        for (int i=0;i<horas;i++){
            for (int j=0;j<dias;j++){
                if(diaComienzo==7)diaComienzo=0;
                if(horario[i][diaComienzo])disponibilidad.cargarHorario(elemento, i, j);
                diaComienzo++;
            }
        }
        return disponibilidad;
        
    }
    
    public DisponibilidadHoraria cargarDisponibilidad(int horas, int dias){
        DisponibilidadHoraria disponibilidad=new DisponibilidadHoraria(horas,dias);
        return disponibilidad;
    }
    
    public void cargarJugador(Jugador j, DisponibilidadHoraria disponibilidad,int pos)
    {
        j.setDisponibilidadHoraria(disponibilidad);
        j.setPos(pos);
    }
    
    public Partido cargarPartido(Jugador jugador1, Jugador jugador2)
    {
        Partido j=  new Partido( jugador1, jugador2) ;
        j.generarDisponibilidadPartido();
        return j;
    }
    
    public void cargarCancha(Cancha c, DisponibilidadHoraria disponibilidad)
    {
        c.setDisponibilidadHoraria(disponibilidad);
    }
    
    public Club cargarClub (Cancha[] c){
        Club j= new Club();
        j.setCanchas(c);
        j.generarDisponibilidadPartido();
        return j;
    }
   
    
    public Torneo cargarTorneo(int horas,int dias,Club organizador,Partido[]enfrentamientos){
        return new Torneo(horas,dias,organizador,enfrentamientos);
    }
    
    /**
     * 
     * @param horas cantidad de horas a generar de diagramacion, ej: de 9:00 a 10:00 -> 1, de 9:00 a 12:00 -> 3.
     * @param dias cantidad de dias de duracion del torneo.
     * @param organizador el club del torneo con sus canchas adentro y respectivos horarios
     * @param enfrentamientos partidos del torneo a diagramarse con los jugadores y respectivos horarios.
     */
    public ArrayList<HorarioCanchaPartido>[][] generarDiagramacion(int horas,int dias,Club organizador,Partido[]enfrentamientos){
        Torneo torneo= cargarTorneo(horas,dias,organizador,enfrentamientos);
        torneo.generarDiagramacion();
        return torneo.getHorarioDefinitivoTorneo();//guardarlo para mostrar
    }
    
}
