package modelo;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaProductos {
    DefaultTableModel ModeloTabla = new DefaultTableModel();
    
    public ModeloTablaProductos(){
        ModeloTabla.addColumn("Codigo");
        ModeloTabla.addColumn("Descripción");
        ModeloTabla.addColumn("Precio");
        ModeloTabla.addColumn("Presentació");
        
        //Retorna el modelo de la tabla
        
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}