import java.util.Map;
import java.util.TreeMap;

/**
 * Cartas
 */
public class Cartas {
    String palo;
    int numero;


  

    public Cartas() {
    }

    public Cartas(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        
    }

    public String getPalo() {
        return palo;
    }


    public void setPalo(String palo) {
        this.palo = palo;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero+ " de " +  palo;
    }


 




    
}

