package modelo;

public class Cuenta {
    String num_cta;
    Cliente cliente;
    double saldo;
    public String getNum_cta() {
        return num_cta;
    }
    public void setNum_cta(String num_cta) {
        this.num_cta = num_cta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
