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
         this.getContentPane().setBackground(new Color(32, 132, 185));
         this.setTitle("ABC de Empleados");
         this.setResizable(false);
         this.setLayout(null);
     }
     
     
     private void menu() {
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("serif", Font.BOLD, 20));
        titulo.setBounds(225, 10, 200, 30);
        this.add(titulo);
        
        
        LblSearch.setBounds(135, 75, 25, 25);
        this.add(LblSearch);
        
        LblIDEmpleado.setBounds(165, 75, 50, 20);
        LblIDEmpleado.setForeground(Color.WHITE);
        this.add(LblIDEmpleado);
        
        TxtIDEmpleado.setBounds(220, 70, 200, 30);
        this.add(TxtIDEmpleado);
        
        LblNombre.setBounds(160, 125, 50, 20);
        LblNombre.setForeground(Color.WHITE);
        this.add(LblNombre);
        
        TxtNombre.setBounds(220, 120, 200, 30);
        this.add(TxtNombre);
        
        LblCalle.setBounds(165, 175, 50, 20);
        LblCalle.setForeground(Color.WHITE);
        this.add(LblCalle);
        
        TxtCalle.setBounds(220, 170, 200, 30);
        this.add(TxtCalle);
        
        
        LblMunicipio.setBounds(130, 225, 90, 20);
        LblMunicipio.setForeground(Color.WHITE);
        this.add(LblMunicipio);
        
        TxtMunicipio.setBounds(220, 220, 200, 30);
        this.add(TxtMunicipio);
        
        LblCiudad.setBounds(130, 275, 90, 20);
        LblCiudad.setForeground(Color.WHITE);
        this.add(LblCiudad);
        
        TxtCiudad.setBounds(220, 270, 200, 30);
        this.add(TxtCiudad);
        
        LblCP.setBounds(130, 325, 90, 20);
        LblCP.setForeground(Color.WHITE);
        this.add(LblCP);
        
        TxtCP.setBounds(220, 320, 200, 30);
        this.add(TxtCP);
        
        
        LblTelefono.setBounds(130, 375, 90, 20);
        LblTelefono.setForeground(Color.WHITE);
        this.add(LblTelefono);
        
        TxtTelefono.setBounds(220, 370, 200, 30);
        this.add(TxtTelefono);
        
        LblCargo.setBounds(130, 425, 90, 20);
        LblCargo.setForeground(Color.WHITE);
        this.add(LblCargo);
        
        TxtCargo.setBounds(220, 420, 200, 30);
        this.add(TxtCargo);
        
        
        LblFechaIngreso.setBounds(470, 75, 90, 20);
        LblFechaIngreso.setForeground(Color.WHITE);
        this.add(LblFechaIngreso);
        
        TxtFechaIngreso.setBounds(560, 70, 200, 30);
        this.add(TxtFechaIngreso);
        
        LblSueldo.setBounds(470, 125, 90, 20);
        LblSueldo.setForeground(Color.WHITE);
        this.add(LblSueldo);
        
        TxtSueldo.setBounds(560, 120, 200, 30);
        this.add(TxtSueldo);
        
        LblHoraEntrada.setBounds(470, 175, 90, 20);
        LblHoraEntrada.setForeground(Color.WHITE);
        this.add(LblHoraEntrada);
        
        TxtHoraEntrada.setBounds(560, 170, 200, 30);
        this.add(TxtHoraEntrada);
        
        
        LblHoraSalida.setBounds(470, 225, 90, 20);
        LblHoraSalida.setForeground(Color.WHITE);
        this.add(LblHoraSalida);
        
        TxtHoraSalida.setBounds(560, 220, 200, 30);
        this.add(TxtHoraSalida);
        
        
        LblCorreo.setBounds(470, 275, 90, 20);
        LblCorreo.setForeground(Color.WHITE);
        this.add(LblCorreo);
        
        TxtCorreo.setBounds(560, 270, 200, 30);
        this.add(TxtCorreo);
        
        
        LblPuesto.setBounds(125, 470, 90, 20);
        LblPuesto.setForeground(Color.WHITE);
        this.add(LblPuesto);
        
        ComboPuesto.setBounds(220, 470, 200, 30);
        // ComboPresentacion.addItem("---Elige Uno---");
        // ComboPresentacion.addItem("bolsa");
        // ComboPresentacion.addItem("caja");
        // ComboPresentacion.addItem("botella");
        // ComboPresentacion.addItem("carton");
        this.add(ComboPuesto);
        
        BtnGuardar.setBounds(20, 520, 100, 30);
        this.add(BtnGuardar);
        
        BtnBuscar.setBounds(130, 520, 100, 30);
        this.add(BtnBuscar);
        
        BtnEliminar.setBounds(240, 520, 100, 30);
        this.add(BtnEliminar);
        
        BtnActualizar.setBounds(350, 520, 100, 30);
        this.add(BtnActualizar);
        
        BtnSalir.setBounds(460, 520, 100, 30);
        this.add(BtnSalir);
     }
     
    //  public static void main(String[] args){
    //      VistaEmpleado ve = new VistaEmpleado(new JFrame(), true);
    //      ve.setVisible(true);
    //  }
     
}
