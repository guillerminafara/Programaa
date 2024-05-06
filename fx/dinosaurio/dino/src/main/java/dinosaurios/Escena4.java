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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Polygon;

public class Escena4 {
    Connection con = null;
    String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    String user = "root";
    String password = "Paquito2024----";

    public Connection conectar() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    @FXML
    private CubicCurve CurveEste;
    @FXML
    private Button BAtras4;

    @FXML
    private Button BSAlir4;

    @FXML
    private ImageView imagenMapa;

    @FXML
    private CubicCurve COeste4;

    @FXML
    private CubicCurve Cnorte;

    @FXML
    private Polygon Csur4;

    @FXML
    void Atras4(ActionEvent event) {
        App.cambioScena1();
    }

    @FXML
    void Salir4(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Seleccion(MouseEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("adentro");

        alert.show();
    }

    @FXML
    void Oeste4(MouseEvent event) {

    }

    @FXML
    void Norte4(MouseEvent event) {

    }

    @FXML
    void sur4(MouseEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Zona Sur");
        alert.setContentText("");
        alert.show();
    }

    public int zonas(String zona) {
        int devolver = 0;
        switch (zona) {
            case "norte":
                devolver = 1;
                break;
            case "este":
                devolver = 2;

                break;
            case "sur":
                devolver = 3;

                break;
            case "oeste":
                devolver = 4;

                break;

        }

        return devolver;
    }

    public void buscarPorZonas(int zona) {
        String sql = "Select * from Atracciones where id_zona=?";
        PreparedStatement ps;
        try {
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, zona);
            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
