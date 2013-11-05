/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
public class Ronda {
    
    Partido[] partidos;

    public Ronda(int cantPart) {
        this.partidos=new Partido[cantPart];
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partido) {
        this.partidos = partido;
    }
    
    
    
}
