package modelo;

public class HorarioReserva {
    int idReserva;
    int idCliente;
    String idHorario;
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
    @Override
    public String toString() {
        return "HorarioReserva [idReserva=" + idReserva + ", idCliente=" + idCliente + ", idHorario=" + idHorario + "]";
    }

    
}
