package usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class Control {
    public HashMap<String, String> mapita = new HashMap<>();
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
      
        valida();

    }

    public void valida() {
        boolean entrar = false;
        int i = 0;
        try {
            FileReader fr = new FileReader("C:\\Users\\Fran-PC\\Desktop\\Willy\\DAM\\Programacion\\Unidad9\\Programaa\\fx\\usuario\\usuariop\\src\\main\\java\\usuario\\user-pass.txt");
            // FileReader fr = new
            // FileReader("/home/dam/Escritorio/Asignaturas/Programacion/gluon/usuario/usuariop/src/main/java/usuario/user-pass.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            do {

                String[] userPass = new String[2];
                userPass = linea.split(":");
                if (userPass[0].equals(TFUsuario.getText())) {
                    if (userPass[1].equals(TFPass.getText())) {
                        entrar = true;
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("ACCESO CONCEDIDO");
                        alert.showAndWait();
                       // Platform.exit();
                    } else {
                        i++;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setContentText("Formato incorrectoooo");
                        alert.showAndWait();
                    }
                 } else {
                    i++;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setContentText("Formatopincorrecto");
                    alert.showAndWait();
                }
                
            } while (i<3 &&!entrar);
            System.out.println("contador" + i);
         //   Platform.exit();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }
}
