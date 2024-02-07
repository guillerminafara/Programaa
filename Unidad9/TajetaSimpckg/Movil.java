import java.text.DecimalFormat;
import java.util.Arrays;

public class Movil extends TarjetaSIM {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    String tarifa;
    double coste;
    

    public Movil() {
    
    }
    public Movil(String numero, String tarifa) {
        super(numero);
        this.tarifa= tarifa;
    }
    public Movil(String numero, int tiempo, String tarifa, double coste) {
        super(numero, tiempo);
        this.tarifa = tarifa;
        this.coste = coste;
    }
    public String getTarifa() {
        return tarifa;
    }
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    public double getCoste() {
        return coste;
    }
    public void setCoste(double coste) {
        this.coste = coste;
    }
    @Override
    public String toString() {
        return "Num. " +super.numero + " - "+super.tiempo+" de conexión"+ " - "+ df.format(coste) +" euros de coste" ; 
    }
 @Override
    public int llama(TarjetaSIM movil, int tiempoo) {
        if(tarifa.equals("plata")){
            this.coste = 0.10;
            System.out.println("entra");
        }else if(tarifa.equals("oro")){
            this.coste= 0.06;
            System.out.println("entra2");
        }else{
            this.coste= 0.03;
            System.out.println("entra3");
        }
        tiempo += tiempoo;
        coste= tiempo* coste;
        movil.setTiempo(tiempoo);
        return tiempoo;

    }
    
}
