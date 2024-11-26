package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;
public class Paciente {
    private Long dni;
    private String nombreApellido;
    private HistoriaClinica historiaClinica;
    //private String estado;

    public Paciente(Long dni, String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.historiaClinica = new HistoriaClinica();
     //   this.estado = "Activo";
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

   /* public String getEstado() {
        return estado;
    }*/

  /*  public void setEstado(String estado) {
        this.estado = estado;
    }*/

    public Long getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }
    public void agregarDiagnostico(Diagnostico diagnostico) {
        historiaClinica.agregarDiagnostico(diagnostico);
    }

    public void agregarEvolucionADiagnostico(Long idDiagnostico, EvolucionClinica evolucion) {
        historiaClinica.agregarEvolucionADiagnostico(idDiagnostico, evolucion);
    }

    public List<Diagnostico> obtenerDiagnosticos() {
        return this.historiaClinica.getDiagnosticos();
    }
}

