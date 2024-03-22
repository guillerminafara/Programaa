package Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pasajeros {
    private int id_pasajero;
    private String pasaporte;
    private String nombre_pasajero;
    private Connection con = null;

    Pasajeros() {
        con = Conexion.gConexion();

    }

    public Pasajeros(String pasaporte, String nombre_pasajero) {
        this.pasaporte = pasaporte;
        this.nombre_pasajero = nombre_pasajero;
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

    public void agregarPasajero() {
        try {
            String sql = "INSERT INTO pasajeros(pasaporte, nombre_pasajero)values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasaporte);
            ps.setString(2, nombre_pasajero);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Agregado correctamente!");
                // this.setId_pasajero(rs.getInt(1));
            } else {
                System.out.println("hubo un error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Pasajeros> buscarPasajeros(String pasaporte){
       // ArrayList<Pasajeros> listaPasajeros= new ArrayList<>();
        String sql= "SELECT * FROM Pasajeros WHERE pasaporte= ?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1, pasaporte);
        ResultSet rs= ps.executeQuery();
       
       if(rs.next()){
        Pasajeros pasajero= null;
        pasajero.setId_pasajero(rs.getString());
        pasajero.setNombre_pasajero(rs.getString(nombre_pasajero));
          
        }else{
            System.out.println("no existe en la base");
        }
        return "";
    }

}
