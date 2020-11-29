package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.ConsultasEmpleado;
import modelo.ConsultasProducto;
import modelo.ModeloEmpleado;
import modelo.ModeloProducto;
import modelo.ModeloTablaEmpleados;
import modelo.ModeloTablaProductos;
import vista.VistaBusquedaEmpleadoPorDescripcion;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaEmpleado;
import vista.VistaProductos;

public class ControladorVistaEmpleado implements MouseListener {
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
        VistaEmpleado.BtnSalir.addMouseListener(this);
        VistaEmpleado.BtnGuardar.addMouseListener(this);
        VistaEmpleado.BtnEliminar.addMouseListener(this);
        VistaEmpleado.BtnActualizar.addMouseListener(this);
        VistaEmpleado.BtnBuscar.addMouseListener(this);
        VistaEmpleado.LblSearch.addMouseListener(this);

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
                JOptionPane.showMessageDialog(VistaEmpleado, "Ese producto ya existe");
            } else {
                llenarModeloConVista();
                if (ConsultasEmpleado.insertar(ModeloEmpleado) == true) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "El campo codigo no debe estar vacio");

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "El campo codigo no debe estar vacio");

        }
    }

    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();

            ModeloEmpleado ModeloTemporal = new ModeloEmpleado();
            ModeloTemporal.setIDEmpleado(Integer.parseInt(VistaEmpleado.TxtIDEmpleado.getText()));

            if (ConsultasEmpleado.buscar(ModeloTemporal) == false) {
                JOptionPane.showMessageDialog(VistaEmpleado, "Ese producto no existe");
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
                JOptionPane.showMessageDialog(VistaEmpleado, "Ese producto no existe");
            } else {
                if (ConsultasEmpleado.eliminar(ModeloEmpleado)) {
                    JOptionPane.showMessageDialog(VistaEmpleado, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaEmpleado, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo codigo no debe de estar vacio");
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
    
}
