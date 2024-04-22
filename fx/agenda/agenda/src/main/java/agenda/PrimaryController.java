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
    static int i = 0;
    int j = 0;

    @FXML
    private Button BAgregar;
    
    @FXML
    private Button BAnterior;

    @FXML
    private Button Bcancel;

    @FXML
    private Button BEliminar;

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
    private Button BModificar;

    @FXML
    void agregar(ActionEvent event) {

    }
    
    @FXML
    void cancelar(ActionEvent event) {

    }
    @FXML
    void eliminar(ActionEvent event) {

    }
    @FXML
    void modificar(ActionEvent event) {
        j++;

        if (j % 2 != 0) {
            System.out.println("aprtado");
            BModificar.setText("Guardar");
            desactivarTF(true);
            deshabilitarUltimo(true);
            deshabilitarIni(true);
        } else {
            BModificar.setText("Modificar");
            // true event.ACTION.equals(false)
            modificarDatos2();
            System.out.println("desactivado");
            // desactivarTF(false);
            // deshabilitarIni(false);
            // deshabilitarUltimo(false);
        }

    }

    @FXML
    void ultimoo(ActionEvent event) {
        ultimo();
        desactivarTF(false);
        deshabilitarIni(false);
        deshabilitarUltimo(true);
    }

    @FXML
    void siguiente(ActionEvent event) {
        desactivarTF(false);

        Empleados empleados = new Empleados();
        if (i >= empleados.totalidad()) {
            i = empleados.totalidad();
        } else {
            i++;
            siguientes(i);
            System.out.println(i);
        }

    }

    @FXML
    void anterior(ActionEvent event) {
        desactivarTF(false);

        if (i <= 1) {
            i = 1;
            primero();
        } else {
            i--;
            anterior(i);
            System.out.println("i: " + i);
        }

    }

    Connection con = null;
    
    public void initialize() {

        con = Conexion.getConexion();
        desactivarTF(false);

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
        if (empleado.getIdEmpleado() <= 1) {
            // deshabilitarIni(true);
            i = 1;
            deshabilitarIni(true);
            deshabilitarUltimo(false);

        }

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
        if (empleado.getIdEmpleado() == empleado.totalidad()) {
            deshabilitarUltimo(true);
        } else {
            deshabilitarIni(false);
            deshabilitarUltimo(false);

        }

    }

    public void siguientes(int i) {
        Empleados empleado = new Empleados();
        empleado = empleado.siguiente(i);
        if (empleado.getIdEmpleado() == empleado.totalidad()) {
            // deshabilitarUltimo(true);
            ultimo();
        } else {
            TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
            TFNombre.setText(empleado.getNombre());
            TFApellido.setText(empleado.getApellido());
            TFTelefono.setText(empleado.getTelefono());
            TFFechaNac.setText(empleado.getFechaNac());
            TFCargo.setText(empleado.getCargo());
            deshabilitarIni(false);
            deshabilitarUltimo(false);
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
        if (empleado.getIdEmpleado() <= 1) {
            // deshabilitarIni(true);
            i = 1;
            primero();
        } else {
            deshabilitarUltimo(false);
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

    public void desactivarTF(boolean desactivado) {
        TFidEmpleado.setEditable(false);
        TFNombre.setEditable(desactivado);
        TFApellido.setEditable(desactivado);
        TFTelefono.setEditable(desactivado);
        TFFechaNac.setEditable(desactivado);
        TFCargo.setEditable(desactivado);
    }

    public void modificarDatos() {
        deshabilitarIni(true);// false=no puedo modificarlos
        deshabilitarUltimo(true);
        desactivarTF(true);
        // String sql="Select * from empleados where idempleado=? ";

        try {
            String sql = "SELECT * FROM empleados WHERE idempleados=?";

            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);
            ps.setString(1, "idempleados");

            rs.updateString("nombre", TFNombre.getText());
            rs.updateString("apellido", TFApellido.getText());
            rs.updateString("telefono", TFTelefono.getText());
            rs.updateString("fechaNac", TFFechaNac.getText());
            rs.updateString("cargo", TFCargo.getText());
            rs.updateRow();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void modificarDatos2() {
        // deshabilitarIni(true); // false no puedo modificarlos
        // deshabilitarUltimo(true);
        // desactivarTF(false);

        String sql = "UPDATE empleados SET nombre=?, apellido=?, telefono=?, fechaNac=?, cargo=? where idempleados=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(6, Integer.parseInt(TFidEmpleado.getText()));
            ps.setString(1, TFNombre.getText());
            ps.setString(2, TFApellido.getText());
            ps.setString(3, TFTelefono.getText());
            ps.setString(4, TFFechaNac.getText());
            ps.setString(5, TFCargo.getText());

            if (ps.executeUpdate() == 1) {
                System.out.println("modificado");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ;
    }
}