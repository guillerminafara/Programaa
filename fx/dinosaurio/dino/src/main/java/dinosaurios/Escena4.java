package dinosaurios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;


public class Escena4 {
    Connection con = null;
    // String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    // String user = "root";
    // String password = "Paquito2024----";
    String url = "jdbc:mysql://localhost/JurassicPark";
    String user = "root";
    String password = "";

    public Connection conectar() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    @FXML
    private Button BAtras4;

    @FXML
    private Button BSAlir4;

    @FXML
    private ImageView imagenMapa;
    @FXML
    private Button BEste;

    @FXML
    private Button BNorte;

    @FXML
    private Button BOeste;

    @FXML
    private Button BSur;

    @FXML
    void Atras4(ActionEvent event) {
        App.cambioScena1();
    }

    @FXML
    void Salir4(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Norte4(ActionEvent event) {
        Atraccion atrac = null;
        atrac = buscarAtracciones(buscarPorZona(1));
        if (atrac != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText(atrac.getZona() + " - " + atrac.getNombre());
            alert.setContentText(
                    "Capacidad: " + atrac.getCapacidad() + "\nEdad Mínima: " + atrac.getEdad() + "\nDinosaurios: "
                            + atrac.getDinosaurio().getNombre());
            alert.show();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText("White-Mont");
            alert.setContentText("Lo sentimos, aún no tenemos atracciones en la Zona");
            alert.show();
        }

    }

    @FXML
    void OEste4(ActionEvent event) {
        Atraccion atrac = null;
        atrac = buscarAtracciones(buscarPorZona(4));
        if (atrac != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText(atrac.getZona() + " - " + atrac.getNombre());
            alert.setContentText(
                    "Capacidad: " + atrac.getCapacidad() + "\nEdad Mínima: " + atrac.getEdad() + "\nDinosaurios: "
                            + atrac.getDinosaurio().getNombre());
            alert.show();

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText("Sun-Beach");
            alert.setContentText("Lo sentimos, aún no tenemos atracciones en la Zona");
            alert.show();
        }
    }

    @FXML
    void Seleccion(ActionEvent event) {
        Atraccion atrac = null;
        atrac = buscarAtracciones(buscarPorZona(2));
        if (atrac != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText(atrac.getZona() + " - " + atrac.getNombre());
            alert.setContentText(
                    "Capacidad: " + atrac.getCapacidad() + "\nEdad Mínima: " + atrac.getEdad() + "\nDinosaurios: "
                            + atrac.getDinosaurio().getNombre());
            alert.show();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText("Sun-Beach");
            alert.setContentText("Lo sentimos, aún no tenemos atracciones en la Zona");
            alert.show();
        }
    }

    @FXML
    void sur4(ActionEvent event) {
        Atraccion atrac = null;
        atrac = buscarAtracciones(buscarPorZona(3));
        if (atrac != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText(atrac.getZona() + " - " + atrac.getNombre());
            alert.setContentText(
                    "Capacidad: " + atrac.getCapacidad() + "\nEdad Mínima: " + atrac.getEdad() + "\nDinosaurios: "
                            + atrac.getDinosaurio().getNombre());
            alert.show();
        } else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Ver Atracciones");
            alert.setHeaderText("Sun-Beach");
            alert.setContentText("Lo sentimos, aún no tenemos atracciones en la Zona");
            alert.show();
        }
    }

    public Atraccion buscarAtracciones(Zona zona) {
        Atraccion atraccion = null;
        String sql = "Select * from Atraccion where id_zona=?";
        PreparedStatement ps;
        try {
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, zona.getIdZona());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                atraccion = new Atraccion();
                atraccion.setIdAtraccion(rs.getInt("id_atraccion"));
                atraccion.setZona(zona);
                atraccion.setDinosaurio(buscarDino(rs.getInt("id_dino")));
                atraccion.setNombre(rs.getString("nombre"));
                atraccion.setCapacidad(rs.getInt("capacidad"));
                atraccion.setEdad(rs.getInt("edad_minima"));
                System.out.println("Entra en buscarporAtrac id: " + rs.getInt("id_dino"));
                System.out.println(zona);
            }
            // Alert alert= new Alert(Alert.AlertType.INFORMATION);
            // alert.setTitle(zonaa.getNombre());
            // alert.setContentText();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return atraccion;
    }

    public Dinosaurio buscarDino(int idDino) {
        Dinosaurio dino = null;
        String sql = "SELECT * from Dinosaurio where id_dino=?";
        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, idDino);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dino = new Dinosaurio();
                dino.setIdDino(idDino);
                dino.setNombre(rs.getString("nombre"));
                dino.setAlimentacion(rs.getString("alimentacion"));
                dino.setTamanyo(rs.getString("tamanyo"));
                dino.setTipo(rs.getString("tipo"));
                System.out.println(dino);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dino;
    }

    public Zona buscarPorZona(int IdZona) {
        Zona zona = null;
        String sql = "SELECT * from Zona where id_zona=?";

        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setInt(1, IdZona);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                zona = new Zona();
                zona.setIdZona(IdZona);
                zona.setNombre(rs.getString("nombre"));
                zona.setUbicacion(rs.getString("ubicacion"));
                System.out.println("Entra en buscarporzona");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return zona;
    }
}
