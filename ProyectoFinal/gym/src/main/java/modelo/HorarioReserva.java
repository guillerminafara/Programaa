package modelo;

public class HorarioReserva {
    int idReserva;
    int idCliente;
    String idHorario;
    boolean estado;
    public HorarioReserva() {
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getIdHorario() {
        return idHorario;
    }
    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "HorarioReserva [idReserva=" + idReserva + ", idCliente=" + idCliente + ", idHorario=" + idHorario + "]";
    }
   

    
}
