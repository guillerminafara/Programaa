package agenda;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loadFXML= new FXMLLoader(App.class.getResource("a.fxml"));
        scene = new Scene(loadFXML.load(), 550, 480);
        stage.setScene(scene);
        stage.show();
    }

 

    public static void main(String[] args) {
        launch();
    }

}