package Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class Vuelos {
    private String id_vuelo;
    private String origen;
    private String destino;
    private String fecha;
    private int capacidad;

    private Connection con = null;

    Vuelos() {
        con = Conexion.gConexion();
    }

    public Vuelos(String id_vuelo, String origen, String destino, String fecha, int capacidad) {
        this.id_vuelo = id_vuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.capacidad = capacidad;
        con = Conexion.gConexion();
    }

    public String getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(String id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void agregarVuelo() {
        String sql = "INSERT INTO vuelos(id_vuelo, origen, destino, fecha, capacidad)value(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            // Statement st= con.createStatement();
            ps.setString(1, id_vuelo);
            ps.setString(2, origen);
            ps.setString(3, destino);
            ps.setString(4, fecha);
            ps.setInt(5, capacidad);

            ps.executeUpdate();
           
           /// vuelo.setId_vuelo(rs.getInt(1));// verificar que no se repita
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

    }
    //mostramos vuelos con toda su información 
    public ArrayList<Vuelos> mostrarVuelos(){
        ArrayList<Vuelos> lista= new ArrayList<>();
        String sql= "SELECT * FROM Vuelos ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
        while (rs.next()) {
            Vuelos vuelo= new Vuelos();
            vuelo.setId_vuelo(rs.getString("id_vuelo"));
            vuelo.setOrigen(rs.getString("origen"));
            vuelo.setDestino(rs.getString("destino"));
            vuelo.setFecha(rs.getString("fecha"));
            vuelo.setCapacidad(rs.getInt("capacidad"));
            lista.add(vuelo);
        }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;
    }
   
    public Vuelos buscarXIDVuelos(String id_vuelo){
        Vuelos vuelo= new Vuelos();
        String sql= "SELECT * FROM Vuelos where id_vuelo like ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id_vuelo);
            ResultSet rs= ps.executeQuery();
            vuelo.setOrigen(rs.getString("origen"));
            vuelo.setDestino(rs.getString("destino"));
            vuelo.setFecha(rs.getString("fecha"));
            vuelo.setCapacidad(rs.getInt("capacidad"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
        return vuelo;
    }
}
