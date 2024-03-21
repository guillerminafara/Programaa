package Reserva;
import java.sql.Connection;
import java.util.HashMap;

public class Vuelo_Pasajeros {
    private int id_vuelo;
    private int id_pasajero;
    Vuelos vuelo;
    Pasajeros Pasajero;
    HashMap<Integer, Boolean> mapa= new HashMap<>();
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
    public void cargaMapa(){
        int n= vuelo.getCapacidad();
        for (int i = 1; i <=n; i++) {
            mapa.put(i, false);
        }
       
    }
    public boolean corroboraAsiento(){
        cargaMapa();
        if(mapa.get(n_asiento)){
            return true;
        }else{
            return false;
        }

    }
    
}
