/**
 * TarjetaSim
 */
public class TarjetaSIM {
    protected String numero;
    protected int tiempo;

    public TarjetaSIM() {
    }

    public TarjetaSIM(String numero) {
        this.numero = numero;
    }

    public TarjetaSIM(String numero, int tiempo) {
        this.numero = numero;
        this.tiempo = tiempo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Num. " + numero + " - " + tiempo + " de conexión";
    }

    public int llama(TarjetaSIM tarjeta, int tiempoo) {

        tiempo += tiempoo;
        tarjeta.setTiempo(tiempoo);
        return tiempo;

    }

}