package gym;

import java.net.URL;
import java.time.DayOfWeek;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.Horario;

public class EscReservaHorario implements Initializable {
  // Locale espa = new Locale("es", "es");
  LocalDateTime ld = LocalDateTime.now();
  // static DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-MM-aaaa");
  DayOfWeek diaa = ld.getDayOfWeek();

  ObservableList<String> datos;
  @FXML
  private AnchorPane anchor;
  @FXML
  private Button botonAtras;
  @FXML
  // private TableColumn<ArrayList, String> ColuViernes= new
  // TableColumn<>("Viernes");
  private TableColumn<String, String> ColuViernes;

  @FXML
  private DatePicker DatePickerB;

  @FXML
  private TableView<String> tableJueves;

  @FXML
  private TableView<String> tableLunes;

  @FXML
  private TableView<String> tableMartes;

  @FXML
  private TableView<String> tableMiercoles;

  @FXML
  private TableView<String> tableViernes;

  @FXML
  // private TableColumn<ArrayList, String> coluJuev = new
  // TableColumn<>("Jueves");

  private TableColumn<String, String> coluJuev;

  @FXML
  // private TableColumn<ArrayList, String> coluLunes = new
  // TableColumn<>("Lunes");

  private TableColumn<String, String> coluLunes;

  @FXML
  // private TableColumn<ArrayList, String> coluMartes = new
  // TableColumn<>("Martes");

  private TableColumn<String, String> coluMartes;

  @FXML
  private TableColumn<String, String> coluMierc;

  // private TableColumn<ArrayList, String> coluMierc = new
  // TableColumn<>("Miércoles");

  @FXML
  private ImageView imagenLogo;
  @FXML
  private Label label;

  @FXML
  void DatePickerEvent(ActionEvent event) {

    // label.setText(DatePickerB.getValue().toString());
    // label.setText(diaa.toString());
    label.setText(ld.getHour() + ":" + ld.getMinute());
    // System.out.println("dia "+ diaa);
    System.out.println("hora " + ld.getHour() + ":" + ld.getMinute());
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
    Timeline tl = new Timeline(new KeyFrame(Duration.ZERO, e -> label.setText(fechita())),
        new KeyFrame(Duration.seconds(1)));
    tl.setCycleCount(Animation.INDEFINITE);
    tl.play();
    cargarTabla();

  }

  private String fechita() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    label.setText(LocalDateTime.now().format(formatter));
    return LocalDateTime.now().format(formatter);
  }

  @SuppressWarnings("unchecked")
  public void cargarTabla() {
    ArrayList<String> horas = new ArrayList();
    String dias = "";
    for (int i = 8; i < 21; i++) {
      dias = i + ":00";
      horas.add(dias);
    }

    datos = FXCollections.observableArrayList();
    datos.addAll(horas);

    tableLunes.setItems(datos);
    tableMartes.setItems(datos);
    tableMiercoles.setItems(datos);
    tableJueves.setItems(datos);
    tableViernes.setItems(datos);

    // SimpleStringProperty();
    this.coluLunes.setCellValueFactory(c -> new SimpleStringProperty(c.getValue()));

    this.coluMartes.setCellValueFactory(c -> new SimpleStringProperty(c.getValue()));
    this.coluMierc.setCellValueFactory(c -> new SimpleStringProperty(c.getValue()));
    this.coluJuev.setCellValueFactory(c -> new SimpleStringProperty(c.getValue()));
    this.ColuViernes.setCellValueFactory(c -> new SimpleStringProperty(c.getValue()));

  }

 
}
