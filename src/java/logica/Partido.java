/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
public class Partido implements Comparable{
    
    int duracion,numero,ronda,ordenLLave;
    Jugador jugador1,jugador2;
    Horario horario;
    
    

    public Partido() {
        this.duracion = 40;
        jugador1=new Jugador();
        jugador2=new Jugador();
    }

    public Partido(int numero, int ronda, Jugador jugador1, Jugador jugador2) {
        this.duracion = 40;
        this.numero = numero;
        this.ronda = ronda;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public int getOrdenLLave() {
        return ordenLLave;
    }

    public void setOrdenLLave(int ordenLLave) {
        this.ordenLLave = ordenLLave;
    }
    
    
    
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    
    /**
     * Retorna si es un Jugador que pasa directo a la ronda siguente
     * @return true si pasa directo
     */
    public boolean isDirecto(){
        return(jugador2.isVacio());
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Partido)
        {
            Partido p=(Partido)o;
            return (this.ordenLLave-p.ordenLLave);            
        }
        return 0;
    }
    
    @Override
    public String toString()
    {
        String s= " Partido "+(ordenLLave+1)+" : "+jugador1.toString();
        if(!jugador2.isVacio()){s+=jugador2.toString();}
        return s;
    }
        
}
