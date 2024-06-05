package hotel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Modelo.Grupo;
import Modelo.Trabajador;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Escena2 implements Initializable {
    static Connection con;
    static Trabajador trabajador;
    static Grupo grupo;
    public Escena2() {
        con = Conexio.getConexion();

    }

    @FXML
    private ImageView b1;

    @FXML
    private ImageView b2;

    @FXML
    private ImageView b3;

    @FXML
    private ImageView b4;

    @FXML
    private ImageView b5;

    @FXML
    private ImageView b6;

    @FXML
    private ImageView bSalir;

    @FXML
    private Label labelNombre;

    @FXML
    void accedeServicio(MouseEvent event) {
        
        System.out.println(event.getPickResult().getIntersectedNode().getId());
        cargarServicio(event.getPickResult().getIntersectedNode().getId());
    }

    @FXML
    void accionSalir(MouseEvent event) {
        App.escena1();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cargaUser();
    }

    public void cargaUser() {
        trabajador = new Trabajador();
        trabajador = Escena1.devuelveTrabajador();

        labelNombre.setText(trabajador.getNom_trabajador());
    }

    public void cargarServicio(String cod){
        cod= cod.substring(1);
        int cod_grupo= Integer.parseInt(cod);

        
        String sql= "select * from grupo where cod_grupo=?";

        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, cod_grupo);
            ResultSet rs= ps.executeQuery();

            if(rs.next()){
                grupo = new Grupo();
                grupo.setCod_grupo(cod_grupo);
                grupo.setNom_servicio(rs.getString("nom_servicio"));
                System.out.println(grupo);
                App.escena3();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public static Grupo pasarGrupo(){
        System.out.println(grupo);
        return grupo;
    }

}
