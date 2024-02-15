public class CartasMain {
   
    public static void main(String[] args) {
        Baraja baraja= new Baraja();
        Jugador paquito= new Jugador("Paquito");
        Jugador tito= new Jugador("Tito");
        JuegoX guerrita= new JuegoX();

        baraja.cargar();//crea la barajas
        baraja.barajar();//mezcla las cartas
        dividir(paquito, tito, baraja); //reparte las cartas
        System.out.println("trampa para ver paquto "+ paquito.getMano());
        System.out.println("trampa para ver tito "+ tito.getMano());
       
       while (!tito.getMano().isEmpty() && !paquito.getMano().isEmpty()) {
        guerrita.juega(paquito, tito);
       }
       

       
    }

    //con esto dividimos la baraja en dos 
    public static void dividir(Jugador paquito, Jugador tito, Baraja baraja){
        for (int i = 0; i < 24; i++) {
            paquito.recibeCarta(baraja.repartirCarta());
            tito.recibeCarta(baraja.repartirCarta());
        }
       
    }



}
