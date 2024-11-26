package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;


public class HistoriaClinica {
    private LocalDate fechaCreado;
    private List<Diagnostico> diagnosticos;

    public HistoriaClinica() {
        this.fechaCreado = LocalDate.now();
        this.diagnosticos = new ArrayList<>();
    }

    public void agregarDiagnostico(Diagnostico diagnostico) {
        this.diagnosticos.add(diagnostico);
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public Optional<Diagnostico> buscarDiagnosticoPorId(Long idDiagnostico) {
        return diagnosticos.stream()
                .filter(d -> d.getId().equals(idDiagnostico))
                .findFirst();
    }
    public void agregarEvolucionADiagnostico(Long idDiagnostico, EvolucionClinica evolucion) {
        Diagnostico diagnostico = diagnosticos.stream()
                .filter(d -> d.getId().equals(idDiagnostico))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Diagnóstico no encontrado con ID: " + idDiagnostico));
        diagnostico.agregarEvolucion(evolucion);
    }

    public LocalDate getFechaCreado() {
        return fechaCreado;
    }
}
