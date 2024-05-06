package dinosaurios;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class PrimaryController implements Initializable{

    @FXML
    private AnchorPane AnchorDino;

    @FXML
    private Button JBCrear;

    @FXML
    private Button JBListarD;

    @FXML
    private Button JBListarZ;

    @FXML
    private Button JBSalir;

    @FXML
    private ImageView imagen;

    @FXML
    public void Crear(ActionEvent actionEvent)  {
       App.cambioScena2();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    void ListarDinos(ActionEvent event) {
        App.cambioScena3();
    }

    @FXML
    void listarZonas(ActionEvent event) {
        App.cambioScena4();
    }
    @FXML
    void salir1(ActionEvent event) {
        System.exit(0);
    }

}
