package Formularios;

import Clases.SliderEspecial;
import Clases.JCheckBoxEspecial;
import java.awt.Color;

/**
 * @author Daniel Sánchez
 */

public class Panel_Opciones extends javax.swing.JPanel {

    public JCheckBoxEspecial getCheckBoxEfectos() {
        return checkBoxEfectos;
    }

    public void setCheckBoxEfectos(JCheckBoxEspecial checkBoxEfectos) {
        this.checkBoxEfectos = checkBoxEfectos;
    }

    public JCheckBoxEspecial getCheckBoxMusica() {
        return checkBoxMusica;
    }

    public void setCheckBoxMusica(JCheckBoxEspecial checkBoxMusica) {
        this.checkBoxMusica = checkBoxMusica;
    }

    public SliderEspecial getSliderEfectos() {
        return sliderEfectos;
    }

    public void setSliderEfectos(SliderEspecial sliderEfectos) {
        this.sliderEfectos = sliderEfectos;
    }

    public SliderEspecial getSliderMusica() {
        return sliderMusica;
    }

    public void setSliderMusica(SliderEspecial sliderMusica) {
        this.sliderMusica = sliderMusica;
    }
    
    public Panel_Opciones(Color color1, Color color2) {
        initComponents();
        init(color1, color2);
        
    }
    
    private void init (Color color1, Color color2) {
        panelBase.setColor1(color1);
        panelBase.setColor2(color2);
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new Clases.PanelGradiente();
        sliderMusica = new Clases.SliderEspecial();
        sliderEfectos = new Clases.SliderEspecial();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        checkBoxMusica = new Clases.JCheckBoxEspecial();
        checkBoxEfectos = new Clases.JCheckBoxEspecial();

        panelBase.setColor1(new java.awt.Color(20, 10, 58));
        panelBase.setColor2(new java.awt.Color(52, 155, 142));

        sliderMusica.setBackground(new java.awt.Color(116, 238, 255));
        sliderMusica.setForeground(new java.awt.Color(112, 55, 249));

        sliderEfectos.setBackground(new java.awt.Color(255, 248, 115));
        sliderEfectos.setForeground(new java.awt.Color(112, 55, 249));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalVolumen_64px.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoVolumenMedio_50px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("mononoki Nerd Font", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(116, 238, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalMusic_38px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoVolumenEfectos_50px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("mononoki Nerd Font", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(116, 238, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalEfectos_38px.png"))); // NOI18N

        checkBoxMusica.setForeground(new java.awt.Color(116, 238, 255));
        checkBoxMusica.setText("Silenciar Música");
        checkBoxMusica.setFont(new java.awt.Font("mononoki Nerd Font", 0, 18)); // NOI18N

        checkBoxEfectos.setBackground(new java.awt.Color(123, 50, 216));
        checkBoxEfectos.setForeground(new java.awt.Color(116, 238, 255));
        checkBoxEfectos.setText("Silenciar Efectos");
        checkBoxEfectos.setFont(new java.awt.Font("mononoki Nerd Font", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelBaseLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(sliderMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelBaseLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sliderEfectos, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(checkBoxEfectos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkBoxMusica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jLabel5))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBaseLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(sliderMusica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBaseLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(sliderEfectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addComponent(checkBoxMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(checkBoxEfectos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxMusicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxMusicaActionPerformed

    private void checkBoxEfectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxEfectosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxEfectosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Clases.JCheckBoxEspecial checkBoxEfectos;
    private Clases.JCheckBoxEspecial checkBoxMusica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Clases.PanelGradiente panelBase;
    private Clases.SliderEspecial sliderEfectos;
    private Clases.SliderEspecial sliderMusica;
    // End of variables declaration//GEN-END:variables
}
