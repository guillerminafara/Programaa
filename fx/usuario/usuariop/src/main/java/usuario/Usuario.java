package usuario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * JavaFX App
 */
public class Usuario extends Application {

    private static Scene scene;

    @Override
    public void init()  {
        //throws FileNotFoundException
        //FileReader fr = new FileReader("C:\\Users\\Fran-PC\\Desktop\\Willy\\DAM\\Programacion\\Unidad9\\Programaa\\fx\\usuario\\usuariop\\src\\main\\java\\usuario\\user-pass.txt");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loadFXML = new FXMLLoader(Usuario.class.getResource("Interfaz.fxml"));
        scene = new Scene(loadFXML.load());
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResource("/usuario/sapoo.png").toExternalForm()));
        // stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop()  {

    }

    public static void main(String[] args) {
        launch();
    }

}