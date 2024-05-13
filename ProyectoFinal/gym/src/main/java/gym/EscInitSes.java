package gym;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class EscInitSes implements Initializable{
    private Connection con = null;
    public EscInitSes() {
        con = Conexion.getConexion();
    }


   
    @FXML
    private Button BotonIngresa;

    @FXML
    private ImageView imagenLogo;

    @FXML
    private TextField textFmail;

    @FXML
    void InicaSesion(ActionEvent event) {

    }


    public void login(){
        String sql="Select * from cliente where idCliente= ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
       
    }
}