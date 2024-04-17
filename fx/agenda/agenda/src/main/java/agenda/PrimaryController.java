package agenda;

import java.io.IOException;

import entidades.Empleados;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class PrimaryController {

    @FXML
    private Button BAnterior;

    @FXML
    private Button BIni;

    @FXML
    private Button BSiguiente;

    @FXML
    private Button BUltimo;

    @FXML
    private TextField TFApellido;

    @FXML
    private TextField TFCargo;

    @FXML
    private TextField TFFechaNac;

    @FXML
    private TextField TFNombre;

    @FXML
    private TextField TFTelefono;

    @FXML
    private TextField TFidEmpleado;

    @FXML
    void validate(ActionEvent event) {

    }


    public void deshabilitarIni(){
        Empleados empleados= new Empleados();
        if(empleados.getIdEmpleado()==1){
            BIni.setDisable(true);
        }
     }

     public void deshabilitarUltimo(int i){
        Empleados empleados= new Empleados();
        if(empleados.getIdEmpleado()==i){
            BIni.setDisable(true);
        }
     }
}
 