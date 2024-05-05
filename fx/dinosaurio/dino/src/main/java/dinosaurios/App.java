package dinosaurios;

import javafx.application.Application;
import javafx.css.converter.StringConverter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import modelo.DinoEnum;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene, scene2, scene3;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader loadFXML = new FXMLLoader(App.class.getResource("disenio.fxml"));
        // VBox root = new VBox();

        scene = new Scene(loadFXML.load());
        scene.getStylesheets().add(getClass().getResource("dise.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        FXMLLoader loadFXML2 = new FXMLLoader(App.class.getResource("scene2.fxml"));
        scene2 = new Scene(loadFXML2.load());


        FXMLLoader loadFXML3 = new FXMLLoader(App.class.getResource("scene3.fxml"));
        scene3 = new Scene(loadFXML3.load());

    }
    public static void cambioScena1(){
        stage.setScene(scene);
    }
    public static void cambioScena2() {

        stage.setScene(scene2);

    }
    public static void cambioScena3() {

        stage.setScene(scene3);

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
        CBTamanio.setConverter(new StringConverter<DinoEnum>() {
        @Override
        public String toString(DinoEnum dinoEnum) {
            return dinoEnum != null ? dinoEnum.getTamanyo() : null;
        }
    
        @Override
        public DinoEnum fromString(String s) {
            return null;
        }
    });

}