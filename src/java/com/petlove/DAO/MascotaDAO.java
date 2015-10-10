
package com.petlove.DAO;

import com.petlove.soporte.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class MascotaDAO {
    
    private Connection con;
    private PreparedStatement ps;
    private static MascotaDAO instance;
    
    public MascotaDAO(){}
    
     public static MascotaDAO getInstance(){
        if(instance==null){
            instance= new MascotaDAO();
        }
        return instance;
    }
    
     public boolean registrarMascota(String nombre, String raza, String distrito, int idCliente){
        boolean sw=false;
        
        //insert into tbCliente values(1,'diego@hotmail.com','12345','Diego','Lopez');
        String sql="insert into tbmascota (correo,pass,nombre,apellido) values("+idCliente+",'"+nombre+"','"+raza+"','"+distrito+"')";
        try{
            
            con= DBConexion.getConnection();
            ps= con.prepareStatement(sql);
            int i=ps.executeUpdate();
            
            if(i==1){
                sw=true;
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return sw;
    }
    
}
