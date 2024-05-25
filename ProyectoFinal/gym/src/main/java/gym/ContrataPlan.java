package gym;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import modelo.Cuota;
import modelo.Planes;

public class ContrataPlan implements Initializable {
    static Connection con;
    String botonSelect;
    Cuota cuota;
    static Planes pla;

    public ContrataPlan() {
        con = Conexion.getConexion();
    }

     //ObservableList<String> datos;
     ObservableList<ObservableList<String>> datos;
    @FXML
    private Button b12M;

    @FXML
    private Button b01M;

    @FXML
    private Button b03M;

   @FXML
    private Button botonAcepta;

    @FXML
    private Button botonAtras;

    @FXML
    private Pane pane2;


    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextArea textArea3;
    @FXML
    private TableColumn<ObservableList<String>, String> columnaDescripcion;

    @FXML
    private TableColumn<ObservableList<String>, String> columnaFechaFin;

    @FXML
    private TableColumn<ObservableList<String>, String> columnaFechaInicio;

    @FXML
    private TableColumn<ObservableList<String>, String> columnaPrecio;

    @FXML
    private TableView<ObservableList<String>> tabla;


    @FXML
    void accionSelecciona(ActionEvent event) {
        botonSelect = event.getSource().toString().substring(11, 14);
        System.out.println(botonSelect);
        deshabilitaBotones(botonSelect);
        buscaPlan(botonSelect);
        cargarTabla();
    }

    @FXML
    void accionAtras(ActionEvent event) {
        App.escena4();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    public void buscaPlan(String botonSelect) {
        String sql = "Select *  from plan where idPlan=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, botonSelect);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pla= new Planes();
                pla.setIdPlan(rs.getString("idPlan"));
                pla.setDescripción(rs.getString("descripcion"));
                System.out.println(pla.getDescripción()+ "descr");
                System.out.println(rs.getString("descripcion")+ "rs");
                pla.setImporte(rs.getDouble("importe"));
                pla.setEstado(true);
            }
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void deshabilitaBotones(String botonSelect) {
        System.out.println(b01M.getId()+"1");

        if (b01M.getId().contains(botonSelect)) {
            System.out.println(b01M.getId()+"1");
            b03M.setDisable(true);
            b12M.setDisable(true);
        } else if (b03M.getId().contains(botonSelect)) {
            System.out.println(b03M.getId() +"3");
            b01M.setDisable(true);
            b12M.setDisable(true);

        } else  if (b12M.getId().contains(botonSelect)){
            System.out.println(b12M.getId()+"12");
            b01M.setDisable(true);
            b03M.setDisable(true);

        }

    }
    public void habilitaBotones(){
        b01M.setDisable(false);
        b03M.setDisable(false);
        b12M.setDisable(false);

    }
    public void cargarTabla(){
        ObservableList<String> fila = FXCollections.observableArrayList();
       datos=  FXCollections.observableArrayList();
       fila.add(LocalDate.now().toString());
       fila.add(pla.getDescripción());
       fila.add(LocalDateTime.now().plusMonths(3)+"");
       fila.add(pla.getImporte()+"");
        datos.add(fila);
        tabla.setItems(datos);
        columnaFechaInicio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(0)));
        columnaDescripcion.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(1)));
        columnaFechaFin.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(2)));
        columnaPrecio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(3)));
    }
}
