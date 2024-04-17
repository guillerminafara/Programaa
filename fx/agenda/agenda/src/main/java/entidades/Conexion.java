package entidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    
        private static final String URL = "jdbc:mysql://localhost/empresaa";
        private static final String USUARIO = "root";
        private static final String PASSWORD = "";

        public Conexion() {
        }
        public static Connection getConexion() {

            Connection conectar = null;
            try {
                conectar = DriverManager.getConnection(URL, USUARIO, PASSWORD); //crea una conexion y la almacena en una variable de tipo Connection
            } catch (SQLException ex) { 
                System.out.println("ta roto");

            }
            return conectar;

        }
}
