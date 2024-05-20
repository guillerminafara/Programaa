package gym;

import java.net.URL;
import java.time.DayOfWeek;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import modelo.Cliente;
import modelo.Horario;

public class EscReservaHorario implements Initializable {
  static Cliente cliente = null;
  EscInitSes initSes = new EscInitSes();
  Locale espa = new Locale("es", "es");
  LocalDateTime ld = LocalDateTime.now();
  // static DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-MM-aaaa");
  DayOfWeek diaa = ld.getDayOfWeek();

  ObservableList<String> datos;
  @FXML
  private AnchorPane anchor;
  @FXML
  private Button boton09;

  @FXML
  private Button boton10;

  @FXML
  private Button boton11;

  @FXML
  private Button boton12;

  @FXML
  private Button boton13;

  @FXML
  private Button boton16;

  @FXML
  private Button boton17;

  @FXML
  private Button boton18;

  @FXML
  private Button boton19;

  @FXML
  private Button boton20;

  @FXML
  private Button boton21;

  @FXML
  private Button boton8;

  @FXML
  private DatePicker DatePickerB;

  @FXML
  private Button botonAtras;

  @FXML
  private TableColumn<?, ?> coluLunes;

  @FXML
  private ImageView imagenLogo;

  @FXML
  private ImageView imagenUser;

  @FXML
  private Label label;

  @FXML
  private Label labelNombre;

  @FXML
  private TextField textFFecha;

  @FXML
  private TableView<?> tableLunes;
  @FXML
  void cargaDia(ActionEvent event) {

  }

  @FXML
  void DatePickerEvent(ActionEvent event) {
   DatePickerB.getValue().getDayOfWeek().getDisplayName(null, espa);
    textFFecha.setText();
    // label.setText(DatePickerB.getValue().toString());
    // label.setText(diaa.toString());
    //label.setText(ld.getHour() + ":" + ld.getMinute());
    // System.out.println("dia "+ diaa);
   // System.out.println("hora " + ld.getHour() + ":" + ld.getMinute());
  }

  @FXML
  void Selecciona(MouseEvent event) {

  }

  @FXML
  void atras(ActionEvent event) {
    App.escena1();
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd
    // HH:mm:ss")))
    // ),
    anchor.getStylesheets().add(getClass().getResource("css/principal.css").toExternalForm());
    circular();
    cargarUser();
    Timeline tl = new Timeline(new KeyFrame(Duration.ZERO, e -> label.setText(fechita())),
        new KeyFrame(Duration.seconds(1)));
    tl.setCycleCount(Animation.INDEFINITE);
    tl.play();
    textFFecha.setEditable(false);
    // cargarTabla();

  }

  private String fechita() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    label.setText(LocalDateTime.now().format(formatter));
    return LocalDateTime.now().format(formatter);
  }

  // @SuppressWarnings("unchecked")
  // public void cargarTabla() {
  // ArrayList<String> horas = new ArrayList();
  // String dias = "";
  // for (int i = 8; i < 21; i++) {
  // dias = i + ":00";
  // horas.add(dias);
  // }

  // datos = FXCollections.observableArrayList();
  // datos.addAll(horas);

  // tableLunes.setItems(datos);
  // tableMartes.setItems(datos);
  // tableMiercoles.setItems(datos);
  // tableJueves.setItems(datos);
  // tableViernes.setItems(datos);

  // // SimpleStringProperty();
  // this.coluLunes.setCellValueFactory(c -> new
  // SimpleStringProperty(c.getValue()));

  // this.coluMartes.setCellValueFactory(c -> new
  // SimpleStringProperty(c.getValue()));
  // this.coluMierc.setCellValueFactory(c -> new
  // SimpleStringProperty(c.getValue()));
  // this.coluJuev.setCellValueFactory(c -> new
  // SimpleStringProperty(c.getValue()));
  // this.ColuViernes.setCellValueFactory(c -> new
  // SimpleStringProperty(c.getValue()));

  // }
  public void circular() {
    double radio = 25;
    Circle circulo = new Circle(radio, radio, radio);
    imagenUser.setClip(circulo);
    imagenUser.setFitWidth(2 * radio);
    imagenUser.setFitHeight(2 * radio);

  }

  // metodo que abre los horarios en caso de que tenga un user loggeado .. si no
  // hay user loggeado redirecciona a ingresar
  public void cargarUser() {
    cliente = initSes.pasarUSer();
    labelNombre.setText(cliente.getNombre());

  }

  public void configuraHorario(){
    
   
  }

}
