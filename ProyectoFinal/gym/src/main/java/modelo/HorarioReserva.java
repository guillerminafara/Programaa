package modelo;

public class HorarioReserva {
    int idReserva;
    Cliente cliente;
    Horario horario;
    boolean estado;
    public HorarioReserva() {
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Horario getHorario() {
        return horario;
    }
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "HorarioReserva [idReserva=" + idReserva + cliente.getNombre() + ", idHorario=" + horario
                + ", estado=" + estado + "]";
    }

   

    
}
