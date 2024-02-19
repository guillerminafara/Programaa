public class Zombie extends Monstruo {
    public Zombie(String nombre, Arma arma) {
        super(nombre, arma);
        this.posicion= (int)(Math.random() * (40)) + 1;
    }
}
