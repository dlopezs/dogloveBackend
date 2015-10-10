package com.petlove.DTO;

/**
 * Created by Kevin on 18/09/2015.
 */
public class ResponseDTO {

    private String msgStatus;
    private String msgError;

    public ResponseDTO(String msgStatus, String msgError) {

        this.msgStatus = msgStatus;
        this.msgError = msgError;
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
}
