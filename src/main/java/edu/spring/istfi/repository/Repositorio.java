package edu.spring.istfi.repository;

import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.Medico;
import edu.spring.istfi.entity.Paciente;
import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface Repositorio {

    Optional<Paciente> buscarPacientePorDni(Long dni);
    Optional<Medico> buscarMedicoPorDni(Long dni);
    List<Paciente> obtenerTodosLosPacientes();
    void guardarPaciente(Paciente paciente);
    void actualizarPaciente(Paciente paciente);

    Optional<Medico> buscarMedicoPorUsername(String username);
}
