import java.lang.reflect.Array;
import java.util.ArrayList;
//Crea una clase "Jugador" que contenga información sobre la mano de cartas que tiene un jugador.
public class Jugador {
    Cartas carta;
    Baraja baraja;
    ArrayList<Cartas> mano= new ArrayList<>();


    public Cartas getCarta() {
        return carta;
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public ArrayList<Cartas> getMano() {
        return mano;
    }


    
    public void setCarta(Cartas carta) {
        this.carta = carta;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public void setMano(ArrayList<Cartas> mano) {
        this.mano = mano;
    }

    //que recibe una carta de la baraja
    public void recibeCarta(Cartas carta){
        mano.add(carta);
      
    }

    //sirve para seleccionar una carta de la mano de cartas

   

    public void juegaCarta(){
        System.out.println(mano);
        mano.get(0);

    }
}
