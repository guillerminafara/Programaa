package Reserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static String url = "jdbc:mysql://localhost/reservas";
    static String user = "root";
    static String password = "";
    // private static Conexion conec = null;

    Conexion() {

    }

    public static Connection gConexion() {
        try {
            Connection conectar = null;
            // if (conec == null) { // ...entonces crea la unica conexion
            // conec = new Conexion();

            // }

            conectar = DriverManager.getConnection(url, user, password);
            if (conectar != null) {
                System.out.println("conectado");
            } else {
                System.out.println("no conectado");
            }
         //   Connection.getConnection(url,);

            // load and register JDBC driver for MySQL
          //  Class.forName("com.mysql.jdbc.Driver");
          Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (SQLException e) {
            // JOptionPane.showMessageDialog(null, "error de conexion " + e);
            System.out.println(e.getMessage() + "error en drivers");
            // e.printStackTrace();
        }
        return conectar;
    }
}
