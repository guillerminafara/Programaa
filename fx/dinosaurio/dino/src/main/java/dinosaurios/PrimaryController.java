package dinosaurios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PrimaryController implements Initializable{

    @FXML
    private Button JBCrear;

    @FXML
    private Button JBListarD;

    @FXML
    private Button JBListarZ;

    @FXML
    private Button JBSalir;

    @FXML
    private AnchorPane LDino;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
     
        try {
            JBSalir.setGraphic(new ImageView(new Image(new FileInputStream("salir.png"))));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
