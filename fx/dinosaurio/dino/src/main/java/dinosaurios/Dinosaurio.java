package dinosaurios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.ObservableList;

// La clase Dinosaurio tiene como atributos nombre, tamanyo (grande, mediano o peque);
// alimentación (carnivoro, omnivoro o herbivoro) y tipo (tierra, aire o agua).

public class Dinosaurio {
    int idDino;
    String nombre;
    String tamanyo;
    String alimentacion;
    String tipo;

    public Dinosaurio() {

    }

    public Dinosaurio(String nombre, String tamanyo, String alimentacion, String tipo) {
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.alimentacion = alimentacion;
        this.tipo = tipo;
    }

    public int getIdDino() {
        return idDino;
    }

    public void setIdDino(int idDino) {
        this.idDino = idDino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " de " + tipo;
    }

    static Connection con = null;
    static String url = "jdbc:mysql://localhost/JurassicPark";
    static String user = "root";
    static String password = "";
    
//    static String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
//    static String user = "root";
//    static String password = "Paquito2024----";

    public static Connection conectar() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void listaDinoTabla(ObservableList<Dinosaurio> lista) {
        try {
        Connection con =conectar();

        String sql = "SELECT * FROM Dinosaurio";
        Dinosaurio dino = null;
       
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                dino = new Dinosaurio();
                dino.setIdDino(rs.getInt("id_dino"));
                dino.setNombre(rs.getString("nombre"));
                dino.setTamanyo(rs.getString("tamanyo"));
                dino.setAlimentacion(rs.getString("alimentacion"));
                dino.setTipo(rs.getString("tipo"));
                lista.add(dino);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        

    }

    
    public static void buscarPorTamanio(String tamanio, ObservableList<Dinosaurio> lista) {
        // ArrayList<Dinosaurio> listaDino = new ArrayList<>();
        String sql = "SELECT * FROM Dinosaurio where tamanyo=?";

        try {

            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, tamanio);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dinosaurio dino = new Dinosaurio();

                dino.setIdDino(rs.getInt("id_dino"));
                dino.setNombre(rs.getString("nombre"));
                dino.setTamanyo(tamanio);
                dino.setAlimentacion(rs.getString("alimentacion"));
                dino.setTipo(rs.getString("tipo"));
                lista.add(dino);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    public static void buscarPorTipo(String tipo, ObservableList<Dinosaurio> lista) {
        // ArrayList<Dinosaurio> listaDino = new ArrayList<>();
        String sql = "SELECT * FROM Dinosaurio where tipo=?";
      
        try {

            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dinosaurio dino = new Dinosaurio();

                dino.setIdDino(rs.getInt("id_dino"));
                dino.setNombre(rs.getString("nombre"));
                dino.setTamanyo(rs.getString("tamanyo"));
                dino.setAlimentacion(rs.getString("alimentacion"));
                dino.setTipo(rs.getString("tipo"));
                lista.add(dino);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    public static void buscarPorAlim(String alimentacion, ObservableList<Dinosaurio> lista) {
        // ArrayList<Dinosaurio> listaDino = new ArrayList<>();
        String sql = "SELECT * FROM Dinosaurio where alimentacion=?";
        Dinosaurio dino =null;
        try {

            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, alimentacion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dino = new Dinosaurio();

                dino.setIdDino(rs.getInt("id_dino"));
                dino.setNombre(rs.getString("nombre"));
                dino.setTamanyo(rs.getString("tamanyo"));
                dino.setAlimentacion(rs.getString("alimentacion"));
                dino.setTipo(rs.getString("tipo"));
                lista.add(dino);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
}