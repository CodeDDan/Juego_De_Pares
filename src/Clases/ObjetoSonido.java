package Clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class ObjetoSonido {
    
    private File nombreS;
    private String carpetaSEfectos;
    private ArrayList<String> dirSonidos = new ArrayList<>();
    private static MediaPlayer mediaPlayer;
    private double volumen = 0.5;

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    
    public ObjetoSonido(String carpetaSonidos) {
        //Se necesita inicializar el JFXPanel a pesar de que no se la use.
        final JFXPanel pan = new JFXPanel();
        carpetaSEfectos = carpetaSonidos;
        //Leemos la carpeta
        try {
            Path dir = Paths.get(carpetaSEfectos);
            Files.walk(dir).forEach(path -> addSonido(path.toFile()));
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error en la lectura de sonidos");
        }
        
    }
    
    private void addSonido(File archivo) {
        //Dividimos la dirección del archivo en 2
        String [] pal = archivo.getAbsolutePath().split("src");
        //System.out.println(pal[1]);
        //Añadimos el path desde la carpeta raíz;
        dirSonidos.add("src"+pal[1]);
        //System.out.println(dirImagen.get(cont));
        //cont++;
    }
    
    public synchronized void usarSonido(String sonido) {
        if(!dirSonidos.contains(sonido)) {
            System.out.println("No existe el sonido");
            return;
        }
        nombreS = new File(sonido);
        Media hit = new Media(nombreS.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setStartTime(Duration.ONE);
        mediaPlayer.setStopTime(Duration.seconds(2));
        //Se debe usar un método distinto para el volumen dado que el objeto MediaPlayer no está inicializado
        mediaPlayer.setVolume(volumen);
        mediaPlayer.play();
    }
    
}
