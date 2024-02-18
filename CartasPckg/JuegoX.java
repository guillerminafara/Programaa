import java.util.ArrayList;
//Juego de la guerrita. Se reparte el mazo entre los dos jugadores. se muestra la primera carta de cada mazo y la que sea mayor gana la ronda
// y gana la carta del otro jugador. guarda la carta jugada mas la ganada en otro mazo o debajo del mazo. La partida termina cuando 
// uno de los 2 participantes se queda sin cartas.. pierde el que se queda sin cartas
//Situación de empate. cada jugador pone 2 cartas ocultas, la tercera* carta se muestra y es la que define quien gana el empate.. quien gana 
// se lleva todas las cartas jugadas en el empate
// *situación rara pero que puede ocurrir: estando en el empate vuelve a darse empate en la definición.. se repite la situación de empate 
// pero con solo 1 carta oculta


//en el proyecto se muestran todas las cartas y partidas unicamente para corroborar  que los códigos funcionan correctamente


public class JuegoX extends JuegodeCartas {
  // Juego la Guerrita

  // que permite averiguar que jugador gana una mano

  int cont = 3;
  int i = 0;
  boolean bandera;

  @Override
  public void ganaMano(Jugador player) {
    System.out.println("gana " + player);

  }

  // comparar las cartas que llegan de los jugadores
  public void juega(Jugador paquito, Jugador tito) {

    System.out.println("Carta de " +paquito.getNombre()+": " + paquito.getMano().get(0));
    System.out.println("Carta de " + tito.getNombre() + ": " + tito.getMano().get(0));

    // tito gana

    if (paquito.getMano().get(0).getNumero() == tito.getMano().get(0).getNumero()) {
      empate(paquito, tito);
    } else if (paquito.getMano().get(0).getNumero() < tito.getMano().get(0).getNumero()) {
      tito.recibeCarta(paquito.getMano().remove(0));
      tito.recibeCarta(tito.getMano().remove(0));
      ganaMano(tito);

    } else if (paquito.getMano().get(0).getNumero() > tito.getMano().get(0).getNumero()) { // paquito gana
      paquito.recibeCarta(tito.getMano().remove(0));
      paquito.recibeCarta(paquito.getMano().remove(0));
      ganaMano(paquito);

    }

  }

  ArrayList<Cartas> empateTito = new ArrayList<>();
  ArrayList<Cartas> empatePaquito = new ArrayList<>();

  public void empate(Jugador paquito, Jugador tito) {

    System.out.println("EMPATEEEEEE");
    i = 0;
    // toma la carta dada vuelta 2 mas sin descubrir y las pone en un array para ser
    // las que se ganan
    while (i <= 3) {
      // System.out.println("trampa para ver cartas ocultas: " +
      // tito.getMano().get(i));
      empateTito.add(tito.getMano().remove(0));
      // System.out.println( "iiiii: " +i);
    
      // System.out.println("trampa para ver cartas ocultas de paquito: " +
      // paquito.getMano().get(i));
      empatePaquito.add(paquito.getMano().remove(0));
      

      i++;
    }
    System.out.println("Tus cartas: " + empatePaquito);
    System.out.println("Empate Tito " + empateTito);

    // tito gana
    System.out.println("Carta de " +paquito.getNombre()+": " +  empatePaquito.get(3));
    System.out.println("Carta de "+ tito.getNombre() +": "  + empateTito.get(3));
    if (empatePaquito.get(cont).getNumero() < empateTito.get(cont).getNumero()) {
      tito.getMano().addAll(empatePaquito);
      tito.getMano().addAll(empateTito);
      ganaMano(tito);
      // System.out.println(tito.getMano());
    } else if (empatePaquito.get(cont).getNumero() > empateTito.get(cont).getNumero()) {
      paquito.getMano().addAll(empateTito);
      paquito.getMano().addAll(empatePaquito);
      ganaMano(paquito);
      System.out.println(paquito.getMano());
    } else {
      // empate(paquito, tito);
      // cont += 2;
      System.out.println("doble empate");
      empatePaquito.add(paquito.getMano().remove(0));
      empateTito.add(tito.getMano().remove(0));
      empatePaquito.add(paquito.getMano().remove(0));
      empateTito.add(tito.getMano().remove(0));
      if (empatePaquito.get(cont).getNumero() < empateTito.get(cont).getNumero()) {
        tito.getMano().addAll(empatePaquito);
        tito.getMano().addAll(empateTito);
        ganaMano(tito);
        // System.out.println(tito.getMano());
      } else if (empatePaquito.get(cont).getNumero() > empateTito.get(cont).getNumero()) {
        paquito.getMano().addAll(empateTito);
        paquito.getMano().addAll(empatePaquito);
        ganaMano(paquito);
        System.out.println(paquito.getMano());

      }
      empatePaquito.clear();
      empateTito.clear();
    }

  }

}