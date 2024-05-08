package cajero;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Cliente;

public class Esceena1 implements Initializable{

      Connection con= null;
    // String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    //  String user = "root";
    //  String password = "Paquito2024----";
     String url = "jdbc:mysql://localhost/JurassicPark";
     String user = "root";
     String password = "";
     public Connection conectar() throws SQLException {
    con= DriverManager.getConnection(url,user,password);
    return con;
}
   @FXML
    private Button BIniciarSesion;

    @FXML
    private TextField TFClave;

    @FXML
    private TextField TFNif;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    public void login(String nif){
            String sql= "Select * from Cliente where NIF=?";
            Cliente cliente= null;
            try {
                PreparedStatement ps= conectar().prepareStatement(sql);
                ps.setString(1, nif);
                ResultSet rs= ps.executeQuery();
                if(rs.next()){
                    cliente = new Cliente();
                    cliente.setClave(rs.getString("clave"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellidos(rs.getString("apellidos"));
                    cliente.setMovil(rs.getString("movil"));

                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

}
