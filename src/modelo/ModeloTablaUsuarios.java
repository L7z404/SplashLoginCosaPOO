package modelo;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaUsuarios {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaUsuarios() {
        ModeloTabla.addColumn("Usuario");
        ModeloTabla.addColumn("Contraseña");
        ModeloTabla.addColumn("Nombre");
        ModeloTabla.addColumn("Tipo");
        
        //Retorna el modelo de la tabla
        
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}