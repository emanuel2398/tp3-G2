package edu.spring.istfi.service;

import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.HistoriaClinica;
import edu.spring.istfi.entity.Paciente;
import edu.spring.istfi.repository.Repositorio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteService {
    private final Repositorio repositorio;

    public PacienteService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void agregarDiagnostico(Long dni, String enfermedad, String descripcion) {

        // Buscar al paciente por DNI
        Paciente paciente = repositorio.buscarPacientePorDni(dni)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado."));

        // Verificar que el paciente no esté suspendido
        if ("Suspendido".equalsIgnoreCase(paciente.getEstado())) {
            throw new RuntimeException("El paciente está suspendido y no se puede agregar un diagnóstico.");
        }

        // Validación: si la enfermedad está vacía o nula, lanzar una excepción
        if (enfermedad == null || enfermedad.isEmpty()) {
            throw new RuntimeException("Datos incompletos: el diagnóstico debe tener una enfermedad (CIE10).");
        }

        // Crear el diagnóstico y agregarlo a la historia clínica
        Diagnostico diagnostico = new Diagnostico(enfermedad, descripcion, new Date());
        paciente.getHistoriaClinica().agregarDiagnostico(diagnostico);
    }

}
