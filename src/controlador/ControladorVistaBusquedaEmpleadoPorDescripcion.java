package controlador;

import modelo.ConsultasEmpleado;
import modelo.ConsultasProducto;
import modelo.ModeloEmpleado;
import modelo.ModeloProducto;
import modelo.ModeloTablaEmpleados;
import modelo.ModeloTablaProductos;
import vista.VistaBusquedaEmpleadoPorDescripcion;
import vista.VistaBusquedaPorDescripcion;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControladorVistaBusquedaEmpleadoPorDescripcion implements MouseListener, KeyListener {
    ModeloTablaEmpleados modeloTablaEmpleados;
    ModeloEmpleado modeloEmpleado;
    VistaBusquedaEmpleadoPorDescripcion vistaBusquedaEmpleadoPorDescripcion;
    ConsultasEmpleado consultasEmpleado = new ConsultasEmpleado();

    // public ControladorVistaBusquedaPorDescripcion(ModeloTablaProductos
    // ModeloTablaProductos,
    // ModeloProducto ModeloProducto,VistaBusquedaPorDescripcion
    // VistaBusquedaPorDescripcion){
    public ControladorVistaBusquedaEmpleadoPorDescripcion(ModeloTablaEmpleados modeloTablaEmpleados,
    ModeloEmpleado modeloEmpleado,VistaBusquedaEmpleadoPorDescripcion vistaBusquedaEmpleadoPorDescripcion){
        this.modeloTablaEmpleados = modeloTablaEmpleados;
        this.modeloEmpleado = modeloEmpleado;
        this.vistaBusquedaEmpleadoPorDescripcion = vistaBusquedaEmpleadoPorDescripcion;
        
         //Toma el modelo de la tabla
         vistaBusquedaEmpleadoPorDescripcion.Tabla.setModel(modeloTablaEmpleados.getModeloTabla());
        
        oyentes();
        llenarTablaProductos();
        // LlenarModeloConSeleccionFilaTabla();
        vistaBusquedaEmpleadoPorDescripcion.setVisible(true);
    }
    
    private void oyentes() {
        vistaBusquedaEmpleadoPorDescripcion.TxtNombre.addMouseListener(this);
        vistaBusquedaEmpleadoPorDescripcion.Tabla.addMouseListener(this);
        vistaBusquedaEmpleadoPorDescripcion.BtnAceptar.addMouseListener(this);
        
        //oyentes del teclado
        vistaBusquedaEmpleadoPorDescripcion.TxtNombre.addKeyListener(this);
    }
    
    private void LlenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = vistaBusquedaEmpleadoPorDescripcion.Tabla.getSelectedRow();
        
        if (filaSeleccionada!=-1) {
            
            // private int IDEmpleado;
            // private String NombreEmp;
            // private String Calle;
            // private String Colonia;
            // private String Municipio;
            // private String Ciudad;
            // private int CP;
            // private String Telefono;
            // private String Cargo;
            // private String FechaIngreso;
            // private float Sueldo;
            // private String HoraEntrada;
            // private String HoraSalida;
            // private String Correo;
        //Tomar lo que ha en la fila selecciona y lo convierte a su tipo de dato.
        // int codigo = Integer.parseInt(ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,0).toString());
        // String Descripcion = ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,1).toString(); 
        // float precio = Float.parseFloat(ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,2).toString());
        // String Nombre = ModeloTablaProductos.getModeloTabla().getValueAt(filaSeleccionada,3).toString();
        
        int IDEmpleado = Integer.parseInt(modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,0).toString());
        String NombreEmp = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,1).toString();
        String Calle = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,2).toString();
        String Colonia = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,3).toString();
        String Municipio = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,4).toString();
        String Ciudad = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,5).toString();
        int CP = Integer.parseInt(modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,6).toString());
        String Telefono = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,7).toString();
        String Cargo = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,8).toString();
        String FechaIngreso = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,9).toString();
        float Sueldo = Float.parseFloat(modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,10).toString());
        String HoraEntrada = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,11).toString();
        String HoraSalida = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,12).toString();
        String Correo = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,13).toString();
        String Nombre = modeloTablaEmpleados.getModeloTabla().getValueAt(filaSeleccionada,14).toString();
        
       //llenar el modelo producto
        // ModeloProducto.setCodigo(codigo);
        // ModeloProducto.setDescripcion(Descripcion);
        // ModeloProducto.setPrecio(precio);
        // ModeloProducto.setNombre(Nombre);
        
         modeloEmpleado.setIDEmpleado(IDEmpleado);
         modeloEmpleado.setNombreEmp(NombreEmp);
         modeloEmpleado.setCalle(Calle);
         modeloEmpleado.setColonia(Colonia);
         modeloEmpleado.setMunicipio(Municipio);
         modeloEmpleado.setCiudad(Ciudad);
         modeloEmpleado.setCP(CP);
         modeloEmpleado.setTelefono(Telefono);
         modeloEmpleado.setCargo(Cargo);
         modeloEmpleado.setFechaIngreso(FechaIngreso);
         modeloEmpleado.setSueldo(Sueldo);
         modeloEmpleado.setHoraEntrada(HoraEntrada);
         modeloEmpleado.setHoraSalida(HoraSalida);
         modeloEmpleado.setCorreo(Correo);
         modeloEmpleado.setNombre(Nombre);
         
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==vistaBusquedaEmpleadoPorDescripcion.BtnAceptar) {
            LlenarModeloConSeleccionFilaTabla();
            vistaBusquedaEmpleadoPorDescripcion.dispose();
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
        if (e.getSource() == vistaBusquedaEmpleadoPorDescripcion.TxtNombre) {
            consultasEmpleado.buscarFrase(vistaBusquedaEmpleadoPorDescripcion.TxtNombre,modeloTablaEmpleados.getModeloTabla());
        }
    }

    

    private void llenarTablaProductos() {
        //consulta la tabla de productos y llena el modelo con todos losregistros encontrados
        consultasEmpleado.buscarTodosLosProductos(modeloTablaEmpleados.getModeloTabla());
        //Actualiza la vista de la tabla con el modelo y todos los datos agregados
        vistaBusquedaEmpleadoPorDescripcion.Tabla.setModel(modeloTablaEmpleados.getModeloTabla());
    }
    
       
    
}
