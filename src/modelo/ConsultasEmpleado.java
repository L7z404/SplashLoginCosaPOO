package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ConsultasEmpleado extends Conexion {
   Connection Con = getConexion();
    
   
   public boolean insertar(ModeloEmpleado Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "insert into empleado (IDEmpleado, Nombre, Calle, Colonia, Municipio, Ciudad, CP, Telefono, Cargo, FechaIngreso, Sueldo, HoraEntrada, HoraSalida, Correo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       
    //    Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
    //    Ps.setString(2,Modelo.getDescripcion()); //Interrogante 2
    //    Ps.setFloat(3,Modelo.getPrecio()); //Interrogante 3
    //    Ps.setInt(4,Modelo.getPresentacion()); //Interrogante 4
       
       Ps.setInt(1, Modelo.getIDEmpleado());
       Ps.setString(2, Modelo.getNombreEmp());
       Ps.setString(3, Modelo.getCalle());
       Ps.setString(4, Modelo.getColonia());
       Ps.setString(5, Modelo.getMunicipio());
       Ps.setString(6, Modelo.getCiudad());
       Ps.setInt(7, Modelo.getCP());
       Ps.setString(8, Modelo.getTelefono());
       Ps.setString(9, Modelo.getCargo());
       Ps.setString(10, Modelo.getFechaIngreso());
       Ps.setFloat(11, Modelo.getSueldo());
       Ps.setString(12, Modelo.getHoraEntrada());
       Ps.setString(13, Modelo.getHoraSalida());
       Ps.setString(14, Modelo.getCorreo());
       
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
       return false; //Algo salió mal
   }
   }

   public boolean modificar (ModeloEmpleado Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "update empleado set Nombre=?, Calle=?, Colonia=?, Municipio=?, Ciudad=?, CP=?, Telefono=?, Cargo=?, FechaIngreso=?, Sueldo=?, HoraEntrada=?, HoraSalida=?, Correo=? where IDEmpleado=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       
    //    Ps.setString(1,Modelo.getDescripcion()); //interrogante 1
    //    Ps.setFloat(2,Modelo.getPrecio()); //Interrogante 2
    //    Ps.setInt(3,Modelo.getPresentacion()); //Interrogante 3
    //    Ps.setInt(4,Modelo.getCodigo()); //Interrogante 4
    
    
            
            Ps.setString(1, Modelo.getNombreEmp());
            Ps.setString(2, Modelo.getCalle());
            Ps.setString(3, Modelo.getColonia());
            Ps.setString(4, Modelo.getMunicipio());
            Ps.setString(5, Modelo.getCiudad());
            Ps.setInt(6, Modelo.getCP());
            Ps.setString(7, Modelo.getTelefono());
            Ps.setString(8, Modelo.getCargo());
            Ps.setString(9, Modelo.getFechaIngreso());
            Ps.setFloat(10, Modelo.getSueldo());
            Ps.setString(11, Modelo.getHoraEntrada());
            Ps.setString(12, Modelo.getHoraSalida());
            Ps.setString(13, Modelo.getCorreo());
            Ps.setInt(14, Modelo.getIDEmpleado());
       
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean eliminar (ModeloEmpleado Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "delete from empleado where IDEmpleado=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       
    //    Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
            Ps.setInt(1, Modelo.getIDEmpleado());
       
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean buscar(ModeloEmpleado Modelo){
   try {
       PreparedStatement Ps;
       String SQL =
       "SELECT * FROM empleado INNER JOIN puesto on " + "empleado.puesto=puesto.puesto where IDEmpleado = ?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       
       
    //    Ps.setInt(1,Modelo.getCodigo()); //interrogante 1
       
       
       ResultSet Rs = Ps.executeQuery();//Para obtener resultados
       
       
    //    if (Rs.next()) {
    //        Modelo.setDescripcion(Rs.getString("descripcion"));
    //        Modelo.setPrecio(Rs.getFloat("precio"));
    //        Modelo.setPresentacion(Rs.getInt("presentacion"));//Foranea)
    //        Modelo.setNombre(Rs.getString("nombre"));
    //        return true;//Todo está bien
    //    }
       
            if (Rs.next()) {
                
                Modelo.setNombreEmp(Rs.getString("Nombre"));
                Modelo.setCalle(Rs.getString("Calle"));
                Modelo.setColonia(Rs.getString("Colonia"));
                Modelo.setMunicipio(Rs.getString("Municipio"));
                Modelo.setCiudad(Rs.getString("Ciudad"));
                Modelo.setCP(Rs.getInt("CP"));
                Modelo.setTelefono(Rs.getString("Telefono"));
                Modelo.setCargo(Rs.getString("Cargo"));
                Modelo.setFechaIngreso(Rs.getString("FechaIngreso"));
                Modelo.setSueldo(Rs.getFloat("Sueldo"));
                Modelo.setHoraEntrada(Rs.getString("HoraEntrada"));
                Modelo.setHoraSalida(Rs.getString("HoraSalida"));
                Modelo.setCorreo(Rs.getString("Correo"));
                Modelo.setPuesto(Rs.getInt("puesto"));
                Modelo.setNombre(Rs.getString("nombre"));
                return true;
            }
       
       return false; //No encontro el dato buscado
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: buscar()\n "+e);
       return false; //Algo salió mal
   }
   }
   
   public void buscarFrase (JTextField TxtConsultar, DefaultTableModel ModeloTabla){
    try {
        PreparedStatement Ps;
        String SQL = "select * from empleado where Nombre like '%"+
                TxtConsultar.getText()+"%'";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Ps.getMetaData().getColumnCount();
        ModeloTabla.setRowCount(0);
        while(Rs.next()){
            String Fila[] = new String[numeroDeCampos];
            Fila[0] = Rs.getInt("IDEmpleado")+"";
            Fila[1] = Rs.getString("Nombre");
            Fila[2] = Rs.getString("Calle")+"";
            Fila[3] = Rs.getString("Colonia")+"";
            Fila[4] = Rs.getString("Municipio")+"";
            Fila[5] = Rs.getString("Ciudad")+"";
            Fila[6] = Rs.getString("CP")+""; //sino jala cambiar a int
            Fila[7] = Rs.getString("Telefono")+"";
            Fila[8] = Rs.getString("Cargo")+"";
            Fila[9] = Rs.getString("FechaIngreso")+"";
            Fila[10] = Rs.getString("Sueldo")+""; //sino jala cambiar a float
            Fila[11] = Rs.getString("HoraEntrada")+"";
            Fila[12] = Rs.getString("HoraSalida")+"";
            Fila[13] = Rs.getString("Correo")+"";
            Fila[14] = obtenerPresentacionString(Rs.getInt("puesto"));
            
            ModeloTabla.addRow(Fila);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
    }
}
   
public String obtenerPresentacionString(int id_presentacion) {
    try {
        PreparedStatement Ps;
        String SQL = "select * from puesto where puesto = ?";
        Ps = Con.prepareCall(SQL);
        Ps.setInt(1,id_presentacion);
        ResultSet Rs = Ps.executeQuery();
        if (Rs.next()) {
            return Rs.getString("nombre");
            
            }
        return null;
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: Obtener presentacionString()\n"+ e);
        return null;
    }
 }


 public Integer obtenerPresentacionNumerica(String Presentacion) {
    try {
        PreparedStatement Ps;
        String SQL = "select * from puesto where nombre = ?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1,Presentacion);
        ResultSet Rs = Ps.executeQuery();
        if (Rs.next()) {
            return Rs.getInt("puesto");
            
            }
        return null;
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: Obtener presentacionNúmerica()\n"+ e);
        return null;
    }
 }
 
 public boolean buscarTodosLosProductos(DefaultTableModel Modelo) {
    try {
        PreparedStatement Ps;
        String SQL = "select * from empleado order by Nombre";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Rs.getMetaData().getColumnCount();
        while (Rs.next()) {
            Object Fila[] = new Object[numeroDeCampos];
            Fila[0] = Rs.getInt("IDEmpleado");
            Fila[1] = Rs.getString("Nombre");
            Fila[2] = Rs.getString("Calle");
            Fila[3] = Rs.getString("Colonia");
            Fila[4] = Rs.getString("Municipio");
            Fila[5] = Rs.getString("Ciudad");
            Fila[6] = Rs.getInt("CP"); //sino jala cambiar a string
            Fila[7] = Rs.getString("Telefono");
            Fila[8] = Rs.getString("Cargo");
            Fila[9] = Rs.getString("FechaIngreso");
            Fila[10] = Rs.getFloat("Sueldo"); //sino jala cambiar a string
            Fila[11] = Rs.getString("HoraEntrada");
            Fila[12] = Rs.getString("HoraSalida");
            Fila[13] = Rs.getString("Correo")+"";
            //Como la características es númerica, la convierte a String con una consulta
            Fila[14] = obtenerPresentacionString(Rs.getInt("puesto"));
            Modelo.addRow(Fila);
            }
        return true;
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarTodosLosProductos()\n"+ e);
         return false;
         
    }
   } 

   
    public void llenarComboPresentacion(JComboBox ComboTabla){
    try{
        PreparedStatement Ps;
        String SQL = "select * from puesto order by nombre";
        Ps = Con.prepareCall(SQL);
        ResultSet RsResultado = Ps.executeQuery();
        while (RsResultado.next()){
            ComboTabla.addItem(RsResultado.getString("nombre"));
            
        }
    }catch (Exception e){
      JOptionPane.showMessageDialog(null,"Error: llenarCombopresentacion()\n "+e);
}
    }
}
    
    
   
        