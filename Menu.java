import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Menu here.
 * 
 * @author Aguirre Mauricio Alejandro
 * @version 03/11/25
 */

public class Menu extends JFrame {

    // Declaracion de variables - no modificar
    private MisOpciones jbOpcionInicio;
    private MisOpciones jbOpcionLibros;
    private MisOpciones jbOpcionPrestamos;
    private MisOpciones jbOpcionSocios;
    private MiIcono jlAgregarSocio;
    private MiIcono jlBorrarSocio;
    private MiIcono jlListarSocios;
    private MiIcono jlAgregarPrestamo;
    private MiIcono jlRegistraDevolucion;
    private MiIcono jlListarPrestamos;
    private MiBoton jbAgregarSocio;
    private MiBoton jbAgregarPrestamo;
    private MiBoton jbRegistraDevolucion;
    private MiBoton jbListarPrestamos;
    private JLabel jlTitulo;
    private JTabbedPane jtpEscritorio;
    private MiPanelEscritorio jpCabecera;
    private MiPanelEscritorio jifInicio;
    private MiPanelEscritorio jifSocio;
    private MiPanelEscritorio jifPrestamo;
    private JPanel jpOpciones;
    private JTextArea jtaTextoInicio;
    private Titulos jlTituloSocio;
    private Titulos jlTituloPrestamo;
    //  

    public Menu() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        //Inicializar los atributos
        this.jlTitulo = new JLabel();
        this.jifInicio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jifSocio = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jifPrestamo = new MiPanelEscritorio("/imagenes/Fondo_Biblioteca_Escritorio_Blur.jpeg");
        this.jpOpciones = new JPanel();
        this.jbOpcionSocios = new MisOpciones();
        this.jbAgregarSocio = new MiBoton("Agregar Socio");
        this.jbOpcionLibros = new MisOpciones();
        this.jbOpcionPrestamos = new MisOpciones();
        this.jbAgregarPrestamo = new MiBoton("Registrar Prestamo");
        this.jbRegistraDevolucion = new MiBoton("Registrar Devolucion");
        this.jbListarPrestamos = new MiBoton("Listar Prestamos");
        this.jbOpcionInicio = new MisOpciones();
        this.jtaTextoInicio = new JTextArea();
        this.jlTituloSocio = new Titulos("Socios");
        this.jlTituloPrestamo = new Titulos("Prestamos");
        this.jtpEscritorio = new JTabbedPane();
        this.jlAgregarSocio = new MiIcono("/imagenes/Agregar_Socio.png");
        this.jlBorrarSocio = new MiIcono("/imagenes/Borrar_Socio.png");
        this.jlListarSocios = new MiIcono("/imagenes/Lista_Socios.png");
        this.jlAgregarPrestamo = new MiIcono("/imagenes/Prestamo_Libro.png");
        this.jlRegistraDevolucion = new MiIcono("/imagenes/Devolver_Libro.png");
        this.jlListarPrestamos = new MiIcono("/imagenes/Lista_Prestamos.png");
        this.jpCabecera = new MiPanelEscritorio("/imagenes/Header.jpeg");

