package Formularios;

import Clases.DialogEspecial;
import Clases.ObjetoImagen;
import Clases.ObjetoMusic;
import Clases.ObjetoPuntuacion;
import Clases.ObjetoSonido;
import ClasesImportadas.Frm_Notificacion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

/**
 * @author Daniel Sánchez
 * @version 1
 */

public class Frm_JuegoFacil extends javax.swing.JFrame {

    // Se agregaran las direcciones con el doble backslash (\\).
    // Las direcciones que agrega el método getAbsolutePath() se agregan con (\).
    ObjetoImagen cartas = new ObjetoImagen("src\\Imagenes", "src\\Imagenes_Pick", "src\\Imagenes_Pick_Anim");
    ObjetoSonido sounds = new ObjetoSonido("src\\Sound_Effects");
    ObjetoMusic musc = new ObjetoMusic("src\\Musica\\Lofi Study - FASSounds.mp3");
    // Variable para controlar el estado de los botones;
    private static boolean estadoBtnMax = true;
    private static boolean btnM = false, btnO = false;
    private CardLayout mostrar;
    // Creamos el valor aleatorio para los labels.
    private final int numLabel[] = new int[6];
    // Creamos nuestro contador de clics.
    private int clic = 0, contadorAciertos = 0;
    // Creamos nuestro array booleano para saber el estado del clic del label.
    private final boolean estado[] = new boolean[6];
    // Creamos el Dialog para la puntuación
    ObjetoPuntuacion puntos;
    // Para llamar al evento de clic de un botón.
    // btnButton.PerformClick();
    // Detener y resetear el reloj al salir del JFrame

