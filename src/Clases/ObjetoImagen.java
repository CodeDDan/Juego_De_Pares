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

    private ArrayList<String> dirBase = new ArrayList<>();
    private ArrayList<String> dirPick = new ArrayList<>();
    private ArrayList<String> dirPickAnim = new ArrayList<>();
    private ArrayList<String> dirPickCorrect = new ArrayList<>();

    public enum MODELO {
        CARTAS, FIGURAS, LETRAS
    }

    public ObjetoImagen(MODELO modelo) {
        String base = "", pick = "", pickAnim = "", pickCorrect = "";
        // Se agregaran las direcciones con el doble backslash (\\).
        // Las direcciones que agrega el método getAbsolutePath() se agregan con (\).
        switch (modelo) {
            case CARTAS:
                base = "src\\Imagenes\\Im_Cartas";
                pick = "src\\Imagenes\\Im_Cartas_Pick";
                pickAnim = "src\\Imagenes\\Im_Cartas_A_Pick";
                pickCorrect = "src\\Imagenes\\Im_Cartas_A_Correcto";
                break;
            case FIGURAS:
                base = "src\\Imagenes\\Im_Figuras";
                pick = "src\\Imagenes\\Im_Figuras_Pick";
                pickAnim = "src\\Imagenes\\Im_Figuras_A_Pick";
                pickCorrect = "src\\Imagenes\\Im_Figuras_A_Correcto";
                break;
            case LETRAS:
                base = "src\\Imagenes\\Im_Letras";
                pick = "src\\Imagenes\\Im_Letras_Pick";
                pickAnim = "src\\Imagenes\\Im_Letras_A_Pick";
                pickCorrect = "src\\Imagenes\\Im_Letras_A_Correcto";
                break;
            default:
                break;
        } 
        try {
            // Añadimos el path de la carpeta.
            Path dir = Paths.get(base);
            // Llamamos al método por cada archivo en la carpeta.
            Files.walk(dir).forEach(path -> addBase(path.toFile()));
            dir = Paths.get(pick);
            Files.walk(dir).forEach(path -> addPick(path.toFile()));
            dir = Paths.get(pickAnim);
            Files.walk(dir).forEach(path -> addPickAnim(path.toFile()));
            dir = Paths.get(pickCorrect);
            Files.walk(dir).forEach(path -> addPickCorrect(path.toFile()));
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error en la lectura de imágenes");
            System.exit(0);
        }
        if (dirBase.size() != dirPick.size()) {
            JOptionPane.showMessageDialog(null, "No hay la misma cantidad de imagenes");
        } else {
            DialogEspecial msj = new DialogEspecial(1);
        }
    }

    private void addBase(File archivo) {
        System.out.println("Archivo: " + archivo.getAbsolutePath());
        //Dividimos la dirección del archivo en 2
        String[] pal = archivo.getAbsolutePath().split("src");
        //Añadimos el path desde la carpeta raíz;
        dirBase.add("src" + pal[1]);
    }

    private void addPick(File archivo) {
        String[] pal = archivo.getAbsolutePath().split("src");
        dirPick.add("src" + pal[1]);
    }

    private void addPickAnim(File archivo) {
        String[] pal = archivo.getAbsolutePath().split("src");
        dirPickAnim.add("src" + pal[1]);
    }

    private void addPickCorrect(File archivo) {
        String[] pal = archivo.getAbsolutePath().split("src");
        dirPickCorrect.add("src" + pal[1]);
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

    public int[] mezclar() {
        //L es la longitud del array
        int valores[];
        //Quitamos un elemento porque la variable guarda el string de la carpeta en [0]
        valores = new int[dirBase.size() - 1];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = i + 1;
        }
        //Mezclamos
        for (int i = valores.length - 1; i > 0; i--) {
            //Calculamos un índice aleatorio dentro del rango permitido
            int shuffled_index = (int) Math.floor(Math.random() * (i + 1));
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

    public ArrayList<String> getDirPickCorrect() {
        return dirPickCorrect;
    }

    /**
     * Recupera el nombre de una imagen sin su extensión final.
     * <p>
     * La imagen debe estar contenida en la carpeta raiz para que funcione
     * correctamente.
     * <p>
     * @author Daniel Sánchez <daniel_s2604@hotmail.com>
     * @param pathCarta String con la dirección de una imagen
     * @return String con el nombre de la imagen sin extensiones
     */
    public String recuperarCarta(String pathCarta) {
        String carta;
        //Los métodos de getIcon() devuelven el path desde el src
        //Dividimos la extensión por .;
        String[] split1 = pathCarta.split("\\.");
        //Obtenemos solamente la carta dividiendo las direcciones\.
        String[] split2 = split1[0].split("\\\\");
        carta = split2[split2.length - 1];
        return carta;
    }

    public enum CARPETA {
        BASE, PICK, A_PICK, A_CORRECTO
    }

    /**
     * Recupera el indice en el arrayList que sea igual al string pasado
     * <p>
     * La imagen debe tener el path absoluto de la misma
     * <p>
     * @author Daniel Sánchez <daniel_s2604@hotmail.com>
     * @param carpeta Carpeta que hace referencia al arrayList donde se debe
     * buscar
     * @param imagen Imagen a ser buscada
     * @return int con el indice de la imagen en el arrayList
     */
    public int obtenerIndiceImagen(CARPETA carpeta, String imagen) {
        int indice;
        switch (carpeta) {
            case BASE:
                indice = dirBase.indexOf(imagen);
                return indice;
            case PICK:
                indice = dirPick.indexOf(imagen);
                return indice;
            case A_PICK:
                indice = dirPickAnim.indexOf(imagen);
                return indice;
            case A_CORRECTO:
                indice = dirPickCorrect.indexOf(imagen);
                return indice;
            default:
                indice = -1;
                return indice;
        }
    }
}
