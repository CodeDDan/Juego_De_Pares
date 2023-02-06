package Clases;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class ObjetoMusic {
    
    private final File nombreM;
    //Se estaba "borrando" el objeto, la solución es declararlo aquí.
    private static MediaPlayer mediaPlayer;

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    
    public ObjetoMusic(String cancion) {
        //Se necesita inicializar el JFXPanel a pesar de que no se lo use.
        final JFXPanel pan = new JFXPanel();
        nombreM = new File(cancion);
        Media hit = new Media(nombreM.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
    }
    
    public synchronized void loop() {
        mediaPlayer.setStartTime(Duration.ZERO);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    
}