    public Frm_JuegoFacil() {
        initComponents();
        for (int i = 0; i < numLabel.length; i++) {
            numLabel[i] = i;
        }
        for (int i = 0; i < estado.length; i++) {
            estado[i] = false;
        }
        musc.loop();
        mostrar = (CardLayout) panelPrincipal.getLayout();
        // Se agregaran las vistas en el orden de los paneles
        // Debemos colocar primero la vista del juego
        Panel_Menu ventanaMenu = new Panel_Menu(panelJuego.getColor1(), panelJuego.getColor2());
        Panel_Opciones ventanaOpcion = new Panel_Opciones(panelJuego.getColor1(), panelJuego.getColor2());
        panelPrincipal.add(panelJuego, "juego");
        panelPrincipal.add(ventanaMenu, "menu");
        panelPrincipal.add(ventanaOpcion, "opcion");
        // Iniciamos el ObjetoPuntuacion
        puntos = new ObjetoPuntuacion(this, ObjetoPuntuacion.TIPO.FACIL, panelJuego);
        // Añadimos funcionalidad a los botones.
        ventanaMenu.getBtnReanudar().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                mostrar.show(panelPrincipal, "juego");
                temporizador1.encenderReloj();
                btnM = false;
                btnO = false;
            }

        });
        ventanaMenu.getBtnSalir().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }

        });
        ventanaMenu.getBtnOpcion().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                mostrar.show(panelPrincipal, "opcion");
                temporizador1.apagarReloj();
                btnM = false;
                btnO = true;
            }

        });

        // Reloj
        temporizador1.encenderReloj();
        String cancion = "Lofi Study - FASSounds";
        Frm_Notificacion noc = new Frm_Notificacion(this, Frm_Notificacion.Type.INFO, Frm_Notificacion.Location.BOT_LEFT, cancion);
        noc.showNotificacion();

        // Métodos para controlar el volumen
        JSlider volumenMusica = ventanaOpcion.getSliderMusica();
        JSlider volumenEfectos = ventanaOpcion.getSliderEfectos();
        JCheckBox checkMusica = ventanaOpcion.getCheckBoxMusica();
        JCheckBox checkEfectos = ventanaOpcion.getCheckBoxEfectos();

        // Valores iniciales
        /*
        Existe un problema al intentar inicializar los valores de los sliders,
        esto debido a que aún no se muestran en pantalla.
        Por defecto, el objeto mediaPlayer inicia con volumen de 1.
        El objeto sounds no inicia el mediaPlayer hasta que se reproduce el 
        sonido, por tanto hay que usar un método distinto.
         */
        musc.getMediaPlayer().setVolume(0.5);
        sounds.setVolumen(0.5);
        // Eventos
        /*
        Se debe dividir para 100, dado que el método setVolumen
        admite valores entre 0.0 y 1.0.
        Se debe usar la transformación (float) o se pierden valores porque
        se realiza una división entera.
         */
        volumenMusica.addChangeListener((ChangeEvent ce) -> {
            double vol = (double) (volumenMusica.getValue() * 0.01);
            musc.getMediaPlayer().setVolume(vol);
        });
        volumenEfectos.addChangeListener((ChangeEvent ce) -> {
            double vol = (double) (volumenEfectos.getValue() * 0.01);
            sounds.setVolumen(vol);
            sounds.usarSonido("src\\Sound_Effects\\sound_click.mp3");
        });

        checkMusica.addActionListener((ActionEvent ae) -> {
            if (checkMusica.isSelected()) {
                musc.getMediaPlayer().setVolume(0);
            } else {
                musc.getMediaPlayer().setVolume(volumenMusica.getValue() * 0.01);
            }
        });
        checkEfectos.addActionListener((ActionEvent ae) -> {
            if (checkEfectos.isSelected()) {
                sounds.setVolumen(0);
            } else {
                sounds.setVolumen(volumenEfectos.getValue() * 0.01);
            }
        });
        JButton[] botones = {btnSalir, btnOpcion, btnAyuda, btnMenu, btnMinimizar, btnMaximizar, btnBack};
        for (JButton btn : botones) {
            btn.setBackground(new Color(10, 31, 58));
            // Para un botón simple btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent me) {
                    btn.setBackground(new Color(72, 153, 188));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    btn.setBackground(new Color(10, 31, 58));
                }
            });
        }
        renewGame();
        // Se crea el objeto puntuación cuando el JFrame es visible.
        puntos.situarDialog(panelPrincipal);
    }

    private void renewGame() {
        /*
        La visibilidad se pone en true en el método main del JFrame, la necesitamos
        en true desde antes para situar nuestra puntuación.
        */
        this.setVisible(true);
        // Debe iniciar en 1, la primera posición del array solo contiene el string de la carpeta
        int k = 1;
        // Se deben agregar los sonidos con las barras invertidas
        sounds.usarSonido("src\\Sound_Effects\\sound_shuffle.mp3");
        int ale[] = cartas.mezclar();
        JLabel[] labels = {lbl1, lbl2, lbl3, lbl4, lbl5, lbl6};
        // Controlamos que existan las cartas
        if (cartas.getDirBase().size() <= 6) {
            JOptionPane.showMessageDialog(null, "No existen imágenes suficientes");
            System.exit(0);
        }

        // Aleatorizamos el array de jlabels inicial
        for (int i = numLabel.length - 1; i > 0; i--) {
            // Calculamos un índice aleatorio dentro del rango permitido
            int shuffled_index = (int) Math.floor(Math.random() * (i + 1));
            // Guardamos el elemento que estamos iterando
            int tmp = numLabel[i];
            // Asignamos el elemento aleatorio al índice iterado
            numLabel[i] = numLabel[shuffled_index];
            // Asignamos el elemento iterado al índice aleatorio
            numLabel[shuffled_index] = tmp;
        }

        // Booleano para poner 2 copias de la misma carta
        boolean cond = true;
        for (int i = 0; i < labels.length; i++) {
            ImageIcon icon = new ImageIcon(cartas.getDirBase().get(ale[k]));
            labels[numLabel[i]].setIcon(icon);
            //Controlamos la condición para que se pongan 2 copias de la misma carta
            if (cond) {
                cond = false;
            } else {
                k++;
                cond = true;
            }
        }

        /**
         * Generamos los eventos para cada label del frame. Lo podemos hacer
         * porque conocemos el orden de los labels. Debemos hacer una copia
         * final de la variable para que ingrese al addMouseListener (Consultar
         * más sobre final varibales)
         */
        int temp = 0;
        for (JLabel lbl : labels) {
            final int v = temp;
            System.out.println(v);
            lbl.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    String selec;
                    if (estado[v] && clic == 1) {
                        // De momento no hacemos nada
                        selec = cartas.recuperarCarta(lbl.getIcon().toString());
                        // Formamos el String a la dirección de la carpeta
                        selec = "src\\Imagenes\\" + selec + ".png";
                        // Cargamos la imagen
                        ImageIcon icon = new ImageIcon(selec);
                        lbl.setIcon(icon);
                        estado[v] = false;
                        clic--;
                    } else {
                        clic++;
                        if (clic == 1) {
                            sounds.usarSonido("src\\Sound_Effects\\sound_click.mp3");
                            selec = cartas.recuperarCarta(lbl.getIcon().toString());
                            // Formamos el String a la dirección de la carpeta
                            selec = "src\\Imagenes_Pick\\" + selec + ".png";
                            // Cargamos la imagen
                            ImageIcon icon = new ImageIcon(selec);
                            lbl.setIcon(icon);
                            estado[v] = true;
                        } else {
                            estado[v] = true;
                            int[] a = {0, 0};
                            int temp = 0;
                            for (int i = 0; i < estado.length; i++) {
                                if (estado[i]) {
                                    a[temp] = i;
                                    temp++;
                                    if (temp > 1) {
                                        break;
                                    }
                                }
                            }
                            if (compararIconos(labels[a[0]], labels[a[1]])) {
                                clic = 0;
                                estado[a[0]] = false;
                                estado[a[1]] = false;
                                contadorAciertos++;
                                comprobarVictoria(contadorAciertos);
                            } else {
                                clic = 1;
                                estado[v] = false;
                            }
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent me) {

                }

                @Override
                public void mouseReleased(MouseEvent me) {

                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    String selec;
                    if (estado[v]) {
                        // Por el momento no hace nada
                    } else {
                        selec = cartas.recuperarCarta(lbl.getIcon().toString());
                        // Formamos el String a la dirección de la carpeta
                        selec = "src\\Imagenes_Pick_Anim\\" + selec + ".gif";
                        // Cargamos el gif
                        ImageIcon icon = new ImageIcon(selec);
                        // Refrescamos el gif
                        Image img = icon.getImage();
                        img.flush();
                        lbl.setIcon(icon);
                    }
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    String selec;
                    if (estado[v]) {
                        // Por el momento no hace nada
                    } else {
                        selec = cartas.recuperarCarta(lbl.getIcon().toString());
                        // Formamos el String a la dirección de la carpeta
                        selec = "src\\Imagenes\\" + selec + ".png";
                        // Cargamos la imagen
                        ImageIcon icon = new ImageIcon(selec);
                        lbl.setIcon(icon);
                    }
                }
            });
            temp++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradiente3 = new Clases.PanelGradiente();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        rootPanel = new javax.swing.JPanel();
        panelOpciones = new Clases.PanelGradiente();
        btnMenu = new javax.swing.JButton();
        btnOpcion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnMaximizar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        temporizador1 = new Clases.Temporizador();
        obContador = new Clases.ObjetoContador();
        btnBack = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelJuego = new Clases.PanelGradiente();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();

        panelGradiente3.setColor1(new java.awt.Color(20, 10, 58));
        panelGradiente3.setColor2(new java.awt.Color(52, 155, 142));

        lbl7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        javax.swing.GroupLayout panelGradiente3Layout = new javax.swing.GroupLayout(panelGradiente3);
        panelGradiente3.setLayout(panelGradiente3Layout);
        panelGradiente3Layout.setHorizontalGroup(
            panelGradiente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradiente3Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(panelGradiente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradiente3Layout.createSequentialGroup()
                        .addComponent(lbl7)
                        .addGap(210, 210, 210)
                        .addComponent(lbl8)
                        .addGap(210, 210, 210)
                        .addComponent(lbl9))
                    .addGroup(panelGradiente3Layout.createSequentialGroup()
                        .addComponent(lbl10)
                        .addGap(210, 210, 210)
                        .addComponent(lbl11)
                        .addGap(210, 210, 210)
                        .addComponent(lbl12))))
        );
        panelGradiente3Layout.setVerticalGroup(
            panelGradiente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradiente3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(panelGradiente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl7)
                    .addComponent(lbl8)
                    .addComponent(lbl9))
                .addGap(180, 180, 180)
                .addGroup(panelGradiente3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl10)
                    .addComponent(lbl11)
                    .addComponent(lbl12)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        rootPanel.setPreferredSize(new java.awt.Dimension(1020, 895));
        rootPanel.setLayout(new java.awt.BorderLayout());

        panelOpciones.setColor1(new java.awt.Color(52, 155, 142));
        panelOpciones.setColor2(new java.awt.Color(20, 10, 58));
        panelOpciones.setPreferredSize(new java.awt.Dimension(800, 75));

        btnMenu.setBackground(new java.awt.Color(10, 31, 58));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoMenu_50px.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnOpcion.setBackground(new java.awt.Color(10, 31, 58));
        btnOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoSettings_50px.png"))); // NOI18N
        btnOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(10, 31, 58));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoClose_50px.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAyuda.setBackground(new java.awt.Color(10, 31, 58));
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoQuestion_50px.png"))); // NOI18N
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnMaximizar.setBackground(new java.awt.Color(10, 31, 58));
        btnMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoMinimizar_50px.png"))); // NOI18N
        btnMaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizarActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(10, 31, 58));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoMinimizarVentana_50px.png"))); // NOI18N
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(10, 31, 58));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/IconoBack_50px.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(temporizador1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(obContador, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(temporizador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(obContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rootPanel.add(panelOpciones, java.awt.BorderLayout.PAGE_START);

        panelPrincipal.setLayout(new java.awt.CardLayout());

        panelJuego.setColor1(new java.awt.Color(20, 10, 58));
        panelJuego.setColor2(new java.awt.Color(52, 155, 142));

        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        lbl6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clovers_A_white.png"))); // NOI18N

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addComponent(lbl4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl5))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addComponent(lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(lbl2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addContainerGap(148, Short.MAX_VALUE)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2)
                            .addComponent(lbl1)
                            .addComponent(lbl3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addGroup(panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelJuegoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl5)))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelJuego, "card3");

        rootPanel.add(panelPrincipal, java.awt.BorderLayout.CENTER);

        getContentPane().add(rootPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        btnM = !btnM;
        // Si el botón esta prendido lo apagamos
        if (btnO) {
            btnO = !btnO;
        }
        if (btnM) {
            mostrar.show(panelPrincipal, "menu");
            temporizador1.apagarReloj();
            repaint();
        }else{
            mostrar.show(panelPrincipal, "juego");
            temporizador1.encenderReloj();
            repaint();
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionActionPerformed
        btnO = !btnO;
        // Si el botón esta prendido lo apagamos
        if (btnM) {
            btnM = !btnM;
        }
        if (btnO) {
            mostrar.show(panelPrincipal, "opcion");
            temporizador1.apagarReloj();
            repaint();
        }else{
            mostrar.show(panelPrincipal, "juego");
            temporizador1.encenderReloj();
            repaint();
        }
    }//GEN-LAST:event_btnOpcionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        String mensajeAyuda = "Empareja cartas con igual color/diseño";
        Frm_Notificacion ayud = new Frm_Notificacion(this, Frm_Notificacion.Type.ALERT, Frm_Notificacion.Location.TOP_RIGHT, mensajeAyuda);
        ayud.showNotificacion();
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnMaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximizarActionPerformed
        if (estadoBtnMax) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ImageIcon min = new ImageIcon("src\\Iconos\\IconoMaximizar_50px.png");
            btnMaximizar.setIcon(min);
            estadoBtnMax = false;
        } else {
            this.setExtendedState(JFrame.NORMAL);
            ImageIcon min = new ImageIcon("src\\Iconos\\IconoMinimizar_50px.png");
            btnMaximizar.setIcon(min);
            estadoBtnMax = true;
        }
        repaint();
        /*
        InvokeLater nos permite realizar la acción cuando la maximización del
        formulario se ha completado, garantizando que nuestro método para situar
        no tome valores erroneos.
        */
        SwingUtilities.invokeLater(() -> {
            puntos.situarDialog(panelPrincipal);
        });
    }//GEN-LAST:event_btnMaximizarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        // Si se usa setExtendedState vuelve al tamaño inicial
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DialogEspecial dg = new DialogEspecial(3);
        if (!dg.isValor()) {
            return;
        }
        Frm_SeleccionD selecD = new Frm_SeleccionD();
        selecD.setVisible(true);
        musc.getMediaPlayer().stop();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private boolean compararIconos(JLabel lbl1, JLabel lbl2) {
        String iconA, iconB, selec;
        iconA = cartas.recuperarCarta(lbl1.getIcon().toString());
        iconB = cartas.recuperarCarta(lbl2.getIcon().toString());
        if (!iconA.equals(iconB)) {
            sounds.usarSonido("src\\Sound_Effects\\sound_error.mp3");
            return false;
        }
        // Acciones al acertar 
        sounds.usarSonido("src\\Sound_Effects\\sound_correcto.mp3");
        // Calculamos los puntos
        puntos.actualizarPuntaje();
        selec = iconA;
        // Formamos el String a la dirección de la carpeta
        selec = "src\\Imagenes_Correcto\\" + selec + ".gif";
        // Cargamos el gif
        ImageIcon icon = new ImageIcon(selec);
        // Refrescamos el gif
        Image im = icon.getImage();
        im.flush();
        lbl1.setIcon(icon);
        lbl2.setIcon(icon);
        // Se debe separar la eliminación de los mouseListeners
        for (MouseListener ml : lbl1.getMouseListeners()) {
            lbl1.removeMouseListener(ml);
        }
        for (MouseListener ml : lbl2.getMouseListeners()) {
            lbl2.removeMouseListener(ml);
        }
        return true;
    }

    // Aquí se cambia la cantidad de aciertos necesarios
    private void comprobarVictoria(int cont) {
        if (cont >= 3) {
            temporizador1.apagarReloj();
            DialogEspecial dig = new DialogEspecial(2);
            if (!dig.isValor()) {
                musc.getMediaPlayer().stop();
                Frm_SeleccionD selecD = new Frm_SeleccionD();
                this.dispose();
                selecD.setVisible(true);
                return;
            }
            this.renewGame();
            obContador.actualizarContador();
            temporizador1.encenderReloj();
            contadorAciertos = 0;
            System.out.println("El tamaño es: " + cartas.getDirBase().size());
        }
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_JuegoFacil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_JuegoFacil().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMaximizar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnOpcion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private Clases.ObjetoContador obContador;
    private Clases.PanelGradiente panelGradiente3;
    private Clases.PanelGradiente panelJuego;
    private Clases.PanelGradiente panelOpciones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel rootPanel;
    private Clases.Temporizador temporizador1;
    // End of variables declaration//GEN-END:variables
}
