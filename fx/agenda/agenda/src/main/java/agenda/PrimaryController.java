package agenda;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PleaseProvideControllerClassName {

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

}

}
