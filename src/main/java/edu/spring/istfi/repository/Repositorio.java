package edu.spring.istfi.repository;

import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.Paciente;

import java.util.Optional;

public interface Repositorio {
    Optional<Paciente> buscarPacientePorDni(Long dni);
    void guardarPaciente(Paciente paciente);

    Optional<Diagnostico> buscarDiagnosticoPorId(Long idDiagnostico);
    void guardarDiagnostico(Diagnostico diagnostico);
}
