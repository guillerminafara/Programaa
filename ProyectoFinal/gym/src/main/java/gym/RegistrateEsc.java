package gym;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import modelo.Cliente;

public class RegistrateEsc implements Initializable {
    Connection con = null;
    static Cliente cliente;

    public RegistrateEsc() {
        con = Conexion.getConexion();
    }

    @FXML
    private Button botonAtras;
    @FXML
    private Button botonRegistrate;

    @FXML
    private TextField textFApellido;

    @FXML
    private TextField textFEmail;

    @FXML
    private TextField textFNif;

    @FXML
    private TextField textFNombre;

    @FXML
    private TextField textFPass;

    @FXML
    void accionAtras(ActionEvent event) {
        App.escena2();
    }

    @FXML
    void accionRegistrate(ActionEvent event) {
      //  cliente= new Cliente();
        try {
            crearUsuario();
            
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 1");
            alert.setTitle("Registro de Usuario");
            alert.show();
        }catch(NullPointerException e){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 5");
            alert.setTitle("Registro de Usuario");
            alert.show();
        }
       
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    public void crearUsuario()  throws InvocationTargetException{
       
        String sql = "INSERT INTO cliente(nombre, apellido, nif, estado, mail, pass) values (?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, textFNombre.getText());
            ps.setString(2, textFApellido.getText());
            ps.setString(3, textFNif.getText());
            ps.setBoolean(4, true);
            ps.setString(5, textFEmail.getText());
            ps.setString(6,textFPass.getText());
         //   ps.executeUpdate();

        //     ResultSet rs = ps.getGeneratedKeys();
        //  if (rs.next()) {
                cliente= new Cliente();
                System.out.println(textFApellido.getText());
                cliente.setNombre(textFNombre.getText());
                cliente.setApellido(textFApellido.getText());
                cliente.setEstado(true);
                cliente.setNif(textFNif.getText());
                cliente.setMail(textFEmail.getText());
                cliente.setPass(textFPass.getText());
          
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Bienvenido!");
                    alert.setContentText("Ya eres parte de nuestro equipo");
                    alert.setTitle("Registro de Usuario");
                    alert.show();
                    App.escena4();
            
            
            // } else{
            //     System.out.println("else del rs.next");
            // }
           
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 2");
            alert.setTitle("Registro de Usuario");
            alert.show();
            System.out.println("ya estas loquillo");
        }catch(NullPointerException e){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 2");
            alert.setTitle("Registro de Usuario");
            alert.show();
        }
       // return cliente;
    }

    public static Cliente pasarUser(){
        System.out.println(RegistrateEsc.cliente);
        return cliente;
    }

}
