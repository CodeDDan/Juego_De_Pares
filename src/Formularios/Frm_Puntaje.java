package Formularios;

import Clases.Conexion;
import Clases.Usuario;
import ClasesImportadas.Frm_Notificacion;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Daniel Sánchez
 */

public class Frm_Puntaje extends javax.swing.JFrame {

    private Conexion con = new Conexion();
    private boolean estadoBtnMax = true;
    
    public Frm_Puntaje() {
        initComponents();
        tblPuntaje.fixTabla(jScrollPane1);
        con.actualizarTabla(tblPuntaje, Usuario.getiD());
        JButton[] botones = {btnSalir, btnAyuda, btnMinimizar, btnMaximizar, btnBack};
        for (JButton btn : botones) {
            btn.setBackground(new Color(10, 31, 58));
            // Para un botón simple btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    btn.setBackground(new Color(72, 153, 188));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    btn.setBackground(new Color(10, 31, 58));
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente1 = new Clases.PanelGradiente();
        btnAyuda = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        btnMaximizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        panelGradiente2 = new Clases.PanelGradiente();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPuntaje = new Clases.JTableEspecial();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelGradiente1.setColor1(new java.awt.Color(43, 27, 104));
        panelGradiente1.setColor2(new java.awt.Color(20, 10, 58));
        panelGradiente1.setPreferredSize(new java.awt.Dimension(1020, 75));

        btnAyuda.setBackground(new java.awt.Color(10, 31, 58));
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoQuestion_50px.png"))); // NOI18N
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(10, 31, 58));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoMinimizarVentana_50px.png"))); // NOI18N
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        btnMaximizar.setBackground(new java.awt.Color(10, 31, 58));
        btnMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoMinimizar_50px.png"))); // NOI18N
        btnMaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(10, 31, 58));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoClose_50px.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(10, 31, 58));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoBack_50px.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradiente1Layout = new javax.swing.GroupLayout(panelGradiente1);
        panelGradiente1.setLayout(panelGradiente1Layout);
        panelGradiente1Layout.setHorizontalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 713, Short.MAX_VALUE)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGradiente1Layout.setVerticalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelGradiente1, java.awt.BorderLayout.PAGE_START);

        panelGradiente2.setColor1(new java.awt.Color(20, 10, 58));
        panelGradiente2.setColor2(new java.awt.Color(43, 27, 104));

        tblPuntaje.setForeground(new java.awt.Color(250, 250, 250));
        tblPuntaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nivel", "Inicio", "Fin", "Puntaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPuntaje.setFont(new java.awt.Font("mononoki NFM", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(tblPuntaje);
        if (tblPuntaje.getColumnModel().getColumnCount() > 0) {
            tblPuntaje.getColumnModel().getColumn(0).setMinWidth(120);
            tblPuntaje.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblPuntaje.getColumnModel().getColumn(0).setMaxWidth(120);
            tblPuntaje.getColumnModel().getColumn(1).setMinWidth(250);
            tblPuntaje.getColumnModel().getColumn(1).setPreferredWidth(290);
            tblPuntaje.getColumnModel().getColumn(1).setMaxWidth(290);
            tblPuntaje.getColumnModel().getColumn(3).setMinWidth(150);
            tblPuntaje.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblPuntaje.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        javax.swing.GroupLayout panelGradiente2Layout = new javax.swing.GroupLayout(panelGradiente2);
        panelGradiente2.setLayout(panelGradiente2Layout);
        panelGradiente2Layout.setHorizontalGroup(
            panelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradiente2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        panelGradiente2Layout.setVerticalGroup(
            panelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradiente2Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        getContentPane().add(panelGradiente2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
        String mensajeAyuda = "Puntaje de tus partidas recientes";
        Frm_Notificacion ayud = new Frm_Notificacion(this, Frm_Notificacion.Type.ALERT, Frm_Notificacion.Location.TOP_RIGHT, mensajeAyuda);
        ayud.showNotificacion();
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        // TODO add your handling code here:
        //Si se usa setExtendedState vuelve al tamaño inicial
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnMaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximizarActionPerformed
        // TODO add your handling code here:
        if (estadoBtnMax) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ImageIcon min = new ImageIcon("src\\Iconos\\IconoMaximizar_50px.png");
            btnMaximizar.setIcon(min);
            estadoBtnMax = false;
        } else {
            this.setExtendedState(JFrame.NORMAL);
            ImageIcon min = new ImageIcon("src\\Iconos\\IconoMinimizar_50px.png");
            btnMaximizar.setIcon(min);
            estadoBtnMax = true;
        }
        repaint();
    }//GEN-LAST:event_btnMaximizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Frm_SeleccionD selecD = new Frm_SeleccionD();
        selecD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Puntaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_Puntaje().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMaximizar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private Clases.PanelGradiente panelGradiente1;
    private Clases.PanelGradiente panelGradiente2;
    private Clases.JTableEspecial tblPuntaje;
    // End of variables declaration//GEN-END:variables
}
