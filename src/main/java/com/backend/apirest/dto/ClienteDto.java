package com.backend.apirest.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class ClienteDto {

    @NotEmpty(message = "Usuario no debe ser nulo")
    private String nombreUsuario;

    @NotEmpty(message = "Contraseña no debe ser nulo")
    private String contrasena;

    @NotEmpty(message = "Nombre no debe ser nulo")
    private String nombre;

    @NotEmpty(message = "Apellidos no debe ser nulo")
    private String apellidos;

    @Email(message = "Email invalido")
    @NotEmpty(message = "Correo no debe ser nulo")
    private String correoE;

    private Date fechaCreacion = new Date();

    public ClienteDto() { }

    public ClienteDto(String nombreUsuario, String contrasena, String nombre, String apellidos, String correoE) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoE = correoE;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}
