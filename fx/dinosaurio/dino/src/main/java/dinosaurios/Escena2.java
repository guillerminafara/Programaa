package dinosaurios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Escena2 implements Initializable {

    Connection con= null;
    // String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
    //  String user = "root";
    //  String password = "Paquito2024----";
     String url = "jdbc:mysql://localhost/JurassicPark";
     String user = "root";
     String password = "";
public Connection conectar() throws SQLException {
    con= DriverManager.getConnection(url,user,password);
    return con;
}

    Atraccion atraccion=null;
    @FXML
    private Button BAtras;

    @FXML
    private Button BSalir;

    @FXML
    private ComboBox CBDino;

    @FXML
    private ComboBox  CBZona;
    @FXML
    private TextField TFEdadMinima;
    @FXML
    private TextField TFNombre;
    @FXML
    private TextField TFCapacidad;
    @FXML
    private Button BAgregar;
    @FXML
    private ImageView imgatras;

    @FXML
    void AsignaDino(ActionEvent event) {
        System.out.println(CBDino.getValue().toString());

        //App.cambioScena3();
    }

    @FXML
    void AsignaZona(ActionEvent event) {
        System.out.println(CBZona.getValue().toString());

    }
    @FXML
    public void AgregarAtraccion(ActionEvent actionEvent) {
        agregaAtraccion();


    }
    @FXML
    void Atras2(ActionEvent event) {
        atras2();
    }

    @FXML
    void Salir2(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarCombo();
    }



//    String nombre;
//    String tamanyo;
//    String alimentacion;
//    String tipo;

    public void atras2(){
        App.cambioScena1();
    }
    public ArrayList listaDinos(){
        ArrayList<Dinosaurio> listaDino= new ArrayList<>();
        String sql = "SELECT * FROM Dinosaurio";
        Dinosaurio dino=null;
        try {
         //   PreparedStatement ps= conectar().prepareStatement(sql);
           // ResultSet rs= ps.executeQuery();
           Statement stmt= conectar().createStatement();
           ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                 dino=new Dinosaurio();
                 dino.setIdDino(rs.getInt("id_dino"));
              dino.setNombre(rs.getString("nombre"));
              dino.setTamanyo(rs.getString("tamanyo"));
              dino.setAlimentacion(rs.getString("alimentacion"));
              dino.setTipo(rs.getString("tipo"));
              listaDino.add(dino);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDino;

    }

    public void cargarCombo(){

       // CBDino.setValue("selecciona");
        CBDino.getItems().addAll(listaDinos());
       // CBZona.setValue("selecciona");
        CBZona.getItems().addAll(listarZonas());
    }

    public ArrayList listarZonas(){
        ArrayList<Zona> listaZona= new ArrayList<>();
        String sql = "SELECT * FROM Zona";
        Zona zona=null;
        try {
           // PreparedStatement ps= conectar().prepareStatement(sql);
           // ResultSet rs= ps.executeQuery();
           Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                zona=new Zona();
                zona.setIdZona(rs.getInt("id_zona"));
                zona.setNombre(rs.getString("nombre"));
                zona.setUbicacion(rs.getString("ubicacion"));


                listaZona.add(zona);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaZona;
    }

    public void agregaAtraccion(){
        String sql="Insert into atraccion(id_zona, id_dino, nombre, capacidad, edad_minima) values (?,?,?,?,?)";
        atraccion= new Atraccion();
        atraccion.setDinosaurio((Dinosaurio)CBDino.getValue());
        atraccion.setZona((Zona)CBZona.getValue());
        atraccion.setNombre(TFNombre.getText());
        atraccion.setCapacidad(Integer.parseInt(TFCapacidad.getText()));
        atraccion.setEdad(Integer.parseInt(TFEdadMinima.getText()));
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
          //ps.setInt(1, Integer.parseInt(CBZona.getValue().toString()));
          ps.setInt(1, atraccion.getZona().getIdZona());
          ps.setInt(2, atraccion.getDinosaurio().getIdDino());

          // ps.setInt(2,Integer.parseInt(CBDino.getValue().toString()));
            ps.setString(3,atraccion.getNombre() );
            ps.setInt(4, atraccion.getCapacidad());
            ps.setInt(5, atraccion.getEdad());
            if(ps.executeUpdate()==1){
                Alert alert= new Alert(AlertType.INFORMATION);
                alert.setContentText("agregado con exito");
                alert.show();
                TFNombre.clear(); 
                TFCapacidad.clear();
                TFEdadMinima.clear();
                
            }
            
        } catch (SQLException e) {
            System.out.println(e);
            Alert alert= new Alert(AlertType.ERROR);
            alert.setContentText("Error a la hora de agregar la atracción");
            alert.show();
        }
    }
}
