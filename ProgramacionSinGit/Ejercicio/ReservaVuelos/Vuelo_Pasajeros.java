import java.sql.Connection;

public class Vuelo_Pasajeros {
    private int id_vuelo;
    private int id_pasajero;
    private int n_asiento;
    private Connection con = null;

    Vuelo_Pasajeros() {
        con = Conexion.gConexion();
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getN_asiento() {
        return n_asiento;
    }

    public void setN_asiento(int n_asiento) {
        this.n_asiento = n_asiento;
    }

    
}
