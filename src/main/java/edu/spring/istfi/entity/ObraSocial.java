package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;


public class ObraSocial {
    private Long idObraSocial;
    private String nombreObraSocial;
    private List<Paciente> pacientes;


    public ObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }

    public Long getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(Long idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public String getNombreObraSocial() {
        return nombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        if (!this.pacientes.contains(paciente)) {
            this.pacientes.add(paciente);
        }
    }
}
