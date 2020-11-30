package vista;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaBusquedaEmpleadoPorDescripcion extends JDialog {
    JLabel LblNombre = new JLabel("Empleado a buscar");
    public JTextField TxtNombre = new JTextField();
    public JButton BtnAceptar = new JButton("Aceptar");

    // Tabla donde se visualiza la barra de desplazamiento vertical
    public JTable Tabla = new JTable();
    JScrollPane ScrollTabla = new JScrollPane(Tabla);

    public VistaBusquedaEmpleadoPorDescripcion(Frame owner, boolean modal) {
    super(owner, modal);
    configuracionInicial();
    agregarComponentes();
}


    private void configuracionInicial() {
        // this.setSize(430,320);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    private void agregarComponentes() {
        LblNombre.setBounds(10,15,150,40);
        TxtNombre.setBounds(140,15,200,40);
        ScrollTabla.setBounds(20,70,550,200);
        BtnAceptar.setBounds(240,290,120,40);
        
        //agregar al frame
        this.add(LblNombre);
        this.add(TxtNombre);
        this.add(ScrollTabla);//El scroll lleva implicita la tabla
        this.add(BtnAceptar);
    }
    
    // public static void main(String[] args){
    //     VistaBusquedaEmpleadoPorDescripcion ve = new VistaBusquedaEmpleadoPorDescripcion(new JFrame(), false);
    //     ve.setVisible(true);
    // }

}
