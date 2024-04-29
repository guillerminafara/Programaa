package dinosaurios;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class PrimaryController implements Initializable{

    @FXML
    private Button JBCrear;

    @FXML
    private Button JBListarD;

    @FXML
    private Button JBListarZ;

    @FXML
    private Button JBSalir;

    @FXML
    private AnchorPane LDino;

    @FXML
    private ImageView imageview;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    //  try {
      
    //    // Image image = new Image(new FileInputStream("/resources/dinosaurios/dino.jpg"));
    //     Image image = new Image(new FileInputStream("C:\\Users\\Fran-PC\\Desktop\\Willy\\DAM\\Programacion\\Unidad9\\Programaa\\fx\\dinosaurio\\dino\\src\\main\\resources\\dinosaurios\\dino.jpg"));

    //  //   Image image = new Image(getClass().getResource("/resources/dinosaurios/dino.jpg"));

    //     imageview.setImage(image);
    // } catch (FileNotFoundException e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    // }
        // try {
        //   //  JBSalir.setGraphic(new ImageView(new Image(new FileInputStream("salir.png"))));
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

    


    }


}
