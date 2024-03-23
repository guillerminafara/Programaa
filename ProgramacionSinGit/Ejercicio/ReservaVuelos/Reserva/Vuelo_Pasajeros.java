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
    Pasajeros Pasajero;

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
    //idea para corregir hacer un metodo que seleccione todas los asientos y que devuelva un mapa 
//buscamos asientos en gral y cargamos un mapa
    public void buscarAsientos(Vuelos vuelo){
        String sql = "SELECT n_asiento FROM Vuelos";
        HashMap<Integer, Boolean> mapa= new HashMap<>(); //trueocupado
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            for (int i = 0; i < vuelo.getCapacidad(); i++) {
                mapa.put(i,rs.getBoolean("n_asiento") );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    
       
    }
    //corroboramos si se encuentran ocupados, true= ocupado. si esta libre, lo ocupamos 
    public void corroboraAsiento(Vuelos vuelo){ //true ocupado
        
        if(mapa.get(n_asiento)){
            System.out.println("asiento ocupado");
        }else{
            mapa.replace(n_asiento, true);
            System.out.println("Asiento Seleccionado");
        }
    }
   
    public Vuelo_Pasajeros reservarVuelo(String id){
        Vuelo_Pasajeros reserva= new Vuelo_Pasajeros();

        return reserva;
    }
}
