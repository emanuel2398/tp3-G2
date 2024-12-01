package edu.spring.istfi.service;

import edu.spring.istfi.entity.*;
import edu.spring.istfi.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class PacienteService {  private final Repositorio repositorio;
    private final AtomicLong idDiagnosticoCounter = new AtomicLong(1);

    public PacienteService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return repositorio.obtenerTodosLosPacientes();
    }

    public Optional<Paciente> buscarPacientePorDni(Long dni) {
        return repositorio.buscarPacientePorDni(dni);
    }

    public void crearPaciente(Paciente nuevoPaciente) {
        Optional<Paciente> pacienteExistente = repositorio.buscarPacientePorDni(nuevoPaciente.getDni());
        if (pacienteExistente.isPresent()) {
            throw new RuntimeException("Ya existe un paciente con el DNI: " + nuevoPaciente.getDni());
        }
        repositorio.guardarPaciente(nuevoPaciente);
    }

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
    public Medico buscarMedicoPorDni(Long dni) {
        return repositorio.buscarMedicoPorDni(dni)
                .orElseThrow(() -> new RuntimeException("Médico con DNI " + dni + " no encontrado."));
    }

    // Agregar evolución
    public void agregarEvolucion(Long dni, Long idDiagnostico, Long dniMedico, String texto) {
        Paciente paciente = obtenerPacientePorDni(dni);
        Medico medico = obtenerMedicoPorDni(dniMedico);

        paciente.agregarEvolucionADiagnostico(idDiagnostico, texto, medico);
        repositorio.actualizarPaciente(paciente);
    }

    public void agregarEvolucionConPedido(Long dni, Long idDiagnostico, Long dniMedico, String texto, String textoPedidoLaboratorio) {
        Paciente paciente = obtenerPacientePorDni(dni);
        Medico medico = obtenerMedicoPorDni(dniMedico);

        paciente.agregarEvolucionADiagnosticoConPedido(idDiagnostico, texto, medico, textoPedidoLaboratorio);
        repositorio.actualizarPaciente(paciente);
    }

    public void agregarEvolucionConReceta(Long dni, Long idDiagnostico, Long dniMedico, String texto, String dosis, List<Map<String, String>> medicamentos) {
        Paciente paciente = obtenerPacientePorDni(dni);
        Medico medico = obtenerMedicoPorDni(dniMedico);

        paciente.agregarEvolucionADiagnosticoConReceta(idDiagnostico, texto, medico, dosis, medicamentos);
        repositorio.actualizarPaciente(paciente);
    }

    // Métodos auxiliares para evitar redundancia
    private Paciente obtenerPacientePorDni(Long dni) {
        return repositorio.buscarPacientePorDni(dni)
                .orElseThrow(() -> new RuntimeException("Paciente con DNI " + dni + " no encontrado."));
    }

    private Medico obtenerMedicoPorDni(Long dniMedico) {
        return repositorio.buscarMedicoPorDni(dniMedico)
                .orElseThrow(() -> new RuntimeException("Médico con DNI " + dniMedico + " no encontrado."));
    }




}
