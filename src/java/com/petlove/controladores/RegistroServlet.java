
package com.petlove.controladores;

import com.google.gson.Gson;
import com.petlove.DAO.UsuarioDAO;
import com.petlove.DTO.ResponseDTOconID;
import com.petlove.DTO.UsuarioDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream is = request.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
        
        UsuarioDTO usuario= new Gson().fromJson(reader,UsuarioDTO.class);
        //esta registrando el jason que ha recibido del movil para ponerlo en la bd
        boolean existe= UsuarioDAO.getInstance().registrar(usuario.getCorreo(), usuario.getPassword(), usuario.getNombre(), usuario.getApellido());
        ResponseDTOconID responseDTO;
        String json;
        
        if(existe){
            //Armar json de exito
            //llamar metodo de id en usuarioDAO
            int id=UsuarioDAO.getInstance().RetornaID(usuario.getCorreo()) ;
            responseDTO= new ResponseDTOconID("OK","",id);
            json= new Gson().toJson(responseDTO);
            System.out.println("-------------EXISTE CTM-----------------");
        }else{
            //Armar json de error
             responseDTO= new ResponseDTOconID("Error","",0);
            json= new Gson().toJson(responseDTO);
        }
        
        response.setContentType("application/json");
        
        //Manda la respuesta a la App Movil
        PrintWriter out = response.getWriter();
        out.print(json);
        
    }

}
