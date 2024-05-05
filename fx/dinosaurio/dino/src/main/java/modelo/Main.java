package modelo;

public class e {
    import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Cargar la vista desde el archivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ComboBox con Enum");

        // Configurar el ComboBox con los valores del enum
        ComboBox<DinoEnum> comboBox = (ComboBox<DinoEnum>) root.lookup("#comboBox");
        comboBox.getItems().addAll(DinoEnum.values());

        // Configurar el StringConverter para convertir los valores del enum a minúsculas
        comboBox.setConverter(new StringConverter<DinoEnum>() {
            @Override
            public String toString(DinoEnum dinoEnum) {
                return dinoEnum != null ? dinoEnum.getTamanyo().toLowerCase() : null;
            }

            @Override
            public DinoEnum fromString(String s) {
                return null;
            }
        });

        // Mostrar la escena
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

}
