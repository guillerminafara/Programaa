

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String url = "jdbc:mysql://localhost/reservas";
    static String user = "root";
    static String password = "";
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
           // JOptionPane.showMessageDialog(null, "error de conexion " + e);
           System.out.println(e.getMessage()+ "error en drivers");
            // e.printStackTrace();
        }
        return conectar;
    }
}