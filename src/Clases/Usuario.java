package Clases;

/**
 * @author Daniel
 */
public class Usuario {
    
    private static int iD;
    private static String fecha;
    private static String tiempo, fin;
    
    public static void setiD(int iD) {
        Usuario.iD = iD;
    }

    public static int getiD() {
        return iD;
    }
    
    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        Usuario.fecha = fecha;
    }

    public static String getTiempo() {
        return tiempo;
    }

    public static void setTiempo(String tiempo) {
        Usuario.tiempo = tiempo;
    }
    
    public static String getFin() {
        return fin;
    }

    public static void setFin(String fin) {
        Usuario.fin = fin;
    }
    
}
