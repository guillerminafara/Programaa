package gym;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Cliente;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class EsceUser implements Initializable {
    static Cliente cliente1=null;
    static Cliente cliente=null;
    RegistrateEsc reg;
    EscInitSes init;

    @FXML
    private AnchorPane anchor4;
    @FXML
    private Button botonAtras;
    @FXML
    private ImageView imagenUser;

    @FXML
    private Label labelFecha;

    @FXML
    private TextField textFApellido;

    @FXML
    private TextField textFCuota;

    @FXML
    private TextField textFMail;

    @FXML
    private TextField textFNombre;

    @FXML
    void accionAtras(ActionEvent event) {
        App.escena1();
    }

    @FXML
    void accionCambiaPlan(ActionEvent event) {

    }

    @FXML
    void accionEditaApellido(ActionEvent event) {

    }

    @FXML
    void accionEditaNombre(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anchor4.getStylesheets().add(getClass().getResource("css/horario.css").toExternalForm());
        cargaUser();
        botonesEditables();

    }

    public void cargaUser() {
        cliente=null;
        cliente1= null;
        try {
            this.cliente1 = reg.pasarUser();
            this.cliente=init.pasarUSer();
            System.out.println(cliente1);

        } catch (Exception e) {
            System.out.println("sigue siendo nulo");
        }
        // 
        if (cliente != null) {
            // cliente = reg.pasarUser();
            cargarPagina(cliente);
            System.out.println("carga cliente");

        } else if (cliente1 != null) {
            System.out.println("carga cliente1");
            cargarPagina(cliente1);

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

    public void cargarPagina(Cliente client) {
        textFNombre.clear();
        textFNombre.setText(client.getNombre());
        textFApellido.setText(client.getApellido());
        textFMail.setText(client.getMail());
        if (client.getCuota() != null) {
            textFCuota.setText(client.getCuota().getplan().getIdPlan());
        } else {
            textFCuota.setText("No cuentas con ningún plan activo");
        }

    }

    public void botonesEditables() {
        textFNombre.setEditable(false);
        textFApellido.setEditable(false);
        textFMail.setEditable(false);
        textFCuota.setEditable(false);
    }
}
