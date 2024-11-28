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

    public Diagnostico buscarDiagnosticoPorId(Long idDiagnostico) {
        return diagnosticos.stream()
                .filter(d -> d.getId().equals(idDiagnostico))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Diagnóstico no encontrado con ID: " + idDiagnostico));
    }
    public void agregarEvolucionADiagnostico(Long idDiagnostico, String texto, Medico medico) {
        Diagnostico diagnostico = buscarDiagnosticoPorId(idDiagnostico);
        diagnostico.agregarEvolucion(texto, medico);
    }

    public void agregarEvolucionADiagnosticoConPedido(Long idDiagnostico, String texto, Medico medico, String textoPedidoLaboratorio) {
        Diagnostico diagnostico = buscarDiagnosticoPorId(idDiagnostico);
        diagnostico.agregarEvolucionConPedido(texto, medico, textoPedidoLaboratorio);
    }

    public void agregarEvolucionADiagnosticoConReceta(Long idDiagnostico, String texto, Medico medico, String dosis, List<Map<String, String>> medicamentos) {
        Diagnostico diagnostico = buscarDiagnosticoPorId(idDiagnostico);
        diagnostico.agregarEvolucionConReceta(texto, medico, dosis, medicamentos);
    }

    public LocalDate getFechaCreado() {
        return fechaCreado;
    }
}
