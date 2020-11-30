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


public class VistaEmpleado extends JDialog {
    VistaPantallaPrincipal VistapantallaPrincipal;

    // Icons
    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search.png"));

    // Cosas
    JLabel titulo = new JLabel("ABC de Empleados");
    public JLabel LblSearch = new JLabel(ImSearch);
    JLabel LblIDEmpleado = new JLabel("IDEmpleado");
    JLabel LblNombre = new JLabel("Nombre");
    JLabel LblCalle = new JLabel("Calle");
    JLabel LblColonia = new JLabel("Colonia");
    JLabel LblMunicipio = new JLabel("Municipio");
    JLabel LblCiudad = new JLabel("Ciudad");
    JLabel LblCP = new JLabel("CP");
    JLabel LblTelefono = new JLabel("Telefono");
    JLabel LblCargo = new JLabel("Cargo");
    JLabel LblFechaIngreso = new JLabel("FechaIngreso");
    JLabel LblSueldo = new JLabel("Sueldo");
    JLabel LblHoraEntrada = new JLabel("HoraEntrada");
    JLabel LblHoraSalida = new JLabel("HoraSalida");
    JLabel LblCorreo = new JLabel("Correo");
    JLabel LblPuesto = new JLabel("Puesto");

    public JTextField TxtIDEmpleado = new JTextField();
    public JTextField TxtNombre = new JTextField();
    public JTextField TxtCalle = new JTextField();
    public JTextField TxtColonia = new JTextField();
    public JTextField TxtMunicipio = new JTextField();
    public JTextField TxtCiudad = new JTextField();
    public JTextField TxtCP = new JTextField();
    public JTextField TxtTelefono = new JTextField();
    public JTextField TxtCargo = new JTextField();
    public JTextField TxtFechaIngreso = new JTextField();
    public JTextField TxtSueldo = new JTextField();
    public JTextField TxtHoraEntrada = new JTextField();
    public JTextField TxtHoraSalida = new JTextField();
    public JTextField TxtCorreo = new JTextField();

    public JComboBox ComboPuesto = new JComboBox();

    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");

    public VistaEmpleado(JFrame jFrame, boolean b) {
         configuracion();
         menu();
     }
 

	private void configuracion() {
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
         this.setSize(800, 600); 
         this.setLocationRelativeTo(null); 
         this.getContentPane().setBackground(new Color(228, 104, 12));
         this.setTitle("ABC de Empleados");
         this.setResizable(false);
         this.setLayout(null);
     }
     
     
     private void menu() {
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("serif", Font.BOLD, 20));
        titulo.setBounds(310, 10, 200, 30);
        this.add(titulo);
        
        
        LblSearch.setBounds(30, 75, 25, 25);
        this.add(LblSearch);
        
        LblIDEmpleado.setBounds(60, 75, 200, 20);
        LblIDEmpleado.setForeground(Color.WHITE);
        this.add(LblIDEmpleado);
        
        TxtIDEmpleado.setBounds(145, 70, 200, 30);
        this.add(TxtIDEmpleado);
        
        LblNombre.setBounds(70, 125, 200, 20);
        LblNombre.setForeground(Color.WHITE);
        this.add(LblNombre);
        
        TxtNombre.setBounds(145, 120, 200, 30);
        this.add(TxtNombre);
        
        LblCalle.setBounds(70, 175, 200, 20);
        LblCalle.setForeground(Color.WHITE);
        this.add(LblCalle);
        
        TxtCalle.setBounds(145, 170, 200, 30);
        this.add(TxtCalle);
        
        
        LblColonia.setBounds(70, 225, 200, 20);
        LblColonia.setForeground(Color.WHITE);
        this.add(LblColonia);
        
        TxtColonia.setBounds(145, 220, 200, 30);
        this.add(TxtColonia);
        
        
        LblMunicipio.setBounds(70, 275, 200, 20);
        LblMunicipio.setForeground(Color.WHITE);
        this.add(LblMunicipio);
        
        TxtMunicipio.setBounds(145, 270, 200, 30);
        this.add(TxtMunicipio);
        
        LblCiudad.setBounds(70, 325, 200, 20);
        LblCiudad.setForeground(Color.WHITE);
        this.add(LblCiudad);
        
        TxtCiudad.setBounds(145, 320, 200, 30);
        this.add(TxtCiudad);
        
        LblCP.setBounds(70, 375, 200, 20);
        LblCP.setForeground(Color.WHITE);
        this.add(LblCP);
        
        TxtCP.setBounds(145, 370, 200, 30);
        this.add(TxtCP);
        
        
        LblTelefono.setBounds(395, 75, 90, 20);
        LblTelefono.setForeground(Color.WHITE);
        this.add(LblTelefono);
        
        TxtTelefono.setBounds(485, 70, 200, 30);
        this.add(TxtTelefono);
        
        LblCargo.setBounds(395, 125, 90, 20);
        LblCargo.setForeground(Color.WHITE);
        this.add(LblCargo);
        
        TxtCargo.setBounds(485, 120, 200, 30);
        this.add(TxtCargo);
        
        
        LblFechaIngreso.setBounds(395, 175, 90, 20);
        LblFechaIngreso.setForeground(Color.WHITE);
        this.add(LblFechaIngreso);
        
        TxtFechaIngreso.setBounds(485, 170, 200, 30);
        this.add(TxtFechaIngreso);
        
        LblSueldo.setBounds(395, 225, 90, 20);
        LblSueldo.setForeground(Color.WHITE);
        this.add(LblSueldo);
        
        TxtSueldo.setBounds(485, 220, 200, 30);
        this.add(TxtSueldo);
        
        LblHoraEntrada.setBounds(395, 275, 90, 20);
        LblHoraEntrada.setForeground(Color.WHITE);
        this.add(LblHoraEntrada);
        
        TxtHoraEntrada.setBounds(485, 270, 200, 30);
        this.add(TxtHoraEntrada);
        
        
        LblHoraSalida.setBounds(395, 325, 90, 20);
        LblHoraSalida.setForeground(Color.WHITE);
        this.add(LblHoraSalida);
        
        TxtHoraSalida.setBounds(485, 320, 200, 30);
        this.add(TxtHoraSalida);
        
        
        LblCorreo.setBounds(395, 375, 90, 20);
        LblCorreo.setForeground(Color.WHITE);
        this.add(LblCorreo);
        
        TxtCorreo.setBounds(485, 370, 200, 30);
        this.add(TxtCorreo);
        
        
        LblPuesto.setBounds(250, 450, 90, 20);
        LblPuesto.setForeground(Color.WHITE);
        this.add(LblPuesto);
        
        ComboPuesto.setBounds(300, 450, 200, 30);
        this.add(ComboPuesto);
        
        BtnGuardar.setBounds(40, 510, 100, 30);
        this.add(BtnGuardar);
        
        BtnBuscar.setBounds(190, 510, 100, 30);
        this.add(BtnBuscar);
        
        BtnEliminar.setBounds(340, 510, 100, 30);
        this.add(BtnEliminar);
        
        BtnActualizar.setBounds(490, 510, 100, 30);
        this.add(BtnActualizar);
        
        BtnSalir.setBounds(640, 510, 100, 30);
        this.add(BtnSalir);
     }
     
    //  public static void main(String[] args){
    //      VistaEmpleado ve = new VistaEmpleado(new JFrame(), true);
    //      ve.setVisible(true);
    //  }
     
}
