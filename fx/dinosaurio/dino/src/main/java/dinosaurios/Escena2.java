package dinosaurios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Escena2 implements Initializable {

    Connection con= null;
    String url = "jdbc:mysql://127.0.0.1:33006/JurassicPark";
     String user = "root";
     String password = "Paquito2024----";
public Connection conectar() throws SQLException {
    con= DriverManager.getConnection(url,user,password);
    return con;
}


    Atraccion atraccion=null;
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
    void AsignaDino(ActionEvent event) {

        App.cambioScena3();
    }

    @FXML
    void AsignaZona(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarCombo();
    }

    @FXML
    public void AgregarAtraccion(ActionEvent actionEvent) {



    }

//    String nombre;
//    String tamanyo;
//    String alimentacion;
//    String tipo;

    public ArrayList listaDinos(){
        ArrayList<Dinosaurio> listaDino= new ArrayList<>();
        String sql = "SELECT * FROM Dinosaurio";
        Dinosaurio dino=null;
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
//            Statement stmt= con.createStatement();
//            ResultSet rs= stmt.executeQuery(sql);
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

        CBDino.setValue("selecciona");
        CBDino.getItems().addAll(listaDinos());
        CBZona.setValue("selecciona");
        CBZona.getItems().addAll(listarZonas());
    }

    public ArrayList listarZonas(){
        ArrayList<Zona> listaZona= new ArrayList<>();
        String sql = "SELECT * FROM Zona";
        Zona zona=null;
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
//            Statement stmt= con.createStatement();
//            ResultSet rs= stmt.executeQuery(sql);
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
        String sql="Insert into Atraccion(id_zona, id_dino, nombre, capacidad, edad_minima) values (?,?,?,?,?)";
        atraccion= new Atraccion();
        atraccion.setDinosaurio((Dinosaurio)CBDino.getValue());
        atraccion.setZona((Zona)CBZona.getValue());
        atraccion.setNombre(TFNombre.getText());
        atraccion.setCapacidad(Integer.parseInt(TFCapacidad.getText()));
        atraccion.setEdad(Integer.parseInt(TFEdadMinima.getText()));
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1, Integer.parseInt(CBZona.getValue().toString()));

           ps.setInt(2,Integer.parseInt(CBDino.getValue().toString()));
            ps.setString(3,atraccion.getNombre() );
            ps.setInt(4, atraccion.getCapacidad());
            ps.setInt(5, atraccion.getEdad());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
