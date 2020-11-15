package vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class VistaPantallaPrincipal extends JFrame{
    //Barra de menu
    JMenuBar BarraDeMenu = new JMenuBar();
    
    //Icons
    ImageIcon ImUserMenu = new ImageIcon(getClass().getResource("/imagenes/userMenu.png"));
    ImageIcon ImExitMenu = new ImageIcon(getClass().getResource("/imagenes/exitMenu.png"));
    ImageIcon ImShrinkMenu = new ImageIcon(getClass().getResource("/imagenes/shrinkMenu.png"));
    ImageIcon ImCartMenu = new ImageIcon(getClass().getResource("/imagenes/cartMenu.png"));
    ImageIcon ImNada = new ImageIcon(getClass().getResource("/imagenes/transparentCosa.png"));
    
    
    //Items
    JMenuItem blank = new JMenuItem(ImNada);
    public JMenuItem user = new JMenuItem(ImUserMenu);
    public JMenuItem cart = new JMenuItem(ImCartMenu);
    public JMenuItem shrink = new JMenuItem(ImShrinkMenu);
    public JMenuItem exit = new JMenuItem(ImExitMenu);
    
    public VistaPantallaPrincipal(){
        configuracion();
        menu();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(700, 400); 
        this.setLocationRelativeTo(null); 
        this.getContentPane().setBackground(new Color(32, 132, 185));
        this.setResizable(false);
        this.setEnabled(true);
        this.setLayout(null);
        this.setUndecorated(true);
    }
    
    GridBagConstraints c = new GridBagConstraints();
    
    private void menu() {
        BarraDeMenu.setLayout(new GridBagLayout()); 
        
        c.insets = new Insets(0,30,0,100);
        BarraDeMenu.add(user, c);
        BarraDeMenu.add(cart, c);
        BarraDeMenu.add(shrink, c);
        BarraDeMenu.add(exit, c);
        this.setJMenuBar(BarraDeMenu);
    }
}
