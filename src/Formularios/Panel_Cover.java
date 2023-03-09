package Formularios;

import Clases.JButtonEspecial;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 * @author Daniel Sánchez
 */
public class Panel_Cover extends javax.swing.JPanel {

    //Para el evento en el login
    private ActionListener event;
    private MigLayout layout;
    private JLabel lblTitulo;
    private JLabel lblLogo;
    private JButtonEspecial btnInicio;

    public JButtonEspecial getBtnInicio() {
        return btnInicio;
    }
    private JButtonEspecial btnSalir;

    public Panel_Cover() {
        initComponents();
        init();
    }

    private void init() {
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push [] 25 [] 10 [] 25 [] push");
        setLayout(layout);
        lblTitulo = new JLabel(new ImageIcon("src\\Iconos\\PalLogo_138px.png"));
        add(lblTitulo);
        lblLogo = new JLabel(new ImageIcon("src\\Iconos\\Logo_350x250px.png"));
        add(lblLogo);
        btnInicio = new JButtonEspecial();
        btnInicio.setRadio(70);
        btnInicio.setIcon(new ImageIcon("src\\Iconos\\PalIngreso_64px.png"));
        btnInicio.addActionListener((ActionEvent ae) -> {
            event.actionPerformed(ae);
        });
        add(btnInicio);
        btnSalir = new JButtonEspecial();
        btnSalir.setRadio(40);
        btnSalir.setIcon(new ImageIcon("src\\Iconos\\PalSalir_38px.png"));
        btnSalir.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        add(btnSalir);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gp = new GradientPaint(0, 0, new Color(20, 10, 58), 0, getHeight(), new Color(43, 27, 104));
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener evt) {
        event = evt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
