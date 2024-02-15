import java.util.ArrayList;

public class JuegoX extends JuegodeCartas {
  // Juego la Guerrita

  // que permite averiguar que jugador gana una mano

  ArrayList<Cartas> empateTito = new ArrayList<>();
  ArrayList<Cartas> empatePaquito = new ArrayList<>();
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
    if (paquito.getMano().get(0).getNumero() < tito.getMano().get(0).getNumero()) {
      tito.recibeCarta(paquito.getMano().remove(0));
      
      ganaMano(tito);

    } else if (paquito.getMano().get(0).getNumero() > tito.getMano().get(0).getNumero()) { // paquito gana
      paquito.recibeCarta(tito.getMano().remove(0));
      ganaMano(paquito);
    } else {

      empate(paquito, tito);

    }

  }

  public void empate(Jugador paquito, Jugador tito) {

    // toma la carta dada vuelta 2 mas sin descubrir y las pone en un array para ser
    // las que se ganan
    while (i <= cont) {
      System.out.println( "trampa para ver cartas ocultas: "+ tito.getMano().get(i));
      empateTito.add(tito.getMano().remove(i));
      System.out.println( "trampa para ver cartas ocultas: "+ paquito.getMano().get(i));
      empatePaquito.add(paquito.getMano().remove(i));
      
      i++;
    }

    // tito gana

    if (empatePaquito.get(cont).getNumero() < empateTito.get(cont).getNumero()) {
      tito.setMano(empatePaquito);
      ganaMano(tito);
    } else if (empatePaquito.get(cont).getNumero() < empateTito.get(cont).getNumero()) {
      paquito.setMano(empateTito);
      ganaMano(paquito);
    } else {
      empate(paquito, tito);
      cont += 3;
    }

  }

}
/*
 * //
 * 
 * 
 */