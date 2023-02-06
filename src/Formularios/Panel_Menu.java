package Formularios;

import Clases.JButtonEspecial;
import java.awt.Color;

/**
 *
 * @author Daniel Sánchez
 */
public class Panel_Menu extends javax.swing.JPanel {

    public JButtonEspecial getBtnReanudar() {
        return btnReanudar;
    }

    public void setBtnReanudar(JButtonEspecial btnReanudar) {
        this.btnReanudar = btnReanudar;
    }

    public JButtonEspecial getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButtonEspecial btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JButtonEspecial getBtnOpcion() {
        return btnOpcion;
    }

    public void setBtnOpcion(JButtonEspecial btnOpcion) {
        this.btnOpcion = btnOpcion;
    }
    
    public Panel_Menu(Color color1, Color color2) {
        initComponents();
        init(color1, color2);
    }
    
    private void init(Color nuevoColor1, Color nuevoColor2) {
        panelBase.setColor1(nuevoColor1);
        panelBase.setColor2(nuevoColor2);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBase = new Clases.PanelGradiente();
        btnReanudar = new Clases.JButtonEspecial();
        btnOpcion = new Clases.JButtonEspecial();
        btnSalir = new Clases.JButtonEspecial();

        setPreferredSize(new java.awt.Dimension(500, 600));

        panelBase.setColor1(new java.awt.Color(20, 10, 58));
        panelBase.setColor2(new java.awt.Color(52, 155, 142));
        panelBase.setLayout(new java.awt.GridBagLayout());

        btnReanudar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalReanudar_64px.png"))); // NOI18N
        btnReanudar.setRadio(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(91, 62, 0, 61);
        panelBase.add(btnReanudar, gridBagConstraints);

        btnOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalOpciones_64px.png"))); // NOI18N
        btnOpcion.setRadio(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(97, 74, 0, 0);
        panelBase.add(btnOpcion, gridBagConstraints);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalSalir_64px.png"))); // NOI18N
        btnSalir.setRadio(20);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(107, 134, 86, 0);
        panelBase.add(btnSalir, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Clases.JButtonEspecial btnOpcion;
    private Clases.JButtonEspecial btnReanudar;
    private Clases.JButtonEspecial btnSalir;
    private Clases.PanelGradiente panelBase;
    // End of variables declaration//GEN-END:variables
}
