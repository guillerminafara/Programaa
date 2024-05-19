package modelo;

public class Planes {
    String idPlan;
    String descripción;
    double importe;
    boolean estado;
    public Planes() {
    }
    public String getIdPlan() {
        return idPlan;
    }
    public void setIdPlan(String idPlan) {
        this.idPlan = idPlan;
    }
    public String getDescripción() {
        return descripción;
    }
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Planes [idPlan=" + idPlan + ", descripción=" + descripción + ", importe=" + importe + "]";
    }

    

}
