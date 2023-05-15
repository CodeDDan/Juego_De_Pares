package Clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class PanelGradiente extends JPanel {
    
    private Color color1 = new Color(240, 240, 240);
    private Color color2 = new Color(240, 240, 240);
    private Image imagen;
    
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
    
    /**
     * Descripción:
     * <p>
     * Incluye una imagen de fondo a este componente. 
     * <p>
     * @author Daniel Sánchez 
     * @param rutaImagen  ruta de la imagen en el formato aceptado en java.
     */
    
    public void setImagenFondo(String rutaImagen) {
        imagen = new ImageIcon(rutaImagen).getImage();
        repaint(); // Vuelve a pintar el panel cuando se establece una nueva imagen de fondo
    }
    
    @Override
    protected void paintComponent (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, 300, height, color2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, width, height);
        if (imagen != null) {
            // Para mejorar el renderizado
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        if (imagen != null) {
            return new Dimension(imagen.getWidth(this), imagen.getHeight(this));
        } else {
            return super.getPreferredSize();
        }
    }

}
