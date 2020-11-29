package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VistaUsuario extends JDialog {
    VistaPantallaPrincipal VistapantallaPrincipal;

    // Icons
    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search.png"));

    // Cosas
    JLabel titulo = new JLabel("ABC de Usuarios");
    public JLabel LblSearch = new JLabel(ImSearch);
    JLabel LblUsuario = new JLabel("Usuario");
    JLabel LblPassword = new JLabel("Contraseña");
    JLabel LblNombre = new JLabel("Nombre");
    JLabel LblTipo = new JLabel("Tipo");

    public JTextField TxtUsuario = new JTextField();
    public JTextField TxtPassword = new JTextField();
    public JTextField TxtNombre = new JTextField();
    public JTextField TxtTipo = new JTextField();


    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");

    public VistaUsuario(JFrame jFrame, boolean b) {
         configuracion();
         menu();
     }
 

	private void configuracion() {
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
         this.setSize(600, 450); 
         this.setLocationRelativeTo(null); 
         this.getContentPane().setBackground(new Color(32, 132, 185));
         this.setTitle("ABC de Usuarios");
         this.setResizable(false);
         this.setLayout(null);
     }
     
     
     private void menu() {
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("serif", Font.BOLD, 20));
        titulo.setBounds(225, 10, 200, 20);
        this.add(titulo);
        
        
        LblSearch.setBounds(135, 75, 25, 25);
        this.add(LblSearch);
        
        LblUsuario.setBounds(165, 75, 50, 20);
        LblUsuario.setForeground(Color.WHITE);
        this.add(LblUsuario);
        
        TxtUsuario.setBounds(220, 70, 200, 30);
        this.add(TxtUsuario);
        
        LblPassword.setBounds(145, 125, 100, 20);
        LblPassword.setForeground(Color.WHITE);
        this.add(LblPassword);
        
        TxtPassword.setBounds(220, 120, 200, 30);
        this.add(TxtPassword);
        
        LblNombre.setBounds(165, 175, 50, 20);
        LblNombre.setForeground(Color.WHITE);
        this.add(LblNombre);
        
        TxtNombre.setBounds(220, 170, 200, 30);
        this.add(TxtNombre);
        
        
        LblTipo.setBounds(185, 225, 90, 20);
        LblTipo.setForeground(Color.WHITE);
        this.add(LblTipo);
        
        TxtTipo.setBounds(220, 220, 200, 30);
        this.add(TxtTipo);
        
        

        
        BtnGuardar.setBounds(20, 310, 100, 30);
        this.add(BtnGuardar);
        
        BtnBuscar.setBounds(130, 310, 100, 30);
        this.add(BtnBuscar);
        
        BtnEliminar.setBounds(240, 310, 100, 30);
        this.add(BtnEliminar);
        
        BtnActualizar.setBounds(350, 310, 100, 30);
        this.add(BtnActualizar);
        
        BtnSalir.setBounds(460, 310, 100, 30);
        this.add(BtnSalir);
     }
     
    //  public static void main(String[] args){
    //      VistaUsuario vu = new VistaUsuario(new JFrame(), true);
    //      vu.setVisible(true);
    //  }
}
