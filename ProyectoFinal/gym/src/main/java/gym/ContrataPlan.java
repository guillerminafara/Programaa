package gym;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modelo.Cliente;
import modelo.Cuota;
import modelo.Planes;

public class ContrataPlan implements Initializable {
    static Connection con;
    String botonSelect;
    Cuota cuota;
    static Planes pla;
    static Cliente cliente;
    static Cliente cliente1;
    static Cliente cliente2;

    static DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    ArrayList<Cuota> listaCuotas = new ArrayList<>();

    public ContrataPlan() {
        con = Conexion.getConexion();
    }

    // ObservableList<String> datos;
    ObservableList<ObservableList<String>> datos;
    @FXML
    private Button b12M;

    @FXML
    private Button b01M;

    @FXML
    private Button b03M;

    @FXML
    private Button botonAcepta;

    @FXML
    private Button botonAtras;

    @FXML
    private Button botonSalir;
    @FXML
    private ImageView img;

    @FXML
    private Label labelPlan;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextArea textArea3;
    @FXML
    private TableColumn<ObservableList<String>, String> columnaDescripcion;

    @FXML
    private TableColumn<ObservableList<String>, String> columnaFechaFin;

    @FXML
    private TableColumn<ObservableList<String>, String> columnaFechaInicio;

    @FXML
    private TableColumn<ObservableList<String>, String> columnaPrecio;

    @FXML
    private TableView<ObservableList<String>> tabla;

    @FXML
    void accionAtras(ActionEvent event) {
        App.escena4();
    }

    @FXML
    void accionCancelar(ActionEvent event) {
        datos.clear();
        habilitaBotones();

    }

    @FXML
    void accionGenerarReserva(ActionEvent event) {
        // TextInputDialog texInput = new TextInputDialog();
     
        buscaPlan(botonSelect);
        boolean aux = crearDialog();
        if (aux) {
            crearCuota();
            System.out.println("entra al true" + aux);
        } else {
            System.out.println("entra al false" + aux);

        }
    }

