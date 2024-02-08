public class Persona {
    protected String nombre; 
    protected String apellidos;
    protected String nif; 
    protected Direccion direccion;
    public Persona(String nombre, String apellidos, String nif, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
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
