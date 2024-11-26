package edu.spring.istfi.service;

import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.EvolucionClinica;
import edu.spring.istfi.entity.HistoriaClinica;
import edu.spring.istfi.entity.Paciente;
import edu.spring.istfi.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class PacienteService {  private final Repositorio repositorio;
    private final AtomicLong idDiagnosticoCounter = new AtomicLong(1);

    public PacienteService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    // Obtener todos los pacientes
    public List<Paciente> obtenerTodosLosPacientes() {
        return repositorio.obtenerTodosLosPacientes();
    }

    // Buscar paciente por DNI
    public Optional<Paciente> buscarPacientePorDni(Long dni) {
        return repositorio.buscarPacientePorDni(dni);
    }

    // Crear un nuevo paciente
    public void crearPaciente(Paciente nuevoPaciente) {
        Optional<Paciente> pacienteExistente = repositorio.buscarPacientePorDni(nuevoPaciente.getDni());
        if (pacienteExistente.isPresent()) {
            throw new RuntimeException("Ya existe un paciente con el DNI: " + nuevoPaciente.getDni());
        }
        repositorio.guardarPaciente(nuevoPaciente);
    }

    // Agregar diagnóstico a un paciente
    public void agregarDiagnostico(Long dni, String enfermedad, String descripcion) {
        Paciente paciente = repositorio.buscarPacientePorDni(dni)
                .orElseThrow(() -> new RuntimeException("Paciente con DNI " + dni + " no encontrado."));

        if (enfermedad == null || enfermedad.isEmpty()) {
            throw new RuntimeException("Datos incompletos: el diagnóstico debe tener una enfermedad.");
        }

        if (descripcion == null || descripcion.isEmpty()) {
            throw new RuntimeException("Datos incompletos: el diagnóstico debe tener una descripción.");
        }

        Long idDiagnostico = idDiagnosticoCounter.getAndIncrement(); // Generar ID único
        Diagnostico diagnostico = new Diagnostico(idDiagnostico, enfermedad, descripcion);
        paciente.getHistoriaClinica().agregarDiagnostico(diagnostico);
    }

    // Agregar evolución a un diagnóstico
    public void agregarEvolucion(Long dni, Long idDiagnostico, EvolucionClinica evolucion) {
        Paciente paciente = repositorio.buscarPacientePorDni(dni)
                .orElseThrow(() -> new RuntimeException("Paciente con DNI " + dni + " no encontrado."));

        paciente.agregarEvolucionADiagnostico(idDiagnostico, evolucion);
    }

}
