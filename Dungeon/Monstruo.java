

//Se crearán tres Monstruos y se situarán aleatoriamente en el
//array, posición del 1 al 39 pero no podrán estar en la misma posición. (Esto igual te obliga a
//poner atributos de posición a los personajes).

class Monstruo extends Personaje{

    protected Monstruo(){
       super(); 
    }
    protected Monstruo(String nombre,Arma arma) {
        super(nombre, arma);
        this.puntosVida= (int)(Math.floor(Math.random() * (20-5+1)) + 5);
      this.posicion= (int)((Math.random() * (40)) + 1);
    }
    
}
