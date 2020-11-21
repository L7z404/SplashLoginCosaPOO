package modelo;

public class ModeloProducto {
    private int codigo;
    private String Descripcion;
    private float precio;
    private int presentacion; //Para la llave foranea
    private String Nombre; //Para el dato del combobox (nombre del campo)
    
    public ModeloProducto(){}

    public ModeloProducto(int codigo, String Descripcion, float precio, int presentacion) {
        this.codigo = codigo;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.presentacion = presentacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(int presentacion) {
        this.presentacion = presentacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
    
}
