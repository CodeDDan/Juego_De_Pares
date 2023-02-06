package Clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class ObjetoImagen {
    
    private String carpetaImBase, carpetaImPick;
    private ArrayList<String> dirBase = new ArrayList<>();
    private ArrayList<String> dirPick = new ArrayList<>();
    private ArrayList<String> dirPickAnim = new ArrayList<>();
    //private static int cont = 0;
    
    public ObjetoImagen(String base, String pick, String pickAnim) {
        carpetaImBase = base;
        carpetaImPick = pick;
        try {
            Path dir = Paths.get(carpetaImBase);
            Files.walk(dir).forEach(path -> addBase(path.toFile()));
            dir = Paths.get(carpetaImPick);
            Files.walk(dir).forEach(path -> addPick(path.toFile()));
            dir = Paths.get(pickAnim);
            Files.walk(dir).forEach(path -> addPickAnim(path.toFile()));
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error en la lectura de imágenes");
        }
        if (dirBase.size() != dirPick.size()) {
            JOptionPane.showMessageDialog(null, "No hay la misma cantidad de imagenes");
        }else {
            DialogEspecial msj = new DialogEspecial(1);
        }
    }
    
    private void addBase(File archivo) {
        System.out.println("Archivo: "+archivo.getAbsolutePath());
        //Dividimos la dirección del archivo en 2
        String [] pal = archivo.getAbsolutePath().split("src");
        //System.out.println(pal[1]);
        //Añadimos el path desde la carpeta raíz;
        dirBase.add("src"+pal[1]);
        //System.out.println(dirImagen.get(cont));
        //cont++;
    }
    
    private void addPick(File archivo) {
        System.out.println("Archivo: "+archivo.getAbsolutePath());
        String [] pal = archivo.getAbsolutePath().split("src");
        dirPick.add("src"+pal[1]);
    }
    
    private void addPickAnim(File archivo) {
        System.out.println("Archivo: "+archivo.getAbsolutePath());
        String [] pal = archivo.getAbsolutePath().split("src");
        dirPickAnim.add("src"+pal[1]);
    }
    /**
    * Descripción:
    * <p>
    * Genera un array con números aleatorios del tamaño de las imagenes leídas
    * en la carpeta que se le pasa al objeto.
    * <p>
    * @author Daniel Sánchez <daniel_s2604@hotmail.com>
    * @return array de enteros aleatorizados
    */
    
    public int [] mezclar() {
        //L es la longitud del array
        int valores [];
        //Quitamos un elemento porque la variable guarda el string de la carpeta en [0]
        valores = new int [dirBase.size() - 1];
        for(int i = 0; i < valores.length; i++){
            valores[i] = i + 1;
        }
        //Mezclamos
        for(int i = valores.length - 1; i > 0; i--) {
            //Calculamos un índice aleatorio dentro del rango permitido
            int shuffled_index = (int)Math.floor(Math.random() * (i + 1));
            //Guardamos el elemento que estamos iterando
            int tmp = valores[i];
            //Asignamos el elemento aleatorio al índice iterado
            valores[i] = valores[shuffled_index];
            //Asignamos el elemento iterado al índice aleatorio
            valores[shuffled_index] = tmp;
        }
        return valores;
    }

    public ArrayList<String> getDirBase() {
        return dirBase;
    }

    public ArrayList<String> getDirPick() {
        return dirPick;
    }
    
    public ArrayList<String> getDirPickAnim() {
        return dirPickAnim;
    }
    /**
    * Recupera el nombre de una imagen sin su extensión final.
    * <p>
    * La imagen debe estar contenida en la carpeta raiz para que 
    * funcione correctamente.
    * <p>
    * @author Daniel Sánchez <daniel_s2604@hotmail.com>
    * @param pathCarta String con la dirección de una imagen
    * @return String con el nombre de la imagen sin extensiones
    */
    public String recuperarCarta(String pathCarta) {
        String carta;
        //Los métodos de getIcon() devuelven el path desde el src
        //Dividimos la extensión por .;
        String [] split1 = pathCarta.split("\\.");
        //Obtenemos solamente la carta dividiendo las direcciones\.
        String [] split2 = split1[0].split("\\\\");
        carta = split2[split2.length - 1];
        return carta;
    }

}
