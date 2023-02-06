package Clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.basic.BasicSliderUI;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class SliderUI extends BasicSliderUI {

    //Representa a la ventana que se muestra.
    private final JWindow window = new JWindow();
    private final Animator animate;
    private boolean show;
    

    public SliderUI(JSlider slider) {
        super(slider);
        PanelSlider panel = new PanelSlider(slider);
        window.add(panel);
        window.setSize(new Dimension(30, 40));
        window.setBackground(new Color(0, 0, 0, 0));
        window.setOpacity(0f);
        //Colores
        slider.setOpaque(false);
        slider.setBackground(new Color(22, 134, 232));
        slider.setForeground(new Color(22, 134, 232));
        slider.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    show = true;
                    window.setLocation(getLocation(slider));
                    window.setVisible(true);
                    if(!animate.isRunning()) {
                        animate.start();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    show = false;
                    detenerAnimacion();
                    animate.start();
                }
            }

        });
        
        slider.addChangeListener((ChangeEvent ce) -> {
            panel.setValores(slider.getValue());
            window.setLocation(getLocation(slider));
        });
        
        animate = new Animator(200, new TimingTargetAdapter() {
            
            @Override
            public void timingEvent(float fraction) {
                if(show) {
                    window.setOpacity(fraction);
                }else {
                    window.setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if(!show) {
                    window.setVisible(false);
                }
            }

        });
        
        animate.setResolution(0);
    }

    private void detenerAnimacion() {
        if(animate.isRunning()) {
            float f = animate.getTimingFraction();
            animate.stop();
            animate.setStartFraction(1f - f);
        }else {
            animate.setStartFraction(0f);
        }
    }
    
    protected Point getLocation(JSlider slider) {
        Point p = slider.getLocationOnScreen();
        //Se debe crear un objeto rectángulo porque no lee
        int x = (30 - thumbRect.width) / 2;
        return new Point(p.x + thumbRect.x - x, p.y - 40);
    }

    @Override
    protected Dimension getThumbSize() {
        //Cambiamos lo que obtenemos al llamar a la variable thumbRect.
        return new Dimension(20, 20);
    }

    @Override
    public void paintFocus(Graphics grphcs) {
        //Vacío para que no se pinte el exterior.
    }

    @Override
    public void paintThumb(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Método para poner gradiente.
        //Se deben colocar las dimensiones del componente.
        //0,0 Es el origen del vector, width y height es donde termina el vector, de esta forma le damos el ángulo.
        g2.setColor(slider.getForeground());
        GradientPaint gp = new GradientPaint(0, 0, slider.getForeground(), 0, thumbRect.height, slider.getBackground());
        g2.setPaint(gp);
        g2.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
        g2.dispose();
    }

    @Override
    public void paintTrack(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Método para poner gradiente.
        //Se deben colocar las dimensiones del componente.
        //0,0 Es el origen del vector, width y height es donde termina el vector, de esta forma le damos el ángulo.
        g2.setColor(slider.getBackground());
        GradientPaint gp = new GradientPaint(0, 0, slider.getForeground(), slider.getWidth(), slider.getHeight(), slider.getBackground());
        g2.setPaint(gp);
        if (slider.getOrientation() == JSlider.VERTICAL) {
            g2.fillRoundRect(slider.getWidth() / 2 - 2, 2, 4, slider.getHeight(), 1, 1);
        } else {
            g2.fillRoundRect(2, slider.getHeight() / 2 - 2, slider.getWidth() - 5, 4, 5, 5);
        }
        g2.dispose();
    }

    private class PanelSlider extends JComponent {

        private JLabel lbl;
        
        public PanelSlider(JSlider slider) {
            init();
        }
        
        private void init() {
            setLayout(new BorderLayout());
            lbl = new JLabel("0");
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("mononoki Nerd Font", Font.PLAIN, 18));
            lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setBorder(new EmptyBorder(0, 0, 10, 0));
            add(lbl, BorderLayout.CENTER);
        }
        
        private void setValores(int values) {
            lbl.setText(values + "");
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            //Aquí se modifica todo lo que tiene que ver con la forma
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            Area area = new Area(new Ellipse2D.Double(0, 0, width, 31));
            //Color
            g2.setColor(slider.getForeground());
            Path2D path = new Path2D.Double();
            path.moveTo(1, 22);
            path.lineTo(width / 2, height);
            path.lineTo(width - 1, 22);
            area.add(new Area(path));
            GradientPaint gp = new GradientPaint(0, 0, slider.getForeground(), 0, trackRect.height + 10, slider.getBackground());
            g2.setPaint(gp);
            g2.fill(area);
            g2.dispose();
            super.paintComponent(grphcs);
        }

    }

}
