package gym;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Cliente;

public class EscInitSes implements Initializable{
    private Connection con = null;
    static Cliente cliente;
    boolean entra=false;
    // static String url = "jdbc:mysql://127.0.0.1:33006/Gimnasio";
    // static String user = "root";
    // static String password = "Paquito2024----";
    public EscInitSes() {
        con = Conexion.getConexion();
    }

//    public Connection conectar() throws SQLException {
//     con= DriverManager.getConnection(url,user,password);
//     return con;
// }

   
    @FXML
    private Button botonAtras;

    @FXML
    private Button BotonIngresa;

    @FXML
    private Button botonRegistrate;

    @FXML
    private PasswordField TextContra;


    @FXML
    private ImageView imagenLogo;

    @FXML
    private TextField textFmail;
    
    @FXML
    void accionRegistrate(ActionEvent event) {
        App.escena5();
    }

    @FXML
    void InicaSesion(ActionEvent event) {
        //login(textFmail.getText(),TextContra.getText() )
      
       if(login(textFmail.getText(),TextContra.getText() )){
            App.escena4();
         }else{
          botonRegistrate.setStyle("-fx-background-color: #F7641D; ");
         }
    }
    @FXML
    void atras(ActionEvent event) {
        App.escena1();
    }

    public boolean login(String log, String pass){
        PreparedStatement ps;
        String sql;

        if(log.contains("@")){
             sql="Select * from cliente where mail= ?"; // verifiicar el metodo de ingreso
             System.out.println("entra con mail");
        }else{
             sql="Select * from cliente where nif= ?";
             System.out.println("entra con nif");

        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, log);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                cliente= new Cliente();
                cliente.setIdCliente(rs.getInt("idcliente"));
                cliente.setNif(rs.getString("nif"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setMail(rs.getString("mail"));
                cliente.setPass(rs.getString("pass"));
                cliente.setEstado(rs.getBoolean("estado"));
                if(cliente.getPass().equals(pass)&& (cliente.getMail().equals(log) ||cliente.getNif().equals(log) )){
                    System.out.println("entra al next");
                    entra=true;
                }else{
                   // cliente= new Cliente(false,"","","","","", "");
                    System.out.println("no esta entrando ");
                    
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Regístrate!");
                alert.setContentText("El usuario no se encuentra registrado");
                alert.setTitle("Inicio de Sesión ");
                alert.show();

              //  cliente= new Cliente(false,"","","","","", "");
           //   throw new NullPointerException("No se ha podido iniciar sesión");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return entra;
   
    }




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
       
    }

    public void alerta(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("El mail no se encuentra registrado");
        alert.setTitle("Inicio de Sesión ");
        alert.show();
    }

    public static Cliente pasarUSer(){
        return cliente;
    }
}