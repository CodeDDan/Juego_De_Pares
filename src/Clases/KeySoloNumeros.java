package Clases;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class KeySoloNumeros implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
