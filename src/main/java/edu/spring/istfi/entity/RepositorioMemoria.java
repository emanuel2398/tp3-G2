package edu.spring.istfi.entity;

import edu.spring.istfi.entity.Paciente;
import edu.spring.istfi.repository.Repositorio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class RepositorioMemoria implements Repositorio {
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    public RepositorioMemoria() {
        medicos = DataInitializer.inicializarMedicos();
        pacientes = DataInitializer.inicializarPacientes(medicos);
    }
    //private List<Paciente> pacientes = new ArrayList<>();
    @Override
    public Optional<Paciente> buscarPacientePorDni(Long dni) {
        return pacientes.stream()
                .filter(p -> p.getDni().equals(dni))
                .findFirst();
    }
    @Override
    public Optional<Medico> buscarMedicoPorDni(Long dni) {
        return medicos.stream()
                .filter(p -> p.getDni().equals(dni))
                .findFirst();
    }
    @Override
    public void guardarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
    @Override
    public void actualizarPaciente(Paciente paciente) {
        buscarPacientePorDni(paciente.getDni())
                .ifPresent(p -> {
                    pacientes.remove(p);
                    pacientes.add(paciente);
                });
    }
    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
        return new ArrayList<>(pacientes);
    }


}
