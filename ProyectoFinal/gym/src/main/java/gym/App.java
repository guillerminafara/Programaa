package gym;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Cliente;

import java.io.IOException;
import java.util.Stack;

/**
 * JavaFX App
 */
public class App extends Application {
    static Cliente cliente; 
     static Scene scene, scene2, scene3, scene4,scene5;
     static Stage stage;
   static Stack<Scene> pila= new Stack<>();


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Principal.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
       // stage.setMaxWidth(1024);
        stage.show();
    }
    public static void escena1() {
        stackScenas(scene);
            stage.setScene(scene);
    
    }

    public static void escena2() {
        
        FXMLLoader fxmlLoader2 = new FXMLLoader(App.class.getResource("InicioSesion.fxml"));
        try {
            scene2 = new Scene(fxmlLoader2.load());
            stackScenas(scene2);
            stage.setScene(scene2);
            // stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void escena3() {
       

        FXMLLoader fxmlLoader3 = new FXMLLoader(App.class.getResource("Reserva.fxml"));
        try {
            scene3 = new Scene(fxmlLoader3.load());
           
            stage.setScene(scene3);
             stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void escena4() {
        
        FXMLLoader fxmlLoader4 = new FXMLLoader(App.class.getResource("InicioCliente.fxml"));
        try {
            scene4 = new Scene(fxmlLoader4.load());
            stage.setScene(scene4);
            // stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void escena5() {
        
        FXMLLoader fxmlLoader5 = new FXMLLoader(App.class.getResource("Registrate.fxml"));
        try {

            scene5 = new Scene(fxmlLoader5.load());
            stackScenas(scene5);
            stage.setScene(scene5);
            // stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // static void setRoot(String fxml) throws IOException {
    // scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +
    // ".fxml"));
    // return fxmlLoader.load();
    // }

    //agrega escenaas a la pila
    public static void stackScenas(Scene escena){
        if (stage.getScene() != null) {
            pila.push(stage.getScene());
        }
        stage.setScene(escena);
    }
    //elimina escenas de la pila 
    public static void volver() {
        if (!pila.isEmpty()) {
            stage.setScene(pila.pop());
        }
    }
    public static void main(String[] args) {
        launch();
    }

}