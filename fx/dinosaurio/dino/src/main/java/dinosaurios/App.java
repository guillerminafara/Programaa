package dinosaurios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene, scene2;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader loadFXML = new FXMLLoader(App.class.getResource("disenio.fxml"));
       // VBox root = new VBox();


        scene = new Scene(loadFXML.load());
        stage.setScene(scene);
        stage.show();

      
         FXMLLoader loadFXML2 = new FXMLLoader(App.class.getResource("scene2.fxml"));
         scene2 = new Scene(loadFXML2.load());
       stage.setScene(scene2);
    }
    public static void cambioScena(){
     stage.setScene(scene2);

    }

    // static void setRoot(String fxml) throws IOException {
    // scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scene2"));
    // return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}