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
        j++;

        if (j % 2 != 0) {
            limpiarCampos();
            deshabilitarIni(true);
            deshabilitarUltimo(true);
            desactivarTF(true);
            BAgregar.setText("Guardar");
            // agregarEmpleado();
        } else {

        }

    }

    @FXML
    void cancelar(ActionEvent event) {
        cancelarCambios();
    }

    @FXML
    void eliminar(ActionEvent event) {
        alert= new Alert(AlertType.CONFIRMATION);
        alert.setContentText("¿Estas segurisimo que deseas eliminar al empleado?");
        alert.showAndWait().ifPresent(response->{
        if(response==ButtonType.OK){
            //ButtonType.OK
            System.out.println("dice que si");
        }else{
            System.out.println("dice que no");
        }
    });
      //  eliminarEmpleado();
    }

    @FXML
    void modificar(ActionEvent event) {
        j++;

        if (j % 2 != 0) { // impar para activar el cambio
            System.out.println("aprtado");
            BModificar.setText("Guardar");
            desactivarTF(true);
            deshabilitarUltimo(true);
            deshabilitarIni(true);

        } else { // par para guardar los cambios
            BModificar.setText("Modificar");
            // true event.ACTION.equals(false)
            // modificarDatos();
            System.out.println("desactivado");
            desactivarTF(false);
            deshabilitarIni(false);
            deshabilitarUltimo(false);
        }

    }

    @FXML
    void ultimoo(ActionEvent event) {
        ultimo();
        desactivarTF(false);
        deshabilitarIni(false);
        deshabilitarUltimo(true);
        // i=em.totalidad();
        // System.out.println("totalidad: " + i);
    }

    @FXML
    void siguiente(ActionEvent event) {
        desactivarTF(false);

        Empleados empleados = new Empleados();
        if (i >= empleados.totalidad()) {
            deshabilitarUltimo(true);
            i = empleados.totalidad();
            System.out.println("entra en siguiente()");

            // ultimo();
        } else {
            i++;
            siguientes(i);
            // deshabilitarIni(false);
            // deshabilitarUltimo(false);
            // System.out.println(i);
        }

    }

    @FXML
    void anterior(ActionEvent event) {
        desactivarTF(false);

        if (i <= 1) {
            i = 1;
            primero();
        } else {
            //
            anterior(i);
            // System.out.println("i anterior: " + i);
            i--;
        }

    }

    Connection con = null;

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

            // ps.setInt(1, i);
            rs = stmt.executeQuery(sql);
            rs.first();

            empleado.setIdEmpleado(rs.getInt("idEmpleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
            deshabilitarIni(true);
            deshabilitarUltimo(false);

        }

    }

    public void ultimo() {
        Empleados empleado = new Empleados();

        String sql = "Select * from empleados ";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // ps.setInt(1, i);
            rs = stmt.executeQuery(sql);
            rs.last();

            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // con.prepareStatement(sql);

        TFidEmpleado.setText(String.valueOf(empleado.getIdEmpleado()));
        TFNombre.setText(empleado.getNombre());
        TFApellido.setText(empleado.getApellido());
        TFTelefono.setText(empleado.getTelefono());
        TFFechaNac.setText(empleado.getFechaNac());
        TFCargo.setText(empleado.getCargo());
        // if (empleado.getIdEmpleado() == empleado.totalidad()) {
        // deshabilitarUltimo(true);
        // System.out.println("entra en ultimo()");
        // } else {
        deshabilitarIni(false);
        deshabilitarUltimo(true);

        // }
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
        } catch (

        SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void anterior(int i) {
        Empleados empleado = new Empleados();

        String sql = "Select * from empleados ";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);

            rs.absolute(i);
            // System.out.println("i-" + i);
            // i--;
            rs.previous();

            empleado.setIdEmpleado(rs.getInt("idempleados"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaNac(rs.getString("fechaNac"));
            empleado.setCargo(rs.getString("cargo"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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

    public void limpiarCampos() {
        TFidEmpleado.setText("");
        TFNombre.setText("");
        TFApellido.setText("");
        TFFechaNac.setText("");
        TFTelefono.setText("");
        TFCargo.setText("");
    }

    public void modificarDatos() {
        // deshabilitarIni(true);// false=no puedo modificarlos
        // deshabilitarUltimo(true);
        // desactivarTF(true);
        // String sql="Select * from empleados where idempleado=? ";

        try {
            String sql = "SELECT * FROM empleados";

            // PreparedStatement ps =
            // con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
            // ResultSet.CONCUR_UPDATABLE);
            Statement ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = ps.executeQuery(sql);

            if (TFTelefono.getText().length() >= 13) {
                // throws new MysqlDataTruncation(sql, i, false, false, i, i, i)
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Número inválido.");
                alert.showAndWait();
                // siguientes(i);
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void modificarDatos2() {
        // deshabilitarIni(true); // false no puedo modificarlos
        // deshabilitarUltimo(true);
        // desactivarTF(false);
        em = new Empleados();
        String sql = "UPDATE empleados SET nombre=?, apellido=?, telefono=?, fechaNac=?, cargo=? where idempleados=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(6, Integer.parseInt(TFidEmpleado.getText()));

            if (TFTelefono.getText().length() >= 13) {
                // throws new MysqlDataTruncation(sql, i, false, false, i, i, i)
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
            // TODO Auto-generated catch block //alert
            e.printStackTrace();
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
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Empleado Agregado");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void eliminarEmpleado() {
        String sql = "Delete from empleado where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(TFidEmpleado.getText()));
            if(ps.executeUpdate()==1){
                alert= new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Eliminado");
                alert.show();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void cancelarCambios() {
        em = new Empleados();
        j = 0;
        desactivarTF(false);
        deshabilitarIni(true);
        deshabilitarUltimo(true);
        BModificar.setText("Modificar");
        BAgregar.setText("Agregar");
        BEliminar.setText("Eliminar");
        if (i <= 1) {
            primero();
            System.out.println("entra en primero");
        } else if (i >= 5) {
            System.out.println("entra en ultimo");
            ultimo();

        } else {
            System.out.println("entra en siguiente");
            siguientes(i);
        }
    }
}