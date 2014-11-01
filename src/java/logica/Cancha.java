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
    
	private long id;
    private DisponibilidadHoraria disponibilidadHoraria=new DisponibilidadHoraria();

    public DisponibilidadHoraria getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
    }
    
    public Cancha(){
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public long getId() {
    	return this.id;
    }
    
}
