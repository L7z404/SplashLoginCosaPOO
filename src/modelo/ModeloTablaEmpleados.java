package modelo;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaEmpleados {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaEmpleados() {
        // ModeloTabla.addColumn("Codigo");
        // ModeloTabla.addColumn("Descripción");
        // ModeloTabla.addColumn("Precio");
        // ModeloTabla.addColumn("Presentació");
        
        ModeloTabla.addColumn("IDEmpleado");
        ModeloTabla.addColumn("Nombre");
        ModeloTabla.addColumn("Calle");
        ModeloTabla.addColumn("Colonia");
        ModeloTabla.addColumn("Municipio");
        ModeloTabla.addColumn("Ciudad");
        ModeloTabla.addColumn("CP");
        ModeloTabla.addColumn("Telefono");
        ModeloTabla.addColumn("Cargo");
        ModeloTabla.addColumn("FechaIngreso");
        ModeloTabla.addColumn("Sueldo");
        ModeloTabla.addColumn("HoraEntrada");
        ModeloTabla.addColumn("HoraSalida");
        ModeloTabla.addColumn("Correo");
        ModeloTabla.addColumn("puesto");
        //Retorna el modelo de la tabla
        
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}