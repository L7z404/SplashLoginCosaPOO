package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.ConsultasProducto;
import modelo.ConsultasUsuario;
import modelo.ModeloProducto;
import modelo.ModeloTablaProductos;
import modelo.ModeloTablaUsuarios;
import modelo.ModeloUsuario;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaBusquedaUsuarioPorDescripcion;
// import vista.vistaUsuario;
import vista.VistaUsuario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorVistaUsuario implements MouseListener, KeyListener {
    private VistaUsuario vistaUsuario;
    private ModeloUsuario modeloUsuario;

    private ConsultasUsuario consultasUsuario = new ConsultasUsuario();

    public ControladorVistaUsuario(ModeloUsuario modeloUsuario, VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.modeloUsuario = modeloUsuario;
        oyentes();
        vistaUsuario.setVisible(true);
        // llenarComboPresentacion();
    }

    private void oyentes() {
        //Oyentes mouse
        vistaUsuario.BtnSalir.addMouseListener(this);
        vistaUsuario.BtnGuardar.addMouseListener(this);
        vistaUsuario.BtnEliminar.addMouseListener(this);
        vistaUsuario.BtnActualizar.addMouseListener(this);
        vistaUsuario.BtnBuscar.addMouseListener(this);
        vistaUsuario.LblSearch.addMouseListener(this);
        
        vistaUsuario.LblOcutarPass.addMouseListener(this);
        vistaUsuario.LblVerPass.addMouseListener(this);
        
        //Oyentes teclado
        vistaUsuario.TxtUsuario.addKeyListener(this);
        vistaUsuario.TxtPassword.addKeyListener(this);
        vistaUsuario.TxtNombre.addKeyListener(this);
        vistaUsuario.TxtTipo.addKeyListener(this);
        

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaUsuario.BtnGuardar) {
            try {
                guardar();
            } catch (NoSuchAlgorithmException e1) {
                // TODO Auto-generated catch block
                System.getLogger(ControladorVistaUsuario.class.getName()).log(null, e1);
            }
        } else if (e.getSource() == vistaUsuario.BtnActualizar) {
            try {
                modificar();
            } catch (NoSuchAlgorithmException e1) {
                // TODO Auto-generated catch block
                System.getLogger(ControladorVistaUsuario.class.getName()).log(null, e1);
            }
        } else if (e.getSource() == vistaUsuario.BtnEliminar) {
            eliminar();
        } else if (e.getSource() == vistaUsuario.BtnBuscar) {
            buscar();
        } else if (e.getSource() == vistaUsuario.BtnSalir) {
            salir();
        } else if (e.getSource() == vistaUsuario.LblSearch) {
            busquedaMVC(); // MVC para buscar en una tabla todos los productos
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == vistaUsuario.LblOcutarPass) {
            vistaUsuario.LblOcutarPass.setVisible(false);
            vistaUsuario.LblVerPass.setVisible(true);
            vistaUsuario.TxtPassword.setEchoChar((char)0);
        } 

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == vistaUsuario.LblOcutarPass) {
            vistaUsuario.LblVerPass.setVisible(false);
            vistaUsuario.LblOcutarPass.setVisible(true);
            vistaUsuario.TxtPassword.setEchoChar('*');
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == vistaUsuario.BtnSalir) {
            vistaUsuario.BtnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == vistaUsuario.BtnGuardar) {
            vistaUsuario.BtnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == vistaUsuario.BtnBuscar) {
            vistaUsuario.BtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == vistaUsuario.BtnEliminar) {
            vistaUsuario.BtnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == vistaUsuario.BtnActualizar) {
            vistaUsuario.BtnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == vistaUsuario.LblVerPass) {
            vistaUsuario.LblVerPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == vistaUsuario.LblOcutarPass) {
            vistaUsuario.LblOcutarPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    private void llenarModeloConVista() throws NoSuchAlgorithmException{
        modeloUsuario.setUsuario(vistaUsuario.TxtUsuario.getText());
        
        
        //Encripatod
        String PasswordSinEncriptar = new String(vistaUsuario.TxtPassword.getText());
        String PassEnctriptado = encriptarPassword(PasswordSinEncriptar);
        // System.out.println(encriptarPassword(PasswordSinEncriptar));
        
        modeloUsuario.setPassword(PassEnctriptado);
        modeloUsuario.setNombre(vistaUsuario.TxtNombre.getText());
        modeloUsuario.setTipo(vistaUsuario.TxtTipo.getText());
    }

    private void llenarVistaConModelo() {
        vistaUsuario.TxtUsuario.setText(modeloUsuario.getUsuario() + "");
        vistaUsuario.TxtPassword.setText(modeloUsuario.getPassword());
        vistaUsuario.TxtNombre.setText(modeloUsuario.getNombre() + "");
        vistaUsuario.TxtTipo.setText(modeloUsuario.getTipo() + "");
    }

    private void limpiarCampos() {
        vistaUsuario.TxtUsuario.setText("");
        vistaUsuario.TxtPassword.setText("");
        vistaUsuario.TxtNombre.setText("");
        vistaUsuario.TxtTipo.setText("");
        vistaUsuario.TxtUsuario.requestFocus();
    }

    private boolean validarCampoCodigo() {
        if (vistaUsuario.TxtUsuario.getText().isEmpty())
            return false;
        else
            return true;
    }

    private boolean validarTodosLosCampos() {
        if (vistaUsuario.TxtUsuario.getText().isEmpty() || vistaUsuario.TxtPassword.getText().isEmpty()
                || vistaUsuario.TxtNombre.getText().isEmpty() || vistaUsuario.TxtTipo.getText().isEmpty())
            return false;
        else
            return true;
    }


    private void guardar() throws NoSuchAlgorithmException {
        if (validarTodosLosCampos()) {
            // ModeloUsuario.setCodigo(Integer.parseInt(vistaUsuario.TxtUsuario.getText()));
            modeloUsuario.setUsuario(vistaUsuario.TxtUsuario.getText());
            if (consultasUsuario.buscar(modeloUsuario) == true) {
                JOptionPane.showMessageDialog(vistaUsuario, "Ese usuario ya existe");
            } else {
                llenarModeloConVista();
                if (consultasUsuario.insertar(modeloUsuario) == true) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "El campo codigo no debe estar vacio");

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "El campo usuario no debe estar vacio");

        }
    }

    private void modificar() throws NoSuchAlgorithmException {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();

            ModeloUsuario ModeloTemporal = new ModeloUsuario();
            ModeloTemporal.setUsuario(vistaUsuario.TxtUsuario.getText());

            if (consultasUsuario.buscar(ModeloTemporal) == false) {
                JOptionPane.showMessageDialog(vistaUsuario, "Ese usuario no existe");
            } else {
                if (consultasUsuario.modificar(modeloUsuario)) {
                    JOptionPane.showMessageDialog(vistaUsuario, "Registro modificado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacíos");
        }
    }

    private void eliminar() {
        if (validarCampoCodigo()) {
            modeloUsuario.setUsuario(vistaUsuario.TxtUsuario.getText());
            if (consultasUsuario.buscar(modeloUsuario) == false) {
                JOptionPane.showMessageDialog(vistaUsuario, "Ese usuario no existe");
            } else {
                if (consultasUsuario.eliminar(modeloUsuario)) {
                    JOptionPane.showMessageDialog(vistaUsuario, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(vistaUsuario, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo usuario no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            modeloUsuario.setUsuario(vistaUsuario.TxtUsuario.getText());
            if (consultasUsuario.buscar(modeloUsuario) == true) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(vistaUsuario, "registro no existe");
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(vistaUsuario, "¿Deseas salir de usuarios?", "ALERTA!", 0, 1);
        if (opc == 0)
            vistaUsuario.dispose();
        {

        }
    }

    public static void main(String[] args) {
        VistaUsuario v = new VistaUsuario(null, false);
        ModeloUsuario m = new ModeloUsuario();
        ControladorVistaUsuario p = new ControladorVistaUsuario(m, v);
    }
    
    private void busquedaMVC() {
        //Crear el MCV para la ventana modal de bisqueda + el modelo tabla
       ModeloTablaUsuarios modeloTablaUsuarios = new ModeloTablaUsuarios();
       VistaBusquedaUsuarioPorDescripcion vistaBusquedaUsuarioPorDescripcion = new VistaBusquedaUsuarioPorDescripcion(new JFrame(), true); //original
       
       //controlado
       ControladorVistaBusquedaUsuarioPorDescripcion ControladorSearch = new ControladorVistaBusquedaUsuarioPorDescripcion(modeloTablaUsuarios,modeloUsuario,
       vistaBusquedaUsuarioPorDescripcion);
       
       llenarVistaConModelo();//el modelo ya trae los datos del registro seleccionado
   }
    
   private String encriptarPassword(String Password) throws NoSuchAlgorithmException{
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(Password.getBytes(), 0, Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //usuario
        if (e.getSource() == vistaUsuario.TxtUsuario) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoUser(vistaUsuario.TxtUsuario.getText(), 20) == true) {
                    vistaUsuario.TxtPassword.requestFocus();
                }else{
                    vistaUsuario.TxtUsuario.setText("");
                }
            }
        }
        
        //password
        if (e.getSource() == vistaUsuario.TxtPassword) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoPass(vistaUsuario.TxtPassword.getText(), 40) == true) {
                    vistaUsuario.TxtNombre.requestFocus();
                }else{
                    vistaUsuario.TxtPassword.setText("");
                }
            }
        }
        
        //nombre
        if (e.getSource() == vistaUsuario.TxtNombre) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(vistaUsuario.TxtNombre.getText(), 80) == true) {
                    vistaUsuario.TxtTipo.requestFocus();
                }else{
                    vistaUsuario.TxtNombre.setText("");
                }
            }
        }
        
        //tipo
        if (e.getSource() == vistaUsuario.TxtTipo) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTipo(vistaUsuario.TxtTipo.getText()) == true) {
                    vistaUsuario.BtnGuardar.requestFocus();
                }else{
                    vistaUsuario.TxtTipo.setText("");
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    
    //Valida campos de puro texto incluyendo la ñ
    private boolean validaCampoTexto(String Cadena, int longitud){
        if (Cadena.matches("[a-z ñ A-Z]+") && Cadena.length()<longitud+1) {
            return true;
        }else{
            JOptionPane.showMessageDialog(vistaUsuario.getRootPane(), "Debes de usar solo letras.\nNo debe de estar vacio el campo y\nla longitud no debe de ser mayor a "+longitud, "¡Alerta!", 0);
            return false;
        }
    }
    
    //Valida tipo de user
    //SuperAdministrador || Registrado
    private boolean validaCampoTipo(String Cadena){
        if (Cadena.equals("SuperAdministrador") || Cadena.equals("Registrado")) {
            return true;
        }else{
            JOptionPane.showMessageDialog(vistaUsuario.getRootPane(), "No debe de estar vacio el campo.\nSolo se acepta SuperAdministrador y Registrado", "¡Alerta!", 0);
            return false;
        }
    }
    
    //Valida Alphanumerico para user
    private boolean validaCampoUser(String Cadena, int longitud){
        if (Cadena.matches("^[a-zA-Z0-9]+$") && Cadena.length()<longitud+1) {
            return true;
        }else{
            JOptionPane.showMessageDialog(vistaUsuario.getRootPane(), "Debes de usar solo letras y numeros.\nNo debe de estar vacio el campo y\nla longitud no debe de ser mayor a "+longitud, "¡Alerta!", 0);
            return false;
        }
    }
    
    //Valida password que no este muy largo
    private boolean validaCampoPass(String Cadena, int longitud){
        if (Cadena.length()<longitud+1) {
            return true;
        }else{
            JOptionPane.showMessageDialog(vistaUsuario.getRootPane(), "No debe de estar vacio el campo y\nla longitud no debe de ser mayor a "+longitud, "¡Alerta!", 0);
            return false;
        }
    }
}
