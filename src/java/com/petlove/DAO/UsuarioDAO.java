
package com.petlove.DAO;

import com.petlove.soporte.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UsuarioDAO {
    
    private Connection con;
    private PreparedStatement ps;
    private static UsuarioDAO instance;
    
    
    private UsuarioDAO(){
    }
    
    public static UsuarioDAO getInstance(){
        if(instance==null){
            instance= new UsuarioDAO();
        }
        return instance;
    }
     //Metodo de login
    
     public boolean loginUsuario(String correo, String password){
        
        //String sql="Select usuario from tbcliente where usuario='"+usuario+"' and pass= '"+ password+"'";
        String sql="Select * from tbcliente where correo=? and pass=?";
        ResultSet rs=null;
        int respuesta=0;
        boolean sw=false;
        
        try{
            con= DBConexion.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,correo);
            ps.setString(2,password);
            rs= ps.executeQuery();
            
            while(rs.next()){
                respuesta++;
            }
            
            if(respuesta==1){
                sw=true;
            }
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return sw;
    }
    
    //Método para registrar en DB
    public boolean registrar(String correo, String password, String nombre, String apellido){
         boolean sw=false;
        if(!this.loginUsuario(correo, password)){ 
        //insert into tbCliente values(1,'diego@hotmail.com','12345','Diego','Lopez');
        String sql="insert into tbCliente (correo,pass,nombre,apellido) values('"+correo+"','"+password+"','"+nombre+"','"+apellido+"')";
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
        }
        
        
        return sw;
    }
    
   
     
     //metodo para obtener el id
     
     public int RetornaID(String correo){
        int id=0;
        String sql="Select idcliente from tbcliente where correo=? ";
        ResultSet rs=null;
        
        try {
            con= DBConexion.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,correo);
            rs= ps.executeQuery();
            while(rs.next()){
              id=rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
        return id;
    }
     
      /**public String RetornaCorreo(String correo){
        String email="";
        String sql="Select correo from tbcliente where correo=? ";
        ResultSet rs=null;
        
        try {
            con= DBConexion.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,correo);
            rs= ps.executeQuery();
            while(rs.next()){
             email=rs.getString(2);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
        return email;
    }*/
     
    
    
    
}
