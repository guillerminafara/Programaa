package reproductormp;

import java.nio.file.Paths;

import javafx.scene.media.Media;

public class MediaPlayer {
    public MediaPlayer(Media media) {
        
    }

    public MediaPlayer getMediaPlayer(String source) {
        Media media = new Media(Paths.get(source).toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0.5); // volumen a la mitad
        player.setAutoPlay(true);
        return player;
    }
    void setAutoPlay(boolean b) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setAutoPlay'");
    }

    void setVolume(double d) {
        // TODO Auto-generated method stub
      //  throw new UnsupportedOperationException("Unimplemented method 'setVolume'");
    }
}
