package modelo;

import java.util.Stack;

public class Cliente {
    int idCliente;
    String nif;
    String nombre;
    String apellido;
    String mail;
    String pass;
    boolean estado;
    Cuota cuota;
   // HorarioReserva reserva;
    Stack <HorarioReserva>pilaReservas= new Stack<>();

    public Cliente() {
    }

    public Cliente(boolean estado, String pass, String mail, String apellido, String nombre, String nif, int idCliente) {
        this.estado = estado;
        this.pass = pass;
        this.mail = mail;
        this.apellido = apellido;
        this.nombre = nombre;
        this.nif = nif;
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    // public HorarioReserva getReserva() {
    //     return reserva;
    // }

    // public void setReserva(HorarioReserva reserva) {
    //     this.reserva = reserva;
    // }



    @Override
    public String toString() {
        return nombre +"";
    }

    public Stack<HorarioReserva> getPilaReservas() {
        return pilaReservas;
    }

    public void setPilaReservas(Stack<HorarioReserva> pilaReservas) {
        this.pilaReservas = pilaReservas;
    }
    

}
