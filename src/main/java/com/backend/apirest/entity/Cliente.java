package com.backend.apirest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_usuario", length = 30, nullable = false)
    private String nombreUsuario;

    @Column(name = "Contrasena", length = 30, nullable = false)
    private String contrasena;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 150, nullable = false)
    private String apellidos;

    @Column(name = "correo_electronico", length = 100, nullable = false)
    private String correoE;

    @Column(name = "edad", scale = 3)
    private int edad;

    @Column(name = "estatura", precision = 4)
    private double estatura;

    @Column(name = "peso", precision = 4)
    private double peso;

    @Column(name = "imc", precision = 4)
    private double imc;

    @Column(name = "geb", precision = 4)
    private double geb;

    @Column(name = "eta", precision = 4)
    private double eta;

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "fecha_eliminacion")
    @Temporal(TemporalType.DATE)
    private Date fechaEliminacion;

    public Cliente() { }

    public Cliente(String nombreUsuario, String contrasena, String nombre, String apellidos, String correoE,
                   int edad, double estatura, double peso, double imc, double geb, double eta, Date fechaCreacion) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoE = correoE;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
        this.imc = imc;
        this.geb = geb;
        this.eta = eta;
        this.fechaCreacion = fechaCreacion;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getGeb() {
        return geb;
    }

    public void setGeb(double geb) {
        this.geb = geb;
    }

    public double getEta() {
        return eta;
    }

    public void setEta(double eta) {
        this.eta = eta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }
    public static final long serialVersionUID = 1L;
}
