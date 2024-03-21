package Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
    public void reserva_vuelo(){

    }

}
