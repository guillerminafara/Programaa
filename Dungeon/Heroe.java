public class Heroe extends Personaje {

    public Heroe(String nombre, Arma arma) {
        super(nombre,  arma);
        if(this.nombre.equals("mago")){
           
            this.puntosVida= (int)(Math.floor(Math.random() * (8-3+1)) + 3);
        }else{
            this.puntosVida= (int)(Math.floor(Math.random() * (10-5+1)) + 5);
        }
        this.posicion=0;

    }
    
}
