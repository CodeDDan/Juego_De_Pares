package Formularios;

import Clases.Conexion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * @author Daniel Sánchez
 * @author DJ-Raven
 * Recuperado y adaptado de github
 * https://github.com/DJ-Raven/java-swing-login-ui-001
 */

public class Frm_Login extends javax.swing.JFrame {
    
    private MigLayout layout;
    private Panel_Cover cover;
    private Panel_Login login;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 45;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private final Conexion con = new Conexion();

    public Frm_Login() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new Panel_Cover();
        login = new Panel_Login();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                }else {
                    size +=  addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    cover.getBtnInicio().setIcon(new ImageIcon("src\\Iconos\\PalIngreso_64px.png"));
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    cover.getBtnInicio().setIcon(new ImageIcon("src\\Iconos\\PalRegistro_64px.png"));
                }
                if (fraction >= 0.5f) {
                    login.mostrarRegistro(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al  0 n 100%");
                layout.setComponentConstraints(login, "width " + loginSize + "%, pos " + fractionLogin + "al  0 n 100%");
                layeredPanel.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }

        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // Para una animación limpia.
        layeredPanel.setLayout(layout);
        layeredPanel.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        layeredPanel.add(login, "width " + loginSize + "%, pos 1al 0 n 100%"); // 1al como 100%
        cover.addEvent((ActionEvent ae) -> {
            if (!animator.isRunning()) {
                animator.start();
            }
        });
        // Evento de ingreso
        login.getBtnIngreso().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicIngreso(login.getTxtAliasI(), login.getPwdPasswordI());
            }
            
        });
        // Evento de registro
        // Añadimos el evento de registro
        login.getBtnRegistro().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicRegistro(login.getTxtAlias(), login.getTxtNombre(), login.getTxtApellido(), 
                        login.getTxtCorreo(), login.getPwdPassword());
            }
        });
    }
    
    public void clicIngreso(JTextField txtNick, JTextField txtPass) {
        boolean ingreso;
        ingreso = con.validarUsuario(txtNick.getText(), txtPass.getText());
        if (!ingreso) {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
            return;
        }
        Frm_SeleccionD selecD = new Frm_SeleccionD();
        selecD.setVisible(true);
        this.dispose();
    }
    
    private void clicRegistro(JTextField txtNick, JTextField txtNombre, JTextField txtApellido,
            JTextField txtCorreo, JTextField txtPass) {
        if (txtNick.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("")
                || txtCorreo.getText().equals("") || txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
            return;
        } else if (txtCorreo.getForeground().equals(new Color(148, 17, 59))) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo válido");
            return;
        }
        con.registrarUsuario(txtNick.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), txtPass.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente1 = new Clases.PanelGradiente();
        layeredPanel = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelGradiente1.setColor1(new java.awt.Color(20, 10, 58));
        panelGradiente1.setColor2(new java.awt.Color(43, 27, 104));

        javax.swing.GroupLayout panelGradiente1Layout = new javax.swing.GroupLayout(panelGradiente1);
        panelGradiente1.setLayout(panelGradiente1Layout);
        panelGradiente1Layout.setHorizontalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        panelGradiente1Layout.setVerticalGroup(
            panelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layeredPanelLayout = new javax.swing.GroupLayout(layeredPanel);
        layeredPanel.setLayout(layeredPanelLayout);
        layeredPanelLayout.setHorizontalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        layeredPanelLayout.setVerticalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPanel)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPanel)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layeredPanel;
    private Clases.PanelGradiente panelGradiente1;
    // End of variables declaration//GEN-END:variables
}
