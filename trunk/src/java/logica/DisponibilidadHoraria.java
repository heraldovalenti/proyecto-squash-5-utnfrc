/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Matias
 */
public class DisponibilidadHoraria {
    
    TreeSet <Horario>[] horarios= new TreeSet [7];
        


    public DisponibilidadHoraria() {
        for(int i =0;i<horarios.length;i++)
        {
            horarios[i]=new TreeSet <Horario>();
        }
    }

    public TreeSet <Horario>[] getHorarios() {
        return horarios;
    }

    public void setHorarios(TreeSet <Horario>[] horarios) {
        this.horarios = horarios;
    }

    public void mostrarHorarios(int ordenDia) {
        System.out.println(" Lista de " + horarios[ordenDia].size() +
        " horarios");
        for( Iterator it = horarios[ordenDia].iterator(); it.hasNext();) {
            Horario h = (Horario)it.next();
            System.out.println(h);
        }
    }
}
