public class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected Arma arma;
    protected int posicion;
    public Personaje(){
        
    }
    public Personaje(String nombre, Arma arma) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.arma = arma;
        this.posicion=0;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
}
