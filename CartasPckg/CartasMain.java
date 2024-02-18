import java.util.Scanner;

public class CartasMain {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Baraja baraja = new Baraja();
        System.out.println("Guerrita. Ingresa tu nombre:");
        String nombre= leer.nextLine();
        Jugador paquito = new Jugador(nombre);
        Jugador tito = new Jugador("Tito");
        JuegoX guerrita = new JuegoX();
        int cont = 0;
        String resp;
        baraja.cargar();// crea la barajas
        baraja.barajar();// mezcla las cartas
        dividir(paquito, tito, baraja); // reparte las cartas
        System.out.println("\n trampa para ver " + paquito.getMano());

        System.out.println("\n trampa para ver tito " + tito.getMano());
       
            do {
                System.out.println("\n Presiona cualquier tecla para jugar o x para salir");
                resp = leer.nextLine();
                guerrita.juega(paquito, tito);
                if (tito.getMano().isEmpty())  {
                    System.out.println("tito se ha quedado sin cartas.");
                    guerrita.ganaMano(paquito);
                
                } else if(paquito.getMano().isEmpty()){
                    System.out.println("te ha quedado sin cartas.");
                    guerrita.ganaMano(tito);

                }

            } while (!resp.equals("x"));
        }

    // con esto dividimos la baraja en dos
    public static void dividir(Jugador paquito, Jugador tito, Baraja baraja) {
        for (int i = 0; i < 24; i++) {
            paquito.recibeCarta(baraja.repartirCarta());
            tito.recibeCarta(baraja.repartirCarta());
        }

    }

}
