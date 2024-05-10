package reproductormp;

import java.nio.file.Paths;

import javafx.scene.media.Media;

public class MediaPlayer {
    public MediaPlayer(Media media) {
        //TODO Auto-generated constructor stub
    }

    public MediaPlayer getMediaPlayer(String source) {
        Media media = new Media(Paths.get("Natalia Oreiro - Tu Veneno_5-CXJP8YYZU.mp3").toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.5); // volumen a la mitad
        player.setAutoPlay(true);
        return player;
    }

    private void setAutoPlay(boolean b) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setAutoPlay'");
    }

    private void setVolume(double d) {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'setVolume'");
    }
}
