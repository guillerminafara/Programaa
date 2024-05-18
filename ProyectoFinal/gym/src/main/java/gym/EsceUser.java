package gym;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import modelo.Cliente;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class EsceUser implements Initializable {
    static Cliente cliente1;
    static Cliente cliente;
    RegistrateEsc reg;
    EscInitSes init;
      @FXML
    private Button botonAtras;
    @FXML
    private ImageView imagenUser;

    @FXML
    private Label labelApellido;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelFecha;

    @FXML
    private Label labelPlan;

    @FXML
    private Label labelnombre;
    @FXML
    void accionAtras(ActionEvent event) {
        App.escena1();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //cargaUser();

    }
    public void cargaUser(){
        cliente1= new Cliente();
        cliente= new Cliente();
        cliente1 = reg.pasarUser();
        cliente=init.pasarUSer();
        if (cliente!= null) {
           // cliente = reg.pasarUser();
           System.out.println("carga cliente");
        } else if (cliente1!= null) {
            System.out.println("carga cliente1");
           // cliente = init.pasarUSer();
        } else {
            
            System.out.println("nullo en Esce User");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Alto!");
            alert.setContentText("nulo");
            alert.setTitle("User");
            alert.show();
            throw new NullPointerException("nulo");
        }
    }

}
