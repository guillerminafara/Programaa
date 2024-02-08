public class Profesor extends Persona{
  
    int nDespacho;

    Profesor(){
      
    }
    public Profesor(String nombre, String apellidos, String nIF, Direccion direccion, int nDespacho) {
        super(nombre, apellidos, nIF, direccion);
        this.nDespacho= nDespacho;
    }

    public Profesor(String nombre, String apellidos, String nIF) {
        super(nombre, apellidos, nIF);
    }
    @Override
    public String toString() {
        return "Profesor: -nombre: " +nombre + " apellido: "+ apellidos+ " NIF: "+ nif+ " Dirección: "+ direccion+ " despacho: " + nDespacho;
    }

    
}
