package modelo;

public class ModeloUsuario {
    //Atributos
    private String Usuario, Password, Nombre, Tipo;

    //Constuctor que recibe parámetro todos los campos
    public ModeloUsuario(String Usuario, String Password, String Nombre, String Tipo) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
    }
    
    //Aveces se usara este constuctor vacio por comodidad
    public ModeloUsuario(){
        
    }

    //Getters y Setters
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
    
}
