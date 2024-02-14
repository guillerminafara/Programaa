import java.util.ArrayList;

public class JuegoX extends JuegodeCartas {
  // Juego la Guerrita

  // que permite averiguar que jugador gana una mano
  @Override
  public void ganaMano() {

  }

  // comparar las cartas que llegan de los jugadores
  public void juega(Jugador paquito, Jugador tito) {
    paquito.getMano().get(0);

    // tito gana
    if (paquito.getMano().get(0).getNumero() < tito.getMano().get(0).getNumero()) {
      tito.recibeCarta(paquito.getMano().remove(0));

    }else if(paquito.getMano().get(0).getNumero() > tito.getMano().get(0).getNumero()){
      paquito.recibeCarta(tito.getMano().remove(0));
    }else{

      ArrayList<Cartas>empateTito= new ArrayList<>();

      ArrayList<Cartas>empatePaquito= new ArrayList<>();

      for (int i = 0; i < 4; i++) {
        empateTito.add(tito.getMano().get(i));
      }
      for (int i = 0; i < 4; i++) {
        empatePaquito.add(paquito.getMano().get(i));
      }

      //tito gana
      if(empatePaquito.get(3).getNumero()<empateTito.get(3).getNumero()){
        tito.setMano(empatePaquito);
      }else if(empatePaquito.get(3).getNumero()<empateTito.get(3).getNumero()){
        
      }

    }

  }


  public void empate(Jugador paquito, Jugador tito){
    
  }

}
