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


public class VistaProductos extends JDialog {
    VistaPantallaPrincipal VistapantallaPrincipal;
     
     //Icons
     ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search.png"));
     
     //Cosas
     JLabel titulo = new JLabel("ABC de Productos");
     public JLabel LblSearch = new JLabel(ImSearch);
     JLabel LblCodigo = new JLabel("Codigo");
     JLabel LblNombre = new JLabel("Nombre");
     JLabel LblPrecio = new JLabel("Precio");
     JLabel LblPresentacion = new JLabel("Presentacion");
     JLabel LblDescripcion = new JLabel ("Descripcion");
     
     public JTextField TxtCodigo = new JTextField();
     public JTextField TxtNombre = new JTextField();
     public JTextField TxtPrecio = new JTextField();
     public JTextField TxtDescripcion = new JTextField();
     
     public JComboBox ComboPresentacion = new JComboBox();
     
     public JButton BtnGuardar = new JButton("Guardar");
     public JButton BtnBuscar = new JButton("Buscar");
     public JButton BtnEliminar = new JButton("Eliminar");
     public JButton BtnActualizar = new JButton("Actualizar");
     public JButton BtnSalir = new JButton("Salir");
     
     
     
     public VistaProductos(JFrame jFrame, boolean b){
         configuracion();
         menu();
     }
 

	private void configuracion() {
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
         this.setSize(600, 450); 
         this.setLocationRelativeTo(null); 
         this.getContentPane().setBackground(new Color(32, 132, 185));
         this.setTitle("ABC de productos");
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
        
        LblCodigo.setBounds(165, 75, 50, 20);
        LblCodigo.setForeground(Color.WHITE);
        this.add(LblCodigo);
        
        TxtCodigo.setBounds(220, 70, 200, 30);
        this.add(TxtCodigo);
        
        LblNombre.setBounds(160, 125, 50, 20);
        LblNombre.setForeground(Color.WHITE);
        this.add(LblNombre);
        
        TxtNombre.setBounds(220, 120, 200, 30);
        this.add(TxtNombre);
        
        LblPrecio.setBounds(165, 175, 50, 20);
        LblPrecio.setForeground(Color.WHITE);
        this.add(LblPrecio);
        
        TxtPrecio.setBounds(220, 170, 200, 30);
        this.add(TxtPrecio);
        
        
        LblDescripcion.setBounds(130, 225, 90, 20);
        LblDescripcion.setForeground(Color.WHITE);
        this.add(LblDescripcion);
        
        TxtDescripcion.setBounds(220, 220, 200, 30);
        this.add(TxtDescripcion);
        
        LblPresentacion.setBounds(125, 275, 90, 20);
        LblPresentacion.setForeground(Color.WHITE);
        this.add(LblPresentacion);
        
        ComboPresentacion.setBounds(220, 270, 200, 30);
        // ComboPresentacion.addItem("---Elige Uno---");
        // ComboPresentacion.addItem("bolsa");
        // ComboPresentacion.addItem("caja");
        // ComboPresentacion.addItem("botella");
        // ComboPresentacion.addItem("carton");
        this.add(ComboPresentacion);
        
        BtnGuardar.setBounds(20, 340, 100, 30);
        this.add(BtnGuardar);
        
        BtnBuscar.setBounds(130, 340, 100, 30);
        this.add(BtnBuscar);
        
        BtnEliminar.setBounds(240, 340, 100, 30);
        this.add(BtnEliminar);
        
        BtnActualizar.setBounds(350, 340, 100, 30);
        this.add(BtnActualizar);
        
        BtnSalir.setBounds(460, 340, 100, 30);
        this.add(BtnSalir);
     }
     
}
