package hotel;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Modelo.Grupo;
import Modelo.Servicio;
import Modelo.Trabajador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Escena3 implements Initializable {
    static Connection con;
    static Trabajador trabajador;
    static Grupo grupo;
    static Servicio servicio;
    ArrayList<Servicio> listaServicios;

    public Escena3() {
        con = Conexio.getConexion();

    }

    @FXML
    private ComboBox comboBox;

    @FXML
    private ImageView imagenBasura;

    @FXML
    private ImageView img;

    @FXML
    private ImageView imgGuardar;

    @FXML
    private Label labelSErvicios;

    @FXML
    private TextField textFHabitacion;

    @FXML
    private TextField textFPrecio;

    @FXML
    void accionCombo(ActionEvent event) {

        System.out.println(comboBox.getSelectionModel().getSelectedItem());
        cargarPrecio();
    }

    @FXML
    void accionDescartar(MouseEvent event) {
      // Trabajador trabajador=null;
        Grupo grupo=null;
        Servicio servicio=null;
        App.escena2();
    }

    @FXML
    void accionGuardar(MouseEvent event) {
        guardar();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        grupo = new Grupo();
        grupo = Escena2.pasarGrupo();
        cargarClases();
        cargarCombo();
        // TODO Auto-generated method stub

    }

    public void cargarClases() {
        trabajador = new Trabajador();
        trabajador = Escena1.devuelveTrabajador();
        grupo = new Grupo();
        grupo = Escena2.pasarGrupo();
    }

    public ArrayList listarServicios() {
        String sql = "select * from servicio where cod_grupo=?";
        listaServicios = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, grupo.getCod_grupo());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setCod_grupo(grupo.getCod_grupo());
                servicio.setGrupo(grupo);
                servicio.setDetalle(rs.getString("detalle"));
                servicio.setId_Servicio(rs.getInt("id_servicio"));
                servicio.setPrecio(rs.getDouble("precio"));
                System.out.println("servicio:   " + servicio);
                listaServicios.add(servicio);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaServicios;
    }

    public void cargarCombo() {

        comboBox.getItems().addAll(listarServicios());
    }

    public void cargarPrecio() {
        Servicio servicio2 = (Servicio) comboBox.getSelectionModel().getSelectedItem();

        textFPrecio.setText(servicio2.getPrecio() + "");
    }

    public void guardar() {
        String sql = "insert into servicio_cliente (id_servicio, cod_trabajador, num_habitacion, importe) values(?,?,?,?)";

       
            try {
                PreparedStatement ps= con.prepareStatement(sql);
                ps.setInt(1, servicio.getId_Servicio());
                ps.setInt(2, trabajador.getCod_trabajador());
                ps.setInt(3, compurebaHab());
                ps.setDouble(4, devuelvePRecio());
                if(ps.executeUpdate()==1){
                    Alert alert= new Alert(AlertType.INFORMATION);
                    alert.setTitle("CArgar de servicio");
                    alert.setContentText("los datos han sido registrados con exito");
                    alert.show();
                }
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     

       

    }
public double devuelvePRecio(){
    textFPrecio.getText();
    double precio=Double.parseDouble(textFPrecio.getText());
    System.out.println(precio);
    return precio; 
}
    public int  compurebaHab() {
        boolean puede = false;
        String hab;
        int habitacion=0;
        // ascii 65-90 y 97 -122
        if (textFHabitacion.getText() != null) {
            //if(textFHabitacion.getText().charAt()){
            hab = textFHabitacion.getText();
            habitacion = Integer.parseInt(hab);
            puede=true;
            // }

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Ojo!");
            alert.setContentText("todos los campos deben ser rellenados");
            alert.show();
        }
        return habitacion;
    }
}
