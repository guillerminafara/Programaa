package reproductormp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loadFXML = new FXMLLoader(App.class.getResource("escenaMediaPlayer.fxml"));
        scene = new Scene(loadFXML.load());
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    static public void reproducir() {

        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File(System.getProperty("media")));
        chooser.setTitle("Selecciona un Archivo de sonido");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Audio", "*.mp3"), new ExtensionFilter("Todo", "*"));
        File fichero = chooser.showOpenDialog(stage);
        if (fichero != null) {
        Media media = new Media(fichero.toURI().toString());

        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}