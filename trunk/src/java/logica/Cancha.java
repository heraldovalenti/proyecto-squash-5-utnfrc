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
public class Cancha implements IDisponible{
    
    private DisponibilidadHoraria disponibilidadHoraria=new DisponibilidadHoraria();

    public DisponibilidadHoraria getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
    }
    
    public Cancha(){
    }
    
}
