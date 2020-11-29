package modelo;

import conexion.Conexion;

import conexion.Conexion;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConsultasUsuario extends Conexion{ 
    Connection Con = getConexion(); //Se conecta a la base de datos
    
    public boolean buscarLogin(ModeloUsuario Modelo){
        try {//Intenta ejecutar el siguiente bloque de instrucciones
            PreparedStatement Ps; //Para hacer la consulta SQL, se copua una variable de este tipo
            String SQL = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?"; //Consulta SQL
            Ps = Con.prepareCall(SQL); //Prepara la llamada o consulta SQL
            //Reemplaza a los ? del String SQL con los datos del modelo (1 y 2 son las interrogantes)
            Ps.setString(1,Modelo.getUsuario()); //? #1 "usuario del modelo"
            Ps.setString(2,Modelo.getPassword()); //? #2 "password del modelo"
            ResultSet Rs = Ps.executeQuery(); //Para obtener los resutados, se ejecuta la consulta sql
            if(Rs.next()){
                Modelo.setNombre(Rs.getString("Nombre")); //Llena el modelo con este dato faltante o buscado
                Modelo.setTipo(Rs.getString("Tipo")); //Llena el modelo con este dato faltante o buscado
                return true; //todo esta bien, retorna verdadero y de paso ya lleno el modelo con los datos buscados
            }
            return false; //No se encontro el usuario en la base de datos, retorna falso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e); //Muesta el error ocurrido
            return false; //Algo salio mal, retorna falso y el error
        }
    }
    
    public boolean insertar(ModeloUsuario modeloUsuario){
        try {
            PreparedStatement Ps;
            String SQL =
            "insert into usuarios (usuario, password,nombre,tipo) values (?,?,?,?)";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloUsuario.getUsuario()); //interrogante 1
            Ps.setString(2,modeloUsuario.getPassword()); //Interrogante 2
            Ps.setString(3,modeloUsuario.getNombre()); //Interrogante 3
            Ps.setString(4,modeloUsuario.getTipo()); //Interrogante 4
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n "+e);
            return false; //Algo salió mal
        }
        }
     
        public boolean modificar (ModeloUsuario modeloUsuario){
        try {
            PreparedStatement Ps;
            String SQL =
            "update usuarios set password=?,nombre=?, tipo=? where usuario=?";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloUsuario.getPassword()); //interrogante 1
            Ps.setString(2,modeloUsuario.getNombre()); //Interrogante 2
            Ps.setString(3,modeloUsuario.getTipo()); //Interrogante 3
            Ps.setString(4,modeloUsuario.getUsuario()); //Interrogante 4
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n "+e);
            return false; //Algo salió mal
        }
     }
        public boolean eliminar (ModeloUsuario modeloUsuario){
        try {
            PreparedStatement Ps;
            String SQL =
            "delete from usuarios where usuario=?";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloUsuario.getUsuario()); //interrogante 1
            Ps.executeUpdate(); //Ejecutar la consulta SQL
            return true;
        } catch (SQLException e) {//Se cacha un posible error
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n "+e);
            return false; //Algo salió mal
        }
     }
        public boolean buscar(ModeloUsuario modeloTemporal){
        try {
            PreparedStatement Ps;
            String SQL =
            "SELECT * FROM usuarios where usuario = ?";
            Ps = Con.prepareCall(SQL);//Preparara llamada a la consulta
            Ps.setString(1,modeloTemporal.getUsuario()); //interrogante 1
            ResultSet Rs = Ps.executeQuery();//Para obtener resultados
            if (Rs.next()) {
                modeloTemporal.setPassword(Rs.getString("password"));
                modeloTemporal.setNombre(Rs.getString("nombre"));
                modeloTemporal.setTipo(Rs.getString("tipo"));
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
                String SQL = "select * from usuarios where nombre like '%"+
                        TxtConsultar.getText()+"%'";
                Ps = Con.prepareCall(SQL);
                ResultSet Rs = Ps.executeQuery();
                int numeroDeCampos = Ps.getMetaData().getColumnCount();
                ModeloTabla.setRowCount(0);
                while(Rs.next()){
                    String Fila[] = new String[numeroDeCampos];
                    Fila[0] = Rs.getString("usuario")+"";
                    Fila[1] = Rs.getString("password");
                    Fila[2] = Rs.getString("nombre")+"";
                    Fila[3] = Rs.getString("tipo")+"";

                    
                    ModeloTabla.addRow(Fila);
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
            }
        }
        
        public boolean buscarTodosLosProductos(DefaultTableModel Modelo) {
            try {
                PreparedStatement Ps;
                String SQL = "select * from usuarios order by nombre";
                Ps = Con.prepareCall(SQL);
                ResultSet Rs = Ps.executeQuery();
                int numeroDeCampos = Rs.getMetaData().getColumnCount();
                while (Rs.next()) {
                    Object Fila[] = new Object[numeroDeCampos];
                    Fila[0] = Rs.getString("usuario");
                    Fila[1] = Rs.getString("password");
                    Fila[2] = Rs.getString("nombre");
                    Fila[3] = Rs.getString("tipo");
                    //Como la características es númerica, la convierte a String con una consulta
                    // Fila[3] = obtenerPresentacionString(Rs.getInt("presentacion"));
                    Modelo.addRow(Fila);
                    }
                return true;
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Error: buscarTodosLosProductos()\n"+ e);
                 return false;
                 
            }
           } 
}
