package cajeronova;

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

    private static Scene scene, scene2;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage= stage;
        FXMLLoader loadFXML = new FXMLLoader(App.class.getResource("Escena1.fxml"));
        scene = new Scene(loadFXML.load() );
        stage.setScene(scene);
        stage.show();

        FXMLLoader loadFXML2 = new FXMLLoader(App.class.getResource("Escena2.fxml"));
        scene2 = new Scene(loadFXML2.load());
    }

    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }
    public static void cambioScena2() {
        stage.setScene(scene2);
       // scene2.setOnShown(event -> Escena2.cargalabel());

    }
    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}