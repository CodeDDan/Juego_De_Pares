package Clases;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * @author Daniel <daniel_s2604@hotmail.com>
 * @author DJ-Raven
 * Recuperado y adaptado de github
 * https://github.com/DJ-Raven/java-swing-confirm-message
 */

public class DialogEspecial extends JDialog{
    
    private ImageIcon iconoMensaje;
    private final ImageIcon iconoBotonSi = new ImageIcon("src\\Iconos\\PalSi_64px.png");
    private final ImageIcon iconoBotonNo = new ImageIcon("src\\Iconos\\PalNo_64px.png");
    private static boolean valor = false;
    
    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        DialogEspecial.valor = valor;
    }
        
    public DialogEspecial(int tipo) {
        init(tipo);
    }
    
    private void init(int tipo) {
        setUndecorated(true);
        switch (tipo) {
            case 1:
                iconoMensaje = new ImageIcon("src\\Iconos\\PalListo_64px.png");
                break;
            case 2:
                iconoMensaje = new ImageIcon("src\\Iconos\\PalContinuar_64px.png");
                break;
            case 3:
                iconoMensaje = new ImageIcon("src\\Iconos\\PalSalir_64px.png");
                break;
            default:
                iconoMensaje = new ImageIcon("src\\Iconos\\PalListo_64px.png");
                break;
        }
        JLabel lblMensaje = new JLabel(iconoMensaje);
        JButtonEspecial btnSi = new JButtonEspecial();
        btnSi.setIcon(iconoBotonSi);
        btnSi.setRadio(20);
        // Evento del botón
        btnSi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                valor = true;
                dispose();
            }   
        });
        JButtonEspecial btnNo = new JButtonEspecial();
        btnNo.setIcon(iconoBotonNo);
        btnNo.setRadio(20);
        // Evento del botón
        btnNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                valor = false;
                dispose();
            }   
        });
        // Agregamos un Gif con animación
        JLabel animacion = new JLabel();
        // Cargamos el gif
        ImageIcon icon;
        switch (tipo) {
            case 1:
                icon = new ImageIcon("src\\Iconos\\IconoCartaL_200px.gif");
                break;
            case 2:
                icon = new ImageIcon("src\\Iconos\\IconoWizardF_200px.gif");
                break;
            case 3:
                icon = new ImageIcon("src\\Iconos\\IconoCartaF_200px.gif");
                break;
            default:
                icon = new ImageIcon("src\\Iconos\\IconoCartaL_200px.gif");
                break;
        }
        // Refrescamos el gif
        Image img = icon.getImage();
        img.flush();
        animacion.setIcon(icon);
        PanelGradiente panel = new PanelGradiente();
        panel.setColor1(new Color(239,50,217));
        panel.setColor2(new Color(137,255,253));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 50));
        panel.add(animacion);
        panel.add(lblMensaje);
        panel.add(btnSi);
        if (tipo == 2 || tipo == 3) {
            panel.add(btnNo);
        }
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.add(panel);
        //Primero se pone el tipo de modal, luego se lo pone visible.
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
