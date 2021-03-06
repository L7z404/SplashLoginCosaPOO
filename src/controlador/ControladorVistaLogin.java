package controlador;

import vista.VistaLogin;
import vista.VistaPantallaPrincipal;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.System.Logger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;

import java.awt.Cursor;

public class ControladorVistaLogin implements MouseListener{
    VistaLogin VistaLogin;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario(); //Objeto para consultas
    
    public ControladorVistaLogin(VistaLogin VistaLogin, ModeloUsuario ModeloUsuario){
        this.VistaLogin = VistaLogin;
        this.ModeloUsuario = ModeloUsuario;
        oyentes();
        VistaLogin.setVisible(true);
        VistaLogin.LblVerContra.setVisible(false);
    }

    private void oyentes() {
        VistaLogin.LblOcutarContra.addMouseListener(this);
        VistaLogin.LblVerContra.addMouseListener(this);
        VistaLogin.LblPassword.addMouseListener(this);
        VistaLogin.BtnCerrar.addMouseListener(this);
        VistaLogin.BtnLogin.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==VistaLogin.BtnCerrar){
            // VistaLogin.dispose();
            System.exit(0);
        }else if(e.getSource()==VistaLogin.BtnLogin){
            try {
                buscarUsuarioPassword();
            } catch (NoSuchAlgorithmException e1) {
                // TODO Auto-generated catch block
                System.getLogger(ControladorVistaLogin.class.getName()).log(null, e1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblOcutarContra) {
            VistaLogin.LblOcutarContra.setVisible(false);
            VistaLogin.LblVerContra.setVisible(true);
            VistaLogin.TxtPassword.setEchoChar((char)0);
        } 
        

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblOcutarContra) {
            VistaLogin.LblVerContra.setVisible(false);
            VistaLogin.LblOcutarContra.setVisible(true);
            VistaLogin.TxtPassword.setEchoChar('*');
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblOcutarContra) {
            VistaLogin.LblOcutarContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaLogin.LblVerContra) {
            VistaLogin.LblVerContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    
    //Funcion que retorna verdadero si los campos no estan vacios
    public boolean camposValidos(){
        //Cheka si estan vacios o no los campos de texo usuario y password
        if(VistaLogin.TxtUsuario.getText().isEmpty() || VistaLogin.TxtPassword.getPassword().length==0){
            return false; //Los campos estan vacios
        }else{
            return true; //Los campos no estan vacios
        }
    }
    
    private void llenarModeloConCampos() throws NoSuchAlgorithmException{
        ModeloUsuario.setUsuario(VistaLogin.TxtUsuario.getText());
        
        //Encripta la pass
        String PasswordSinEncriptar = new String(VistaLogin.TxtPassword.getPassword());
        String PassEncriptado = encriptarPassword(PasswordSinEncriptar);
        // System.out.println(encriptarPassword(PasswordSinEncriptar));
        
        
        
        ModeloUsuario.setPassword(PassEncriptado);
        ModeloUsuario.setNombre(""); //No se conoce
        ModeloUsuario.setTipo(""); //No se conoce
    }
    
    //Metodo que ahce una busqueda del usuario y password en la base de datos
    private void buscarUsuarioPassword() throws NoSuchAlgorithmException{
        if(camposValidos()==true){ //Hay texto en los campos
            llenarModeloConCampos(); //Para que lleve la informaicon ue necesita la consulta sql
            if(ConsultasUsuario.buscarLogin(ModeloUsuario)==true){ //Si encontro al usuairo
                //El ModeloUsuario y alleno sus campos faltantes con la busqueda (nombre y tipo)
                //Ya solo desplegarlos y dar la bienvenida
                
                final JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);    
                JOptionPane.showMessageDialog(dialog, "Bienvenido: "+ModeloUsuario.getNombre(), "Tipo: "+ModeloUsuario.getTipo(), 1);
                
                // JOptionPane.showMessageDialog(null, "Bienvenido: "+ModeloUsuario.getNombre(), "Tipo: "+ModeloUsuario.getTipo(), 1); 
                //1 = tipo de icono.
                
                
                
                //Liberar la ventana del login
                VistaLogin.dispose();
                
                //Crear el Modelo Vista de la pantalla principal
                VistaPantallaPrincipal VistaPantallaPrincipal = new VistaPantallaPrincipal();
                ControladorVistaPantallaPrincipal ControladorVistaPantallaPrincipal = new ControladorVistaPantallaPrincipal(VistaPantallaPrincipal);
                
                if (!(ModeloUsuario.getTipo().equals("SuperAdministrador"))) {
                    VistaPantallaPrincipal.BarraDeMenu.remove(VistaPantallaPrincipal.user);
                }
                
            }else{ //usuario no existe o contraseña incorrecta
                final JDialog dialog1 = new JDialog();
                dialog1.setAlwaysOnTop(true);    
                JOptionPane.showConfirmDialog(dialog1, "Usuario o Password Incorrectos", "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                // JOptionPane.showConfirmDialog(null, "Usuario o Password Incorrectos");
            }
        }else{ //Algun campo esta vacio o ambos (usuario/password)
            final JDialog dialog2 = new JDialog();
            dialog2.setAlwaysOnTop(true);    
            JOptionPane.showConfirmDialog(dialog2, "Debes de colocar texto en los campos","Usuario o Password Vacio", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            
            // JOptionPane.showConfirmDialog(null, "Debes de colocar texto en los campos"+"usuario y password");
        }
    }
    
    private String encriptarPassword(String Password) throws NoSuchAlgorithmException{
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(Password.getBytes(), 0, Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }
}
