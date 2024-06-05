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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.input.KeyEvent;
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
    private ImageView imagenlogo;

    @FXML
    private Label labelAdvierte;

    @FXML
    private Label labelComprueba;
    @FXML
    private TextField textFApellido;

    @FXML
    private TextField textFEmail;

    @FXML
    private TextField textFNif;

    @FXML
    private TextField textFNombre;

    @FXML
    private PasswordField textFPass;

    @FXML
    private PasswordField textPass2;

    @FXML
    void accionAtras(ActionEvent event) {
        App.volver();
    }

    @FXML
    void accionRegistrate(ActionEvent event) {
        // cliente= new Cliente();
        try {
            crearUsuario();

        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 1");
            alert.setTitle("Registro de Usuario");
            alert.show();
        } catch (NullPointerException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 5");
            alert.setTitle("Registro de Usuario");
            alert.show();
        }

    }

    @FXML
    void accionVerificaContra(KeyEvent event) {
        verificaContra();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
public boolean verificaContra(){
    boolean puede= false;
    if (textFPass.getText().equals(textPass2.getText())) {
       
       puede= true;
    
        labelComprueba.setText("");
    } else {
        labelComprueba.setText("Contraseñas no coinciden");
    }
    return puede;
}
    public boolean crearUsuario()  throws InvocationTargetException {
        boolean puede=false;
        String sql = "INSERT INTO cliente(nombre, apellido, nif, estado, mail, pass) values (?, ?, ?, ?, ?, ?) ";
        try {
            if (verificaExtension()&& verificaContra()) {

                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, textFNombre.getText());
                ps.setString(2, textFApellido.getText());
                ps.setString(3, textFNif.getText());
                ps.setBoolean(4, true);
                ps.setString(5, textFEmail.getText());
                ps.setString(6, textFPass.getText());
               
                if (ps.executeUpdate() == 1) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if(rs.next()){
                    cliente = new Cliente();
                    int idClienteGenerado = rs.getInt(1);
                        
                        cliente.setIdCliente(idClienteGenerado);
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
                        puede=true;
                        alert.show();
                        App.escena4();
                        
                    }
                }
            }else{
                Alert alert= new Alert(AlertType.ERROR);
                alert.setContentText("errror en la carga de datos ");
                alert.show();
            }
           

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 3");
            alert.setTitle("Registro de Usuario");
            alert.show();
        
        } catch (NullPointerException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("Ya eres parte de nuestro equipo Accion 2");
            alert.setTitle("Registro de Usuario");
            alert.show();
        }
         return puede;
    }

    public static Cliente pasarUser() {
       
        return cliente;
    }

    public boolean verificaExtension() {
        boolean puede = true;
        if (textFNif.getText().length() > 9) {
            // textFNif.setText("");
            labelAdvierte.setText("NIF INVÁLIDO");
            puede = false;
        } else if (textFNif.getText().isEmpty() || textFApellido.getText().isEmpty() || textFNombre.getText().isEmpty()
                || textFEmail.getText().isEmpty()) {
            labelAdvierte.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");
            puede = false;
        }
        return puede;

    }
}
