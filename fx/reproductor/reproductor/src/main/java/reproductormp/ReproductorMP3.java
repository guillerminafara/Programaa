package reproductormp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ReproductorMP3 implements Initializable {

        @FXML
    private Slider BarraCancion;

    @FXML
    private Slider BarraVolumen;

    @FXML
    private Button BotonAtras;

    @FXML
    private Button BotonPlay;

    @FXML
    private Button BotonRayitas;

    @FXML
    private Button BotonVolumen;
        @FXML
    void rayitasEvent(ActionEvent event) {
       App.reproducir();
    }

    @FXML
    private Button BotonX;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
      
    }
    
}

