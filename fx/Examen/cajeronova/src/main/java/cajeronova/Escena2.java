
package cajeronova;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.binding.IntegerExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Cuenta;
import modelo.Factura;

/**
 * Escena2
 */
public class Escena2 implements Initializable {
    Alert alert;
    Cuenta cuenta;
    Factura factura;
    ArrayList<Cuenta> lista;
    ArrayList<String> listaFacturas = new ArrayList<>();
    Connection con = null;
    String url = "jdbc:mysql://127.0.0.1:33006/CajeroNOVA";
    String user = "root";
    String password = "Paquito2024----";

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
        cargalabel();
        cargarCombo();
    }

    @FXML
    void pagaFactura(ActionEvent event) {
        cuenta = buscarCuenta(CCuentas.getValue().toString());
        cliente = cuenta.getCliente();
        System.out.println("prueba corrobora cliente" + cliente);
        ArrayList<String> choices = buscarFacturas(cliente);
        System.out.println(choices);
        ChoiceDialog<String> choiceDia = new ChoiceDialog<>(null, choices);
        //ChoiceDialog choiceDia = new ChoiceDialog();
        choiceDia.setTitle("Seleccionar factura");
        choiceDia.setHeaderText("Saldo Disponible: " + cuenta.getSaldo());
        choiceDia.setContentText("Elija la factura a pagar");
        choiceDia.setContentText("Facturas: ");
        Optional<String> result = choiceDia.showAndWait();
        if (result.isPresent()) {
            System.out.println("Has elegido: " + result.get());
            // Obteniendo el resultado con una lambda
            result.ifPresent(numero -> {
                if(cuenta.getSaldo()>= factura.getImporte()){
                    actualizaFactura(0, 0);
                    Alert aler = new Alert(AlertType.CONFIRMATION);
                    aler.setTitle("Pagar Factura");
                    aler.setContentText("saldo disponible:"+ cuenta.getSaldo()+"\n La factura num: "+ numero+ "\n Tiene un importe de: "+ factura.getImporte() );
                  
                    aler.show();
                }
                System.out.println("Has elegido: " + numero);

            });
        }

    }

    @FXML
    void sacaDinero(ActionEvent event) {

        TextInputDialog texInput = new TextInputDialog();
        texInput.setTitle("Sacar Dinero");
        System.out.println(Integer.parseInt(CCuentas.getValue().toString()));
        // for (ArrayList cuentas : this.listaCuentas()) {

        // }
        String montoSEle = texInput.getDefaultValue().toString();
        System.out.println("monto sele" + montoSEle);
        cuenta = buscarCuenta(CCuentas.getValue().toString());
        texInput.setHeaderText("Saldo Disponible: " + cuenta.getSaldo());
        texInput.setContentText("Introduce el dinero: ");
        // texInput.show();
        Optional<String> result = texInput.showAndWait(); // Obteniendo el resultado
        if (result.isPresent()) {
            System.out.println("Hola adadad" + result.get());
            // Obteniendo el resultado con una lambda
            result.ifPresent(monto -> {
                System.out.println("Hola " + monto);
                if (cuenta.getSaldo() >= Integer.parseInt(monto)) {

                    System.out.println("sirveeeee");
                    extraerDinero(cuenta, Double.parseDouble(monto));
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Sacar Dinero");
                    alert.setHeaderText("Operación realizada con éxito");
                    alert.setContentText("OPERACIÓN REALIZADA\n Saldo actual: " +
                            cuenta.getSaldo());
                    alert.show();

                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Sacar Dinero");
                    alert.setHeaderText("Advertencia");
                    alert.setContentText("Saldo insuficiente \n sólo puedes extraer: " + cuenta.getSaldo());
                    alert.show();
                }

            });
        }
        ;

        // if (cuenta.getSaldo() >= montoSEle) {

        // // alert.showAndWait().ifPresent(response -> {
        // // if (response == ButtonType.OK) {
        // // extraerDinero(cuenta);

        // // } else {

        // // }
        // // });
        // extraerDinero(cuenta);
        // System.out.println("saldo con extraci"+ cuenta.getSaldo());

        // }
    }

    @FXML
    void seleccionaCuenta(ActionEvent event) {

        cuenta = (Cuenta) CCuentas.getValue();
        if (cuenta != null) {
            BSacarDinero.setDisable(false);
            BPagarFActura.setDisable(false);

        }

    }

    @FXML
    void cerrarSesion(ActionEvent event) {
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("¿Seguro que deseas salir?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                App.cambioScena1();

            } else {

            }
        });
    }
    // @FXML
    // void mostraCombo(MouseEvent event) {

    // // cargarCombo();
    // }

    // public void enviarAEsc1(ActionEvent Event) throws IOException {

    // FXMLLoader loader = new FXMLLoader(App.class.getResource("Esceena1.fxml"));
    // Parent root = loader.load();
    // // escena1.enviarObje();
    // // scene2 = new Scene(loadFXML2.load());
    // //cargalabel();
    // Stage stage = new Stage();
    // stage.setScene(new Scene(root));
    // stage.show();
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        boolean si = true;
        // cliente =cargarCliente(cliente);
        cambiarColorBoton();
        cargalabel();
        cargarCombo();
        BPagarFActura.setDisable(si);
        BSacarDinero.setDisable(si);
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
        System.out.println(cliente);
        LFulano.setText(cliente.getApellidos() + ", " + cliente.getNombre());
        // LFulano.setText(cliente.getApellidos() + ", " + cliente.getNombre());
    }

    public ArrayList listaCuentas() {
        Cuenta cuenta = null;
        lista = new ArrayList<>();
        String sql = "SELECT * FROM Cuenta where NIF=?";
        PreparedStatement ps;
        // System.out.println(cliente);
        try {
            ps = conectar().prepareStatement(sql);
            ps.setString(1, cliente.getnIF());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cuenta = new Cuenta();
                cuenta.setCliente(cliente);
                // System.out.println(cliente);
                cuenta.setNum_cta(rs.getString("num_cta"));
                cuenta.setSaldo(rs.getInt("saldo"));
                // System.out.println(cuenta);
                lista.add(cuenta);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;
    }

    public Cuenta buscarCuenta(String numerocuenta) {
        Cuenta cuenta = null;
        // lista= new ArrayList<>();
        String sql = "SELECT * FROM Cuenta where NIF=? and num_cta=?";
        PreparedStatement ps;
        // System.out.println(cliente);
        try {
            ps = conectar().prepareStatement(sql);
            ps.setString(1, cliente.getnIF());
            ps.setString(2, numerocuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuenta = new Cuenta();
                cuenta.setCliente(cliente);
                // System.out.println(cliente);
                cuenta.setNum_cta(numerocuenta);

                // cuenta.setNum_cta(rs.getString("num_cta"));
                cuenta.setSaldo(rs.getInt("saldo"));
                // System.out.println(cuenta);
                // lista.add(cuenta);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cuenta;
    }

    public void cargarCombo() {
        // BCerrarSesion.setOnMouseEntered(MouseEvent -> {
        // BCerrarSesion.setStyle("-fx-background-color: #6599CA;");
        // });
        // BCerrarSesion.setOnMouseExited(MouseEvent -> {
        // BCerrarSesion.setStyle("-fx-background-color: #E3E3E3;");
        // });
        CCuentas.getItems().addAll(listaCuentas());

    }

    public void extraerDinero(Cuenta cuenta, double monto) {
        double saldonuevo = 0.0;
        String sql = "select * from Cuenta where num_cta=?";
        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, cuenta.getNum_cta());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuenta.setSaldo(rs.getDouble("saldo"));
                saldonuevo = cuenta.getSaldo() - monto;
                actualizaSaldo(cuenta, saldonuevo);
                System.out.println("saldo nuevoooo:" + saldonuevo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void actualizaSaldo(Cuenta cuenta, double saldonuevo) {
        String sql = "update Cuenta set saldo=? where num_cta=?";
        PreparedStatement ps;
        try {
            ps = conectar().prepareStatement(sql);
            cuenta.setSaldo(saldonuevo);
            ps.setDouble(1, saldonuevo);
            ps.setString(2, cuenta.getNum_cta());

            if (ps.executeUpdate() == 1) {
                System.out.println("con eeeeexito");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<String> buscarFacturas(Cliente cliente) {

        try {
            String sql = "select * from Factura where NIF=?";
            PreparedStatement ps;

            ps = conectar().prepareStatement(sql);
            ps.setString(1, cliente.getnIF());
            System.out.println("nif" + cliente.getnIF());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                factura = new Factura();
                factura.setNum_fra(rs.getInt("num_fra"));
                factura.setCliente(cliente);
                factura.setNum_habitacion(rs.getInt("num_habitacion"));
                factura.setImporte(rs.getDouble("importe"));
                listaFacturas.add(String.valueOf(factura.getNum_fra()));
                System.out.println(factura);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaFacturas;

    }

    public void actualizaFactura(double nuevoSaldo, int num_fra) {
        String sql = "UPDATE Factura SET importe=? where num_fra=?";
        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setDouble(1, nuevoSaldo);
            ps.setInt(2, num_fra);

            if (ps.executeUpdate() == 1) {
                factura.setImporte(nuevoSaldo);
                System.out.println("si cargó ");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}