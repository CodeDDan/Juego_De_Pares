package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
    public enum Tabla {
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
    
    public int obtenerIntPK(Tabla tabla) {
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
        int usu_Id = obtenerIntPK(Tabla.USUARIO) + 1;
        String consulta = "INSERT INTO TBL_USUARIO (USU_ID, USU_ALIAS, USU_NOMBRE, USU_APELLIDO, USU_CORREO, USU_PASSWORD)\n" 
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(consulta);
        try {
            // Método de protección "Consultas preparadas"
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, String.valueOf(usu_Id));
            ps.setString(2, usu_Alias);
            ps.setString(3, usu_Nombre);
            ps.setString(4, usu_Apellido);
            ps.setString(5, usu_Correo);
            ps.setString(6, usu_Password);
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
        
        String consulta = "SELECT u.USU_ID, u.USU_ALIAS, u.USU_PASSWORD\n" 
                + "FROM TBL_USUARIO u\n" 
                + "WHERE u.USU_ALIAS = ? AND u.USU_PASSWORD = ?";
        System.out.println(consulta);
        try {
            // Utilizamos el método de protección "Consultas preparadas"
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            // La consulta se situa en la cabecera, de haber 1 resultado existirá rs.next()
            if (rs.next() == true) {
                Usuario.setiD(Integer.valueOf(rs.getString(1)));
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }
    
    public void ingresarPuntaje(int niv_Id, String tiempoDeJuego, String puntaje) {
        int par_Id = obtenerIntPK(Conexion.Tabla.PARTIDA) + 1;
        int usu_Id = Usuario.getiD();
        String consulta = "INSERT INTO TBL_PARTIDA (PAR_ID, USU_ID, NIV_ID, PAR_FECHA, "
                + "PAR_TIEMPODEPARTIDA, PAR_PUNTAJE) \n" 
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(consulta);
        // Método de protección "Consultas preparadas"
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, String.valueOf(par_Id));
            ps.setString(2, String.valueOf(usu_Id));
            ps.setString(3, String.valueOf(niv_Id));
            ps.setString(4, Usuario.getFecha());
            ps.setString(5, Usuario.getFin());
            ps.setString(6, puntaje);
            ps.execute();
        } catch (SQLException e) {
            
        }
    }
    
    public String fechaYHora() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = dateFormat.format(new Date());
        System.out.println(fecha);
        return fecha;
    }
    
    public void actualizarTabla(JTableEspecial tabla, int usu_Id) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String consulta = "Select p.NIV_ID, p.PAR_FECHA, p.PAR_TIEMPODEPARTIDA, p.PAR_PUNTAJE \n" 
                + "FROM TBL_PARTIDA p\n" 
                + "WHERE p.USU_ID = " + usu_Id
                + "ORDER BY p.PAR_FECHA DESC";
        System.out.println(consulta);
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            /*
            rs se situa en el "HEADER" por así decirlo, a pesar de que la consulta
            solo devuelva un valor, existirá una cabezara. debemos mover el cursor 
            usando rs.next()
             */
            while (rs.next()) {
                String nivel = rs.getString(1);
                String fecha = rs.getString(2);
                String tiempo = rs.getString(3);
                String puntaje = rs.getString(4);
                modelo.addRow(new Object[]{nivel, fecha, tiempo, puntaje});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se actualizar la tabla");
        }
        tabla.setModel(modelo);
    }
}
