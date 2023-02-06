package Formularios;

import Clases.JButtonEspecial;
import Clases.KeySoloCorreo;
import Clases.KeySoloLetras;
import Clases.PasswordEspecial;
import Clases.TextFieldEspecial;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 * @author Daniel Sánchez
 */
public class Panel_Login extends javax.swing.JPanel {
    
    public JButtonEspecial getBtnRegistro() {
        return btnRegistro;
    }
    
    public JButtonEspecial getBtnIngreso() {
        return btnIngreso;
    }
    
    public TextFieldEspecial getTxtAlias() {
        return txtAlias;
    }
    
    public PasswordEspecial getPwdPassword() {
        return pwdPassword;
    }
    
    public TextFieldEspecial getTxtNombre() {
        return txtNombre;
    }
    
    public TextFieldEspecial getTxtApellido() {
        return txtApellido;
    }
    
    public TextFieldEspecial getTxtCorreo() {
        return txtCorreo;
    }
    
    public TextFieldEspecial getTxtAliasI() {
        return txtAliasI;
    }
    
    public PasswordEspecial getPwdPasswordI() {
        return pwdPasswordI;
    }
    private JButtonEspecial btnRegistro;
    private JButtonEspecial btnIngreso;
    
    private TextFieldEspecial txtAliasI;
    private PasswordEspecial pwdPasswordI;
    
    private TextFieldEspecial txtAlias;
    private PasswordEspecial pwdPassword;
    private TextFieldEspecial txtNombre;
    private TextFieldEspecial txtApellido;
    private TextFieldEspecial txtCorreo;
    
    public Panel_Login() {
        initComponents();
        initLogin();
        initRegistro();
    }
    
    private void initLogin() {
        btnIngreso = new JButtonEspecial();
        panelLogin.setLayout(new MigLayout("wrap", "push [center] push", "push [] 25 [] 10 [] 25 [] push"));
        JLabel titulo = new JLabel(new ImageIcon("src\\Iconos\\PalAcceder_50px.png"));
        panelLogin.add(titulo);
        // Alias
        txtAliasI = new TextFieldEspecial();
        txtAliasI.setLabelText("Nick Name");
        txtAliasI.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoNick_50px.png"));
        panelLogin.add(txtAliasI, "w 60%");
        // Password
        pwdPasswordI = new PasswordEspecial();
        pwdPasswordI.setLabelText("Contraseña");
        pwdPasswordI.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoPassword_50px.png"));
        pwdPasswordI.setShowAndHide(true);
        panelLogin.add(pwdPasswordI, "w 60%");
        // Boton Ingreso
        btnIngreso.setIcon(new ImageIcon("src\\Iconos\\PalIngresar_50px.png"));
        btnIngreso.setRadio(20);
        panelLogin.add(btnIngreso, "w 40% , h 40");
    }
    
    private void initRegistro() {
        btnRegistro = new JButtonEspecial();
        panelRegistro.setLayout(new MigLayout("wrap", "push [center] push", "push [] 25 [] 10 [] 10 [] 10 [] 10 [] 25 [] push"));
        JLabel titulo = new JLabel(new ImageIcon("src\\Iconos\\PalCrear_50px.png"));
        panelRegistro.add(titulo);
        // Alias
        txtAlias = new TextFieldEspecial();
        txtAlias.setLabelText("Nick Name");
        txtAlias.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoNick_50px.png"));
        panelRegistro.add(txtAlias, "w 60%");
        // Nombre
        txtNombre = new TextFieldEspecial();
        txtNombre.setLabelText("Nombre");
        txtNombre.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoUsuario_50px.png"));
        txtNombre.addKeyListener(new KeySoloLetras());
        panelRegistro.add(txtNombre, "w 60%");
        // Apellido
        txtApellido = new TextFieldEspecial();
        txtApellido.setLabelText("Apellido");
        txtApellido.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoApellido_50px.png"));
        txtApellido.addKeyListener(new KeySoloLetras());
        panelRegistro.add(txtApellido, "w 60%");
        // Correo
        txtCorreo = new TextFieldEspecial();
        txtCorreo.setLabelText("Correo");
        txtCorreo.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoMail_50px.png"));
        txtCorreo.addKeyListener(new KeySoloCorreo(txtCorreo));
        panelRegistro.add(txtCorreo, "w 60%");
        // Password
        pwdPassword = new PasswordEspecial();
        pwdPassword.setLabelText("Contraseña");
        pwdPassword.setPrefixIcon(new ImageIcon("src\\Iconos\\IconoPassword_50px.png"));
        pwdPassword.setShowAndHide(true);
        panelRegistro.add(pwdPassword, "w 60%");
        // Boton Registro
        btnRegistro = new JButtonEspecial();
        btnRegistro.setIcon(new ImageIcon("src\\Iconos\\PalCrearCuenta_50px.png"));
        btnRegistro.setRadio(20);
        panelRegistro.add(btnRegistro, "w 40% , h 40");
    }
    
    public void mostrarRegistro(boolean show) {
        if (show) {
            panelRegistro.setVisible(true);
            panelLogin.setVisible(false);
        } else {
            panelRegistro.setVisible(false);
            panelLogin.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistro = new Clases.PanelGradiente();
        panelLogin = new Clases.PanelGradiente();

        setLayout(new java.awt.CardLayout());

        panelRegistro.setColor1(new java.awt.Color(247, 174, 33));
        panelRegistro.setColor2(new java.awt.Color(66, 15, 112));

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        add(panelRegistro, "card2");

        panelLogin.setColor1(new java.awt.Color(20, 10, 58));
        panelLogin.setColor2(new java.awt.Color(122, 48, 255));

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        add(panelLogin, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Clases.PanelGradiente panelLogin;
    private Clases.PanelGradiente panelRegistro;
    // End of variables declaration//GEN-END:variables
}
