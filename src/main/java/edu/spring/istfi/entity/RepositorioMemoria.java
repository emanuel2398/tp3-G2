package edu.spring.istfi.entity;

import edu.spring.istfi.entity.Paciente;
import edu.spring.istfi.repository.Repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioMemoria implements Repositorio {
    private List<Paciente> pacientes = new ArrayList<>();

    @Override
    public Optional<Paciente> buscarPacientePorDni(Long dni) {
        return pacientes.stream()
                .filter(paciente -> paciente.getDni().equals(String.valueOf(dni)))
                .findFirst();
    }
    @Override
    public void guardarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public Optional<Diagnostico> buscarDiagnosticoPorId(Long idDiagnostico) {
        return Optional.empty();
    }

    @Override
    public void guardarDiagnostico(Diagnostico diagnostico) {

    }
}
