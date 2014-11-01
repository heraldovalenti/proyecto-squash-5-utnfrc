/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
public class Jugador implements IDisponible{
    private long id;
    private int pos;
    private  int [] rondas;
    private boolean enFixture,vacio=false,unranked=false;
    private DisponibilidadHoraria disponibilidadHoraria=new DisponibilidadHoraria();

    
    
    public DisponibilidadHoraria getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
        this.disponibilidadHoraria.generarMatrizVerdad();
    }

    public void setId(Long id) {
    	this.id = id;
    }

    
    public Long getId() {
    	return this.id;
    }
    
    public Jugador(int pos) {
        this.pos = pos;
        disponibilidadHoraria=new DisponibilidadHoraria();
        
    }

    public boolean isUnranked() {
        return unranked;
    }

    public void setUnranked(boolean unranked) {
        this.unranked = unranked;
    }
    
    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    public boolean isEnFixture() {
        return enFixture;
    }

    public void setEnFixture(boolean enFixture) {
        this.enFixture = enFixture;
    }

    public Jugador() {
        pos=0;
    }

    public Jugador(int pos,int [] rondas) {
        this.pos = pos;
        this.rondas=rondas;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int[] getRondas() {
        return rondas;
    }

    public void setRondas(int[] rondas) {
        this.rondas = rondas;
    }
    
    @Override
    public String toString()
    {
        String s=" Ranking: ";
        if(!unranked){
            s+=this.pos;
            return s;
        }
        s+="N/C";
        return s;
    }
    
    
}
