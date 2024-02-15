import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    Cartas carta;
    String[] palo = { "oro", "espada", "basto", "copa" };
    ArrayList<Cartas> baraja = new ArrayList<>();

    public Cartas getCarta() {
        return carta;
    }

    public void setCarta(Cartas carta) {
        this.carta = carta;
    }

    public String[] getPalo() {
        return palo;
    }

    public void setPalo(String[] palo) {
        this.palo = palo;
    }

    public ArrayList<Cartas> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Cartas> baraja) {
        this.baraja = baraja;
    }
//crear la baraja
    public void cargar() {
        
        for (int i = 0; i < palo.length; i++) {
            
            for (int j = 1; j <13; j++) {
                //carta.setPalo(palo[i]);
                //carta.setNumero(j);
                baraja.add(new Cartas(palo[i], j));
            }
        }
        System.out.println(baraja);

    }
//meacla las cartas
    public void barajar(){
        Collections.shuffle(baraja);
       // System.out.println(baraja);
    }
//repartirCarta(), que reparte la primera carta de la baraja.
    public Cartas repartirCarta(){
        //Cartas aux;
      //  barajar();
        //aux=baraja.get(0);
       // baraja.remove(aux);
       
        return baraja.remove(0);

    }

    
}
