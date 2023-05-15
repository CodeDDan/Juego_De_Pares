package Formularios;

/**
 * @author Daniel
 */
public class Dlg_Modelo extends javax.swing.JDialog {

    public int getOpcion() {
        return opcion;
    }

    private int opcion;
    /**
     * Crea un JDialog personalizado
     * @param parent
     * @param modal
     */
    public Dlg_Modelo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        opcion = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new Clases.PanelGradiente();
        jButtonEspecial1 = new Clases.JButtonEspecial();
        jButtonEspecial2 = new Clases.JButtonEspecial();
        jButtonEspecial3 = new Clases.JButtonEspecial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelBase.setColor1(new java.awt.Color(239, 50, 217));
        panelBase.setColor2(new java.awt.Color(137, 255, 253));

        jButtonEspecial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalCartas_64px.png"))); // NOI18N
        jButtonEspecial1.setRadio(20);
        jButtonEspecial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecial1ActionPerformed(evt);
            }
        });

        jButtonEspecial2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalFiguras_64px.png"))); // NOI18N
        jButtonEspecial2.setRadio(20);
        jButtonEspecial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecial2ActionPerformed(evt);
            }
        });

        jButtonEspecial3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PalLetras_64px.png"))); // NOI18N
        jButtonEspecial3.setRadio(20);
        jButtonEspecial3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspecial3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBaseLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButtonEspecial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBaseLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButtonEspecial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBaseLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButtonEspecial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEspecial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEspecial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEspecial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEspecial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecial1ActionPerformed
        opcion = 1;
        this.dispose();
    }//GEN-LAST:event_jButtonEspecial1ActionPerformed

    private void jButtonEspecial2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecial2ActionPerformed
        opcion = 2;
        this.dispose();
    }//GEN-LAST:event_jButtonEspecial2ActionPerformed

    private void jButtonEspecial3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspecial3ActionPerformed
        opcion = 3;
        this.dispose();
    }//GEN-LAST:event_jButtonEspecial3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dlg_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Dlg_Modelo dialog = new Dlg_Modelo(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Clases.JButtonEspecial jButtonEspecial1;
    private Clases.JButtonEspecial jButtonEspecial2;
    private Clases.JButtonEspecial jButtonEspecial3;
    private Clases.PanelGradiente panelBase;
    // End of variables declaration//GEN-END:variables
}
