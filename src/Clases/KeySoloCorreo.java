package Clases;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class KeySoloCorreo extends KeyAdapter{

    private final JTextField textField;

    public KeySoloCorreo(JTextField textField) {
        this.textField = textField;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        String email = textField.getText();
        String pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);

        if (m.matches()) {
            textField.setForeground(new Color(55, 172, 21));
        } else {
            textField.setForeground(new Color(148, 17, 59));
        }
    }
}
