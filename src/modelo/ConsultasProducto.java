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

public class ConsultasProducto extends Conexion{
   Connection Con = getConexion();
    
   
   public boolean insertar(ModeloProducto modeloProducto){
   try {
       PreparedStatement Ps;
       String SQL =
       "insert into productos (codigo, descripcion,precio,presentacion) values (?,?,?,?)";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,modeloProducto.getCodigo()); //interrogante 1
       Ps.setString(2,modeloProducto.getDescripcion()); //Interrogante 2
       Ps.setFloat(3,modeloProducto.getPrecio()); //Interrogante 3
       Ps.setInt(4,modeloProducto.getPresentacion()); //Interrogante 4
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
       return false; //Algo salió mal
   }
   }

   public boolean modificar (ModeloProducto modeloProducto){
   try {
       PreparedStatement Ps;
       String SQL =
       "update productos set descripcion=?,precio=?, presentacion=? where codigo=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setString(1,modeloProducto.getDescripcion()); //interrogante 1
       Ps.setFloat(2,modeloProducto.getPrecio()); //Interrogante 2
       Ps.setInt(3,modeloProducto.getPresentacion()); //Interrogante 3
       Ps.setInt(4,modeloProducto.getCodigo()); //Interrogante 4
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean eliminar (ModeloProducto modeloProducto){
   try {
       PreparedStatement Ps;
       String SQL =
       "delete from productos where codigo=?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,modeloProducto.getCodigo()); //interrogante 1
       Ps.executeUpdate(); //Ejecutar la consulta SQL
       return true;
   } catch (SQLException e) {//Se cacha un posible error
       JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
       return false; //Algo salió mal
   }
}
   public boolean buscar(ModeloProducto modeloTemporal){
   try {
       PreparedStatement Ps;
       String SQL =
       "SELECT * FROM productos INNER JOIN presentacion on " + "productos.presentacion=presentacion.presentacion where codigo = ?";
       Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
       Ps.setInt(1,modeloTemporal.getCodigo()); //interrogante 1
       ResultSet Rs = Ps.executeQuery();//Para obtener resultados
       if (Rs.next()) {
           modeloTemporal.setDescripcion(Rs.getString("descripcion"));
           modeloTemporal.setPrecio(Rs.getFloat("precio"));
           modeloTemporal.setPresentacion(Rs.getInt("presentacion"));//Foranea)
           modeloTemporal.setNombre(Rs.getString("nombre"));
           return true;//Todo está bien
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
        String SQL = "select * from productos where descripcion like '%"+
                TxtConsultar.getText()+"%'";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Ps.getMetaData().getColumnCount();
        ModeloTabla.setRowCount(0);
        while(Rs.next()){
            String Fila[] = new String[numeroDeCampos];
            Fila[0] = Rs.getInt("codigo")+"";
            Fila[1] = Rs.getString("descripcion");
            Fila[2] = Rs.getString("precio")+"";
            Fila[3] = obtenerPresentacionString(Rs.getInt("presentacion"));
            
            ModeloTabla.addRow(Fila);
        }
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
    }
}
   
public String obtenerPresentacionString(int id_presentacion) {
    try {
        PreparedStatement Ps;
        String SQL = "select * from presentacion where presentacion = ?";
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
        String SQL = "select * from presentacion where nombre = ?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1,Presentacion);
        ResultSet Rs = Ps.executeQuery();
        if (Rs.next()) {
            return Rs.getInt("presentacion");
            
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
        String SQL = "select * from productos order by descripcion";
        Ps = Con.prepareCall(SQL);
        ResultSet Rs = Ps.executeQuery();
        int numeroDeCampos = Rs.getMetaData().getColumnCount();
        while (Rs.next()) {
            Object Fila[] = new Object[numeroDeCampos];
            Fila[0] = Rs.getInt("codigo");
            Fila[1] = Rs.getString("descripcion");
            Fila[2] = Rs.getFloat("precio");
            //Como la características es númerica, la convierte a String con una consulta
            Fila[3] = obtenerPresentacionString(Rs.getInt("presentacion"));
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
        String SQL = "select * from presentacion order by nombre";
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
    
    
   
        