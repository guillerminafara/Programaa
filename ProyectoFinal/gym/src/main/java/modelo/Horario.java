package modelo;

import java.time.LocalDate;

public class Horario {
    String idHorario;
    LocalDate diaHora;
    int cant;
    boolean estado;

  
    public Horario() {
    }
    public LocalDate getDiaHora() {
        return diaHora;
    }
    public void setDiaHora(LocalDate diaHora) {
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
}
