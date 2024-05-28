package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Horario {
    String idHorario;
    LocalDateTime diaHora;
    int cant;
    boolean estado;

  
    public Horario(String idHorario, LocalDateTime diaHora, int cant, boolean estado) {
        this.idHorario = idHorario;
        this.diaHora = diaHora;
        this.cant = cant;
        this.estado = estado;
    }
    public Horario() {
    }
    public LocalDateTime getDiaHora() {
        return diaHora;
    }
    public void setDiaHora(LocalDateTime diaHora) {
        this.diaHora = diaHora;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public int getCant() {
        return cant;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }
    public String getIdHorario() {
        return idHorario;
    }
    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }
    @Override
    public String toString() {
        return "Horario [idHorario=" + idHorario + ", diaHora=" + diaHora + ", cant=" + cant + ", estado=" + estado
                + "]";
    }
    
}
