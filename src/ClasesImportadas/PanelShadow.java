package ClasesImportadas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelShadow extends JPanel{

    public ShadowType getSombraType() {
        return sombraType;
    }

    public void setSombraType(ShadowType sombraType) {
        this.sombraType = sombraType;
    }

    public int getShadowSize() {
        return shadowSize;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    public float getShadowOpacity() {
        return shadowOpacity;
    }

    public void setShadowOpacity(float shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }
    
    private ShadowType sombraType = ShadowType.CENTER;
    private int shadowSize = 6;
    private float shadowOpacity = 0.5f;
    private Color shadowColor = Color.BLACK;
    
    public PanelShadow() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        createShadow(grphcs);
        super.paintComponent(grphcs);
    }
    
    private void createShadow(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        int size = getShadowSize() * 2;
        int x , y ;
        int width = getWidth() - size;
        int height = getHeight() - size;
        switch (sombraType) {
            case TOP:
                x = shadowSize;
                y = size;
                break;
            case BOT:
                x = shadowSize;
                y = 0;
                break;
            case TOP_LEFT:
                x = size;
                y = size;
                break;
            case TOP_RIGHT:
                x = 0;
                y = size;
                break;
            case BOT_LEFT:
                x = size;
                y = 0;
                break;
            case BOT_RIGHT:
                x = 0;
                y = 0;
                break;
            default:
                //Center
                x = shadowSize;
                y = shadowSize;
                break;
        }
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setBackground(getBackground());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Si queremos generar un círculo, en vez de "RoundRect" se usará oval.
        g.fillRoundRect(0, 0, width, height, 10, 10);
        //Creamos la sombra
        ShadowRenderer render = new ShadowRenderer(getShadowSize(), getShadowOpacity(), getShadowColor());
        g2.drawImage(render.createShadow(img), 0, 0, null);
        g2.drawImage(img, x, y, null);
    }
}
