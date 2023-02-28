package Clases;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Point;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Daniel Sánchez
 */
public class ObjetoPuntuacion extends Dialog {

    private int puntaje = 0;
    private final TIPO tipo;
    private final PanelGradiente gradiente = new PanelGradiente();
    // Tendremos una puntuación máxima de 9999
    private final ImageIcon icon [] = new ImageIcon[11];
    private JLabel lbl1, lbl2, lbl3, lbl4;
    
    public int getPuntaje() {
        return puntaje;
    }
    
    public ObjetoPuntuacion(Frame owner, TIPO tipo, PanelGradiente panel) {
        super(owner);
        this.tipo = tipo;
        init(panel);
    }

    private void init(PanelGradiente panel) {
        // Iniciamos los íconos
        gradiente.setLayout(new BoxLayout(gradiente, BoxLayout.X_AXIS));
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
        // Cuando la división resulte exactamente 10 
        icon[10] = new ImageIcon("src\\Iconos\\Icono0_50px.png");
        // Iniciamos los label
        lbl1 = new JLabel(icon[0]);
        lbl2 = new JLabel(icon[0]);
        lbl3 = new JLabel(icon[0]);
        lbl4 = new JLabel(icon[0]);
        // Quitamos la cabezera del JDialog
        this.setUndecorated(true);
        // Personalizamos el panel
        gradiente.setColor1(panel.getColor2());
        gradiente.setColor2(panel.getColor1());
        // Añadimos los label al panel principal
        gradiente.add(lbl1);
        gradiente.add(lbl2);
        gradiente.add(lbl3);
        gradiente.add(lbl4);
        // Añadimos el panel
        add(gradiente);
        pack();
    }

    public enum TIPO {
        FACIL, MEDIO, DIFICIL
    }

    public void actualizarPuntaje() {
        switch (tipo) {
            case FACIL:
                puntaje += 2;
                break;
            case MEDIO:
                puntaje += 5;
                break;
            case DIFICIL:
                puntaje += 10;
                break;
            default:
                break;
        }
        // Se debe obtener la división del dígito correspondiente y luego sacar 
        // el módulo. 
        int pos1 = (puntaje / 1000) % 10;
        int pos2 = (puntaje / 100) % 10;
        int pos3 = (puntaje / 10) % 10;
        int pos4 = puntaje % 10;
        lbl1.setIcon(icon[pos1]);
        lbl2.setIcon(icon[pos2]);
        lbl3.setIcon(icon[pos3]);
        lbl4.setIcon(icon[pos4]);
    }

    public void situarDialog(JPanel panel) {
        // Lo colocamos en la parte superior derecha
        Point panelLocation = panel.getLocationOnScreen();
        int x = (int) (panelLocation.getX() + panel.getWidth() - this.getWidth());
        int y = (int) panelLocation.getY();
        setLocation(x, y);
        setVisible(true);
    }
}
