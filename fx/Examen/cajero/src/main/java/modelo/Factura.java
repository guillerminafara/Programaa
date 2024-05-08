package modelo;

public class Factura {
    int num_fra;
    Cliente cliente;
    int num_habitacion;
    double importe;
    
    public int getNum_fra() {
        return num_fra;
    }
    public void setNum_fra(int num_fra) {
        this.num_fra = num_fra;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public int getNum_habitacion() {
        return num_habitacion;
    }
    public void setNum_habitacion(int num_habitacion) {
        this.num_habitacion = num_habitacion;
    }
    public double getImporte() {
        return importe;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }

    
}
