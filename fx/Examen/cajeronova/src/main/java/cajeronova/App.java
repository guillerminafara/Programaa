package cajeronova;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        FXMLLoader loadFXML = new FXMLLoader(App.class.getResource("Escena1.fxml"));
        scene = new Scene(loadFXML.load());
        stage.setScene(scene);
        stage.show();

    }

    // static void setRoot(String fxml) throws IOException {
    // scene.setRoot(loadFXML(fxml));
    // }
    public static void cambioScena1(){
        stage.setScene(scene);

    }
    public static void cambioScena2() {

        try {
            FXMLLoader loadFXML2 = new FXMLLoader(App.class.getResource("Escena2.fxml"));
            scene2 = new Scene(loadFXML2.load());
            stage.setScene(scene2);
            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // stage.addEventHandler(WindowEvent.WINDOW_SHOWN, new
        // EventHandler<Event>(WindowEvent) {

        // @Override
        // public void handle(Event arg0) {
        // // TODO Auto-generated method stub
        // Escena2
        // }

        // });
        // scene.setOnShown(WindowEvent.WINDOW_SHOWN Escena2.cargalabel());
        // scene2.setOnShown(event -> Escena2.cargalabel());

    }
    // private static Parent loadFXML(String fxml) throws IOException {
    // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +
    // ".fxml"));
    // return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}