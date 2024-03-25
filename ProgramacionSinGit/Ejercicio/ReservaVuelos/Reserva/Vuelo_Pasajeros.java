package Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Vuelo_Pasajeros {
    private int id_vuelo;
    private int id_pasajero;
    Vuelos vuelo;
    Pasajeros pasajero;

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

    @Override
    public String toString() {
        return "Codigo vuelo: "+ id_vuelo+ "\nPasajero: "+pasajero.getPasaporte()+"\n Número de asiento: "+ n_asiento;
    }

    public boolean buscarAsientos(int numAsiento) {
        String sql = "SELECT * FROM Vuelo_Pasajero where n_asiento=numAsiento";
        boolean libre = false;
        // HashMap<Integer, Boolean> mapa= new HashMap<>(); //trueocupado
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("asiento ocupado");
                return true;
            } else {
                System.out.println("asiento disponible");
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return libre;
    }

    public Vuelo_Pasajeros reservarVuelo(String pasaporte) {
        Vuelo_Pasajeros reserva = new Vuelo_Pasajeros();
        pasajero= pasajero.buscarPasajeros(pasaporte);
        if (pasajero !=null) {
            
            System.out.println("pasajero existe" + pasajero);
        }
        return reserva;
    }
}
