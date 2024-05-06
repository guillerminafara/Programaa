package dinosaurios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Escena4 {
    
    
    @FXML
    private Button BAtras4;

    @FXML
    private Button BSAlir4;

    @FXML
    private ImageView imagenMapa;

    @FXML
    void Atras4(ActionEvent event) {
        App.cambioScena1();
    }

    @FXML
    void Salir4(ActionEvent event) {
        System.exit(0);
    }
}
