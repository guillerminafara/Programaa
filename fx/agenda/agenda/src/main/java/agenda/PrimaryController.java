package agenda;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Conexion;
import entidades.Empleados;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button BAnterior;

    @FXML
    private Button BIni;

    @FXML
    private Button BSiguiente;

    @FXML
    private Button BUltimo;

    @FXML
    private TextField TFApellido;

    @FXML
    private TextField TFCargo;

    @FXML
    private TextField TFFechaNac;

    @FXML
    private TextField TFNombre;

    @FXML
    private TextField TFTelefono;

    @FXML
    private TextField TFidEmpleado;

    @FXML
    void initialize(ActionEvent event) {

    }

    Connection con = null;

    public void initialize() {

        con = Conexion.getConexion();
        primero();
        
        
    }

    public void primero(){
        Empleados empleado = new Empleados();
        int i = 1;
        empleado = empleado.primero();

        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());


    }
    public void deshabilitarIni(int i) {
        // Empleados empleados = new Empleados();
        // empleados.setIdEmpleado(i);
        if (i == 1) {
            BIni.setDisable(true);
            BAnterior.setDisable(true);
        }
    }

    public void deshabilitarUltimo(int i) {
        Empleados empleados = new Empleados();
        if (empleados.getIdEmpleado() == 1) {
            // BIni.setDisable(true);
        }
    }
}