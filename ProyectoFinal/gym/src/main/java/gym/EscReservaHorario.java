package gym;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
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
  static DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  DayOfWeek diaa = ld.getDayOfWeek();
  static ArrayList<Button> listaBotones = new ArrayList<>();
  static int i = 0;
  static HorarioReserva reserva;
  String diahora = "";
  Horario horario;
  Map<Button, LocalTime> mapa = new HashMap<>();

  // LocalDateTime diaHoy= LocalDateTime.
  public EscReservaHorario() {
    con = Conexion.getConexion();

  }
  // ObservableList<ObservableList<String>> datos;
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
  private Button botonPrueba;
  @FXML
  private Button botonReserva;

  @FXML
  private DatePicker DatePickerB;

  @FXML
  private Button botonAtras;

  @FXML
  private TableColumn<String,Cliente> coluEstado;

  @FXML
  private TableColumn<String, HorarioReserva> coluFecha;

  @FXML
  private TableColumn<String,HorarioReserva> coluNombre;

  @FXML
  private TableView<String> tablaReservas;

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
  void cargaDia(ActionEvent event) {

  }

  @FXML
  void accionReservar(ActionEvent event) {
    String id = crearId();
    if (!verificaHorario(id)) {
      System.out.println("entra en el true ");

      crearHorarios(id);// por error meti el id dentro del metodo en otro metodo verificar crregir si da
                        // tiempo

    } else {
      horario = buscaHorarios(id);
      reservaHorario(id);
      System.out.println("YA EXISTE EL ID");
    }
  }

  @FXML
  void accionPrueba(ActionEvent event) {
    crearId();
  }

  @FXML
  void accionSeleccionaHora(MouseEvent event) {
    // botonSeleccionado ="";
    crearId();
    // System.out.println(event.getPickResult());
    String botonSeleccionado = event.getSource().toString();
    botonSeleccionado = botonSeleccionado.substring(10, 17);
    System.out.println(botonSeleccionado);

    i++;
    System.out.println(i);
    if (i % 2 == 0) {
      habilitaBotones();
    } else {
      deshabilitaBotones(botonSeleccionado);
    }

  }

  @FXML
  void DatePickerEvent(ActionEvent event) {
    String mayus = DatePickerB.getValue().getDayOfWeek().getDisplayName(TextStyle.FULL, espa);
    textFFecha.setText(mayus.toUpperCase());
    habilitaBotones();

    deshabilitarPorHora(mapaBotones());
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
    System.out.println(cliente);
    deshabilitaTodosBotones();
    anchor.getStylesheets().add(getClass().getResource("css/principal.css").toExternalForm());
    circular();
    cargarUser();
    Timeline tl = new Timeline(new KeyFrame(Duration.ZERO, e -> label.setText(fechita())),
        new KeyFrame(Duration.seconds(1)));
    tl.setCycleCount(Animation.INDEFINITE);
    tl.play();
    textFFecha.setEditable(false);
    // mapaBotones();

    // if (!verificaReserva()) {
    // System.out.println("El cliente ya tiene una reserva");
    // System.out.println(cliente.getPilaReservas().get(cliente.getPilaReservas().size()));
    // } else {
    // System.out.println("El cliente no tiene reserva ");
    // }
    // cargarTabla();

    datePickerModifica();
  }

  public Horario buscaHorarios(String id) {
    String sql = "SELECT * FROM horario where idHorario=?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        System.out.println("id ingresado en buscarHorario: " + id);

        horario = new Horario();
        horario.setIdHorario(id);
        horario.setDiaHora(LocalDateTime.parse(rs.getString("fecha_hora"), formater));
        horario.setCant(rs.getInt("cantidad"));
        horario.setEstado(rs.getBoolean("estado"));
        System.out.println("horario ingresadi desde buscarHorario " + horario);
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return horario;
  }

  public void cancelarReserva() {
    String sql = " update reserva set estado=? where idCliente=? ";
    PreparedStatement ps;
    try {
      ps = con.prepareStatement(sql);
      ps.setBoolean(1, false);
      ps.setInt(2, cliente.getIdCliente());

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Estás seguro que deseas eliminar la reserva");
        alert.setTitle("Cancelar Reserva");
        alert.show();
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void cargarUser() {
    cliente = initSes.pasarUSer();
    labelNombre.setText(cliente.getNombre());

  }

  public void cargarTablaReservas() {
      datos = FXCollections.observableArrayList();
      cliente;
      coluNombre.setCellFactory(this);
  }

  public void circular() {
    double radio = 25;
    Circle circulo = new Circle(radio, radio, radio);
    imagenUser.setClip(circulo);
    imagenUser.setFitWidth(2 * radio);
    imagenUser.setFitHeight(2 * radio);

  }

  // crea un horario y devuelve verdadero o false en caso de crearlo
  public boolean crearHorarios(String id) {
    boolean exito = false;
    // verifica horario es false o sea si el id no existe, procedemos a crearlo
    // if (!verificaHorario(crearId())) {

    String sql = "insert into horario(idHorario, fecha_hora, cantidad, estado)values(?, ?, ?, ?)";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      horario = new Horario();
      horario.setIdHorario(id);
      horario.setDiaHora(ld);
      horario.setCant(8);
      horario.setEstado(true);
      ps.setString(1, horario.getIdHorario());
      ps.setString(2, diahora);
      ps.setInt(3, 8);
      ps.setBoolean(4, true);
      if (ps.executeUpdate() == 1) {
        System.out.println("creamos con exito el horario");
        exito = true;
        System.out.println("horario de crear horario" + horario);

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // }
    return exito;
  }

  public String crearId() {
    String mes = "";
    diahora = DatePickerB.getValue() + " " + deshabilitarPorHora(mapaBotones());

    mes = DatePickerB.getValue().getMonth().toString().substring(0, 3);
    // System.out.println(mes + DatePickerB.getValue().getDayOfMonth());
    mes += DatePickerB.getValue().getDayOfMonth() + "-";
    // System.out.println("horarioSeleccionado(mapaBotones())" +
    // deshabilitarPorHora(mapaBotones()));
    mes += deshabilitarPorHora(mapaBotones());
    mes = mes.substring(0, 8);
    System.out.println("salida crearId " + mes);

    return mes;
  }

  // metodo que abre los horarios en caso de que tenga un user loggeado .. si no
  // hay user loggeado redirecciona a ingresar

  // public boolean verificaCuota() {
  // boolean puede = false;
  // String sql = "SELECT * FROM cliente where idCliente=?";
  // try {
  // PreparedStatement ps = con.prepareStatement(sql);
  // ps.setInt(1, cliente.getIdCliente());
  // // ResultSet rs= ps.executeQuery();
  // if (cliente.getCuota() == null) {
  // Alert alert = new Alert(AlertType.WARNING);
  // alert.setContentText("No tienes ningún plan contratado con nosotros. ");
  // alert.setTitle("Reserva de Horario");
  // } else {
  // puede = true;
  // }
  // // si el cliente ya tiene una reserva en el mismo dia no deberia poder
  // reservar
  // // de nuevo

  // } catch (SQLException e) {
  // // TODO Auto-generated catch block
  // e.printStackTrace();
  // }
  // return puede;

  // }
  public void datePickerModifica() {
    Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
      @Override
      public DateCell call(final DatePicker DatePickerB) {
        return new DateCell() {
          @Override
          public void updateItem(LocalDate fecha, boolean vacio) {
            super.updateItem(fecha, vacio);

            // deshabilito los dias anteriores
            if (fecha.isBefore(LocalDate.now())) {
              setDisable(true);
              setStyle("-fx-background-color: #EEEEEE;");
            }
            // deshabilito los dias posteriores
            if (fecha.isAfter(LocalDate.now().plusDays(2))) {
              setDisable(true);
              setStyle("-fx-background-color: #EEEEEE;");
            }
          }
        };
      }
    };

    DatePickerB.setDayCellFactory(dayCellFactory);
  }

  public void deshabilitaBotones(String boton) {

    for (Button botons : listarBotones()) {
      if (!botons.getId().toString().equals(boton)) {
        botons.setDisable(true);

      }
    }
  }

  public void deshabilitaTodosBotones() {
    for (Button botons : listarBotones()) {

      botons.setDisable(true);

    }
  }

  public String deshabilitarPorHora(Map<Button, LocalTime> mapa) {
    LocalDate hoy = LocalDate.now();
    LocalTime ahora = LocalTime.now();

    ahora = ahora.plusHours(1);

    for (Map.Entry<Button, LocalTime> mapita : mapa.entrySet()) {
      Button boton = mapita.getKey();
      LocalTime hora = mapita.getValue();
      if (hora.isBefore(ahora) && DatePickerB.getValue().isEqual(hoy)) {
        boton.setDisable(true);
      }
      boton.setOnAction(event -> {
        seleccion = hora.toString();
        // System.out.println("boton seleccion: " + seleccion);
        // System.out.println("botn presionado: " + boton.getText());
        // System.out.println("Hora del botón: " + hora);
      });
    }

    return seleccion;
  }

  private String fechita() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    label.setText(LocalDateTime.now().format(formatter));
    return LocalDateTime.now().format(formatter);

  }

  public void habilitaBotones() {

    for (Button botons : listarBotones()) {
      // if (botons.getId().toString().equals(boton)) {
      botons.setDisable(false);

      // }
    }
  }

  static String seleccion = "";

  public String horarioSeleccionado(Map<Button, LocalTime> mapa) {

    for (Map.Entry<Button, LocalTime> mapita : mapa.entrySet()) {
      Button boton = mapita.getKey();
      LocalTime hora = mapita.getValue();

      boton.setOnAction(event -> {
        seleccion = hora.toString();
        // System.out.println("boton seleccion: " + seleccion);
        // System.out.println("botn presionado: " + boton.getText());
        // System.out.println("Hora del botón: " + hora);
      });

    }
    return seleccion;
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

  public ArrayList<HorarioReserva> listarReservas() {
    ArrayList<HorarioReserva> listaReservas = new ArrayList<>();
    HorarioReserva reservaaa;
    String sql = "Select * from reserva where idCliente=?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, cliente.getIdCliente());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        reservaaa = new HorarioReserva();
        reservaaa.setIdReserva(rs.getInt("idReserva"));
        reservaaa.setIdCliente(cliente.getIdCliente());
        reservaaa.setIdHorario(rs.getString("idHorario"));
        reservaaa.setEstado(rs.getBoolean("estado"));
        listaReservas.add(reserva);
      }
      System.out.println(listaReservas);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listaReservas;
  }

  public void reservaHorario(String id) {

    String sql = "Insert into reserva(idCliente, idHorario, estado) values (?, ?, ?)";
    // if (verificaReserva()) {//completar metodo con una lista

    try {
      PreparedStatement ps = con.prepareStatement(sql);
      reserva = new HorarioReserva();

      // reserva.setIdHorario();
      reserva.setIdCliente(cliente.getIdCliente());
      System.out.println("cliente.getIdCliente()" + cliente.getIdCliente());
      reserva.setIdHorario(horario.getIdHorario());
      System.out.println("horario.getIdHorario()" + horario.getIdHorario());
      reserva.setEstado(true);
      ps.setInt(1, reserva.getIdCliente());
      ps.setString(2, reserva.getIdHorario());
      ps.setBoolean(3, reserva.isEstado());
      if (ps.executeUpdate() == 1) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("Ya tenes tu reserva lista");
        alert.setHeaderText("Reserva creada con exito");
        alert.show();
      } else {
        System.out.println("no se que onda ");
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // }

  }

  public Map<Button, LocalTime> mapaBotones() {

    mapa.put(boton08, LocalTime.of(8, 0));
    mapa.put(boton09, LocalTime.of(9, 0));
    mapa.put(boton10, LocalTime.of(10, 0));
    mapa.put(boton11, LocalTime.of(11, 0));
    mapa.put(boton12, LocalTime.of(12, 0));
    mapa.put(boton13, LocalTime.of(13, 0));
    mapa.put(boton16, LocalTime.of(16, 0));
    mapa.put(boton17, LocalTime.of(17, 0));
    mapa.put(boton18, LocalTime.of(18, 0));
    mapa.put(boton19, LocalTime.of(19, 0));
    mapa.put(boton20, LocalTime.of(20, 0));
    mapa.put(boton21, LocalTime.of(21, 0));

    return mapa;
  }

  // metodo que pretende verificar si ya existe creado el horario FALSE NO EXISTE
  public boolean verificaHorario(String id) {
    boolean existe = false;
    String sql = "SELECT * FROM horario where idHorario=?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        System.out.println("id ingresado en verificar Horario : " + id);
        existe = true;
      }
      // System.out.println("estado de verificaHorario " + existe);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return existe;
  }

  public boolean verificaReserva() {
    // ArrayList<HorarioReserva> listaReservas = new ArrayList<>();
    // listaReservas = listarReservas();

    // String dia = ld.getDayOfMonth();
    // Month mes = ld.getMonth();
    // String mayus = mes.getDisplayName(TextStyle.FULL, espa);
    // mayus = mayus.toUpperCase();
    // String clave = mayus.substring(0, 3);
    // clave += dia;
    boolean puede = false;
    LocalDate hoy = LocalDate.now();

    String id2 = hoy.getMonth().getDisplayName(TextStyle.FULL, espa);
    id2 += hoy.getDayOfMonth() + "";

    // String id = crearId();
    // if (lista != null) {
    for (HorarioReserva listaReservas : listarReservas()) {
      if (listaReservas.getIdHorario().contains(id2)) {
        if (listaReservas.isEstado()) {
          Alert alert = new Alert(AlertType.ERROR);
          alert.setContentText("Ya tienes una reserva activa para este día.");
          alert.setHeaderText("Ya tienes una reserva");
          alert.setTitle("Reserva de Horario ");
          alert.show();
        } else {
          puede = true;
        }
      } else {
        puede = true;
      }
    }
    // }
    return puede;
  }

}
