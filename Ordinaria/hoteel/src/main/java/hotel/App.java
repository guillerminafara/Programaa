package hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene, scene2,scene3;
    static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("escena1.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public static void escena1(){
        stage.setScene(scene);
    }
    public static void escena2(){
        FXMLLoader fxmlLoader2 = new FXMLLoader(App.class.getResource("escena2.fxml"));
        try {
            scene2 = new Scene(fxmlLoader2.load());
            stage.setScene(scene2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escena3(){
        FXMLLoader fxmlLoader3 = new FXMLLoader(App.class.getResource("escena3.fxml"));
        try {
            scene3 = new Scene(fxmlLoader3.load());
            stage.setScene(scene3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}