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
    static int i = 1;
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
        ultimo();

    }

    @FXML
    void siguiente(ActionEvent event) {

        siguientes(i);
        System.out.println(i);
        i++;
    }

    @FXML
    void anterior(ActionEvent event) {
        anterior(i);
        i--;
    }

    Connection con = null;

    public void initialize() {

        con = Conexion.getConexion();
        primero();

    }

    public void primero() {
        Empleados empleado = new Empleados();

        empleado = empleado.primero();

        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());
        deshabilitarIni(true);

    }

    public void ultimo() {
        Empleados empleado = new Empleados();

        empleado = empleado.ultimo();

        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());
        deshabilitarIni(false);
        if (empleado.getIdEmpleado() == empleado.Totalidad()) {
            deshabilitarUltimo(true);
        }

    }

    public void siguientes(int i) {
        Empleados empleado = new Empleados();
        empleado = empleado.siguiente(i);
        if (empleado.getIdEmpleado() == empleado.Totalidad()) {
            deshabilitarUltimo(true);

        } else {
            TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
            TFNombre.setText(empleado.getNombre());
            TFApellido.setText(empleado.getApellido());
            TFTelefono.setText(empleado.getTelefono());
            TFFechaNac.setText(empleado.getFechaNac());
            TFCargo.setText(empleado.getCargo());
            deshabilitarIni(false);
        }

    }

    public void anterior(int i) {
        Empleados empleado = new Empleados();
        empleado = empleado.siguiente(i);
        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());
        if (empleado.getIdEmpleado() == 1) {
            deshabilitarIni(true);
        } else {
            deshabilitarIni(false);
        }
    }

    public void deshabilitarIni(boolean estado) {
        // Empleados empleados = new Empleados();
        // empleados.setIdEmpleado(i);

        BIni.setDisable(estado);
        BAnterior.setDisable(estado);

    }

    public void deshabilitarUltimo(boolean estado) {
        BUltimo.setDisable(estado);
        BSiguiente.setDisable(estado);

    }
}