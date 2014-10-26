/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Matias
 */
public class Torneo {
    Club organizador;
    Partido[]enfrentamientos;
    DisponibilidadHoraria disponibilidadEnfrentamientos=new DisponibilidadHoraria();
    int dias=7,horas=16;
    ArrayList <HorarioCanchaPartido>[][] horarioDefinitivoTorneo;
    private int[][] matrizConteoClub;

    public Partido[] getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(Partido[] enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }

    public ArrayList<HorarioCanchaPartido>[][] getHorarioDefinitivoTorneo() {
        return horarioDefinitivoTorneo;
    }

    public void setHorarioDefinitivoTorneo(ArrayList<HorarioCanchaPartido>[][] horarioDefinitivoTorneo) {
        this.horarioDefinitivoTorneo = horarioDefinitivoTorneo;
    }

    public Torneo(){
        horarioDefinitivoTorneo= new ArrayList [horas][dias];
        matrizConteoClub= new int[horas][dias];
        for (ArrayList<HorarioCanchaPartido>[] horario : horarioDefinitivoTorneo) {
            for (ArrayList<HorarioCanchaPartido> horario1 : horario) {
                horario1 = new <HorarioCanchaPartido>ArrayList();
            }
        }
    }
    
    public Torneo(int horas,int dias,Club organizador,Partido[]enfrentamientos){
        this.horas=horas;
        this.dias=dias;
        this.organizador = organizador;
        this.enfrentamientos=enfrentamientos;
        horarioDefinitivoTorneo= new ArrayList [horas][dias];
        matrizConteoClub= new int[horas][dias];
        for (ArrayList<HorarioCanchaPartido>[] horario : horarioDefinitivoTorneo) {
            for (ArrayList<HorarioCanchaPartido> horario1 : horario) {
                horario1 = new <HorarioCanchaPartido>ArrayList();
            }
        }
    }
    
    

    public Torneo(Club organizador) {
        this.organizador = organizador;
        for (ArrayList<HorarioCanchaPartido>[] horario : horarioDefinitivoTorneo) {
            for (ArrayList<HorarioCanchaPartido> horario1 : horario) {
                horario1 = new <HorarioCanchaPartido>ArrayList();
            }
        }
    }

