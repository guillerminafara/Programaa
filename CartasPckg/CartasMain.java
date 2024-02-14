public class CartasMain {
   
    public static void main(String[] args) {
        Baraja baraja= new Baraja();
        Jugador paquito= new Jugador();
        Jugador tito= new Jugador();
        JuegoX guerrita= new JuegoX();

        baraja.cargar();
        
       System.out.println( baraja.repartirCarta());
       
       
    }
    public void dividir(Jugador paquito, Jugador tito, Baraja baraja){
        for (int i = 0; i < 24; i++) {
            paquito.recibeCarta(baraja.repartirCarta());
            tito.recibeCarta(baraja.repartirCarta());
        }
       
    }
}
