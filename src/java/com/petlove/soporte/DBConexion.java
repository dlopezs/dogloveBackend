

package com.petlove.soporte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kevin
 */
public class DBConexion {
    
    private static String url="jdbc:mysql://localhost:3306/test?user=root&password=kevin";
    
    public static Connection getConnection(){
        Connection con=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url);
        }catch(ClassNotFoundException ex){
            System.out.println("Verifica tu driver en el classpath");
        }catch(SQLException ex){
            System.out.println("Verifica tus parametros de conexion");
        }
        
        return con;
    }
    
    
    
}
