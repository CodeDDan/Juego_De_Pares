package ClasesImportadas;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JDialog;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * @author Daniel Sánchez
 * @author DJ-Raven
 * Recuperado de GitHub y adaptado
 * https://github.com/DJ-Raven/swing-notification
 */

public class Frm_Notificacion extends JComponent {
    
    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean show;
    private Thread thread;
    private final int animate = 10;
    private BufferedImage imageShadow;
    private final int shadowSize = 6;
    private final Type tipo;
    private final Location location;

    public Frm_Notificacion(Frame fram, Type type, Location location, String mensaje) {
        this.fram = fram;
        this.tipo = type;
        this.location = location;
        initComponents();
        init(mensaje);
        initAnimator();
    }
    
    private void init(String mensaje) {
        setBackground(new Color(10,31,58));
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
        switch (tipo) {
            case SUCCESS:
                lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoNota_50px.png"))); // NOI18N
                lblTipo.setText("Correcto");
                break;
            case INFO:
                lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoNota_50px.png"))); // NOI18N
                lblTipo.setText("Youtube Audio Library");
                break;
            case ALERT:
                lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoInfo_50px.png"))); // NOI18N
                lblTipo.setText("Juego de Pares por Daniel Sánchez");
                break;
            default:
                break;
        }
        lblMensaje.setText(mensaje);
    }
    
    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x, top;
            private boolean top_to_bot;
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    }else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    }else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
                repaint();
            }

            @Override
            public void begin() {
                //Aquí podemos cambiar las posiciones.
                if (!show) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    switch(location) {
                        case TOP_CENTER:
                            x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                            y = fram.getY();
                            top_to_bot = true;
                            break;
                        case TOP_RIGHT:
                            x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                            y = fram.getY() + margin + 70;
                            top_to_bot = true;
                            break;
                        case TOP_LEFT:
                            x = fram.getX() + margin;
                            y = fram.getY();
                            top_to_bot = true;
                            break;
                        case BOT_CENTER:
                            x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                            y = fram.getY() + fram.getHeight() - dialog.getHeight();
                            top_to_bot = false;
                            break;
                        case BOT_RIGHT:
                            x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                            y = fram.getY() + fram.getHeight() - dialog.getHeight();
                            top_to_bot = false;
                            break;
                        case BOT_LEFT:
                            x = fram.getX() + margin;
                            y = fram.getY() + fram.getHeight() - dialog.getHeight();
                            top_to_bot = false;
                            break;
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
                
            }

            @Override
            public void end() {
                show = !show;
                if (show) {
                    thread = new Thread(() -> {
                        sleep();
                        closeNotificacion();
                    });
                    thread.start();
                }else {
                    dialog.dispose();
                }
            }
            
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }
    
    public void showNotificacion() {
        animator.start();
    }
    
    private void closeNotificacion() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!show) {
                animator.stop();
                show = true;
                animator.start();
            }
        }else {
            show = true;
            animator.start();
        }
    }
    private void sleep() {
        try {
            Thread.sleep(7000);
        }catch (InterruptedException e) {
            
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize, y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
        //Para cambiar el color de la etiqueta y la sombra.
        switch(tipo) {
            case SUCCESS:
                g2.setColor(new Color(18, 163, 24));
                break;  
            case INFO:
                g2.setColor(new Color(28, 139, 206));
                break;
            case ALERT:
                g2.setColor(new Color(100,35,255));
                break;    
        }
        //Para cambiar el tamaño de la etiqueta de color.
        g2.fillRect(6, 6, 5, getHeight() - shadowSize * 2);
        g2.dispose();
        super.paint(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        crearImagenSombra();
    }
    
    
    
   private void crearImagenSombra() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(crearSombra(), 0, 0, null);
        g2.dispose();
    }
    
    private BufferedImage crearSombra() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcono = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(550, 75));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoNota_50px.png"))); // NOI18N

        lblTipo.setFont(new java.awt.Font("mononoki Nerd Font", 1, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(204, 204, 255));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTipo.setText("Música");

        lblMensaje.setFont(new java.awt.Font("mononoki Nerd Font", 1, 18)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(204, 204, 255));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("Nombre de la canción");

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoCancel_50px.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMensaje))
                    .addComponent(lblIcono)
                    .addComponent(lblClose, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        closeNotificacion();
    }//GEN-LAST:event_lblCloseMouseClicked

    public static enum Type {
        SUCCESS, INFO, ALERT;
    }
    public static enum Location{
        TOP_CENTER, TOP_RIGHT, TOP_LEFT, BOT_CENTER, BOT_RIGHT, BOT_LEFT, CENTER;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTipo;
    // End of variables declaration//GEN-END:variables
}
