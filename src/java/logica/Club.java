/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
public class Club {
    Cancha [] canchas;
    
    public Club()
    {
        canchas = new Cancha[1];
        for (int i =0;i<canchas.length;i++) {
            canchas[i]=new Cancha();
        }
    }
    

    public Cancha[] getCanchas() {
        return canchas;
    }

    public void setCanchas(Cancha[] canchas) {
        this.canchas = canchas;
    }
    
    
}
