package hotel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Modelo.Trabajador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class Escena1 implements Initializable {
    static Connection con;
    static Trabajador trabajador;

    public Escena1() {
        con = Conexio.getConexion();

    }
    @FXML
    private Button botonEntrar;

    @FXML
    private ImageView img;

    @FXML
    private PasswordField textFCod;

    @FXML
    void accionEntrar(ActionEvent event) {
        codigoValid(Integer.parseInt(textFCod.getText()));
    }

   

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    public Trabajador codigoValid(int cod) {

        String sql = "Select * from trabajador where cod_trabajador=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setCod_trabajador(cod);
                trabajador.setNom_trabajador(rs.getString("nom_trabajador"));
                App.escena2();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR DE ACCESO");
                alert.setContentText("El código no peertenee a ningún trabajador");
                alert.setHeaderText("Error");
                alert.show();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return trabajador;


    }
    public static Trabajador devuelveTrabajador(){
        return trabajador;
    }

}
