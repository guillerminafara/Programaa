package dinosaurios;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import modelo.DinoEnum;

public class Escana3 implements Initializable{
    Connection con= null;
    @FXML
    private Button BSalir3;

    @FXML
    private Button Batras3;

    @FXML
    private ComboBox<?> CBAlimentacion;

    @FXML
    private ComboBox CBTamanio;

    @FXML
    private ComboBox<?> CBTipo;

    @FXML
    private ImageView Imag3;

    @FXML
    private Button JBBuscar;

    @FXML
    private TableView<?> JTTabla;

    @FXML
    void Buscar(ActionEvent event) {

    }

    @FXML
    void atras(ActionEvent event) {
        App.cambioScena1();

    }
    @FXML
    void SelecTamanio(ActionEvent event) {

    }
    public void initialize() {
    }

    public void cargarCombo3(){

        CBTamanio.getItems().addAll(DinoEnum.values());
    }
    public void buscarPorTamanio(String tamanio){
        Dinosaurio dino= new Dinosaurio();
        ArrayList<Dinosaurio> listaDino= new ArrayList<>();
        String sql= "SELECT * FROM Dinosaurio where tamanyo=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tamanio);
            ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                
            dino.setIdDino(rs.getInt("id_dino"));
            dino.setNombre(rs.getString("nombre"));
            dino.setTamanyo(rs.getString("tamanyo"));
            dino.setAlimentacion(rs.getString("alimentacion"));
            dino.setTipo(rs.getString("tipo"));
            listaDino.add(dino);
        }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cargarCombo3();

      
    }

   
}