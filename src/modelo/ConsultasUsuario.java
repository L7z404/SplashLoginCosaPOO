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
            String SQL = "select * from usuarios where usuario ? and password = ?"; //Consulta SQL
            Ps = Con.prepareCall(SQL); //Prepara la llamada o consulta SQL
            //Reemplaza a los ? del String SQL con los datos del modelo (1 y 2 son las interrogantes)
            Ps.setString(1,Modelo.getUsuario()); //? #1 "usuario del modelo"
            Ps.setString(2,Modelo.getPassword()); //? #2 "password del modelo"
            ResultSet Rs = Ps.executeQuery(); //Para obtener los resutados, se ejecuta la consulta sql
            if(Rs.next()){
                Modelo.setNombre(Rs.getString("nombre")); //Llena el modelo con este dato faltante o buscado
                Modelo.setNombre(Rs.getString("tipo")); //Llena el modelo con este dato faltante o buscado
                return true; //todo esta bien, retorna verdadero y de paso ya lleno el modelo con los datos buscados
            }
            return false; //No se encontro el usuario en la base de datos, retorna falso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e); //Muesta el error ocurrido
            return false; //Algo salio mal, retorna falso y el error
        }
    }
}
