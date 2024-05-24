package gym;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import modelo.Cliente;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EsceUser implements Initializable {
    App app= new App();
    Connection con;
    static Cliente cliente1 = null;
    static Cliente cliente = null;
    RegistrateEsc reg;
    EscInitSes init;

    public EsceUser() {
        con= Conexion.getConexion();
    }


    @FXML
    private AnchorPane anchor4;
    @FXML
    private Button botonAtras;
    @FXML
    private Button botonnFondo;

    @FXML
    private Button botonReserva;
    @FXML
    private ImageView imagenUser;

    @FXML
    private Label labelFecha;
    @FXML
    private Label labelReserva;

    @FXML
    private TextField textFApellido;

    @FXML
    private TextField textFCuota;

    @FXML
    private TextField textFMail;

    @FXML
    private TextField textFNombre;

    @FXML
    void accionReserva(ActionEvent event) {
        App.escena3();
    }

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
    @FXML
    void accionAccesoReserva(MouseEvent event) {
        App.escena3();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anchor4.getStylesheets().add(getClass().getResource("css/horario.css").toExternalForm());
        cargaUser();
        Timeline tl = new Timeline(new KeyFrame(Duration.ZERO, e -> labelFecha.setText(fechita())),
                new KeyFrame(Duration.seconds(1)));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
        fechita();
        botonesEditables();
        circular();
        sas();

    }

    public void cargaUser() {
        cliente = null;
        cliente1 = null;
        try {
            this.cliente1 = reg.pasarUser();
            this.cliente = init.pasarUSer();
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

    public void circular() {
        double radio = 100;
        Circle circulo = new Circle(radio, radio, radio);
        imagenUser.setClip(circulo);
        imagenUser.setFitWidth(2 * radio);
        imagenUser.setFitHeight(2 * radio);

    }

    private String fechita() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        labelFecha.setText(LocalDateTime.now().format(formatter));
        return LocalDateTime.now().format(formatter);
    }
    public static Cliente pasarUser(){
        return cliente;

    }

    public void sas(){
        if(verificaCuota()){
           // botonReserva.setDisable(false);
            labelReserva.setDisable(false);
            System.out.println("El cliente tiene un plan");
            System.out.println(cliente.getPilaReservas());
          }else{
           // botonReserva.setDisable(true);
            labelReserva.setDisable(true);
            System.out.println("El cliente no tiene un plan  ");
            Tooltip toolito= new Tooltip("Contrata un Plan para poder reservar");
            Tooltip.install(botonnFondo, toolito);
          }
    }

    public boolean verificaCuota() {
    boolean puede = false;
    String sql = "SELECT * FROM cliente where idCliente=?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, cliente.getIdCliente());
      // ResultSet rs= ps.executeQuery();
      if (cliente.getCuota() == null) {
        // Alert alert = new Alert(AlertType.WARNING);
        // alert.setContentText("No tienes ningún plan contratado con nosotros. ");
        // alert.setTitle("Reserva de Horario");

      } else {
        puede = true;
      }
      // si el cliente ya tiene una reserva en el mismo dia no deberia poder reservar
      // de nuevo

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return puede;

  }
}
