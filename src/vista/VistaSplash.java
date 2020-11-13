package vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VistaSplash extends JFrame {
    
    //Convertir imagen splash.gif en objeto
    ImageIcon ImSplash = new ImageIcon(getClass().getResource("/imagenes/splash.gif"));
    //Esta etiqueta es la que se agregara al JFrame, con la imagen splash incrustada
    public JLabel LblSplash = new JLabel(ImSplash);
    
    public VistaSplash(){
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        //No se pone EXIT_ON_CLOSE por que cerraria la app
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //No se sabe el tamaño del splash, le damos la medidad de la imagen
        this.setSize(ImSplash.getIconWidth(),ImSplash.getIconHeight());
        this.setLocationRelativeTo(null); //Centrarlo
        
        //Quitar el decorado (Borde, barra de titulo, maximizar, minimizar, etc.)
        this.setUndecorated(true);
       
        //Quitar el Fondo del JFrame
        //No me jalo el com.sun.awt.AWTUtilities;
        this.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        //Mantiene el JFrame siempre encima de todo
        // this.setAlwaysOnTop(true);
    }

    private void agregarComponentes() {
        this.add(LblSplash); //agregar al JFrame la etiqueta con la imagen
    }
}
