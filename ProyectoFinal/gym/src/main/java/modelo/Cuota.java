
package modelo;

import java.time.LocalDateTime;

/**
 * Cuota
 */
public class Cuota {
    int idCuota;
    Planes plan;
    int idCliente;
    boolean estado;
    LocalDateTime fechaVencimiento;
    public Cuota(Planes plan, int idCliente, boolean estado, LocalDateTime fechaVencimiento) {
        this.plan = plan;
        this.idCliente = idCliente;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public Planes getPlan() {
        return plan;
    }

    public void setPlan(Planes plan) {
        this.plan = plan;
    }

    public Planes getplan() {
        return plan;
    }
    public void setIdPlan(Planes plan) {
        this.plan = plan;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    @Override
    public String toString() {
        return "Cuota [idPlan=" + plan + ", idCliente=" + idCliente + ", estado=" + estado + ", fechaVencimiento="
                + fechaVencimiento + "]";
    }
    
    
}