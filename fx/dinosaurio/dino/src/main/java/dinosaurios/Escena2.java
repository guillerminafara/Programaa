package dinosaurios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Escena2 implements Initializable {
Connection con= null;
    Atraccion atraccion=null;
    @FXML
    private ComboBox<?> CBDino;

    @FXML
    private ComboBox<?> CBZona;
    @FXML
    private TextField TFEdadMinima;
    @FXML
    private TextField TFNombre;
    @FXML
    private TextField TFCapacidad;
    @FXML
    private Button BAgregar;

    @FXML
    void AsignaDino(ActionEvent event) {
        App.cambioScena3();
    }

    @FXML
    void AsignaZona(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void AgregarAtraccion(ActionEvent actionEvent) {



    }

    public void agregaAtraccion(){
        String sql="Insert into Atraccion values (?,?,?,?,?,?)";
       atraccion= new Atraccion();
        atraccion.setNombre(TFNombre.getText());
        atraccion.setCapacidad(Integer.parseInt(TFCapacidad.getText()));
        atraccion.setEdad(Integer.parseInt(TFEdadMinima.getText()));
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,);
            ps.setString(2,atraccion.getNombre() );
            ps.setInt(3, atraccion.getCapacidad());
            ps.setInt(4, atraccion.getEdad());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
