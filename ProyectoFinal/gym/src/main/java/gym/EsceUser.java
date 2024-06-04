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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import modelo.Cliente;
import modelo.Cuota;
import modelo.Planes;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class EsceUser implements Initializable {
    App app = new App();
    // Locale espa = new Locale("es", "ES");
    DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Connection con;
    static Cliente cliente1 = null;
    static Cliente cliente2 = null;
    static Cliente cliente = null;
    static Cuota cuota;
    static Planes pla;
    RegistrateEsc reg;
    EscInitSes init;

    public EsceUser() {
        con = Conexion.getConexion();
    }

    @FXML
    private Button Contrata;
    @FXML
    private AnchorPane anchor4;
    @FXML
    private Button botonAtras;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonCambiarContraseña;
    @FXML
    private Button botonCerrarSesion;
    @FXML
    private Button botonnFondo;

    @FXML
    private Button botonReserva;

    @FXML
    private ImageView imagenUser;
    @FXML
    private Label labelCoincide;
    @FXML
    private Label labelFecha;
    @FXML
    private Label labelReserva;

    @FXML
    private Label vencimiento;

    @FXML
    private TextField textFApellido;

    // @FXML
    // private TextField textFContraActual;
    @FXML
    private Label textFCuota;

    @FXML
    private TextField textFMail;

    @FXML
    private TextField textFNombre;

    @FXML
    private TextField textFPass;

    @FXML
    private TextField textFPass2;

    @FXML
    void accionAccesoReserva(MouseEvent event) {// label
        App.escena3();
    }

    @FXML
    void accionAtras(ActionEvent event) {
        App.escena1();
    }

    @FXML
    void accionCancelar(ActionEvent event) {
        botonCambiarContraseña.setVisible(false);
        // textFContraActual.setVisible(false);
        desactivaText(false);
        botonesEditables(false);
        textFApellido.setText(cliente.getApellido());
        textFNombre.setText(cliente.getNombre());
        i--;
        j--;
    }

    @FXML
    void accionCambiaPlan(ActionEvent event) {
        App.escena6();
    }

    int i = 0;

    @FXML
    void accionCambiarContraseña(ActionEvent event) {
        i++;
        if (i % 2 == 0) {
            desactivaText(false); // deshabilita

            // textFContraActual.setVisible(false);
        } else {// apretar 1 vez
            // textFContraActual.setVisible(true);
            desactivaText(true); // se activa

        }
    }
    // @FXML
    // void accionCambiaContrTeclado(KeyEvent event) {
    // if (textFContraActual.getText().equals(cliente.getPass())) {
    // textFContraActual.setVisible(false);
    // desactivaText(false);
    // }else{
    // labelCoincide.setText("contraseña incorrecta");
    // }

    // }

    @FXML
    void accionCerrarSesion(ActionEvent event) {
        cliente = null;
        cliente2 = null;
        cliente1 = null;
        App.escena1();
    }

    @FXML
    void accionCorrobora(KeyEvent event) {
        if (textFPass.getText().equals(textFPass2.getText())) {
            labelCoincide.setText(" ");
        } else {
            labelCoincide.setText("Las contraseñas deben coincidir");

        }
    }

    int j = 0;

    @FXML
    void accionEdita(ActionEvent event) {
        j++;
        if (j % 2 == 0) {// par
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Modificar User");
            alert.setContentText("¿Estas seguro de que deseas modificar tus datos?");
            alert.setHeaderText("Modificar Usuarios");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                    botonCambiarContraseña.setVisible(false);
                    botonesEditables(false);
                    editarCliente();
                    botonCancelar.setVisible(false);
                    desactivaText(false);
                }
            });

        } else {
            botonCambiarContraseña.setVisible(true);
            botonesEditables(true);
            botonCancelar.setVisible(true);
        }

    }

    @FXML
    void accionReserva(ActionEvent event) {
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
        botonesEditables(false);
        circular();
        sas();
        desactivaText(false);
        // textFContraActual.setVisible(false);
        botonCambiarContraseña.setVisible(false);
        botonCancelar.setVisible(false);
        System.out.println("entra en iniciar");
    }

    public void cargaUser() {
        cliente = null;
        cliente2 = null;
        cliente1 = null;
        try {
            this.cliente1 = RegistrateEsc.pasarUser(); //reg.pasarUser();
            //System.out.println("prueba para ver 1 "+  cliente1);
            this.cliente2 = init.pasarUSer();
          //  System.out.println("prueba para ver "+  cliente2);


        } catch (Exception e) {
            System.out.println("sigue siendo nulo");
        }

        if (cliente2 != null) {
            cliente = cliente2;

            cargarPagina(cliente2);
            System.out.println("carga cliente");

        } else if (cliente1 != null) {
            cliente = cliente1;

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
        // if (client.getCuota() != null) {
        // textFCuota.setText(client.getCuota().getplan().getIdPlan());
        // } else {
        // textFCuota.setText("No cuentas con ningún plan activo");
        // }

        if (verificaCuota()) {
            textFCuota.setText(cuota.getPlan().getDescripción());
            vencimiento.setText("Tenes hasta el: " + cuota.getFechaVencimiento().format(formater));
            System.out.println(cuota);
        } else {
            textFCuota.setText("No cuentas con ningún plan activo");
        }
    }

    public void botonesEditables(boolean editar) {
        textFNombre.setEditable(editar);
        textFApellido.setEditable(editar);
        textFMail.setEditable(editar);
        // textFCuota.setEditable(false);
    }

    public void circular() {
        double radio = 100;
        Circle circulo = new Circle(radio, radio, radio);
        imagenUser.setClip(circulo);
        imagenUser.setFitWidth(2 * radio);
        imagenUser.setFitHeight(2 * radio);

    }

    public void desactivaText(boolean activar) {
        textFPass.setStyle("-fx-background-color: #ffffff;");
        textFPass2.setStyle("-fx-background-color: #ffffff;");

        textFPass.setStyle("-fx-text-fill: #2F2F2F;");
        textFPass2.setStyle("-fx-text-fill: #2F2F2F;");

        textFPass.setVisible(activar);
        textFPass2.setVisible(activar);
        textFPass.setEditable(activar);
        textFPass2.setEditable(activar);

    }

    private String fechita() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        labelFecha.setText(LocalDateTime.now().format(formatter));
        return LocalDateTime.now().format(formatter);
    }

    public static Cliente pasarUser() {
        return cliente;

    }

    public void sas() {
        if (verificaCuota()) {
            // botonReserva.setDisable(false);
            labelReserva.setDisable(false);
            System.out.println("El cliente tiene un plan");
            System.out.println("Tu promo: " + cliente.getPilaReservas());
        } else {
            // botonReserva.setDisable(true);
            labelReserva.setDisable(true);
            System.out.println("El cliente no tiene un plan  ");
            Tooltip toolito = new Tooltip("Contrata un Plan para poder reservar");
            Tooltip.install(botonnFondo, toolito);
        }
    }

    /* */
    public boolean verificaCuota() {
        boolean puede = false;
        String sql = "SELECT * FROM cuota where idCliente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            // ResultSet rs= ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuota = new Cuota();

                cuota.setIdCuota(rs.getInt("idCuota"));
                cuota.setPlan(buscaPlan(rs.getString("idPlan")));
                cuota.setIdCliente(rs.getInt("idCliente"));
                cuota.setEstado(rs.getBoolean("estado"));

                cuota.setFechaInicio(LocalDate.parse(rs.getString("fechaInicio")));
                cuota.setFechaVencimiento(LocalDate.parse(rs.getString("fechaVencimiento")));
                if (cuota.isEstado()) {
                    puede = true;
                } else {

                }

                cliente.setCuota(cuota);
            }
            // si el cliente ya tiene una reserva en el mismo dia no deberia poder reservar
            // de nuevo

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return puede;

    }

    public Planes buscaPlan(String id) {
        String sql = "Select *  from plan where idPlan=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
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
        return pla;
    }

    public void verificaVencimiento() {
        if (cuota.getFechaVencimiento().isAfter(LocalDate.now())) {
            cuota.setEstado(false);
        }

    }

    public Cliente cargaClienteParaEdit() {
        Cliente cliente2 = new Cliente();
        System.out.println(textFNombre.getText());
        System.out.println(textFApellido.getText());
        System.out.println(textFPass.getText());
        System.out.println(textFPass2.getText());
        cliente2.setNombre(textFNombre.getText());

        cliente2.setApellido(textFApellido.getText());
        if (textFPass.getText() != null && textFPass2.getText() != null) {
            if (textFPass.getText().equals(textFPass2.getText())) {
                cliente2.setPass(textFPass.getText());
            }
        }

        return cliente2;
    }

    public void editarCliente() {
        Cliente aux = cargaClienteParaEdit();
        String sql = "update cliente set nombre=?, apellido=?, pass=? where idcliente=?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aux.getNombre());
            ps.setString(2, aux.getApellido());

            if (aux.getPass() != null) {
                ps.setString(3, aux.getPass());
            } else {
                ps.setString(3, cliente.getPass());

            }
            ps.setInt(4, cliente.getIdCliente());

            if (ps.executeUpdate() == 1) {
                cliente.setApellido(aux.getApellido());
                cliente.setNombre(aux.getNombre());
                if (aux.getPass() != null) {
                    cliente.setPass(aux.getPass());
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
