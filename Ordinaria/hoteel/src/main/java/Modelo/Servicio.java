package Modelo;

public class Servicio {
    int id_Servicio;
    int cod_grupo;
    String detalle;
    double precio;
    Grupo grupo;
    public Servicio() {
    }
    public int getId_Servicio() {
        return id_Servicio;
    }
    public void setId_Servicio(int id_Servicio) {
        this.id_Servicio = id_Servicio;
    }
    public int getCod_grupo() {
        return cod_grupo;
    }
    public void setCod_grupo(int cod_grupo) {
        this.cod_grupo = cod_grupo;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return detalle;
    }
    public Grupo getGrupo() {
        return grupo;
    }
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
}
