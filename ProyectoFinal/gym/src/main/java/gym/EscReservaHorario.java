package gym;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
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
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import modelo.Cliente;
import modelo.Horario;
import modelo.HorarioReserva;

public class EscReservaHorario implements Initializable {
  static Connection con;
  static Cliente cliente = null;
  EscInitSes initSes = new EscInitSes();
  Locale espa = new Locale("es", "ES");
  LocalDateTime ld = LocalDateTime.now();
  // static DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-MM-aaaa");
  DayOfWeek diaa = ld.getDayOfWeek();
  static ArrayList<Button> listaBotones = new ArrayList<>();
  static int i = 0;

  // LocalDateTime diaHoy= LocalDateTime.
  public EscReservaHorario() {
    con = Conexion.getConexion();

  }

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
  private Button boton08;
  @FXML
  private Button botonReserva;

  @FXML
  private DatePicker DatePickerB;

  @FXML
  private Button botonAtras;

  @FXML
  private TableColumn<?, ?> coluLunes;

  @FXML
  private GridPane gridPane;
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
  void accionReservar(MouseEvent event) {

  }

  @FXML
  void accionSeleccionaHora(MouseEvent event) {
    // System.out.println(event.getPickResult());
    String botonSeleccionado = event.getSource().toString();
    botonSeleccionado = botonSeleccionado.substring(10, 17);
    System.out.println(botonSeleccionado);

    i++;
    System.out.println(i);
    if (i % 2 == 0) {
      habilitaBotones();
    } else {
      deshabilitaBotones(listaBotones, botonSeleccionado);
    }

  }

  @FXML
  void DatePickerEvent(ActionEvent event) {
    String mayus = DatePickerB.getValue().getDayOfWeek().getDisplayName(TextStyle.FULL, espa);
    textFFecha.setText(mayus.toUpperCase());
    habilitaBotones();
    // label.setText(DatePickerB.getValue().toString());
    // label.setText(diaa.toString());
    // label.setText(ld.getHour() + ":" + ld.getMinute());
    // System.out.println("dia "+ diaa);
    // System.out.println("hora " + ld.getHour() + ":" + ld.getMinute());
  }

  @FXML
  void Selecciona(MouseEvent event) {

  }

  @FXML
  void atras(ActionEvent event) {
    App.escena4();
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd
    // HH:mm:ss")))
    // ),
    deshabilitaTodosBotones();
    anchor.getStylesheets().add(getClass().getResource("css/principal.css").toExternalForm());
    circular();
    cargarUser();
    Timeline tl = new Timeline(new KeyFrame(Duration.ZERO, e -> label.setText(fechita())),
        new KeyFrame(Duration.seconds(1)));
    tl.setCycleCount(Animation.INDEFINITE);
    tl.play();
    textFFecha.setEditable(false);

    if(verificaReserva()){
      System.out.println("El cliente ya tiene una reserva");
      System.out.println(cliente.getPilaReservas().get(cliente.getPilaReservas().size()));
    }else{
      System.out.println("El cliente no tiene reserva ");
    }
    // cargarTabla();

  }

  private String fechita() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    label.setText(LocalDateTime.now().format(formatter));
    return LocalDateTime.now().format(formatter);
  }

  
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

  public boolean verificaCuota() {
    boolean puede = false;
    String sql = "SELECT * FROM cliente where idCliente=?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, cliente.getIdCliente());
      // ResultSet rs= ps.executeQuery();
      if (cliente.getCuota() == null) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setContentText("No tienes ningún plan contratado con nosotros. ");
        alert.setTitle("Reserva de Horario");
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

  public boolean verificaReserva() {
    int dia = ld.getDayOfMonth();
    Month mes = ld.getMonth();
    String mayus = mes.getDisplayName(TextStyle.FULL, espa);
    mayus = mayus.toUpperCase();
    String clave = mayus.substring(0, 3);
    clave += dia;
    boolean puede = false;
    if (cliente.getPilaReservas() != null) {
      for (HorarioReserva reservaList : cliente.getPilaReservas()) {
        if (reservaList.getIdHorario().contains(clave)) {
          if (reservaList.isEstado()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Ya tienes una reserva activa para este día.");
            alert.setHeaderText("Ya tienes una reserva");
            alert.setTitle("Reserva de Horario ");

          } else {
            puede = true;
          }
        } else {
          puede = true;
        }
      }
    }
    return puede;
  }

  public void reservaHorario() {
    HorarioReserva reserva = new HorarioReserva();
    String sql = "Insert into reserva(idCliente, idCuota, estado) values (?, ?, ?)";
    if (verificaCuota() && verificaReserva()) {

      try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, cliente.getIdCliente());
        ps.setInt(2, cliente.getCuota().getIdCuota());
        ps.setBoolean(3, true);

        // reserva.setIdHorario();
        reserva.setIdCliente(cliente.getIdCliente());
        reserva.setEstado(true);

        ps.executeUpdate();

      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

  }

  public void deshabilitaBotones(ArrayList<Button> listaBotones, String boton) {

    for (Button botons : listarBotones()) {
      if (!botons.getId().toString().equals(boton)) {
        botons.setDisable(true);

      }
    }
  }

  public ArrayList<Button> listarBotones() {

    listaBotones.add(boton08);
    listaBotones.add(boton09);
    listaBotones.add(boton10);
    listaBotones.add(boton11);
    listaBotones.add(boton12);
    listaBotones.add(boton13);
    listaBotones.add(boton16);
    listaBotones.add(boton17);
    listaBotones.add(boton18);
    listaBotones.add(boton19);
    listaBotones.add(boton20);
    listaBotones.add(boton21);

    return listaBotones;
  }

  public void habilitaBotones() {

    for (Button botons : listarBotones()) {
      // if (botons.getId().toString().equals(boton)) {
      botons.setDisable(false);

      // }
    }
  }

  public void deshabilitaTodosBotones(){
    for (Button botons : listarBotones()) {
      
         botons.setDisable(true);
 
    }
  }



}
