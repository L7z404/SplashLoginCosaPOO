package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    //Datos necesarios que cambian de acuerdo a las necesidades de la app
    private final String Servidor = "localhost"; //si es local = "localhost"
    private final String Database = "tiendita";
    private final String Usuario = "root"; //si el servidor es con localhost = root
    private final String Password = "";
    
    //Datos necesarios
    private final String Puerto = "3306"; 
    private final String Url = "jdbc:mysql://"+Servidor+":"+Puerto+"/"+Database+"?characterEncoding=utf8";
    
    //Conexión
    public static Connection Con;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = (Connection) DriverManager.getConnection(Url, Usuario, Password);
            System.out.println("Conexión establecida con la base de datos "+Database);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    
    public Connection getConexion(){
        return Con; //retorna la conexion a la base de datos
    }
}
