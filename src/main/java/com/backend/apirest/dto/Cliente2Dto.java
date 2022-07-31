package com.backend.apirest.dto;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Positive;
import java.util.Date;

public class Cliente2Dto {

    @Range(min = 1, max = 150, message = "El rango de edad debe estar entre 1-150.")
    private int edad;

    @Positive(message = "Estatura debe ser numerico mayor a 0")
    private double estatura;

    @Positive(message = "Peso debe ser numerico mayor a 0")
    private double peso;

    @Positive(message = "GEB debe ser numerico mayor a 0")
    private double geb;

    private Date fechaActualizacion = new Date();

    public Cliente2Dto() { }

    public Cliente2Dto(int edad, double estatura, double peso, double imc, double geb, double eta) {
        super();
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
        this.geb = geb;
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

    public double getGeb() {
        return geb;
    }

    public void setGeb(double geb) {
        this.geb = geb;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
