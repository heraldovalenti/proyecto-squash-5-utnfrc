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
    int horaInicio,ordenDia;
    IDisponible elementoDisponibilidad;

    public Horario() {
    }

    public Horario(int horaInicio, int ordenDia, IDisponible elementoDisponibilidad) {
        this.horaInicio = horaInicio;
        this.ordenDia = ordenDia;
        this.elementoDisponibilidad = elementoDisponibilidad;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getOrdenDia() {
        return ordenDia;
    }

    public void setOrdenDia(int ordenDia) {
        this.ordenDia = ordenDia;
    }

    public IDisponible getElementoDisponibilidad() {
        return elementoDisponibilidad;
    }

    public void setElementoDisponibilidad(IDisponible elementoDisponibilidad) {
        this.elementoDisponibilidad = elementoDisponibilidad;
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
                return 0;
            }
            
        }
        return -1;
    }
            
}
