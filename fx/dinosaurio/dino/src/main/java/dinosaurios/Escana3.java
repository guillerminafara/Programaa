package dinosaurios;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import modelo.DinoEnum;

public class Escana3 implements Initializable {
    static Connection con = null;
    String url = "jdbc:mysql://localhost/JurassicPark";
    String user = "root";
    String password = "";
    // String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    // String user = "root";
    // String password = "Paquito2024----";
    public Connection conectar() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    String peque = "Peque";
    String grande = "Grande";
    String mediano = "Mediano";
    @FXML
    private Button BSalir3;

    @FXML
    private Button Batras3;

    @FXML
    private ComboBox CBAlimentacion;

    @FXML
    private ComboBox CBTamanio;

    @FXML
    private ComboBox CBTipo;

    // @FXML
    // private ImageView Imag3;

    @FXML
    private Button JBBuscar;

    @FXML
    private TableView<Dinosaurio> JTTabla;

    ObservableList<Dinosaurio> listaDino;
    @FXML
    private TableColumn<Dinosaurio, Integer> idDino;
    @FXML
    private TableColumn<Dinosaurio, String> nombre;
    @FXML
    private TableColumn<Dinosaurio, String> tamanyo;
    @FXML
    private TableColumn<Dinosaurio, String> alimentacion;
    @FXML
    private TableColumn<Dinosaurio, String> tipo;
    @FXML
    void Salir3(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void Buscar(ActionEvent event) {
       
    }

    @FXML
    void atras(ActionEvent event) {
        App.cambioScena1();

    }
    @FXML
    void BuscarAlimentacion(ActionEvent event) {
        listaDino = FXCollections.observableArrayList();
        Dinosaurio.buscarPorAlim(CBAlimentacion.getValue().toString(),listaDino);
        JTTabla.setItems(listaDino);
        nombre.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("nombre"));
        tamanyo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tamanyo"));
        alimentacion.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("alimentacion"));
        tipo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tipo"));
    }

    @FXML
    void BuscarTipo(ActionEvent event) {
        listaDino = FXCollections.observableArrayList();
        Dinosaurio.buscarPorTipo(CBTipo.getValue().toString(),listaDino);
        JTTabla.setItems(listaDino);
        nombre.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("nombre"));
        tamanyo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tamanyo"));
        alimentacion.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("alimentacion"));
        tipo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tipo"));
    }

    @FXML
    void SelecTamanio(ActionEvent event) {
        
        listaDino = FXCollections.observableArrayList();
        Dinosaurio.buscarPorTamanio(CBTamanio.getValue().toString(),listaDino);
        JTTabla.setItems(listaDino);
        nombre.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("nombre"));
        tamanyo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tamanyo"));
        alimentacion.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("alimentacion"));
        tipo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tipo"));

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cargarCombo3();
       cargarTabla();

    }

    public void cargarTabla() {
        listaDino = FXCollections.observableArrayList();
        Dinosaurio.listaDinoTabla(listaDino);
        JTTabla.setItems(listaDino);
        // idDino.setCellValueFactory(new PropertyValueFactory<Dinosaurio,
        // Integer>("idDino"));
        nombre.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("nombre"));
        tamanyo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tamanyo"));
        alimentacion.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("alimentacion"));
        tipo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tipo"));
    }

    public void cargarCombo3() {
        String tierra= "Tierra";
        CBTipo.getItems().addAll(tierra, "Agua", "Aire");
        CBAlimentacion.getItems().addAll("Carnivoro", "Herbivoro", "Omnivoro");
        CBTamanio.getItems().addAll(grande, mediano, peque);
    }


    public ArrayList listaDinowwws() {
        ArrayList<Dinosaurio> listaDino = new ArrayList<>();
        String sql = "SELECT * FROM Dinosaurio";
        Dinosaurio dino = null;
        try {
            // PreparedStatement ps= conectar().prepareStatement(sql);
            // ResultSet rs= ps.executeQuery();
            Statement stmt = conectar().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dino = new Dinosaurio();
                dino.setIdDino(rs.getInt("id_dino"));
                dino.setNombre(rs.getString("nombre"));
                dino.setTamanyo(rs.getString("tamanyo"));
                dino.setAlimentacion(rs.getString("alimentacion"));
                dino.setTipo(rs.getString("tipo"));
                listaDino.add(dino);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDino;

    }

}