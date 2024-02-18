import java.util.Scanner;
//Juego de la guerrita. Se reparte el mazo entre los dos jugadores. se muestra la primera carta de cada mazo y la que sea mayor gana la ronda
// y gana la carta del otro jugador. guarda la carta jugada mas la ganada en otro mazo o debajo del mazo. La partida termina cuando 
// uno de los 2 participantes se queda sin cartas.. pierde el que se queda sin cartas
//Situación de empate. cada jugador pone 2 cartas ocultas, la tercera* carta se muestra y es la que define quien gana el empate.. quien gana 
// se lleva todas las cartas jugadas en el empate
// *situación rara pero que puede ocurrir: estando en el empate vuelve a darse empate en la definición.. se repite la situación de empate 
// pero con solo 1 carta oculta


//en el proyecto se muestran todas las cartas y partidas unicamente para corroborar  que los códigos funcionan correctamente
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
