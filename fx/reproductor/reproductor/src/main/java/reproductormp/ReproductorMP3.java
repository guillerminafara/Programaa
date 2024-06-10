package reproductormp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ReproductorMP3 implements Initializable {
    MediaPlayer playerito;
    @FXML
    private Slider BarraCancion;

    @FXML
    private Slider BarraVolumen;

    @FXML
    private Button BotonAtras;

    @FXML
    private Button BotonPlay;

    @FXML
    private Button BotonRayitas;

    @FXML
    private Button BotonVolumen;

    @FXML
    private Button BotonALguno;
    @FXML
    private ImageView img;

    @FXML
    void adelantaCancion(MouseEvent event) {
        playerito.seek(Duration.seconds(BarraCancion.getValue()));

    }

    boolean playP = true;
    Duration dura;
    int i=0;
    @FXML
    void darlePlay(ActionEvent event) {
        Timeline tl = new Timeline(
                (new KeyFrame(Duration.ZERO, e -> BarraCancion.setValue(playerito.getCurrentTime().toSeconds()))),
                new KeyFrame(Duration.seconds(1)));
        System.out.println();
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
        if (playP) {
            i++;
            if(i==1){
                darleAlPlay();

            }else{
                System.out.println(dura);
                playerito.seek(dura);
                BarraCancion.setValue(dura.toSeconds());
                tl.play();
                playerito.play();
            }

            playP = false;

        } else {
            dura=playerito.getCurrentTime();
            playerito.pause();
            tl.pause();
            playP = true;

        }
        // playerito.currentTimeProperty().addListener(new ChangeListener<Duration>() {
        // @Override
        // public void changed(ObservableValue <? extends Duration> valor, Duration
        // duracion, Duration duracion2){
        // // playerito.seek(duracion2);
        // BarraCancion.setValue(duracion2.toSeconds());
        // }
        // });

    }
    boolean mute= true;
    @FXML
    void mute(ActionEvent event) {
        if(mute){
            playerito.setMute(true);
            mute= false;
        }else{
            mute=true;
            playerito.setMute(false);

        }

    }


    @FXML
    void rayitasEvent(ActionEvent event) {
        reproducir();
        BotonPlay.setDisable(false);

    }

    @FXML
    void subirVolumen(MouseEvent event) {
        playerito.setVolume(BarraVolumen.getValue() * 0.01);
    }

    @FXML
    private Button BotonX;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        BarraVolumen.setValue(50);
        BotonPlay.setDisable(true);

    }

    static Media media;

    public void reproducir() {

        FileChooser chooser = new FileChooser();
        // chooser.setInitialDirectory(new File(System.getProperty("media")));
        Stage stagee = (Stage) BotonRayitas.getScene().getWindow();
        chooser.setTitle("Selecciona un Archivo de sonido");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Audio", "*.mp3"), new ExtensionFilter("Todo", "*"));

        File fichero = chooser.showOpenDialog(stagee);
        if (fichero != null) {
            media = new Media(fichero.toURI().toString());
            // System.out.println(fichero.toURI().toString());

        }
    }

    public void darleAlPlay() {
        playerito = new MediaPlayer(media);
        playerito.setVolume(0.5);
        playerito.setAutoPlay(true);
        playerito.play();
        playerito.setOnReady(() -> {
            BarraCancion.setMax(playerito.getTotalDuration().toSeconds());

        });

        // return playerito;
    }

    public void subirVolumen() {

    }
}
