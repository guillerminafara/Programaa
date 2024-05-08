package modelo;

public class Cliente {
    String nIF;
    String clave;
    String nombre;
    String apellidos;
    String movil;
    public String getnIF() {
        return nIF;
    }
    public void setnIF(String nIF) {
        this.nIF = nIF;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getMovil() {
        return movil;
    }
    public void setMovil(String movil) {
        this.movil = movil;
    }

    
}
