package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Daniel Sánchez <daniel_s2604@hotmail.com>
 */

public class Conexion {

    // Services de NetBeans nos permite comprobar la conexión, no es necesario crear una nueva
    private Connection conexion;
    String url = "jdbc:sqlserver://localhost:1433;databaseName=PI_Juego_de_Pares;User=Daniel;Password=1234";

    public Conexion() {
        conectarBase();
    }

    private Connection conectarBase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas en la conexión");
        }
        System.out.println("Correcto");
        return conexion;
    }

    /* 
    USUARIO | PARTIDA | NIVEL
     */
    
    public enum selecionTabla {
        USUARIO, PARTIDA, NIVEL
    }

    /**
     * Descripción:
     * <p>
     * Obtiene el índice de la última clave primaria ingresada en nuestra
     * base de datos.
     * <p>
     * @author Daniel Sánchez 
     * @param tabla tablas existentes en nuestro modelo relacional
     * @return Índice máximo de la llave primaria
     */
    
    public int obtenerIntPK(selecionTabla tabla) {
        int id = 0;
        String consulta;
        switch (tabla) {
            case USUARIO:
                consulta = "SELECT MAX(u.USU_ID)\n"
                        + "FROM TBL_USUARIO u";
                break;
            case PARTIDA:
                consulta = "SELECT MAX(p.PAR_ID)\n"
                        + "FROM TBL_PARTIDA p";
                break;
            case NIVEL:
                consulta = "SELECT MAX(n.NIV_ID)\n"
                        + "FROM TBL_NIVEL n";
                break;
            default:
                consulta = "";
                break;
        }
        System.out.println(consulta);
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            /*
            rs se situa en el "HEADER" por así decirlo, a pesar de que la consulta
            solo devuelva un valor, existirá una cabezara. debemos mover el cursor 
            usando rs.next()
             */
            rs.next();
            id = rs.getInt(1);
            // id_mesa = id;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se obtuvo el último índice");
        }
        return id;
    }

    /**
     * Descripción:
     * <p>
     * Ingresa al usuario en nuestra base de datos relacional, sirve para este 
     * caso en específico.
     * <p>
     * @author Daniel Sánchez <daniel_s2604@hotmail.com>
     * @param usu_Alias NickName o Alias del usuario
     * @param usu_Nombre Nombre del usuario
     * @param usu_Apellido Apellido del usuario
     * @param usu_Correo Correo del usuario
     * @param usu_Password Contraseña del usuario
     */
    
    public void registrarUsuario(String usu_Alias, String usu_Nombre, String usu_Apellido, String usu_Correo, String usu_Password) {
        int usu_Id = obtenerIntPK(selecionTabla.USUARIO) + 1;
        String consulta = "INSERT INTO TBL_USUARIO (USU_ID, USU_ALIAS, USU_NOMBRE, USU_APELLIDO, USU_CORREO, USU_PASSWORD) \n"
                + "VALUES (" + usu_Id + ", '" + usu_Alias + "', '" + usu_Nombre + "', '" + usu_Apellido + "', '" + usu_Correo + "', '" + usu_Password + "')";
        System.out.println(consulta);
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario ingresado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo ingresar");
        }
    }

    /**
     * Descripción:
     * <p>
     * Valída que el nombre de usuario y la contraseña ingresada pertenezcan
     * a un usuario en nuestra base de datos relacional
     * <p>
     * @author Daniel Sánchez <daniel_s2604@hotmail.com>
     * @param usuario Nombre del usuario
     * @param password Contraseña de dicho usuario
     * @return True si existe, False si no
     */
    
    public boolean validarUsuario(String usuario, String password) {
        String consulta = "SELECT u.USU_ALIAS, u.USU_PASSWORD\n"
                + "FROM TBL_USUARIO u\n"
                + "WHERE u.USU_ALIAS = '" + usuario + "' AND u.USU_PASSWORD = '" + password + "'";
        System.out.println(consulta);
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            //Debemos guardar en un vector todos los datos de haber varios
            //La consulta devuelve el último
            if (rs.next() == true) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }
    
}
