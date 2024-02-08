
public class Direccion {
    String calle;
    String ciudad;
    int CP;
    String Pais;

    
    public Direccion() {
    }


    public Direccion(String calle, String ciudad, int cP, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        CP = cP;
        Pais = pais;
    }


    @Override
    public String toString() {
        return "calle: " + calle + ", ciudad=" + ciudad + ", CP=" + CP + ", Pais=" + Pais ;
    }
   
}