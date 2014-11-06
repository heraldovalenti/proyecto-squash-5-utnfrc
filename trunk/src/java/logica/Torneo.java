/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
    private int[][] matrizConteoEnfrentamientos;

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
        matrizConteoEnfrentamientos= new int[horas][dias];
        for(int i = 0; i < horarioDefinitivoTorneo.length; i++) {
        	for (int j = 0; j < horarioDefinitivoTorneo[i].length; j++) {
        		horarioDefinitivoTorneo[i][j] = new ArrayList<HorarioCanchaPartido>();
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
        matrizConteoEnfrentamientos= new int[horas][dias];
        for(int i = 0; i < horarioDefinitivoTorneo.length; i++) {
        	for (int j = 0; j < horarioDefinitivoTorneo[i].length; j++) {
        		horarioDefinitivoTorneo[i][j] = new ArrayList<HorarioCanchaPartido>();
        	}
        }
    }
    
    

    public Torneo(Club organizador) {
        this.organizador = organizador;
        for(int i = 0; i < horarioDefinitivoTorneo.length; i++) {
        	for (int j = 0; j < horarioDefinitivoTorneo[i].length; j++) {
        		horarioDefinitivoTorneo[i][j] = new ArrayList<HorarioCanchaPartido>();
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
        //generarDisponibilidadEnfrentamientosEnCanchas();
        generarMatrizConteo();
        generarMatrizConteoEnfrentamientos();
        generarHorarioTorneo();
    }
    
    //1 genera enfrentamientos en los horarios (toda la semana)
    public void generarDisponibilidadEnfrentamientos(){
        for (Partido enfrentamiento : enfrentamientos) {
            disponibilidadEnfrentamientos.add(enfrentamiento.getDisponibilidadHoraria());
        }
    }
    
    //2 saca los enfrentamientos en los que no hay canchas disponibles (toda la semana)
    public void generarDisponibilidadEnfrentamientosEnCanchas(){
    	for (Partido enfrentamiento : enfrentamientos)  enfrentamiento.generarDisponibilidadPartido();
        boolean[][] matrizVerdadClub=organizador.disponibilidadHoraria.generarMatrizVerdad();
        for(int i = 0; i < matrizVerdadClub.length; i++){ 
            for (int j = 0; j < matrizVerdadClub[i].length; j++) {
                 if(!matrizVerdadClub[i][j]){ 
                     if(!disponibilidadEnfrentamientos.getHorarios()[i][j].isEmpty())disponibilidadEnfrentamientos.getHorarios()[i][j].clear();
                     for (Partido enfrentamiento : enfrentamientos) {
                        //enfrentamiento.disponibilidadHoraria.getHorarios()[i][j].clear();
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
        imprimirMatrizConteoClub();
    }
    
  //4 genera la cantidad de enfrentamientos disponibles por horario
    public void generarMatrizConteoEnfrentamientos(){
        boolean[][] matrizVerdadTorneo=disponibilidadEnfrentamientos.generarMatrizVerdad();
        for(int i = 0; i < matrizVerdadTorneo.length; i++){ 
            for (int j = 0; j < matrizVerdadTorneo[i].length; j++) {
                 if(matrizVerdadTorneo[i][j]){ 
                	 for(int n=0;n<enfrentamientos.length;n++) if(enfrentamientos[n].getDisponibilidadHoraria().generarMatrizVerdad()[i][j]) matrizConteoEnfrentamientos[i][j]++;
                	
                 }
            }
        }
        imprimirMatrizConteoEnfrentamientos();
    }
    
    public void imprimirMatrizConteoClub(){
    	for(int i = 0; i < matrizConteoClub.length; i++){ 
            for (int j = 0; j < matrizConteoClub[i].length; j++) {
                 
                     System.out.println("i:"+i+" j:" +j +" ="+matrizConteoClub[i][j]);
            }
        }
    }
    
    public void imprimirMatrizConteoEnfrentamientos(){
    	for(int i = 0; i < matrizConteoClub.length; i++){ 
            for (int j = 0; j < matrizConteoClub[i].length; j++) {
                 
                     System.out.println("i:"+i+" j:" +j +" ="+matrizConteoEnfrentamientos[i][j]);
            }
        }
    }
    
    //resta contador de canchas, si es cero no hay mas canchas disponibles en eso horario y cambia la matriz de verdad del club
    public void tomarCancha(int i,int j){
        matrizConteoClub[i][j]--;
        if(matrizConteoClub[i][j]==0){
            organizador.disponibilidadHoraria.getMatrizVerdad()[i][j]=false;
        }
    }
    
    //quita el horario en los partidos, si es cero no hay mas canchas disponibles en eso horario saca el horario de los partidos
    public void sacarHorarioEnPartidos(int i,int j){
        for (Partido enfrentamiento : enfrentamientos) {
            ArrayList<Horario> arregloHorario = enfrentamiento.getDisponibilidadHoraria().getHorarios()[i][j];
            arregloHorario.clear();
        }
    }
    
    /**
     * obtenemos la posicion en el array del enfrentamiento con menor disp horaria
     * @return 
     */
    public int obtenerPosEnfrentamientoMenorDisponibilidad()
    {
        int pos=-1;
        Partido menor=null;
        for(int i=0;i<enfrentamientos.length;i++)
        if (!enfrentamientos[i].isAsignado()) {
            menor=enfrentamientos[i];
            pos=i;
            break;
        }
        
        if (pos==-1) return -1;
        
        
        for(int i=0;i<enfrentamientos.length;i++) {
        	int cantHorariosAux=this.contarHorariosEnfrentamiento(enfrentamientos[i].getDisponibilidadHoraria().getMatrizVerdad());
        	int cantHorariosMenor=this.contarHorariosEnfrentamiento(menor.getDisponibilidadHoraria().getMatrizVerdad());
        	
        	if (!enfrentamientos[i].isAsignado()&&cantHorariosAux-cantHorariosMenor<0) {
        	    menor=enfrentamientos[i];
        	    pos=i;
        	}
        }
        System.out.println(" count= "+this.contarHorariosEnfrentamiento(menor.getDisponibilidadHoraria().getMatrizVerdad()));
        
        
        //if(enfrentamientos[pos].getDisponibilidadHoraria().contarDisponibilidades()==0)
        //{
        //    return -1;
        //}
        return pos;
    }
    
    private int contarHorariosEnfrentamiento(boolean[][] matriz) {
    	int count=0;
    	for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]&&matrizConteoClub[i][j]>0)count++;
			}
		}
		return count;
	}

	public void eliminarHorariosEnfrentamiento(Partido p){
        
        boolean[][]matrizVerdadPartido=p.getDisponibilidadHoraria().generarMatrizVerdad();
        for (int i = 0; i < matrizVerdadPartido.length; i++) {
			for (int j = 0; j < matrizVerdadPartido[i].length; j++) {
				if(matrizVerdadPartido[i][j])matrizConteoEnfrentamientos[i][j]--;
			}
		}
    }
        
    
    public void generarHorarioTorneo(){
        int pos=obtenerPosEnfrentamientoMenorDisponibilidad();
        int count=enfrentamientos.length;
        while(pos>=0 && count>=0){
            enfrentamientos[pos].setAsignado(true);
            count--;
            DisponibilidadHoraria horario=enfrentamientos[pos].getDisponibilidadHoraria();
            boolean[][]matrizVerdadPartido=horario.generarMatrizVerdad();
            
            
            //agregado
            boolean[][] matrizVerdadClub=organizador.disponibilidadHoraria.generarMatrizVerdad();
            //ArrayList <Horario> h=disponibilidadEnfrentamientos.obtenerHorarioMenorDisponiblidad(matrizVerdadPartido,matrizVerdadClub );
            
            int hora=-1; int diaSemana=-1;int menor=enfrentamientos.length+1;
            
                    
            for (int i = 0; i < matrizConteoEnfrentamientos[0].length; i++) {
				for (int j = 0; j < matrizConteoEnfrentamientos.length; j++) {
					if(matrizVerdadClub[j][i]&&matrizVerdadPartido[j][i]){
						if(menor>matrizConteoEnfrentamientos[j][i]) {
							hora=j;
							diaSemana=i;
							menor= matrizConteoEnfrentamientos[j][i];
						}
					}
				}
			}
            
            if(hora==-1){pos=obtenerPosEnfrentamientoMenorDisponibilidad();continue;}
            
            ArrayList<Horario> horarioCanchas=organizador.getDisponibilidadHoraria().getHorarios()[hora][diaSemana];
            Cancha canchaAsignada=(Cancha)horarioCanchas.remove(0).getElementoDisponibilidad();
            HorarioCanchaPartido horarioDefinitivo=new HorarioCanchaPartido(hora,diaSemana,canchaAsignada,enfrentamientos[pos]);
            
            tomarCancha(hora,diaSemana);
            eliminarHorariosEnfrentamiento(enfrentamientos[pos]);
            
            horarioDefinitivoTorneo[hora][diaSemana].add(horarioDefinitivo);
            System.out.println(horarioDefinitivo+ " pos= "+pos);
            pos=obtenerPosEnfrentamientoMenorDisponibilidad();
        }
    }
}
