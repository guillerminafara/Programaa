package cajeronova;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Cliente;

public class Esceena1 implements Initializable {
    static Cliente cliente = null;
     Escena2 escena2 = new Escena2();
    Connection con = null;
    // String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    // String user = "root";
    // String password = "Paquito2024----";
    String url = "jdbc:mysql://localhost/CajeroNOVA";
    String user = "root";
    String password = "";

    public Esceena1() { // mi constructor

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Connection conectar() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    @FXML
    private Button BIniciarSesion;

    @FXML
    private PasswordField PFPAss;

    @FXML
    private TextField TFNif;

    // public void enviarAEsc2(ActionEvent Event)throws IOException{

    // FXMLLoader loader = new FXMLLoader(App.class.getResource("Escena2.fxml"));
    // Parent root= loader.load();
    // //scene2 = new Scene(loadFXML2.load());
    // Stage stage = new Stage();
    // stage.setScene(new Scene(root));
    // stage.show();
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        // promtping();
        BIniciarSesion.setOnMouseEntered(MouseEvent -> {
            BIniciarSesion.setStyle("-fx-background-color: #6599CA;");
        });
        BIniciarSesion.setOnMouseExited(MouseEvent -> {
            BIniciarSesion.setStyle("-fx-background-color: #0073EB;");
        });
        // BIniciarSesion.setOnMousePressed(MouseEvent -> {
        // BIniciarSesion.setStyle("-fx-background-color: #6599CA;");
        // });
        // BIniciarSesion.setOnMouseReleased(MouseEvent -> {
        // BIniciarSesion.setStyle("-fx-background-color: #0073EB;");
        // });
    }

    @FXML
    void InitSesion(ActionEvent event) {

        System.out.println("ingresa");
        System.out.println(TFNif.getText());
        System.out.println(PFPAss.getText());
        if (login(TFNif.getText(), PFPAss.getText()) != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Bienvenido");
            alert.setHeaderText("Ingreso Correcto");
            // alert.setContentText("Bienvenido");
            alert.show();
          //  enviarObje();
            App.cambioScena2();

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error");

            alert.setContentText("NIF o Clave incorrecta");
            alert.show();
            // throw new NullPointerException("");

        }

    }

    public void promtping() {
        TFNif.setPromptText("NIF o NIE");
        // TFClave.setPromptText("Clave de acceso");
    }

    public Cliente enviarObje() {
       // escena2.cargalabel(cliente);
        return cliente;
    }

    public Cliente login(String nif, String pass) {

        String sql = "Select * from Cliente where NIF=?";

        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setnIF(nif);
                cliente.setClave(rs.getString("clave"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setMovil(rs.getString("movil"));
                // escena2.cargarCombo();
                 escena2.cargarCliente(cliente);
                // escena2.cargalabel(cliente.getNombre());

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cliente;
    }
    // public Cliente devuelvoCliente(){

    // return cliente;
    // }
}
