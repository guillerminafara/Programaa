public class Profesor extends Persona{
  
    int nDespacho;

    Profesor(){
      
    }
    public Profesor(String nombre, String apellidos, String nIF, String direccion) {
        super(nombre, apellidos, nIF, direccion);
    }

    public Profesor(String nombre, String apellidos, String nIF) {
        super(nombre, apellidos, nIF);
    }

    
}
