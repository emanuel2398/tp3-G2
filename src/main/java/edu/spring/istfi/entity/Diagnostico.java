package edu.spring.istfi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;


public class Diagnostico {

    private String enfermedad;
    private String descripcion;
    private Date fechaDiagnostico;
    private List<EvolucionClinica> evoluciones; // Relación con evoluciones clínicas

    public Diagnostico(String enfermedad, String descripcion, Date fechaDiagnostico) {
        this.enfermedad = enfermedad;
        this.descripcion = descripcion;
        this.fechaDiagnostico = fechaDiagnostico;
        this.evoluciones = new ArrayList<>();
    }


    public void agregarEvolucion(EvolucionClinica evolucion) {
        if (evolucion == null) {
            throw new IllegalArgumentException("La evolución clínica no puede ser nula.");
        }
        evoluciones.add(evolucion);
    }

    public List<EvolucionClinica> getEvoluciones() {
        return new ArrayList<>(evoluciones);
    }


    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }
}
