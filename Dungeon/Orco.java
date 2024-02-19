public class Orco extends Monstruo {

    public Orco(String nombre, Arma arma) {
        super(nombre, arma);
        this.posicion= (int)(Math.random() * (40)) + 1;
    }
    
}
