package gym;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import modelo.Cliente;

public class EscInitSes implements Initializable{
    private Connection con = null;
    Cliente cliente;
    public EscInitSes() {
        con = Conexion.getConexion();
    }
    @FXML
    private Button botonAtras;

   
    @FXML
    private Button BotonIngresa;
    @FXML
    private PasswordField TextContra;


    @FXML
    private ImageView imagenLogo;

    @FXML
    private TextField textFmail;

    @FXML
    void InicaSesion(ActionEvent event) {
        cliente=login(textFmail.getText(),TextContra.getText() );
        if(cliente.isEstado()){

        }else{

        }
    }
    @FXML
    void atras(ActionEvent event) {
        App.escena1();
    }

    public Cliente login(String log, String pass){
        Cliente cliente=null;
        PreparedStatement ps;
        String sql;

        if(log.contains("@")){
             sql="Select * from cliente where email= ?"; // verifiicar el metodo de ingreso
        }else{
             sql="Select * from cliente where nif= ?";

        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, log);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){

                if(cliente.getPass().equals(pass)&& cliente.getMail().equals(log)){
                    cliente= new Cliente();
                    cliente.setIdCliente(rs.getString("idcliente"));
                    cliente.setIdCliente(rs.getString("nif"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setMail(rs.getString("email"));
                    cliente.setPass(rs.getString("pass"));
                    cliente.setEstado(rs.getBoolean("estado"));
                }else{
                    cliente= new Cliente(false,"","","","","", "");

                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("El usuario no se encuentra registrado");
                alert.setTitle("Inicio de Sesión ");
                alert.show();
                cliente= new Cliente(false,"","","","","", "");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cliente;
   
    }




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
       
    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("El mail no se encuentra registrado");
        alert.setTitle("Inicio de Sesión ");
        alert.show();
    }
}