package com.backend.apirest.exception;

public class Response {

    private String mensaje;
    private int error;

    public Response(String mensaje, int error){
        this.mensaje = mensaje;
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getError() {
        return error;
    }
}
