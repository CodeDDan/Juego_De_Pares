package Clases;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */
public class Temporizador extends JLabel {

    private int seg = 0, segD = 0, min = 0, minD = 0;
    private int segundosTotales = 0;
    private JLabel lbl1, lbl2, lbl3, lbl4, lblDiv;
    private final ImageIcon icon[] = new ImageIcon[12];
    private int contador = 0;
    private boolean encendido;
    private Dificultad dificultad;
    private final ScheduledExecutorService tarea = Executors.newSingleThreadScheduledExecutor();

    public int getSegundosTotales() {
        return segundosTotales;
    }

    public void setSegundosTotales(int segundosTotales) {
        this.segundosTotales = segundosTotales;
    }

    public enum Dificultad {
        FACIL, MEDIO, DIFICIL
    }

    public Temporizador(Dificultad dificultad) {
        this.dificultad = dificultad;
        // Aquí se determinan los segundos totales de partida por dificultad
        switch (dificultad) {
            case FACIL:
                segundosTotales = 420;
                break;
            case MEDIO:
                segundosTotales = 300;
                break;
            case DIFICIL:
                segundosTotales = 180;
                break;
            default:
                break;
        }
        init();
    }

    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        icon[0] = new ImageIcon("src\\Iconos\\Icono0_50px.png");
        icon[1] = new ImageIcon("src\\Iconos\\Icono1_50px.png");
        icon[2] = new ImageIcon("src\\Iconos\\Icono2_50px.png");
        icon[3] = new ImageIcon("src\\Iconos\\Icono3_50px.png");
        icon[4] = new ImageIcon("src\\Iconos\\Icono4_50px.png");
        icon[5] = new ImageIcon("src\\Iconos\\Icono5_50px.png");
        icon[6] = new ImageIcon("src\\Iconos\\Icono6_50px.png");
        icon[7] = new ImageIcon("src\\Iconos\\Icono7_50px.png");
        icon[8] = new ImageIcon("src\\Iconos\\Icono8_50px.png");
        icon[9] = new ImageIcon("src\\Iconos\\Icono9_50px.png");
        // Cuando la división de exactamente 10
        icon[10] = new ImageIcon("src\\Iconos\\Icono0_50px.png");
        icon[11] = new ImageIcon("src\\Iconos\\IconoDosPuntos_50px.png");
        minD = segundosTotales / 600;
        min = segundosTotales / 60;
        segD = (segundosTotales % 60) /10;
        seg = (segundosTotales % 60) % 10;
        lbl1 = new JLabel(icon[minD]);
        lbl2 = new JLabel(icon[min]);
        lbl3 = new JLabel(icon[segD]);
        lbl4 = new JLabel(icon[seg]);
        lblDiv = new JLabel(icon[11]);
        this.add(lbl1);
        this.add(lbl2);
        this.add(lblDiv);
        this.add(lbl3);
        this.add(lbl4);
        tarea.scheduleAtFixedRate(() -> {
            if (contador >= 1000 ) {
                segundosTotales -= 1;
                System.out.println(segundosTotales);
                actualizarIconos();
                contador = 0;
            } 
            if (encendido) {
                contador += 100;
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
    
    private void actualizarIconos() {
        minD = segundosTotales / 600;
        min = segundosTotales / 60;
        segD = (segundosTotales % 60) /10;
        seg = (segundosTotales % 60) % 10;
        lbl1.setIcon(icon[minD]);
        lbl2.setIcon(icon[min]);
        lbl3.setIcon(icon[segD]);
        lbl4.setIcon(icon[seg]);
    }

    public void resetear() {
        switch (dificultad) {
            case FACIL:
                segundosTotales = 420;
                break;
            case MEDIO:
                segundosTotales = 300;
                break;
            case DIFICIL:
                segundosTotales = 180;
                break;
            default:
                break;
        }
        actualizarIconos();
    }

    public void aumentarTiempo() {
        switch (dificultad) {
            case FACIL:
                segundosTotales += 2;
                break;
            case MEDIO:
                segundosTotales += 4;
                break;
            case DIFICIL:
                segundosTotales += 5;
                break;
            default:
                break;
        }
        actualizarIconos();
    }
    
    public void apagarReloj() {
        encendido = false;
    }

    public void encenderReloj() {
        encendido = true;
    }

}
