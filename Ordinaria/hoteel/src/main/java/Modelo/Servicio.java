package Modelo;

public class Servicio {
    int id_Servicio;
    int cod_grupo;
    String detalle;
    double decimal;
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
    public double getDecimal() {
        return decimal;
    }
    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }
    @Override
    public String toString() {
        return "Servicio [id_Servicio=" + id_Servicio + ", cod_grupo=" + cod_grupo + ", detalle=" + detalle
                + ", decimal=" + decimal + "]";
    }
    
}
