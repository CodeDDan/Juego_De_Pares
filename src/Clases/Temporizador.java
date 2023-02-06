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

public class Temporizador extends JLabel{

    private int seg = 0, segD = 0, min = 0, minD = 0;
    private JLabel lbl1, lbl2, lbl3, lbl4, lblDiv;
    private final ImageIcon icon [] = new ImageIcon[11];
    private int contador = 0;
    private boolean encendido;
    private final ScheduledExecutorService tarea = Executors.newSingleThreadScheduledExecutor();
    
    public Temporizador() {
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
        icon[10] = new ImageIcon("src\\Iconos\\IconoDosPuntos_50px.png");
        lbl1 = new JLabel(icon[0]);
        lbl2 = new JLabel(icon[0]);
        lbl3 = new JLabel(icon[0]);
        lbl4 = new JLabel(icon[0]);
        lblDiv = new JLabel(icon[10]);
        this.add(lbl1);
        this.add(lbl2);
        this.add(lblDiv);
        this.add(lbl3);
        this.add(lbl4);
        tarea.scheduleAtFixedRate(() -> {
            //System.out.println(contador);
            if (contador >= 1000 && seg < 9) {
                seg++;
                System.out.println(seg);
                Temporizador.this.lbl4.setIcon(icon[seg]);
                contador = 0;
            } else if (contador >= 1000 && segD < 5) {
                segD++;
                Temporizador.this.lbl3.setIcon(icon[segD]);
                Temporizador.this.lbl4.setIcon(icon[0]);
                seg = 0;
                contador = 0;
            } else if (contador >= 1000 && min < 9) {
                min++;
                Temporizador.this.lbl2.setIcon(icon[min]);
                Temporizador.this.lbl3.setIcon(icon[0]);
                Temporizador.this.lbl4.setIcon(icon[0]);
                seg = 0;
                segD = 0;
                contador = 0;
            } else if (contador >= 1000 && minD < 5) {
                minD++;
                Temporizador.this.lbl1.setIcon(icon[minD]);
                Temporizador.this.lbl2.setIcon(icon[0]);
                Temporizador.this.lbl3.setIcon(icon[0]);
                Temporizador.this.lbl4.setIcon(icon[0]);
                seg = 0;
                segD = 0;
                min = 0;
                contador = 0;
            } else if (contador >= 1000 && minD >= 5) {
                resetear();
            } 
            //this.lbl4.setIcon(icon[contador]);
            if (encendido) {
                contador += 100;
            }
            
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
    
    public void resetear(){
        lbl1.setIcon(icon[0]);
        lbl2.setIcon(icon[0]);
        lbl3.setIcon(icon[0]);
        lbl4.setIcon(icon[0]);
        contador = 0; seg = 0; segD = 0; min = 0; minD = 0;
    }
    
    public void apagarReloj() {
        encendido = false;
    }
    
    public void encenderReloj() {
        encendido = true;
    }
    
}
