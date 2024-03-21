import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vuelos {
    private int id_vuelo;
    private String origen;
    private String destino;
    private String fecha;
    private int capacidad;

    private Connection con = null;

    Vuelos() {
        con = Conexion.gConexion();
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
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

    public void agregarVuelo(Vuelos vuelo) {
        String sql = "INSERT INTO vuelo(id_vuelo, origen, destino, fecha, capacidad)value(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Statement st= con.createStatement();
            ps.setInt(1, id_vuelo);
            ps.setString(2, origen);
            ps.setString(3, destino);
            ps.setString(4, fecha);
            ps.setInt(5, capacidad);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            vuelo.setId_vuelo(rs.getInt(1));// verificar que no se repita
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void reserva_vuelo(){

    }

}