    @FXML
    void accionSelecciona(ActionEvent event) {
        botonSelect = event.getSource().toString().substring(11, 14);
       
        deshabilitaBotones(botonSelect);
        buscaPlan(botonSelect);
        if (cliente.getCuota() != null) {
            if (cliente.getCuota().isEstado()) {
                recontrata();

            }

        } else {
            cargarTabla();
        }
        botonAcepta.setDisable(false);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        botonAcepta.setDisable(true);
        cargarUser();
    }
    public Cliente cargarUser(){
        cliente1= new Cliente();
        cliente2= new Cliente();

        cliente1= RegistrateEsc.pasarUser();
        cliente2= EscInitSes.pasarUSer();
        if(cliente1!=null){
            cliente= cliente1;
        }
        if(cliente2!=null){
            cliente=cliente2;
        }
        return cliente;
    }
    public void buscaPlan(String botonSelect) {
        String sql = "Select *  from plan where idPlan=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, botonSelect);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pla = new Planes();
                pla.setIdPlan(rs.getString("idPlan"));
                pla.setDescripción(rs.getString("descripcion"));
             
                pla.setImporte(rs.getDouble("importe"));
                pla.setEstado(true);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Planes buscaPlanxId(String id) {
        Planes plann = null;
        String sql = "Select *  from plan where idPlan=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                plann = new Planes();
                plann.setIdPlan(rs.getString("idPlan"));
                plann.setDescripción(rs.getString("descripcion"));
              
                plann.setImporte(rs.getDouble("importe"));
                plann.setEstado(rs.getBoolean("estado"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return plann;
    }

    public void deshabilitaBotones(String botonSelect) {
      

        if (b01M.getId().contains(botonSelect)) {
            
            b03M.setDisable(true);
            b12M.setDisable(true);
        } else if (b03M.getId().contains(botonSelect)) {
        
            b01M.setDisable(true);
            b12M.setDisable(true);

        } else if (b12M.getId().contains(botonSelect)) {
            
            b01M.setDisable(true);
            b03M.setDisable(true);

        }

    }

    public void habilitaBotones() {
        b01M.setDisable(false);
        b03M.setDisable(false);
        b12M.setDisable(false);
        botonAcepta.setDisable(true);

    }

    public void cargarTabla() {
        ObservableList<String> fila = FXCollections.observableArrayList();
        datos = FXCollections.observableArrayList();
        fila.add(LocalDate.now().format(formater));
        fila.add(pla.getDescripción());
        fila.add(fechasFinaliza(pla).format(formater));
        fila.add(pla.getImporte() + "");
        datos.add(fila);
        tabla.setItems(datos);
        columnaFechaInicio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(0)));
        columnaDescripcion.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(1)));
        columnaFechaFin.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(2)));
        columnaPrecio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(3)));
    }

    public void crearCuota() {
        String sql = "Insert into cuota (idPlan, idCliente, estado, fechaInicio, fechaVencimiento) values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            cuota = new Cuota();
            cuota.setIdPlan(pla);
            cuota.setIdCliente(cliente.getIdCliente());
            cuota.setEstado(true);
            cuota.setFechaInicio(LocalDate.now());
            cuota.setFechaVencimiento(fechasFinaliza(pla));

            ps.setString(1, cuota.getPlan().getIdPlan());
            ps.setInt(2, cuota.getIdCliente());
            ps.setBoolean(3, true);
            ps.setString(4, cuota.getFechaInicio() + "");
            ps.setString(5, cuota.getFechaVencimiento() + "");
            if (ps.executeUpdate() == 1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Ya eres parte de nuestro equipo. ");
                alert.setTitle("Membresia");
                alert.setContentText(
                        pla.getDescripción() + ". El plan estará disponible hasta " + cuota.getFechaVencimiento());
                alert.show();
                botonAcepta.setDisable(true);
                cliente.setCuota(cuota);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public LocalDate fechasFinaliza(Planes pla) {
        LocalDate fechas = null;
        if (pla.getIdPlan().equals("01M")) {
            fechas = LocalDate.now().plusMonths(1).minusDays(1);
        } else if (pla.getIdPlan().equals("03M")) {
            fechas = LocalDate.now().plusMonths(3).minusDays(1);

        } else if (pla.getIdPlan().equals("12M")) {
            fechas = LocalDate.now().plusMonths(12).minusDays(1);

        }
        return fechas;
    }

    public boolean crearDialog() {
        boolean[] puede = { false };
        // String puede="0";
        Dialog<List<String>> dialog = new Dialog();
        dialog.setHeaderText("Pago con tarjeta");
        // dialog.setContentText("Número de tarjeta: ");
        ButtonType botonOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(botonOk, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        TextField num = new TextField();
        num.setPromptText("Número de tarjeta: ");
        TextField cvv = new TextField();
        cvv.setPromptText("CVV:");
        TextField vencimiento = new TextField();
        vencimiento.setPromptText("Vencimiento:");
        grid.add(new Label("Número de tarjeta: "), 0, 0);
        grid.add(num, 1, 0);
        grid.add(new Label("CVV:"), 0, 1);
        grid.add(cvv, 1, 1);
        grid.add(new Label("Vencimiento:"), 0, 2);
        grid.add(vencimiento, 1, 2);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == botonOk) {
                List<String> results = new ArrayList<>();
                results.add(num.getText());
                results.add(cvv.getText());
                results.add(vencimiento.getText());
                return results;
            }
            return null;
        });
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Pago con tarjeta");
        alert.setContentText("Datos no válidos");

        Optional<List<String>> result = dialog.showAndWait();
        result.ifPresent(inputs -> {
            if (inputs.get(0).length() != 16) {
                alert.show();
            } else if (inputs.get(1).length() != 3) {
                alert.show();
            } else if (inputs.get(2).length() != 7) {
                alert.show();
            } else {
                puede[0] = true;
            }

        });
        return puede[0];
    }

    public void recontrata() {
        LocalDate fechaInicio = LocalDate.now();
        String fechaVencimiento = "";

        fechaInicio = cliente.getCuota().getFechaVencimiento().plusDays(1);

        ObservableList<String> fila = FXCollections.observableArrayList();
        datos = FXCollections.observableArrayList();
        fila.add(fechaInicio.format(formater) + "");
        fila.add(pla.getDescripción());
        fila.add(fechasFinaliza2(pla, fechaInicio).format(formater) + "");
        fila.add(pla.getImporte() + "");
        datos.add(fila);
        tabla.setItems(datos);
        columnaFechaInicio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(0)));
        columnaDescripcion.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(1)));
        columnaFechaFin.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(2)));
        columnaPrecio.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().get(3)));
    }

    public LocalDate fechasFinaliza2(Planes pla, LocalDate inicio) {
        LocalDate fechas = null;
        if (pla.getIdPlan().equals("01M")) {
            fechas = inicio.plusMonths(1).minusDays(1);
        } else if (pla.getIdPlan().equals("03M")) {
            fechas = inicio.plusMonths(3).minusDays(1);

        } else if (pla.getIdPlan().equals("12M")) {
            fechas = inicio.plusMonths(12).minusDays(1);

        }
        return fechas;
    }

    public void cancelaxVencimiento() {
        for (Cuota lista : listarCuotas()) {

        }
    }

    public ArrayList<Cuota> listarCuotas() {
        listaCuotas = new ArrayList<>();
        Cuota cuotaa = new Cuota();
        String sql = "Select * from cuota where idcliente= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fecha = "";
                fecha = rs.getString("fechaInicio");
                cuotaa.setPlan(buscaPlanxId(rs.getString("idPlan")));
                cuotaa.setIdCliente(rs.getInt("idCliente"));
                cuotaa.setFechaInicio(LocalDate.parse(fecha));
                cuotaa.setFechaVencimiento(LocalDate.parse(rs.getString("fechaVencimiento")));
                listaCuotas.add(cuotaa);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaCuotas;
    }

}
