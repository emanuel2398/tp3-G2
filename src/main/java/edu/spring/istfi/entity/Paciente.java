package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
@Entity

public class Paciente extends Persona {
    private String dni;
    private String nombreApellido;
    private HistoriaClinica historiaClinica;
    private String estado;


    public Paciente(String dni, String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.historiaClinica = new HistoriaClinica();
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }
}

