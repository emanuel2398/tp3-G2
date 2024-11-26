package edu.spring.istfi.controller;


import edu.spring.istfi.entity.DataInitializer;
import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.EvolucionClinica;
import edu.spring.istfi.entity.Paciente;
import edu.spring.istfi.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    // Constructor para inyectar el servicio
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Obtener todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosLosPacientes() {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        return ResponseEntity.ok(pacientes);
    }

    // Buscar paciente por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<Paciente> buscarPacientePorDni(@PathVariable Long dni) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorDni(dni);
        return paciente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Crear un paciente
    @PostMapping
    public ResponseEntity<String> crearPaciente(@RequestBody Paciente nuevoPaciente) {
        try {
            pacienteService.crearPaciente(nuevoPaciente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Paciente creado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // Obtener los diagnósticos de un paciente por DNI
    @GetMapping("/{dni}/diagnosticos")
    public ResponseEntity<List<Diagnostico>> obtenerDiagnosticosDePaciente(@PathVariable Long dni) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorDni(dni);
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(paciente.get().obtenerDiagnosticos());
    }

    // Agregar un diagnóstico a un paciente
    /*@PostMapping("/{dni}/diagnosticos")
    public ResponseEntity<String> agregarDiagnostico(@PathVariable Long dni, @RequestBody Diagnostico nuevoDiagnostico) {
        try {
            pacienteService.agregarDiagnostico(dni, nuevoDiagnostico.getEnfermedad(), nuevoDiagnostico.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body("Diagnóstico agregado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }*/

    // Agregar evolución a un diagnóstico de un paciente
    @PostMapping("/{dni}/diagnosticos/{idDiagnostico}/evoluciones")
    public ResponseEntity<String> agregarEvolucion(
            @PathVariable Long dni,
            @PathVariable Long idDiagnostico,
            @RequestBody EvolucionClinica nuevaEvolucion) {
        try {
            pacienteService.agregarEvolucion(dni, idDiagnostico, nuevaEvolucion);
            return ResponseEntity.status(HttpStatus.CREATED).body("Evolución agregada exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
