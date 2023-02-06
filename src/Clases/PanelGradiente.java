package Clases;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class PanelGradiente extends JPanel {
    
    private Color color1 = new Color(240, 240, 240);
    private Color color2 = new Color(240, 240, 240);
    
    public PanelGradiente() {
        init();
    }
    
    private void init() {
        setOpaque(true);
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    @Override
    protected void paintComponent (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, 300, height, color2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, width, height);
    }

}
