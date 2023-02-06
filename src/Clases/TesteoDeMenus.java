/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Formularios.Frm_SeleccionD;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Clase de prueba para las funciones de nuestro juego
 * @author Daniel Sánchez
 */
public class TesteoDeMenus {
    public static void main(String[] args) {
        // TODO code application logic here
        // Para que mantenga el modo Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
               }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        }
        ObjetoMusic musc = new ObjetoMusic("src\\Musica\\Nothing Easy - Causmic.mp3");
        musc.loop();
        musc.getMediaPlayer().setVolume(1);
        Frm_SeleccionD facil = new Frm_SeleccionD();
        facil.setVisible(true); 

    }  
}
