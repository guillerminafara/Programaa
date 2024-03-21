import java.sql.Connection;

public class Pasajeros {
    private int id_pasajero; 
    private String pasaporte;
    private String nombre_pasajero;
    private Connection con = null;

    Pasajeros() {
        con = Conexion.gConexion();

    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre_pasajero() {
        return nombre_pasajero;
    }

    public void setNombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
    }

   public void agregarPasajero(){
    
   }
    
}
