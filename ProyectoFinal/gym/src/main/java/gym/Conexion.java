package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     static String url = "jdbc:mysql://127.0.0.1:33006/Gym";
    static String user = "root";
    static String password = "Paquito2024----";

    // static String url = "jdbc:mysql://localhost/Gimnasio";
    // static String user = "root";
    // static String password = "";
    static Connection conectar = null;

    Conexion() {

    }

    public static Connection getConexion() {
      
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        //   System.out.println("error en drivers");
        // }
        try {
            conectar = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // JOptionPane.showMessageDialog(null, "error de conexion " + e);
            System.out.println(e.getMessage()+ "error en conexion");
            // e.printStackTrace();
        }
        return conectar;
    }
}

