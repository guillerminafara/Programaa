package gym;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import modelo.Cliente;

public class Principal implements Initializable {
//static boolean escenitas;
EsceUser cuenta;
static Cliente cliente;
    @FXML
    private Button BotonDonde;

    @FXML
    private Button BotonIngresa;

    @FXML
    private Button BotonReserva;

    @FXML
    private Button BotonSobreNosotros;

    @FXML
    private ImageView imagenEvolucion;
    @FXML
    private ImageView ImagenLogo;
  @FXML
    private Pane panelito;
      @FXML
    private TextArea textAreaAnim;


        @FXML
    private AnchorPane anchor;

    @FXML
    void InicioSesion(ActionEvent event) {
        cliente =cuenta.pasarUser();
       // escenitas=true;
       if(cliente!=null){
        App.escena4();
        BotonReserva.setDisable(true);
       }else{
        
        App.escena2();

       }
    }
    @FXML
    void accionRegistrate(ActionEvent event)  {
       // escenitas= false;
        App.escena5();
    }
    boolean entra=false;
    @FXML
    void accionSobreNosotros(ActionEvent event) {
       
        if(!entra){
        // TranslateTransition text= new TranslateTransition();
        // text.setNode(panelito);
        // text.setDuration(Duration.seconds(4));
        // text.setByY(-200);
        // text.play();
        TranslateTransition text2= new TranslateTransition();
        text2.setNode(anchor);
        text2.setDuration(Duration.seconds(2));
        text2.setByY(-200);
        text2.play();
        entra=true;
        }else{
            // TranslateTransition text= new TranslateTransition();
            // text.setNode(panelito);
            // text.setDuration(Duration.seconds(4));
            // text.setByY(200);
            // text.play();
            TranslateTransition text2= new TranslateTransition();
            text2.setNode(anchor);
            text2.setDuration(Duration.seconds(2));
            text2.setByY(200);
            text2.play();
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        anchor.getStylesheets().add(getClass().getResource("css/principal.css").toExternalForm());
       
    }


}