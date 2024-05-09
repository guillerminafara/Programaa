
package cajeronova;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import modelo.Cliente;
import modelo.Cuenta;

/**
 * Escena2
 */
public class Escena2 implements Initializable {
    Connection con = null;
    // String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    // String user = "root";
    // String password = "Paquito2024----";
    String url = "jdbc:mysql://localhost/CajeroNOVA";
    String user = "root";
    String password = "";
    // Esceena1 escena1=new Esceena1();
    // private Cliente cliente =escena1.devuelvoCliente();
    static Cliente cliente;

    public Connection conectar() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public Escena2() { // mi constructor
    }

    @FXML
    private Button BCerrarSesion;

    @FXML
    private Button BPagarFActura;

    @FXML
    private Button BSacarDinero;

    @FXML
    private ComboBox CCuentas;

    @FXML
    private Label LFulano;

    @FXML
    void prueba(ActionEvent event) {


    }

    @FXML
    void mostraCombo(MouseEvent event) {
        //cargarCombo();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        boolean si = false;
        // cargalabel();
        cambiarColorBoton();
        // CCuentas.getItems().add(buscarCuenta());
        // cargarCliente(cliente);

    }

    public void cargarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cambiarColorBoton() {
        BCerrarSesion.setOnMouseEntered(MouseEvent -> {
            BCerrarSesion.setStyle("-fx-background-color: #6599CA;");
        });
        BCerrarSesion.setOnMouseExited(MouseEvent -> {
            BCerrarSesion.setStyle("-fx-background-color: #E3E3E3;");
        });

        BPagarFActura.setOnMouseEntered(MouseEvent -> {
            BPagarFActura.setStyle("-fx-background-color: #6599CA;");
        });
        BPagarFActura.setOnMouseExited(MouseEvent -> {
            BPagarFActura.setStyle("-fx-background-color: #E3E3E3;");
        });
        BSacarDinero.setOnMouseEntered(MouseEvent -> {
            BSacarDinero.setStyle("-fx-background-color: #6599CA;");
        });
        BSacarDinero.setOnMouseExited(MouseEvent -> {
            BSacarDinero.setStyle("-fx-background-color: #E3E3E3;");
        });

    }

    public void cargalabel() {

        LFulano.setText(cliente.getApellidos() + ", " + cliente.getNombre());
    }

    public Cuenta buscarCuenta() {
        Cuenta cuenta = null;
        String sql = "SELECT * FROM Cuenta where NIF=?";
        PreparedStatement ps;
        System.out.println(cliente);
        try {
            ps = conectar().prepareStatement(sql);
            ps.setString(1, cliente.getnIF());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuenta = new Cuenta();
                cuenta.setCliente(cliente);
                System.out.println(cliente);
                cuenta.setNum_cta(rs.getString("num_cta"));
                cuenta.setSaldo(rs.getInt("saldo"));
                System.out.println(cuenta);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cuenta;
    }

    public void cargarCombo() {
        // BCerrarSesion.setOnMouseEntered(MouseEvent -> {
        //     BCerrarSesion.setStyle("-fx-background-color: #6599CA;");
        // });
        // BCerrarSesion.setOnMouseExited(MouseEvent -> {
        //     BCerrarSesion.setStyle("-fx-background-color: #E3E3E3;");
        // });
       // CCuentas.setOnMou;


        
    }

}