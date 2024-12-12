package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;


public class ObraSocial {
    private static Long contador = 0L;
    private Long idObraSocial;
    private String nombreObraSocial;
    //private List<Paciente> pacientes;


    public ObraSocial(String nombreObraSocial) {
        this.idObraSocial=generarId();
        this.nombreObraSocial = nombreObraSocial;
    }
    private synchronized static Long generarId() {
        return ++contador;
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

    /*public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        if (!this.pacientes.contains(paciente)) {
            this.pacientes.add(paciente);
        }
    }*/
}
