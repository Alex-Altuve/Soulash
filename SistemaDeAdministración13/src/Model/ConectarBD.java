
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



public class ConectarBD {
  
    public static  Connection conectar() {
        try {
            
            Connection  cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_soulash","root","");
            System.out.println("Conexion establecida...");
            return cn;
            
        } catch (SQLException e) {
            
            System.out.println("Error en conexión local " + e);
        }
        return (null);
     
       
    }
   
 
}
