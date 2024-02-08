public class Profesor extends Persona{
  
    int nDespacho;

    Profesor(){
      
    }
    public Profesor(String nombre, String apellidos, String nIF, Direccion direccion) {
        super(nombre, apellidos, nIF, direccion);
    }

    public Profesor(String nombre, String apellidos, String nIF) {
        super(nombre, apellidos, nIF);
    }

    
}
