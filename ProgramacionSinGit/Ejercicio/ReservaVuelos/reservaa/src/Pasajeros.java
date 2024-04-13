
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

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

    @Override
    public String toString() {
        return "id_pasajero: " + id_pasajero + "\n Nombre: " + nombre_pasajero + "\n Pasaporte: " + pasaporte;
    }
// METODO PARA CREAR PASAJEROS
    public void agregarPasajero() throws MysqlDataTruncation{
        try {
            String sql = "INSERT INTO pasajeros(pasaporte, nombre)values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasaporte);
            if (pasaporte.length() > 9) {
              System.out.println("el pasaporte debe contener hasta 9 caracteres");
                throw new MysqlDataTruncation("el pasaporte debe contener hasta 9 caracteres",1, true, true, 9, 9, 1);
            }
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
            System.out.println("Error al ingresar a la tabla pasajeros");
        }

    }
//METODO PARA BUSCAR PASAJEROS. LO BUSCAMOS CON PASAPORTE. SI EXISTE, DEVUELVE UN OBJETO CON INFO DEL PASAJERO 
    public Pasajeros buscarPasajeros(String pasaporte) {
        // ArrayList<Pasajeros> listaPasajeros= new ArrayList<>();
        Pasajeros pasajero = null;
        try {
            String sql = "SELECT * FROM pasajeros WHERE pasaporte= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pasaporte);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pasajero = new Pasajeros();
                pasajero.setId_pasajero(rs.getInt("id_pasajero"));
                pasajero.setNombre_pasajero(rs.getString("nombre"));

            } else {
                System.out.print("el pasajero no existe en la base. ");
            }
        } catch (SQLException e) {
            System.out.println("Error al ingresar a la tabla pasajeros");
        }
        return pasajero;
    }
//METODO PARA BUSCAR PASAJEROS. LO BUSCAMOS CON ID. SI EXISTE, DEVUELVE UN OBJETO CON INFO DEL PASAJERO 
    public Pasajeros buscarPasajerosPorId(int id) {

        Pasajeros pasajero = null;
        try {
            String sql = "SELECT * FROM pasajeros WHERE id_pasajero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            pasajero = new Pasajeros();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                pasajero.setId_pasajero(id);
                pasajero.setNombre_pasajero(rs.getString("nombre"));
                pasajero.setPasaporte(rs.getString("pasaporte"));
            } else {
                System.out.println("no existe en la base");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("error al ingresar a la tabla Pasajeros");
        }
        return pasajero;
    }
// METODO RANDOM PARA PROBAR SI ANDABA. IGNORAR
    public void busca() {
        try {
            String sql= "Select * from vuelos";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String codi = rs.getString("id_vuelo");
                // String apellido = rs.getString("COGNOM");
                // String apellido= rs.getString("COGNOM");
                // String especialidad= rs.getString("ESPECIALITAT");

                // String nombre = rs.getString("Nom");
                // int codi= rs.getInt("CodiActor");
                // System.out.println(nombre);
                System.out.println(codi);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error al ingresar a la tabla pasajeros");
        }
    }

}
