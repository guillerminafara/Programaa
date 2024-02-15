import java.util.ArrayList;

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

    System.out.println(paquito.getNombre() + "carta: " + paquito.getMano().get(0));
    System.out.println(tito.getNombre() + "Carta: " + tito.getMano().get(0));

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
      System.out.println("Empate Tito " + empateTito);
      // System.out.println("trampa para ver cartas ocultas de paquito: " +
      // paquito.getMano().get(i));
      empatePaquito.add(paquito.getMano().remove(0));
      System.out.println("Empate Paquito " + empatePaquito);

      i++;
    }

    // tito gana
    System.out.println(paquito.getNombre() + "carta: " + empatePaquito.get(3));
    System.out.println(tito.getNombre() + "Carta: " + empateTito.get(3));
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
/*
 * //
 * 
 * 
 */