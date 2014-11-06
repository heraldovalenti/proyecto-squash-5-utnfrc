/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
public class Club implements IDisponible{
    Cancha [] canchas;
    DisponibilidadHoraria disponibilidadHoraria=new DisponibilidadHoraria();

    public DisponibilidadHoraria getDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
        this.disponibilidadHoraria = disponibilidadHoraria;
    }
    
    public Club()
    {
        canchas = new Cancha[1];
        for (int i =0;i<canchas.length;i++) {
            canchas[i]=new Cancha();
        }
    }
    
    public void generarDisponibilidadPartido(){
    	for (int i =canchas.length-1;i>=0;i--) {
            disponibilidadHoraria.add(canchas[i].getDisponibilidadHoraria());
        }
    }

    public Cancha[] getCanchas() {
        return canchas;
    }

    public void setCanchas(Cancha[] canchas) {
        this.canchas = canchas;
    }
    
    
}
