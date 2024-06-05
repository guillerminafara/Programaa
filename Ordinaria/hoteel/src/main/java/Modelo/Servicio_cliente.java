package Modelo;

public class Servicio_cliente {
    int id_sc;
    int id_servicio;
    int cod_trabajador;
    int num_habitacion;
    double decimal;
    Grupo grupo;
    Servicio servicio;
    public Servicio_cliente() {
    }
    public int getId_sc() {
        return id_sc;
    }
    public void setId_sc(int id_sc) {
        this.id_sc = id_sc;
    }
    public int getId_servicio() {
        return id_servicio;
    }
    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }
    public int getCod_trabajador() {
        return cod_trabajador;
    }
    public void setCod_trabajador(int cod_trabajador) {
        this.cod_trabajador = cod_trabajador;
    }
    public int getNum_habitacion() {
        return num_habitacion;
    }
    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }
    public double getDecimal() {
        return decimal;
    }
    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }
    @Override
    public String toString() {
        return "Servicio_cliente [id_sc=" + id_sc + ", id_servicio=" + id_servicio + ", cod_trabajador="
                + cod_trabajador + ", num_habitacion=" + num_habitacion + ", decimal=" + decimal + "]";
    }
    
}
