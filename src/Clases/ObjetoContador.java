package Clases;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** 
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class ObjetoContador extends JLabel {

    public int getNiv() {
        return niv;
    }

    private int niv;
    private JLabel lblbase, lbl1, lbl2;
    private final ImageIcon icon [] = new ImageIcon[11];

    public ObjetoContador() {
        niv = 0;
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
        // Cuando la división resulte exactamente 10 
        icon[10] = new ImageIcon("src\\Iconos\\Icono0_50px.png");
        lblbase = new JLabel (new ImageIcon("src\\Iconos\\PalNivel_50px.png"));
        lbl1 = new JLabel(icon[0]);
        lbl2 = new JLabel(icon[0]);
        this.add(lblbase);
        this.add(lbl1);
        this.add(lbl2);
    }
    
    public void actualizarContador() {
        niv++;
        int pos1 = niv / 10;
        int pos2 = niv % 10;
        lbl1.setIcon(icon[pos1]);
        lbl2.setIcon(icon[pos2]);
    }

}
