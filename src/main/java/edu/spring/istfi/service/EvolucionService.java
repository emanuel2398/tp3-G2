package edu.spring.istfi.service;

import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.EvolucionClinica;
import edu.spring.istfi.entity.Medico;
import edu.spring.istfi.repository.Repositorio;

import java.util.Optional;

public class EvolucionService {
    private Repositorio repositorio;

    public EvolucionService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarEvolucion(Long diagnosticoId, String descripcionEvolucion, Medico medico) {
        if (descripcionEvolucion == null || descripcionEvolucion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la evolución no puede estar vacía.");
        }
        if (medico == null) {
            throw new IllegalArgumentException("La evolución debe estar asociada a un médico.");
        }

        Optional<Diagnostico> diagnosticoOptional = repositorio.buscarDiagnosticoPorId(diagnosticoId);

        if (diagnosticoOptional.isEmpty()) {
            throw new RuntimeException("Diagnóstico no encontrado.");
        }

        Diagnostico diagnostico = diagnosticoOptional.get();

        EvolucionClinica evolucion = new EvolucionClinica(descripcionEvolucion, medico);
        diagnostico.agregarEvolucion(evolucion);

        repositorio.guardarDiagnostico(diagnostico);

        System.out.println("Se registró la evolución exitosamente.");
    }
}
