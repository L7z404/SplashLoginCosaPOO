package controlador;

import modelo.ConsultasProducto;
import modelo.ConsultasUsuario;
import modelo.ModeloProducto;
import modelo.ModeloTablaProductos;
import modelo.ModeloTablaUsuarios;
import modelo.ModeloUsuario;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaBusquedaUsuarioPorDescripcion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControladorVistaBusquedaUsuarioPorDescripcion implements MouseListener, KeyListener {
    ModeloTablaUsuarios modeloTablaUsuarios;
    ModeloUsuario modeloUsuario;
    VistaBusquedaUsuarioPorDescripcion vistaBusquedaUsuarioPorDescripcion;
    ConsultasUsuario consultasUsuario = new ConsultasUsuario();

    // public ControladorVistaBusquedaPorDescripcion(ModeloTablaProductos
    // ModeloTablaProductos,
    // ModeloProducto ModeloProducto,VistaBusquedaPorDescripcion
    // VistaBusquedaPorDescripcion){
    public ControladorVistaBusquedaUsuarioPorDescripcion(ModeloTablaUsuarios modeloTablaUsuarios,
    ModeloUsuario modeloUsuario,VistaBusquedaUsuarioPorDescripcion vistaBusquedaUsuarioPorDescripcion){
        this.modeloTablaUsuarios = modeloTablaUsuarios;
        this.modeloUsuario = modeloUsuario;
        this.vistaBusquedaUsuarioPorDescripcion = vistaBusquedaUsuarioPorDescripcion;
        
         //Toma el modelo de la tabla
         vistaBusquedaUsuarioPorDescripcion.Tabla.setModel(modeloTablaUsuarios.getModeloTabla());
        
        oyentes();
        llenarTablaProductos();
        // LlenarModeloConSeleccionFilaTabla();
        vistaBusquedaUsuarioPorDescripcion.setVisible(true);
    }
    
    private void oyentes() {
        vistaBusquedaUsuarioPorDescripcion.TxtNombre.addMouseListener(this);
        vistaBusquedaUsuarioPorDescripcion.Tabla.addMouseListener(this);
        vistaBusquedaUsuarioPorDescripcion.BtnAceptar.addMouseListener(this);
        
        //oyentes del teclado
        vistaBusquedaUsuarioPorDescripcion.TxtNombre.addKeyListener(this);
    }
    
    private void LlenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = vistaBusquedaUsuarioPorDescripcion.Tabla.getSelectedRow();
        
        if (filaSeleccionada!=-1) {
        //Tomar lo que ha en la fila selecciona y lo convierte a su tipo de dato.
        String usuario = modeloTablaUsuarios.getModeloTabla().getValueAt(filaSeleccionada,0).toString();
        String password = modeloTablaUsuarios.getModeloTabla().getValueAt(filaSeleccionada,1).toString(); 
        String nombre = modeloTablaUsuarios.getModeloTabla().getValueAt(filaSeleccionada,2).toString();
        String tipo = modeloTablaUsuarios.getModeloTabla().getValueAt(filaSeleccionada,3).toString();
        
       //llenar el modelo producto
        modeloUsuario.setUsuario(usuario);
        modeloUsuario.setPassword(password);
        modeloUsuario.setNombre(nombre);
        modeloUsuario.setTipo(tipo);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==vistaBusquedaUsuarioPorDescripcion.BtnAceptar) {
            LlenarModeloConSeleccionFilaTabla();
            vistaBusquedaUsuarioPorDescripcion.dispose();
        }
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaBusquedaUsuarioPorDescripcion.TxtNombre) {
            consultasUsuario.buscarFrase(vistaBusquedaUsuarioPorDescripcion.TxtNombre,modeloTablaUsuarios.getModeloTabla());
        }
    }

    

    private void llenarTablaProductos() {
        //consulta la tabla de productos y llena el modelo con todos losregistros encontrados
        consultasUsuario.buscarTodosLosProductos(modeloTablaUsuarios.getModeloTabla());
        //Actualiza la vista de la tabla con el modelo y todos los datos agregados
        vistaBusquedaUsuarioPorDescripcion.Tabla.setModel(modeloTablaUsuarios.getModeloTabla());
    }
    
       
    
}
