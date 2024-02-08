public class CartasMain {
   
    public static void main(String[] args) {
        Baraja baraja= new Baraja();


        baraja.cargar();
        
       System.out.println( baraja.repartirCarta());

       
    }
}
