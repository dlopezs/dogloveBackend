
package com.petlove.controladores;

import com.google.gson.Gson;
import com.petlove.DAO.UsuarioDAO;
import com.petlove.DAO.MascotaDAO;
import com.petlove.DTO.MascotaDTO;
import com.petlove.DTO.ResponseDTO;
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

public class RegistroServletMascota extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream is = request.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
       //esta registrando el jason que ha recibido del movil para ponerlo en la bd
       MascotaDTO mascota=new Gson().fromJson(reader, MascotaDTO.class);
        
        boolean existe= MascotaDAO.getInstance().registrarMascota(mascota.getNombre(), mascota.getRaza(), mascota.getDistrito(), mascota.getIdcliente());
        ResponseDTO responseDTO;
        String json;
        
        if(existe){
            //Armar json de exitomas
           
            responseDTO= new ResponseDTO("OK","");
            json= new Gson().toJson(responseDTO);
            System.out.println("-------------EXISTE CTM-----------------");
        }else{
            //Armar json de error
             responseDTO= new ResponseDTO("Error","");
            json= new Gson().toJson(responseDTO);
        }
        
        response.setContentType("application/json");
        
        //Manda la respuesta a la App Movil
        PrintWriter out = response.getWriter();
        out.print(json);
        
    }
    }

    
   


