package controlador;

import modelo.ConsultasProducto;
import modelo.ModeloProducto;
import modelo.ModeloTablaProductos;
import vista.VistaBusquedaPorDescripcion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControladorVistaBusquedaPorDescripcion implements MouseListener,KeyListener {
    ModeloTablaProductos ModeloTablaProductos;
    ModeloProducto ModeloProducto;
    VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion;
    ConsultasProducto ConsultasProducto = new ConsultasProducto();

   // public ControladorVistaBusquedaPorDescripcion(ModeloTablaProductos ModeloTablaProductos,
    //        ModeloProducto ModeloProducto,VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion){
      public ControladorVistaBusquedaPorDescripcion(ModeloTablaProductos ModeloTablaProductos,
              ModeloProducto ModeloProducto,VistaBusquedaPorDescripcion VistaBusquedadPorDescripcion){
        this.ModeloTablaProductos = ModeloTablaProductos;
        this.ModeloProducto = ModeloProducto;
        this.VistaBusquedaPorDescripcion = VistaBusquedadPorDescripcion;
        
         //Toma el modelo de la tabla
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaProductos.getModeloTabla());
        
        oyentes();
        llenarTablaProductos();
        // LlenarModeloConSeleccionFilaTabla();
        VistaBusquedaPorDescripcion.setVisible(true);
    }
    
    private void oyentes() {
        VistaBusquedaPorDescripcion.TxtNombre.addMouseListener(this);
        VistaBusquedaPorDescripcion.Tabla.addMouseListener(this);
        VistaBusquedaPorDescripcion.BtnAceptar.addMouseListener(this);
        
        //oyentes del teclado
        VistaBusquedaPorDescripcion.TxtNombre.addKeyListener(this);
    }
    
    private void LlenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = VistaBusquedaPorDescripcion.Tabla.getSelectedRow();
        
        if (filaSeleccionada!=-1) {
        //Tomar lo que ha en la fila selecciona y lo convierte a su tipo de dato.
        int codigo = Integer.parseInt(ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,0).toString());
        String Descripcion = ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,1).toString(); 
        float precio = Float.parseFloat(ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,2).toString());
        String Nombre = ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,3).toString();
       //llenar el modelo producto
        ModeloProducto.setCodigo(codigo);
        ModeloProducto.setDescripcion(Descripcion);
        ModeloProducto.setPrecio(precio);
        ModeloProducto.setNombre(Nombre);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaBusquedaPorDescripcion.BtnAceptar) {
            LlenarModeloConSeleccionFilaTabla();
            VistaBusquedaPorDescripcion.dispose();
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
        if (e.getSource() == VistaBusquedaPorDescripcion.TxtNombre) {
            ConsultasProducto.buscarFrase(VistaBusquedaPorDescripcion.TxtNombre,ModeloTablaProductos.getModeloTabla());
        }
    }

    

    private void llenarTablaProductos() {
        //consulta la tabla de productos y llena el modelo con todos losregistros encontrados
        ConsultasProducto.buscarTodosLosProductos(ModeloTablaProductos.getModeloTabla());
        //Actualiza la vista de la tabla con el modelo y todos los datos agregados
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaProductos.getModeloTabla());
    }
    
       
    
}