    public Club getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Club organizador) {
        this.organizador = organizador;
    }
    
    public void generarDiagramacion(){
        generarDisponibilidadEnfrentamientos();
        generarDisponibilidadEnfrentamientosEnCanchas();
        generarMatrizConteo();
        generarHorarioTorneo();
    }
    
    //1 genera enfrentamientos en los horarios (toda la semana)
    public void generarDisponibilidadEnfrentamientos(){
        for (Partido enfrentamiento : enfrentamientos) {
            enfrentamiento.generarDisponibilidadPartido();
            disponibilidadEnfrentamientos.add(enfrentamiento.getDisponibilidadHoraria());
        }
    }
    
    //2 saca los enfrentamientos en los que no hay canchas disponibles (toda la semana)
    public void generarDisponibilidadEnfrentamientosEnCanchas(){
        boolean[][] matrizVerdadClub=organizador.disponibilidadHoraria.generarMatrizVerdad();
        for(int i = 0; i < matrizVerdadClub.length; i++){ 
            for (int j = 0; j < matrizVerdadClub[i].length; j++) {
                 if(!matrizVerdadClub[i][j]){ 
                     if(!disponibilidadEnfrentamientos.getHorarios()[i][j].isEmpty())disponibilidadEnfrentamientos.getHorarios()[i][j].removeAll(disponibilidadEnfrentamientos.getHorarios()[i][j]);
                     for (Partido enfrentamiento : enfrentamientos) {
                        enfrentamiento.generarDisponibilidadPartido();
                        if(!enfrentamiento.disponibilidadHoraria.getHorarios()[i][j].isEmpty())enfrentamiento.disponibilidadHoraria.getHorarios()[i][j].removeAll(enfrentamiento.disponibilidadHoraria.getHorarios()[i][j]);
                     }
                 }
            }
        }
    }
    
    //3 genera la cantidad de canchas disponibles por horario
    public void generarMatrizConteo(){
        boolean[][] matrizVerdadTorneo=disponibilidadEnfrentamientos.generarMatrizVerdad();
        for(int i = 0; i < matrizVerdadTorneo.length; i++){ 
            for (int j = 0; j < matrizVerdadTorneo[i].length; j++) {
                 if(matrizVerdadTorneo[i][j]){ 
                     matrizConteoClub[i][j]=organizador.disponibilidadHoraria.getHorarios()[i][j].size();
                 }
            }
        }
    }
    
    //resta contador de canchas, si es cero no hay mas canchas disponibles en eso horario y cambia la matriz de verdad del club
    public void tomarCancha(int i,int j){
        matrizConteoClub[i][j]--;
        if(matrizConteoClub[i][j]==0){
            organizador.disponibilidadHoraria.getMatrizVerdad()[i][j]=false;
            sacarHorarioEnPartidos(i, j);
        }
    }
    
    //quita el horario en los partidos, si es cero no hay mas canchas disponibles en eso horario saca el horario de los partidos
    public void sacarHorarioEnPartidos(int i,int j){
        for (Partido enfrentamiento : enfrentamientos) {
            ArrayList<Horario> arregloHorario = enfrentamiento.getDisponibilidadHoraria().getHorarios()[i][j];
            if (!arregloHorario.isEmpty()) {
                arregloHorario.removeAll(arregloHorario);
            }
        }
    }
    
    /**
     * obtenemos la posicion en el array del enfrentamiento con menor disp horaria
     * @return 
     */
    public int obtenerPosEnfrentamientoMenorDisponibilidad()
    {
        int pos=0;
        Partido menor=enfrentamientos[pos];
        for(int i=1;i<enfrentamientos.length;i++) {
            if ((!enfrentamientos[i].isAsignado())&&enfrentamientos[i].getDisponibilidadHoraria().compareTo(menor.getDisponibilidadHoraria())<0) {
                menor=enfrentamientos[i];
                pos=i;
            }
        }
        if(enfrentamientos[pos].getDisponibilidadHoraria().contarDisponibilidades()==0)
        {
            return -1;
        }
        return pos;
    }
    
    public void eliminarHorariosEnfrentamiento(Partido p){
        
        boolean[][]matrizVerdadPartido=p.getDisponibilidadHoraria().generarMatrizVerdad();
        this.disponibilidadEnfrentamientos.eliminarHorariosEnfrentamiento(matrizVerdadPartido, p);
    }
        
    
    public void generarHorarioTorneo(){
        int pos=obtenerPosEnfrentamientoMenorDisponibilidad();
        while(pos>=0){
            enfrentamientos[pos].setAsignado(true);
            DisponibilidadHoraria horario=enfrentamientos[pos].getDisponibilidadHoraria();
            boolean[][]matrizVerdadPartido=horario.generarMatrizVerdad();
            
            ArrayList <Horario> h=disponibilidadEnfrentamientos.obtenerHorarioMenorDisponiblidad(matrizVerdadPartido );
            int hora=h.get(0).getHoraInicio();
            int diaSemana=h.get(0).getOrdenDia();
            
            ArrayList<Horario> horarioCanchas=organizador.getDisponibilidadHoraria().getHorarios()[hora][diaSemana];
            Cancha canchaAsignada=(Cancha)horarioCanchas.remove(0).getElementoDisponibilidad();
            HorarioCanchaPartido horarioDefinitivo=new HorarioCanchaPartido(hora,diaSemana,canchaAsignada,enfrentamientos[pos]);
            
            tomarCancha(hora,diaSemana);
            eliminarHorariosEnfrentamiento(enfrentamientos[pos]);
            
            horarioDefinitivoTorneo[hora][diaSemana].add(horarioDefinitivo);
            pos=obtenerPosEnfrentamientoMenorDisponibilidad();
        }
    }
}
