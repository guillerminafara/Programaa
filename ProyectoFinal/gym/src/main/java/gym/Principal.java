package gym;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Principal implements Initializable {

    @FXML
    private Button BotonDonde;

    @FXML
    private Button BotonIngresa;

    @FXML
    private Button BotonReserva;

    @FXML
    private Button BotonSobreNosotros;

    @FXML
    private ImageView ImagenLogo;

        @FXML
    private AnchorPane anchor;

    @FXML
    void InicioSesion(ActionEvent event) {
        App.escena2();
    }
    @FXML
    void DirigirReservaEvent(ActionEvent event) {
        App.escena3();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        anchor.getStylesheets().add(getClass().getResource("css/principal.css").toExternalForm());
       
    }

}