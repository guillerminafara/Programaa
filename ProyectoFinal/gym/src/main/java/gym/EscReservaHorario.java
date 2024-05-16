package gym;

import java.net.URL;
import java.time.DayOfWeek;

import javafx.beans.Observable;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.Horario;

public class EscReservaHorario implements Initializable {
  // Locale espa = new Locale("es", "es");
  LocalDateTime ld = LocalDateTime.now();
  // static DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-MM-aaaa");
  DayOfWeek diaa = ld.getDayOfWeek();

  @FXML
  private TableColumn<?, ?> ColuViernes;

  @FXML
  private DatePicker DatePickerB;

  @FXML
  private TableView<?> TablaHorarios;

  @FXML
  private TableColumn<?, ?> coluDomingo;

  @FXML
  private TableColumn<?, ?> coluJuev;

  @FXML
  private TableColumn<ArrayList<String>, String> coluLunes;

  @FXML
  private TableColumn<?, ?> coluMartes;

  @FXML
  private TableColumn<?, ?> coluMierc;

  @FXML
  private TableColumn<?, ?> coluSabado;

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

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
    // ),
     
    Timeline tl = new Timeline(new KeyFrame(Duration.ZERO, e -> label.setText(fechita())
    ),
        new KeyFrame(Duration.seconds(1)));

    // label.setText(ld.getHour() + ":" + ld.getMinute());

    // System.out.println("dia "+ diaa);
    // System.out.println("hora "+ ld);
    tl.setCycleCount(Animation.INDEFINITE);
    tl.play();


  }

  private String fechita() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    label.setText(LocalDateTime.now().format(formatter));
      return LocalDateTime.now().format(formatter);
  }
  public void cargarTabla() {
    ArrayList<String> lunes= new ArrayList();
    String dias="";
    for (int i = 8; i <21 ; i++) {
      dias= i+"";
      lunes.add(dias);
    }
   // coluLunes.setCellValueFactory(new PropertyValueFactory<lunes, String >("Lunes"));

  }
}
