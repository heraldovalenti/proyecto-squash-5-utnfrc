/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Matias
 */
public class DisponibilidadHoraria implements Comparable{
    
    private ArrayList<Horario>[][] horarios;
    private boolean[][] matrizVerdad;

    public DisponibilidadHoraria(int horas, int dias) {
        horarios= new ArrayList[horas][dias];
        matrizVerdad=new boolean[horas][dias];
        for (ArrayList<Horario>[] horario : horarios) {
        	Arrays.fill(horario, new ArrayList<Horario>());
        }
    }

    public boolean[][] getMatrizVerdad() {
        return matrizVerdad;
    }

    public void setMatrizVerdad(boolean[][] matrizVerdad) {
        this.matrizVerdad = matrizVerdad;
    }


    public DisponibilidadHoraria() {
        horarios= new ArrayList [16][7];
        matrizVerdad=new boolean[16][7];
        for (ArrayList<Horario>[] horario : horarios) {
        	Arrays.fill(horario, new ArrayList<Horario>());
        }
    }

    public ArrayList<Horario>[][] getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario>[][] horarios) {
        this.horarios = horarios;
    }
    
    /**
     * Cualquier elemento con disponibilidadHoraria carga su horario
     * @param elementoDisponible elemento con disponibilidadHoraria
     * @param hora hora disponible
     * @param diaSemana dia de a semana disponible(ya sea lunes, martes, etc)
     */
    public void cargarHorario(IDisponible elementoDisponible,int hora, int diaSemana){
        Horario h =new Horario(hora, diaSemana, elementoDisponible);
        horarios[hora][diaSemana].add(h);
    }
    
    public boolean[][] generarMatrizVerdad(){
        for(int i = 0; i < horarios.length; i++){ 
            for (int j = 0; j < horarios[i].length; j++) {
                 matrizVerdad[i][j]=!horarios[i][j].isEmpty(); } }
        return matrizVerdad;
    }
    
    public boolean disponible(int hora, int diaSemana){
        return matrizVerdad[hora][diaSemana];
    }
    
    /**
     * cruza disponibilidades horarias dejando solo los q ambos estan disponibles
     * @param matrizVerdad
     * @return 
     */
    public boolean[][]CruzarDisponibilidadSemanalNegativa(boolean[][] matrizVerdad){
        for(int i = 0; i < horarios.length; i++){ 
            for (int j = 0; j < horarios[i].length; j++) {
                 matrizVerdad[i][j]=this.matrizVerdad[i][j] && matrizVerdad[i][j]; } }
        return matrizVerdad;
    }
    
    public void generarDisponibilidadConMatrizVerdad(boolean[][] matrizVerdad, IDisponible elementoDisp){
        for(int i = 0; i < horarios.length; i++){ 
            for (int j = 0; j < horarios[i].length; j++) {
                 if(matrizVerdad[i][j]){
                 horarios[i][j].add(new Horario(i, j, elementoDisp));}
                     } }
    }

    public void add(DisponibilidadHoraria disponibilidad) {
        ArrayList <Horario>[][] dispHorarios=disponibilidad.getHorarios();
        for(int i = 0; i < dispHorarios.length; i++){ 
            for (int j = 0; j < dispHorarios[i].length; j++) {
                if(!dispHorarios[i][j].isEmpty()) {
                    for(int x=0;x<dispHorarios[i][j].size();x++){
                        horarios[i][j].add(new Horario(i, j, dispHorarios[i][j].get(x).getElementoDisponibilidad()));
                    }
                }
            }
        }
    }
    
    public int contarDisponibilidades(){
        int count=0;
        for (ArrayList<Horario>[] horario : horarios) {
            for (ArrayList<Horario> horario1 : horario) {
                count += horario1.size();
            }
        }
        return count;
    }

    @Override
    public int compareTo(Object o) {
        if (this.contarDisponibilidades()==0)return 1;
        DisponibilidadHoraria externo=(DisponibilidadHoraria)o;
        if (externo.contarDisponibilidades()==0)return -1;
        return this.contarDisponibilidades()-externo.contarDisponibilidades();
    }
    
    public ArrayList <Horario> obtenerHorarioMenorDisponiblidad(boolean[][]matrizValor){
        ArrayList <Horario> h=null;
        for(int i=0;i<matrizValor.length;i++){
                for(int j=0;j<matrizValor[i].length;j++){
                    if(matrizValor[i][j]){
                        if(h==null){
                            h=horarios[i][j];
                        }
                        if(h.size()>horarios[i][j].size()){
                            h=horarios[i][j];
                        }
                    }
                }
            }
        return h;
    }
    
    public void eliminarHorariosEnfrentamiento(boolean[][]matrizValor,IDisponible elemento){
        for(int i=0;i<matrizValor.length;i++){
            for(int j=0;j<matrizValor[i].length;j++){                    
                if(matrizValor[i][j]){                        
                    Horario h=elemento.getDisponibilidadHoraria().getHorarios()[i][j].get(0);                        
                    if(this.horarios[i][j].contains(h)){                            
                        this.horarios[i][j].remove(h);                        
                    }
                }
            }
        }
                
    }
    


}
