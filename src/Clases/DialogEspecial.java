package Clases;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
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
        PanelGradiente panel = new PanelGradiente();
        panel.setColor1(new Color(20,10,58));
        panel.setColor2(new Color(43,27,104));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 50));
        panel.add(lblMensaje);
        panel.add(btnSi);
        if (tipo == 2 || tipo == 3) {
            panel.add(btnNo);
        }
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.add(panel);
        //Primero se pone el tipo de modal, luego se lo pone visible.
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.setVisible(true);
    }
}
