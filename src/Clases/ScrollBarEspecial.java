package Clases;

import ClasesImportadas.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 * @see JTableEspecial
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class ScrollBarEspecial extends JScrollBar {

    // Colocar el color por defecto
    private final Color colorScrollFondo = new Color(30, 30, 30);
    
    public ScrollBarEspecial() {
        init();
    }
    
    private void init() {
        ModernScrollBarUI miModelo = new ModernScrollBarUI();
        miModelo.setColorFondo(colorScrollFondo);
        setUI(miModelo);
        setPreferredSize(new Dimension(8, 8));
        // Aquí se edita el color de la guía.
        setForeground(new Color(48, 144, 216));
        // Aquí se edita el color del fondo.
        setBackground(new Color(30, 30, 30));
    }
}