        //Settea los atributos de la ventana principal
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 500));
        this.setResizable(false);
        this.setSize(new Dimension(800, 500));
        this.getContentPane().setLayout(null);

        //Settea los atributos del titulo de la cabecera
        this.jlTitulo.setVerticalTextPosition(SwingConstants.BOTTOM);//Posicion vertical del texto respecto al ancho y alto del componente
        this.jlTitulo.setIcon(new ImageIcon(getClass().getResource("/imagenes/Libro_Abierto.png")));//Settea la icono que acompaña al titulo
        this.jlTitulo.setIconTextGap(10);//Settea el espacio que separa al icono del texto
        this.jlTitulo.setFont(new Font("Corbel", 1, 36));//Settea la fuente y el tamaño
        this.jlTitulo.setForeground(new Color(100, 100, 100));//Settea el color de la fuente
        this.jlTitulo.setText("Biblioteca Central");

        //Settea el Layout de los paneles a null para ubicar con presicion los componente con coordenadas (x, y)
        this.jpCabecera.setLayout(null);
        this.jpOpciones.setLayout(null);
        this.jtpEscritorio.setLayout(null);
        this.jifInicio.setLayout(null);
        this.jifSocio.setLayout(null);
        this.jifPrestamo.setLayout(null);

        //Añade el titulo a la cabecera y settea su ubicacion y tamaño
        this.jpCabecera.add(jlTitulo);
        this.jlTitulo.setBounds(10, 10, 800, 64);        

        //Añade icono de agregar socio
        this.jifSocio.add(jlAgregarSocio);
        this.jlAgregarSocio.setBounds(60, 100, 64, 64);

        //Añade icono de borrar socio
        this.jifSocio.add(jlBorrarSocio);
        this.jlBorrarSocio.setBounds(260, 100, 64, 64);

        //Añade icono de listar socios
        this.jifSocio.add(jlListarSocios);
        this.jlListarSocios.setBounds(460, 100, 64, 64);
        
        //Añade icono de agregar prestamo
        this.jifPrestamo.add(jlAgregarPrestamo);
        this.jlAgregarPrestamo.setBounds(60, 100, 64, 64);

        //Añade icono de borrar socio
        this.jifPrestamo.add(jlRegistraDevolucion);
        this.jlRegistraDevolucion.setBounds(260, 100, 64, 64);

        //Añade icono de listar socios
        this.jifPrestamo.add(jlListarPrestamos);
        this.jlListarPrestamos.setBounds(460, 100, 64, 64);

        //Añade boton de agregar socio
        this.jifSocio.add(jbAgregarSocio);
        this.jbAgregarSocio.setBounds(40, 200, 100, 40);
        this.jbAgregarSocio.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbAgregarSocio.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbAgregarSocio.jBotonMouseExited(evt);
                }
            });

        //Settea los atributos del texto en el panel interno Inicio     
        this.jtaTextoInicio.setFont(new Font("Corbel", 1, 40));
        this.jtaTextoInicio.setForeground(Color.white);
        this.jtaTextoInicio.setText("                  Bienvenido a\nSistema de gestion biblioteca");
        this.jtaTextoInicio.setOpaque(false);
        this.jifInicio.add(jtaTextoInicio);
        this.jtaTextoInicio.setBounds(50, 100, 1000, 100);

        //Añade el titulo a la pestaña de socios
        this.jifSocio.add(jlTituloSocio);
        
        //Añade el titulo a la pestaña de prestamos
        this.jifPrestamo.add(jlTituloPrestamo);
        
        //Añade botones a la pestaña de prestamos
        this.jifPrestamo.add(jbAgregarPrestamo);
        this.jbAgregarPrestamo.setBounds(25, 200, 130, 40);
        this.jbAgregarPrestamo.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbAgregarPrestamo.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbAgregarPrestamo.jBotonMouseExited(evt);
                }
            });
        this.jifPrestamo.add(jbRegistraDevolucion);
        this.jbRegistraDevolucion.setBounds(225, 200, 130, 40);
        this.jbRegistraDevolucion.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbRegistraDevolucion.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbRegistraDevolucion.jBotonMouseExited(evt);
                }
            });
        this.jifPrestamo.add(jbListarPrestamos);
        this.jbListarPrestamos.setBounds(425, 200, 130, 40);
        this.jbListarPrestamos.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbListarPrestamos.jBotonMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbListarPrestamos.jBotonMouseExited(evt);
                }
            });    
        
        //Color de fondo para el panel de opciones
        this.jpOpciones.setBackground(new Color(102, 102, 102));

        //Inicializa el texto de la opcion inicio y añade el boton al panel de opciones
        this.jbOpcionInicio.setText("Inicio");
        this.jpOpciones.add(jbOpcionInicio);
        this.jbOpcionInicio.setBounds(0, 0, 170, 50);
        this.jbOpcionInicio.addMouseListener(new MouseAdapter() { //addMouseListener responde a los eventos que puedan ocurrir
                public void mouseEntered(MouseEvent evt) {        //MouseAdapter es una clase abstracta por lo que debemos  
                    jbOpcionInicio.jbOpcionMouseEntered(evt);     //implementar metodos para darle funcionalidad
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionInicio.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifInicioMouseClicked(evt);
                }
            });

        //Inicializa el texto de la opcion socios y añade el boton al panel de opciones
        this.jbOpcionSocios.setText("Socios");
        this.jpOpciones.add(jbOpcionSocios);
        this.jbOpcionSocios.setBounds(0, 50, 170, 50);
        this.jbOpcionSocios.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionSocios.jbOpcionMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionSocios.jbOpcionMouseExited(evt);
                }

                public void mouseClicked(MouseEvent evt){
                    jifSocioMouseClicked(evt);
                }
            });

        //Inicializa el texto de la opcion libros y añade el boton al panel de opciones
        this.jbOpcionLibros.setText("Libros");
        this.jpOpciones.add(jbOpcionLibros);
        this.jbOpcionLibros.setBounds(0, 100, 170, 50);
        this.jbOpcionLibros.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionLibros.jbOpcionMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionLibros.jbOpcionMouseExited(evt);
                }
            });
            
        //Inicializa el texto de la opcion prestamos y añade el boton al panel de opciones
        this.jbOpcionPrestamos.setText("Prestamos");
        this.jpOpciones.add(jbOpcionPrestamos);
        this.jbOpcionPrestamos.setBounds(0, 150, 170, 50);
        this.jbOpcionPrestamos.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    jbOpcionPrestamos.jbOpcionMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    jbOpcionPrestamos.jbOpcionMouseExited(evt);
                }
                
                public void mouseClicked(MouseEvent evt){
                    jifPrestamoMouseClicked(evt);
                }
            });

        //Añade el panel de contenido a la ventana principal
        this.getContentPane().add(jtpEscritorio);
        this.jtpEscritorio.setBounds(170, 90, 730, 420);// Settea su ubicacion
        this.jtpEscritorio.addTab("tab1", jifInicio);// Agrega una ventana interna al panel de contenido
        this.jtpEscritorio.addTab("tab2", jifSocio);
        this.jtpEscritorio.addTab("tab3", jifPrestamo);
        //Añade el panel de opciones a la ventana principal
        this.getContentPane().add(jpOpciones);
        this.jpOpciones.setBounds(0, 90, 170, 420);
        //Añade el panel de cabecera a la ventana principal
        this.getContentPane().add(jpCabecera);
        this.jpCabecera.setBounds(0, 0, 900, 100);

        this.pack();//Ajusta el tamaño de la ventana y los componentes
        this.setVisible(true);//Hace visible la ventana
    } 

    private void jifInicioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(0);
    }

    private void jifSocioMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(1);
    }
    
    private void jifPrestamoMouseClicked(MouseEvent evt) {                                           
        this.jtpEscritorio.setSelectedIndex(2);
    }
}