public class Persona {
     String nombre; 
    String apellidos;
    String nif; 
    String direccion;
    public Persona(String nombre, String apellidos, String nif, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        direccion = direccion;
    }
    public Persona(String nombre, String apellidos, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }
    public Persona() {
        //TODO Auto-generated constructor stub
    }
    
}
