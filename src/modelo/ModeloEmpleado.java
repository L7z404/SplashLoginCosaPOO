package modelo;

public class ModeloEmpleado {
    private int IDEmpleado;
    private String NombreEmp;
    private String Calle;
    private String Colonia;
    private String Municipio;
    private String Ciudad;
    private int CP;
    private String Telefono;
    private String Cargo;
    private String FechaIngreso;
    private float Sueldo;
    private String HoraEntrada;
    private String HoraSalida;
    private String Correo;
    
    
    private int puesto; // Para la llave foranea
    private String Nombre; // Para el dato del combobox (nombre del campo)

    public ModeloEmpleado() {
    }

    public ModeloEmpleado(int IDEmpleado, String NombreEmp, String Calle, String Colonia, String Municipio,
            String Ciudad, int CP, String Telefono, String Cargo, String FechaIngreso, float Sueldo, String HoraEntrada,
            String HoraSalida, String Correo, int puesto) {
        this.IDEmpleado = IDEmpleado;
        this.NombreEmp = NombreEmp;
        this.Calle = Calle;
        this.Colonia = Colonia;
        this.Municipio = Municipio;
        this.Ciudad = Ciudad;
        this.CP = CP;
        this.Telefono = Telefono;
        this.Cargo = Cargo;
        this.FechaIngreso = FechaIngreso;
        this.Sueldo = Sueldo;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.Correo = Correo;
        this.puesto = puesto;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int iDEmpleado) {
        IDEmpleado = iDEmpleado;
    }

    public String getNombreEmp() {
        return NombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        NombreEmp = nombreEmp;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String colonia) {
        Colonia = colonia;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int cP) {
        CP = cP;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float sueldo) {
        Sueldo = sueldo;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        HoraEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String horaSalida) {
        HoraSalida = horaSalida;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    
    
    
    
    
}
