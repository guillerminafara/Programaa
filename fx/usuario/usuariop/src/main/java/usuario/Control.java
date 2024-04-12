package usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class Control {
    public HashMap<String, String> mapita= new HashMap<>();
    @FXML
    private Button BValidar;

    @FXML
    private TextField TFPass;

    @FXML
    private TextField TFUsuario;

    @FXML
    void Validar(ActionEvent event) {
        valida();
    }

    @FXML
    void initialize() {
        // autor de la aplicación
        valida();
      //  File f= new File("user-pass.txt");
      //  System.out.println(f.getAbsolutePath());
    }

    public void valida() {
        boolean entrar = false;
        try {
            FileReader fr = new FileReader("/home/dam/Escritorio/Asignaturas/Programacion/gluon/usuario/usuariop/src/main/java/usuario/user-pass.txt");
            BufferedReader br = new BufferedReader(fr);
            // Alert alert = new Alert(Alert.AlertType.WARNING);
            String linea = br.readLine();

            while (linea != null) {
                System.out.println("holaaaa");
                String[] userPass = new String[2];
                userPass = linea.split(":");
                if (userPass[0].equals(TFUsuario.getText())) {
                    if (userPass[1].equals(TFPass.getText())) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("ACCESO CONCEDIDO");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Formato incorrecto");
                        alert.showAndWait();
                    }
                }

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
           System.out.println( e.getMessage());
        }

        
    }
}
