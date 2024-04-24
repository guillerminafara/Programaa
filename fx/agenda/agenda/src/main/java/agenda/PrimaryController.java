package agenda;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import entidades.Conexion;
import entidades.Empleados;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {
    int i = 0;
    int j = 0;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    Empleados em;
    Alert alert;
    Connection con = null;
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
        em= new Empleados();
        j++;

        if (j % 2 != 0) {
            limpiarCampos();
            deshabilitarIni(true);
            deshabilitarUltimo(true);
            desactivarTF(true);
            BEliminar.setDisable(true);
            BAgregar.setText("Guardar");
            BModificar.setDisable(true);
            // agregarEmpleado();
        } else {
            BEliminar.setDisable(false);
            BModificar.setDisable(false);
            agregarEmpleado();
            if (i <= 1) {
                primero();
            } else if (i >= em.totalidad()) {
                ultimo();
            } else {
                siguientes(i);
            }
        }

    }

    @FXML
    void cancelar(ActionEvent event) {
        cancelarCambios();
    }

    @FXML
    void eliminar(ActionEvent event) {
        em= new Empleados();

        alert= new Alert(AlertType.CONFIRMATION);
        alert.setContentText("¿Estas segurisimo que deseas eliminar al empleado?");
        alert.showAndWait().ifPresent(response->{
        if(response==ButtonType.OK){
            eliminarEmpleado();
            if (i <= 1) {
                primero();
            } else if (i >= em.totalidad()) {
                ultimo();
            } else {
                siguientes(i);
            }
            BAgregar.setDisable(true);
        }else{
            
        }
    });
      //  eliminarEmpleado();
    }

    @FXML
    void modificar(ActionEvent event) {
        em= new Empleados();
        j++;

        if (j % 2 != 0) { // impar para activar el cambio
            System.out.println("aprtado");
            BModificar.setText("Guardar");
            desactivarTF(true);
            deshabilitarUltimo(true);
            deshabilitarIni(true);
            BAgregar.setDisable(true);
            BEliminar.setDisable(true);
        } else { // par para guardar los cambios
            BModificar.setText("Modificar");
             modificarDatos();
            if (i <= 1) {
                primero();
            } else if (i >= em.totalidad()) {
                ultimo();
            } else {
                siguientes(i);
            }
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
            deshabilitarUltimo(true);
            i = empleados.totalidad();
        } else {
            i++;
            siguientes(i);
        }

    }

    @FXML
    void anterior(ActionEvent event) {
        desactivarTF(false);

        if (i <= 1) {
            i = 1;
            primero();
        } else {
            anterior(i);
            i--;
        }

    }

    @FXML
    public void initialize() {
        con = Conexion.getConexion();
        desactivarTF(false);
        primero();
    }

    public void primero() {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados ";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            rs.first();
            empleado.setIdEmpleado(rs.getInt("idEmpleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        }

        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());
        if (empleado.getIdEmpleado() <= 1) {
            i = 1;
            deshabilitarIni(true);
            deshabilitarUltimo(false);
        }

    }

    public void ultimo() {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados ";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            rs.last();
            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));

        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        } // con.prepareStatement(sql);

        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());
        deshabilitarIni(false);
        deshabilitarUltimo(true);
        i = empleado.getIdEmpleado();
    }

    public void siguientes(int i) {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados ";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            // System.out.println("totalidad "+ totalidad());
            // System.out.println(rs.getInt("idempleados"));

            // System.out.println(" ha llegado");
            // if (rs.next()) {

            rs.absolute(i);

            // rs.next();
            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));

            TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
            TFNombre.setText(empleado.getNombre());
            TFApellido.setText(empleado.getApellido());
            TFTelefono.setText(empleado.getTelefono());
            TFFechaNac.setText(empleado.getFechaNac());
            TFCargo.setText(empleado.getCargo());
            deshabilitarUltimo(false);
            deshabilitarIni(false);
            if (!rs.next()) {
                ultimo();
                System.out.println("entra en siguientes()");

            } else if (i <= 1) {
                primero();
            }
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        }

    }

    public void anterior(int i) {
        Empleados empleado = new Empleados();
        String sql = "Select * from empleados ";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            rs.absolute(i);
            rs.previous();
            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        }

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

    public void limpiarCampos() {
        TFidEmpleado.setText("-");
        TFNombre.setText("");
        TFApellido.setText("");
        TFFechaNac.setText("");
        TFTelefono.setText("");
        TFCargo.setText("");
    }

    public void modificarDatos() {
        try {
            String sql = "SELECT * FROM empleados";
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);
            if (TFTelefono.getText().length() >= 13) {   
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Número inválido.");
                alert.showAndWait();
            } else {
                rs.absolute(Integer.parseInt(TFidEmpleado.getText()));
                rs.updateString("nombre", TFNombre.getText());
                rs.updateString("apellido", TFApellido.getText());
                rs.updateString("telefono", TFTelefono.getText());
                rs.updateString("fechaNac", TFFechaNac.getText());
                rs.updateString("cargo", TFCargo.getText());
                rs.updateRow();
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Modificado correctamente");
                alert.show();
            }
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        }
    }

    public void modificarDatos2() {
        em = new Empleados();
        String sql = "UPDATE empleados SET nombre=?, apellido=?, telefono=?, fechaNac=?, cargo=? where idempleados=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(6, Integer.parseInt(TFidEmpleado.getText()));
            if (TFTelefono.getText().length() >= 13) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Número de teléfono inválido.");
                alert.showAndWait();
            } else {
                ps.setString(1, TFNombre.getText());
                ps.setString(2, TFApellido.getText());
                ps.setString(3, TFTelefono.getText());
                ps.setString(4, TFFechaNac.getText());
                ps.setString(5, TFCargo.getText());
                if (ps.executeUpdate() == 1) {
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setContentText("Modificado correctamente");
                    alert.show();
                }
            }

        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        }

    }

    public void agregarEmpleado() {
        String sql = "INSERT INTO empleados(nombre, apellido, telefono, fechaNac, cargo) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TFNombre.getText());
            ps.setString(2, TFApellido.getText());
            ps.setString(3, TFTelefono.getText());
            ps.setString(4, TFFechaNac.getText());
            ps.setString(5, TFCargo.getText());
            if (ps.executeUpdate() == 1) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Empleado Agregado");
                alert.show();
            }
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al ingresar a la tabla ");
                alert.show();
        }
    }

    public void eliminarEmpleado() {
        String sql = "Delete from empleados where idempleados=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(TFidEmpleado.getText()));
            if(ps.executeUpdate()==1){
                alert= new Alert(AlertType.INFORMATION);
                alert.setContentText("Eliminado");
                alert.show();
            }else{
                alert= new Alert(AlertType.ERROR);
                alert.setContentText("Error al eliminar el empleado");
                alert.show();
            }
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al ingresar a la tabla ");
            alert.show();
        }

    }

    public void cancelarCambios() {
        em = new Empleados();
        j = 0;
        desactivarTF(false);
        deshabilitarIni(true);
        deshabilitarUltimo(true);
        BAgregar.setDisable(false);
        BEliminar.setDisable(false);
        BModificar.setDisable(false);
        BModificar.setText("Modificar");
        BAgregar.setText("Agregar");
        BEliminar.setText("Eliminar");

        if (i <= 1) {
            primero();
        } else if (i >= em.totalidad()) {
            ultimo();
        } else {
            siguientes(i);
        }
    }
}