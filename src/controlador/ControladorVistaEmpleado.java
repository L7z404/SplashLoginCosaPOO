package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.ConsultasEmpleado;
import modelo.ConsultasProducto;
import modelo.ModeloEmpleado;
import modelo.ModeloProducto;
import modelo.ModeloTablaEmpleados;
import modelo.ModeloTablaProductos;
// import sun.jvm.hotspot.opto.RootNode;
import vista.VistaBusquedaEmpleadoPorDescripcion;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaEmpleado;
import vista.VistaProductos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorVistaEmpleado implements MouseListener, KeyListener {
    private VistaEmpleado VistaEmpleado;
    private ModeloEmpleado ModeloEmpleado;

    private ConsultasEmpleado ConsultasEmpleado = new ConsultasEmpleado();

    public ControladorVistaEmpleado(ModeloEmpleado ModeloEmpleado, VistaEmpleado VistaEmpleado) {
        this.VistaEmpleado = VistaEmpleado;
        this.ModeloEmpleado = ModeloEmpleado;
        oyentes();
        VistaEmpleado.setVisible(true);
        llenarComboPresentacion();
    }

    private void oyentes() {
        //Oyentes Mouse
        VistaEmpleado.BtnSalir.addMouseListener(this);
        VistaEmpleado.BtnGuardar.addMouseListener(this);
        VistaEmpleado.BtnEliminar.addMouseListener(this);
        VistaEmpleado.BtnActualizar.addMouseListener(this);
        VistaEmpleado.BtnBuscar.addMouseListener(this);
        VistaEmpleado.LblSearch.addMouseListener(this);

        //Oyentes teclado
        VistaEmpleado.TxtIDEmpleado.addKeyListener(this);
        VistaEmpleado.TxtNombre.addKeyListener(this);
        VistaEmpleado.TxtCalle.addKeyListener(this);
        VistaEmpleado.TxtColonia.addKeyListener(this);
        VistaEmpleado.TxtMunicipio.addKeyListener(this);
        VistaEmpleado.TxtCiudad.addKeyListener(this);
        VistaEmpleado.TxtCP.addKeyListener(this);
        VistaEmpleado.TxtTelefono.addKeyListener(this);
        VistaEmpleado.TxtCargo.addKeyListener(this);
        VistaEmpleado.TxtFechaIngreso.addKeyListener(this);
        VistaEmpleado.TxtSueldo.addKeyListener(this);
        VistaEmpleado.TxtHoraEntrada.addKeyListener(this);
        VistaEmpleado.TxtHoraSalida.addKeyListener(this);
        VistaEmpleado.TxtCorreo.addKeyListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VistaEmpleado.BtnGuardar) {
            guardar();
        } else if (e.getSource() == VistaEmpleado.BtnActualizar) {
            modificar();
        } else if (e.getSource() == VistaEmpleado.BtnEliminar) {
            eliminar();
        } else if (e.getSource() == VistaEmpleado.BtnBuscar) {
            buscar();
        } else if (e.getSource() == VistaEmpleado.BtnSalir) {
            salir();
        } else if (e.getSource() == VistaEmpleado.LblSearch) {
            busquedaMVC(); // MVC para buscar en una tabla todos los productos
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VistaEmpleado.BtnSalir) {
            VistaEmpleado.BtnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaEmpleado.BtnGuardar) {
            VistaEmpleado.BtnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaEmpleado.BtnBuscar) {
            VistaEmpleado.BtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaEmpleado.BtnEliminar) {
            VistaEmpleado.BtnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaEmpleado.BtnActualizar) {
            VistaEmpleado.BtnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    private void llenarModeloConVista() {
        ModeloEmpleado.setIDEmpleado(Integer.parseInt(VistaEmpleado.TxtIDEmpleado.getText()));
        ModeloEmpleado.setNombreEmp(VistaEmpleado.TxtNombre.getText());
        // ModeloEmpleado.setPrecio(Float.parseFloat(VistaEmpleado.TxtPrecio.getText()));
        ModeloEmpleado.setCalle(VistaEmpleado.TxtCalle.getText());
        ModeloEmpleado.setColonia(VistaEmpleado.TxtColonia.getText());
        ModeloEmpleado.setMunicipio(VistaEmpleado.TxtMunicipio.getText());
        ModeloEmpleado.setCiudad(VistaEmpleado.TxtCiudad.getText());
        ModeloEmpleado.setCP(Integer.parseInt(VistaEmpleado.TxtCP.getText()));
        ModeloEmpleado.setTelefono(VistaEmpleado.TxtTelefono.getText());
        ModeloEmpleado.setCargo(VistaEmpleado.TxtCargo.getText());
        ModeloEmpleado.setFechaIngreso(VistaEmpleado.TxtFechaIngreso.getText());
        ModeloEmpleado.setSueldo(Float.parseFloat(VistaEmpleado.TxtSueldo.getText()));
        ModeloEmpleado.setHoraEntrada(VistaEmpleado.TxtHoraEntrada.getText());
        ModeloEmpleado.setHoraSalida(VistaEmpleado.TxtHoraSalida.getText());
        ModeloEmpleado.setCorreo(VistaEmpleado.TxtCorreo.getText());
        
        
        
        
        ModeloEmpleado.setNombre(VistaEmpleado.ComboPuesto.getSelectedItem().toString());
        ModeloEmpleado.setPuesto(ConsultasEmpleado.obtenerPresentacionNumerica(ModeloEmpleado.getNombre()));
    }

    private void llenarVistaConModelo() {
        VistaEmpleado.TxtIDEmpleado.setText(ModeloEmpleado.getIDEmpleado() + "");
        VistaEmpleado.TxtNombre.setText(ModeloEmpleado.getNombreEmp());
        VistaEmpleado.TxtCalle.setText(ModeloEmpleado.getCalle() + "");
        VistaEmpleado.TxtColonia.setText(ModeloEmpleado.getColonia() + "");
        VistaEmpleado.TxtMunicipio.setText(ModeloEmpleado.getMunicipio() + "");
        VistaEmpleado.TxtCiudad.setText(ModeloEmpleado.getCiudad() + "");
        VistaEmpleado.TxtCP.setText(ModeloEmpleado.getCP() + "");
        VistaEmpleado.TxtTelefono.setText(ModeloEmpleado.getTelefono() + "");
        VistaEmpleado.TxtCargo.setText(ModeloEmpleado.getCargo() + "");
        VistaEmpleado.TxtFechaIngreso.setText(ModeloEmpleado.getFechaIngreso() + "");
        VistaEmpleado.TxtSueldo.setText(ModeloEmpleado.getSueldo() + "");
        VistaEmpleado.TxtHoraEntrada.setText(ModeloEmpleado.getHoraEntrada() + "");
        VistaEmpleado.TxtHoraSalida.setText(ModeloEmpleado.getHoraSalida() + "");
        VistaEmpleado.TxtCorreo.setText(ModeloEmpleado.getCorreo() + "");
        
        VistaEmpleado.ComboPuesto.setSelectedItem(ModeloEmpleado.getNombre());
    }

    private void limpiarCampos() {
        VistaEmpleado.TxtIDEmpleado.setText("");
        VistaEmpleado.TxtNombre.setText("");
        VistaEmpleado.TxtCalle.setText("");
        VistaEmpleado.TxtColonia.setText("");
        VistaEmpleado.TxtMunicipio.setText("");
        VistaEmpleado.TxtCiudad.setText("");
        VistaEmpleado.TxtCP.setText("");
        VistaEmpleado.TxtTelefono.setText("");
        VistaEmpleado.TxtCargo.setText("");
        VistaEmpleado.TxtFechaIngreso.setText("");
        VistaEmpleado.TxtSueldo.setText("");
        VistaEmpleado.TxtHoraEntrada.setText("");
        VistaEmpleado.TxtHoraSalida.setText("");
        VistaEmpleado.TxtCorreo.setText("");
        
        
        VistaEmpleado.TxtIDEmpleado.requestFocus();
    }

    private boolean validarCampoCodigo() {
        if (VistaEmpleado.TxtIDEmpleado.getText().isEmpty())
            return false;
        else
            return true;
    }

    //Completar este
    private boolean validarTodosLosCampos() {
        if (VistaEmpleado.TxtIDEmpleado.getText().isEmpty() || VistaEmpleado.TxtNombre.getText().isEmpty()
                || VistaEmpleado.TxtCalle.getText().isEmpty() || VistaEmpleado.TxtColonia.getText().isEmpty()
                || VistaEmpleado.TxtMunicipio.getText().isEmpty() || VistaEmpleado.TxtCiudad.getText().isEmpty()
                || VistaEmpleado.TxtCP.getText().isEmpty() || VistaEmpleado.TxtTelefono.getText().isEmpty()
                || VistaEmpleado.TxtCargo.getText().isEmpty() || VistaEmpleado.TxtFechaIngreso.getText().isEmpty()
                || VistaEmpleado.TxtSueldo.getText().isEmpty() || VistaEmpleado.TxtHoraEntrada.getText().isEmpty()
                || VistaEmpleado.TxtHoraSalida.getText().isEmpty() || VistaEmpleado.TxtCorreo.getText().isEmpty())
            return false;
        else
            return true;
    }

    private void llenarComboPresentacion() {
        ConsultasEmpleado.llenarComboPresentacion(VistaEmpleado.ComboPuesto);
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloEmpleado.setIDEmpleado(Integer.parseInt(VistaEmpleado.TxtIDEmpleado.getText()));
            if (ConsultasEmpleado.buscar(ModeloEmpleado) == true) {
                JOptionPane.showMessageDialog(VistaEmpleado, "Ese empleado ya existe");
            } else {
                llenarModeloConVista();
                if (ConsultasEmpleado.insertar(ModeloEmpleado) == true) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "El campo ID no debe estar vacio");

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "El campo ID no debe estar vacio");

        }
    }

    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();

            ModeloEmpleado ModeloTemporal = new ModeloEmpleado();
            ModeloTemporal.setIDEmpleado(Integer.parseInt(VistaEmpleado.TxtIDEmpleado.getText()));

            if (ConsultasEmpleado.buscar(ModeloTemporal) == false) {
                JOptionPane.showMessageDialog(VistaEmpleado, "Ese empleado no existe");
            } else {
                if (ConsultasEmpleado.modificar(ModeloEmpleado)) {
                    JOptionPane.showMessageDialog(VistaEmpleado, "Registro modificado correctamente");
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
            ModeloEmpleado.setIDEmpleado(Integer.parseInt(VistaEmpleado.TxtIDEmpleado.getText()));
            if (ConsultasEmpleado.buscar(ModeloEmpleado) == false) {
                JOptionPane.showMessageDialog(VistaEmpleado, "Ese empleado no existe");
            } else {
                if (ConsultasEmpleado.eliminar(ModeloEmpleado)) {
                    JOptionPane.showMessageDialog(VistaEmpleado, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaEmpleado, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo ID no debe de estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloEmpleado.setIDEmpleado(Integer.parseInt(VistaEmpleado.TxtIDEmpleado.getText()));
            if (ConsultasEmpleado.buscar(ModeloEmpleado) == true) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(VistaEmpleado, "registro no existe");
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Los campos no debe de estar vacio");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaEmpleado, "¿Deseas salir de Empleados?", "ALERTA!", 0, 1);
        if (opc == 0)
            VistaEmpleado.dispose();
        {

        }
    }

    public static void main(String[] args) {
        VistaEmpleado v = new VistaEmpleado(null, false);
        ModeloEmpleado m = new ModeloEmpleado();
        ControladorVistaEmpleado p = new ControladorVistaEmpleado(m, v);
    }
    
    private void busquedaMVC() {
        //Crear el MCV para la ventana modal de bisqueda + el modelo tabla
       ModeloTablaEmpleados modeloTablaEmpleados = new ModeloTablaEmpleados();
       VistaBusquedaEmpleadoPorDescripcion vistaBusquedaEmpleadoPorDescripcion = new VistaBusquedaEmpleadoPorDescripcion(new JFrame(), true); //original
       
       //controlado
       ControladorVistaBusquedaEmpleadoPorDescripcion ControladorSearch = new ControladorVistaBusquedaEmpleadoPorDescripcion(modeloTablaEmpleados,ModeloEmpleado,
       vistaBusquedaEmpleadoPorDescripcion);
       
       llenarVistaConModelo();//el modelo ya trae los datos del registro seleccionado
   }

   @Override
   public void keyTyped(KeyEvent e) {
    //    if (e.getSource() == VistaEmpleado.TxtIDEmpleado) {
    //        if (e.getKeyChar() == e.VK_ENTER) {
    //            VistaEmpleado.TxtNombre.requestFocus();
    //        }
    //    }
    
    

   }

   //Terminar Estas Validaciones y las de Usuarios
   //Acomodar diseño si hay chanza
   @Override
   public void keyPressed(KeyEvent e) {
       //IDEmpleado
       if (e.getSource() == VistaEmpleado.TxtIDEmpleado) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoEntero(VistaEmpleado.TxtIDEmpleado.getText(), 11) == true) {
                    VistaEmpleado.TxtNombre.requestFocus();
                }else{
                    VistaEmpleado.TxtIDEmpleado.setText("");
                }
            }
       }
       
       
       
       //Nombre
       if (e.getSource() == VistaEmpleado.TxtNombre) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(VistaEmpleado.TxtNombre.getText(), 45) == true) {
                    VistaEmpleado.TxtCalle.requestFocus();
                }else{
                    VistaEmpleado.TxtNombre.setText("");
                }
            }
        }
        
        //Calle
        if (e.getSource() == VistaEmpleado.TxtCalle) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(VistaEmpleado.TxtCalle.getText(), 45) == true) {
                    VistaEmpleado.TxtColonia.requestFocus();
                }else{
                    VistaEmpleado.TxtCalle.setText("");
                }
            }
        }
        
        //Colonia
        if (e.getSource() == VistaEmpleado.TxtColonia) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(VistaEmpleado.TxtColonia.getText(), 45) == true) {
                    VistaEmpleado.TxtMunicipio.requestFocus();
                }else{
                    VistaEmpleado.TxtColonia.setText("");
                }
            }
        }
        
        //Municipio
        if (e.getSource() == VistaEmpleado.TxtMunicipio) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(VistaEmpleado.TxtMunicipio.getText(), 45) == true) {
                    VistaEmpleado.TxtCiudad.requestFocus();
                }else{
                    VistaEmpleado.TxtMunicipio.setText("");
                }
            }
        }
        
        //Ciudad
        if (e.getSource() == VistaEmpleado.TxtCiudad) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(VistaEmpleado.TxtCiudad.getText(), 45) == true) {
                    VistaEmpleado.TxtCP.requestFocus();
                }else{
                    VistaEmpleado.TxtCiudad.setText("");
                }
            }
        }
        
        //CP
        if (e.getSource() == VistaEmpleado.TxtCP) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoEntero(VistaEmpleado.TxtCP.getText(), 11) == true) {
                    VistaEmpleado.TxtTelefono.requestFocus();
                }else{
                    VistaEmpleado.TxtCP.setText("");
                }
            }
       }
        
        //Telefono
       if (e.getSource() == VistaEmpleado.TxtTelefono) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTel(VistaEmpleado.TxtTelefono.getText(), 12) == true) {
                    VistaEmpleado.TxtCargo.requestFocus();
                }else{
                    VistaEmpleado.TxtTelefono.setText("");
                }
            }
        }
        
        //Cargo
        if (e.getSource() == VistaEmpleado.TxtCargo) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTexto(VistaEmpleado.TxtCargo.getText(), 45) == true) {
                    VistaEmpleado.TxtFechaIngreso.requestFocus();
                }else{
                    VistaEmpleado.TxtCargo.setText("");
                }
            }
        }
       
       //FechaIngreso
       if (e.getSource() == VistaEmpleado.TxtFechaIngreso) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoDate(VistaEmpleado.TxtFechaIngreso.getText()) == true) {
                    VistaEmpleado.TxtSueldo.requestFocus();
                }else{
                    VistaEmpleado.TxtFechaIngreso.setText("");
                }
            }
        }
        
        //Sueldo
        if (e.getSource() == VistaEmpleado.TxtSueldo) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoFloat(VistaEmpleado.TxtSueldo.getText()) == true) {
                    VistaEmpleado.TxtHoraEntrada.requestFocus();
                }else{
                    VistaEmpleado.TxtSueldo.setText("");
                }
            }
        }
        
        //HoraEntrada
       if (e.getSource() == VistaEmpleado.TxtHoraEntrada) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTime(VistaEmpleado.TxtHoraEntrada.getText()) == true) {
                    VistaEmpleado.TxtHoraSalida.requestFocus();
                }else{
                    VistaEmpleado.TxtHoraEntrada.setText("");
                }
            }
        }
        
         //HoraSalida
       if (e.getSource() == VistaEmpleado.TxtHoraSalida) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoTime(VistaEmpleado.TxtHoraSalida.getText()) == true) {
                    VistaEmpleado.TxtCorreo.requestFocus();
                }else{
                    VistaEmpleado.TxtHoraSalida.setText("");
                }
            }
        }
        
          //Correo
       if (e.getSource() == VistaEmpleado.TxtCorreo) {
        if (e.getKeyChar() == e.VK_ENTER) {
            if (validaCampoCorreo(VistaEmpleado.TxtCorreo.getText()) == true) {
                VistaEmpleado.BtnGuardar.requestFocus();
            }else{
                VistaEmpleado.TxtCorreo.setText("");
            }
        }
    }

   }

   @Override
   public void keyReleased(KeyEvent e) {
       // TODO Auto-generated method stub

   }
   
    //Valida numeros
   private boolean validaCampoEntero(String Cadena, int longitud){
       if (Cadena.matches("[0-9, .]+") && Cadena.length()<longitud+1) {
           return true;
       }else{
           JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "Debes de usar solo numeros.\nNo debe de estar vacio el campo y\nla longitud no debe de ser mayor a "+longitud, "¡Alerta!", 0);
           return false;
       }
   }
   
   //Valida floats
   private boolean validaCampoFloat(String Cadena){
    if (Cadena.matches("[+-]?([0-9]*[.])?[0-9]+")) {
        return true;
    }else{
        JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "Debes de usar solo numeros f.\nNo debe de estar vacio el campo", "¡Alerta!", 0);
        return false;
    }
}
   
    /*Valida texto 
     Acepta letras (incluyendo ñ) sin numeros
    */
   private boolean validaCampoTexto(String Cadena, int longitud){
       if (Cadena.matches("[a-z ñ A-Z]+") && Cadena.length()<longitud+1) {
           return true;
       }else{
           JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "Debes de usar solo letras.\nNo debe de estar vacio el campo y\nla longitud no debe de ser mayor a "+longitud, "¡Alerta!", 0);
           return false;
       }
   }
   
   /*Valida fecha aaaa-mm-dd
     Requiere 0s y el año completo
     
     Valido 2020-11-23
     (dia hasta 31)
     (mes hasta 12)
    */
    
   String regexDate = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
   Pattern pattern = Pattern.compile(regexDate);
   
   private boolean validaCampoDate(String Cadena){
        Matcher matcher = pattern.matcher(Cadena);
        if (matcher.matches()) {
                return true;
        }else{
            JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "La fecha esta en el formato incorrecto.\nNo debe de estar vacio el campo y\nel formato debe de ir aaaa-mm-dd \nincluyendo 0s y año completo.", "¡Alerta!", 0);
            return false;
        }
   }
   
    /*Valida tiempo HH-MM-SS
     El 0 inicial es opcional
     
     Valido 2:00:00 || 02:00:00
     
    */
   String regexTime = "^([0-1]?[0-9]|[2][0-3]):([0-5][0-9])(:[0-5][0-9])$";
   Pattern pattern2 = Pattern.compile(regexTime);
   
   private boolean validaCampoTime(String Cadena){
       Matcher matcher = pattern2.matcher(Cadena);
       if(matcher.matches()){
           return true;
       }else{
        JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "La hora esta en el formato incorrecto.\nNo debe de estar vacio el campo y\nel formato debe de ir HH:MM:SS\n el 0 inicial es opcional.", "¡Alerta!", 0);
           return false;
       }
   }
   
   /*Valida correo usuario@dominio.com || usuario@dominio.com.in
     
     No valido
        usuario#dominio.com
        @dominio.com
    */
    String regexCorreo = "^(.+)@(.+)$";
    Pattern pattern3 = Pattern.compile(regexCorreo);
    
    private boolean validaCampoCorreo(String Cadena){
        Matcher matcher = pattern3.matcher(Cadena);
        if(matcher.matches()){
            return true;
        }else{
         JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "El correo esta en el formato incorrecto.\nNo debe de estar vacio el campo y\nel formato debe de ir\nusuario@dominio.com o usuario@dominio.com.in", "¡Alerta!", 0);
            return false;
        }
    }
    
     /*Valida telefono numeros y guion
        
        Valido 375-254-4875
        No valido 3752544875 || 375--2544875
     
     */
   private boolean validaCampoTel(String Cadena, int longitud){
    if (Cadena.matches("^[0-9]([0-9]|-(?!-))+$") && Cadena.length()==12) {
        return true;
    }else{
        JOptionPane.showMessageDialog(VistaEmpleado.getRootPane(), "Debes de usar solo numeros y guiones.\nNo debe de estar vacio el campo.\nEl formato es 000-000-0000 y\nla longitud no debe de ser mayor a\n"+longitud+" incluyendo guiones", "¡Alerta!", 0);
        return false;
    }
}
}
