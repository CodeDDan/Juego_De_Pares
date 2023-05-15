package Clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class JButtonEspecial extends JButton{
    
    public JButtonEspecial() {
        init();
    } 
    
    private void init() {
        setColor(new Color(253, 239, 249));
        setBackground(color);
        colorDentro = new Color(42, 8, 69);
        colorClick = new Color(100, 65, 165);
        colorBorde = new Color(82, 85, 255);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorDentro);
                en = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                en = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (en) {
                    setBackground(colorDentro);
                }else {
                    setBackground(color);
                }
            }
            
            
            
        });
    }

    public boolean isEn() {
        return en;
    }

    public void setEn(boolean en) {
        this.en = en;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorDentro() {
        return colorDentro;
    }

    public void setColorDentro(Color colorFuera) {
        this.colorDentro = colorFuera;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }
    
    private boolean en;
    private int radio = 0;
    private Color color;
    private Color colorDentro;
    private Color colorClick;
    private Color colorBorde;

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorBorde);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
        g2.setColor(getBackground());
        // Borde de 2 píxeles
        g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, radio, radio);
        super.paintComponent(grphcs);
        
    }
    
    
}
