public class Dragon extends Monstruo{

    public Dragon(String nombre, Arma arma) {
        super(nombre, arma);
        this.posicion=(int)(Math.random() * (40)) + 1;
        //TODO Auto-generated constructor stub
    }

    
}
