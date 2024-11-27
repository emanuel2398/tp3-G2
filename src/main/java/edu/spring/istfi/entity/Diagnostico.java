package edu.spring.istfi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;


public class Diagnostico {
    private Long id;
    private String enfermedad;
    private String observaciones;
    private List<EvolucionClinica> evoluciones;

    public Diagnostico(Long id, String enfermedad, String observaciones) {
        this.id = id;
        this.enfermedad = enfermedad;
        this.observaciones = observaciones;
        this.evoluciones = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public List<EvolucionClinica> getEvoluciones() {
        return Collections.unmodifiableList(evoluciones);
    }


    public void agregarEvolucion(String texto, Medico doctor) {
        EvolucionClinica evolucion = new EvolucionClinica(texto, doctor);

        evoluciones.add(evolucion);
    }
}
