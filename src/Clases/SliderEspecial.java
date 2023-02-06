package Clases;
import javax.swing.JSlider;

/**
 * @see JTableEspecial
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public final class SliderEspecial extends JSlider{
     
    /* Para generar el gradiente del componenete unicamente se debe seleccionar
    el foreground y background en la interfaz de netbeas. Caso contrario 
    asigarnlos en el constructor.
    */
    public SliderEspecial() {
        SliderUI sliderUI = new SliderUI(this);
        setUI(sliderUI);
    }
    
}
