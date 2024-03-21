import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

    static String url = "jdbc:mysql://127.0.0.1:33006/vuelos";
    static String user = "root";
    static String password = "paquito2024";
    private static Conexion conec = null;

    Conexion() {

    }

    public static Connection gConexion() {
        Connection conectar = null;
        if (conec == null) { // ...entonces crea la unica conexion
            conec = new Conexion();
        }
        try {
            conectar = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error de conexion " + e);
            // e.printStackTrace();
        }
        return conectar;
    }
}
