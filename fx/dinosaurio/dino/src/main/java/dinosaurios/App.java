package dinosaurios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene, scene2, scene3, scene4;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader loadFXML = new FXMLLoader(App.class.getResource("disenio.fxml"));
        // VBox root = new VBox();

        scene = new Scene(loadFXML.load());
        //scene.getStylesheets().add(getClass().getResource("dise.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


    }

    public static void cambioScena1() {
        
        stage.setScene(scene);
    }

    public static void cambioScena2()  {
        FXMLLoader loadFXML2 = new FXMLLoader(App.class.getResource("scene2.fxml"));
        try {
            scene2 = new Scene(loadFXML2.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stage.setScene(scene2);

    }

    public static void cambioScena3() {
        FXMLLoader loadFXML3 = new FXMLLoader(App.class.getResource("scene3.fxml"));
        try {
            scene3 = new Scene(loadFXML3.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stage.setScene(scene3);

    }

    public static void cambioScena4() {
        FXMLLoader loadFXML4 = new FXMLLoader(App.class.getResource("scena4.fxml"));
        try {
            scene4 = new Scene(loadFXML4.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        stage.setScene(scene4);

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