package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo.ConsultasProducto;
import modelo.ModeloProducto;
import vista.VistaProductos;

public class ControladorVistaProducto implements MouseListener{
    private VistaProductos VistaProductos;
    private ModeloProducto ModeloProducto;
    
    private ConsultasProducto ConsultasProducto = new ConsultasProducto();
    
    public ControladorVistaProducto(ModeloProducto ModeloProducto, VistaProductos VistaProductos){
        this.VistaProductos = VistaProductos;
        this.ModeloProducto = ModeloProducto;
        oyentes();
        VistaProductos.setVisible(true);
        llenarComboPresentacion();
    }
    
    private void oyentes() {
        VistaProductos.BtnSalir.addMouseListener(this);
        VistaProductos.BtnGuardar.addMouseListener(this);
        VistaProductos.BtnEliminar.addMouseListener(this);
        VistaProductos.BtnActualizar.addMouseListener(this);
        VistaProductos.BtnBuscar.addMouseListener(this);
        VistaProductos.LblSearch.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VistaProductos.BtnGuardar){
            guardar();
        }else if (e.getSource() == VistaProductos.BtnActualizar){
            modificar();
        } else if (e.getSource() == VistaProductos.BtnEliminar){
            eliminar();
        } else if (e.getSource() == VistaProductos.BtnBuscar){
            buscar();
        } else if (e.getSource() == VistaProductos.BtnSalir){
            salir();
        } else if (e.getSource()==VistaProductos.LblSearch){
            //Pendiente
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
        if (e.getSource() == VistaProductos.BtnSalir){
            VistaProductos.BtnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaProductos.BtnGuardar){
            VistaProductos.BtnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaProductos.BtnBuscar){
            VistaProductos.BtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaProductos.BtnEliminar){
            VistaProductos.BtnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaProductos.BtnActualizar){
            VistaProductos.BtnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    
    private void llenarModeloConVista() {
        ModeloProducto.setCodigo(Integer.parseInt(VistaProductos.TxtCodigo.getText()));
        ModeloProducto.setDescripcion(VistaProductos.TxtDescripcion.getText());
        ModeloProducto.setPrecio(Float.parseFloat(VistaProductos.TxtPrecio.getText()));
        ModeloProducto.setNombre(VistaProductos.ComboPresentacion.getSelectedItem().toString());       
        ModeloProducto.setPresentacion(ConsultasProducto.obtenerPresentacionNumerica(ModeloProducto.getNombre()));
     }
    
    private void llenarVistaConModelo() {
        VistaProductos.TxtCodigo.setText(ModeloProducto.getCodigo()+"");
        VistaProductos.TxtDescripcion.setText(ModeloProducto.getDescripcion());
        VistaProductos.TxtPrecio.setText(ModeloProducto.getPrecio()+"");
        VistaProductos.ComboPresentacion.setSelectedItem(ModeloProducto.getNombre());
    }
    
    private void limpiarCampos() {
        VistaProductos.TxtCodigo.setText("");
        VistaProductos.TxtDescripcion.setText("");
        VistaProductos.TxtPrecio.setText("");
        VistaProductos.TxtCodigo.requestFocus();
    }
    
    private boolean validarCampoCodigo() {
        if (VistaProductos.TxtCodigo.getText().isEmpty()) 
           return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos() {
        if (VistaProductos.TxtCodigo.getText().isEmpty()||
            VistaProductos.TxtDescripcion.getText().isEmpty()||
            VistaProductos.TxtPrecio.getText().isEmpty())
            return false;
        else
            return true;
    }
    
    private void llenarComboPresentacion() {
        ConsultasProducto.llenarComboPresentacion(VistaProductos.ComboPresentacion);
    }
    
    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloProducto.setCodigo(Integer.parseInt(VistaProductos.TxtCodigo.getText()));
            if (ConsultasProducto.buscar(ModeloProducto)==true) {
                JOptionPane.showMessageDialog(VistaProductos,"Ese producto ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasProducto.insertar(ModeloProducto)==true) {
                    JOptionPane.showMessageDialog(null,"Registro guardado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"El campo codigo no debe estar vacio");
                    
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe estar vacio");
            
        }
    }
    
    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            ModeloProducto ModeloTemporal = new ModeloProducto();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaProductos.TxtCodigo.getText()));
            
            if (ConsultasProducto.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaProductos,"Ese producto no existe");
            }else{
                if (ConsultasProducto.modificar(ModeloProducto)) {
                   JOptionPane.showMessageDialog(VistaProductos,"Registro modificado correctamente");
                   limpiarCampos();
               }else{
                    JOptionPane.showMessageDialog(null,"Error al modificar el registro");
                }
            }
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Los campos no deben estar vacíos");
        }
    }
    
    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloProducto.setCodigo(Integer.parseInt(VistaProductos.TxtCodigo.getText()));
            if (ConsultasProducto.buscar(ModeloProducto)==false) {
               JOptionPane.showMessageDialog(VistaProductos,"Ese producto no existe");
            }else{
                if (ConsultasProducto.eliminar(ModeloProducto)) {
                    JOptionPane.showMessageDialog(VistaProductos,"Registro eliminado correctamente");
                   limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaProductos,"Error al eliminar el registro");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null,"El campo codigo no debe de estar vacio");
        }
    }
    
    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloProducto.setCodigo(Integer.parseInt(VistaProductos.TxtCodigo.getText()));
            if (ConsultasProducto.buscar(ModeloProducto)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaProductos,"registro no existe");
            }  
        }else{
            JOptionPane.showConfirmDialog(null,"Los campos no debe de estar vacio");
        }
    }
    
    private void salir(){
        int opc = JOptionPane.showConfirmDialog(VistaProductos,"¿Deseas salir de productos?","ALERTA!",0,1);
        if (opc == 0)VistaProductos.dispose(); {
            
        }
    }
    
    public static void main(String[] args){
        VistaProductos v = new VistaProductos(null, false);
        ModeloProducto m = new ModeloProducto();
        ControladorVistaProducto p = new ControladorVistaProducto(m,v);
    }
    
}
