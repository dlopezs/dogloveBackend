/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petlove.DTO;

/**
 *
 * @author Kevin
 */
public class ResponseDTOconID {
    private String msgStatus;
    private String msgError;
    private int id;
  

    public ResponseDTOconID(String msgStatus, String msgError, int id) {

        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.id=id;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
    
}
