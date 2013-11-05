/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Matias
 */
public class Cancha {
    
    int tiempoJuegoDia;
    TreeSet<Horario>[] horarios= new TreeSet[7];
    
    public Cancha(){
        for(int i =0;i<horarios.length;i++)
        {
            horarios[i]=new TreeSet<Horario>();
            Horario h=new Horario(9,0,23,0,i);
            horarios[i].add(h);
        }
    }

    public TreeSet<Horario>[] getHorarios() {
        return horarios;
    }

    public void setHorarios(TreeSet<Horario>[] horarios) {
        this.horarios = horarios;
    }
    
    
    
}
