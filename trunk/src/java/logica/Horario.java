/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
public class Horario implements Comparable {
    int horaInicio,minInicio,horaFin,minFin,ordenDia;
    

    public Horario() {
    }

    public Horario(int horaInicio, int minInicio, int horaFin, int minFin, int ordenDia) {
        this.horaInicio = horaInicio;
        this.minInicio = minInicio;
        this.horaFin = horaFin;
        this.minFin = minFin;
        this.ordenDia = ordenDia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinInicio() {
        return minInicio;
    }

    public void setMinInicio(int minInicio) {
        this.minInicio = minInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getMinFin() {
        return minFin;
    }

    public void setMinFin(int minFin) {
        this.minFin = minFin;
    }

    public int getOrdenDia() {
        return ordenDia;
    }

    public void setOrdenDia(int ordenDia) {
        this.ordenDia = ordenDia;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Horario)
        {
            Horario h=(Horario)o;
            if(this.horaInicio>h.horaInicio)
            {
                return 1;
            }
            else if(this.horaInicio<h.horaInicio)
            {
                return -1;
            }
            else if(this.horaInicio==h.horaInicio)
            {
                if(this.minInicio>h.minInicio)
                {
                    return 1;
                }
                else if(this.minInicio<h.minInicio)
                {
                    return -1;
                }
                else if(this.minInicio==h.minInicio)
                {
                    return 0;
                }
            }
            
        }
        return -1;
    }
            
}
