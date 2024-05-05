package dinosaurios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // static String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    // static String user = "root";
    // static String password = "Paquito2024----";

    static String url = "jdbc:mysql://localhost/jurassicpark";
    static String user = "root";
    static String password = "";
    Conexion() {

    }

    public static Connection gConexion() {
        Connection conectar = null;

        try {
            conectar = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // JOptionPane.showMessageDialog(null, "error de conexion " + e);
            System.out.println(e.getMessage()+ "error en drivers");
            // e.printStackTrace();
        }
        return conectar;
    }
}