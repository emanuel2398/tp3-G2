package edu.spring.istfi.controller;


import edu.spring.istfi.entity.*;
import edu.spring.istfi.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping("/medicos/{dni}")
    public ResponseEntity<Medico> buscarMedicoPorDni(@PathVariable Long dni) {
        try {
            Medico medico = pacienteService.buscarMedicoPorDni(dni);
            return ResponseEntity.ok(medico);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodosLosPacientes() {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Paciente> buscarPacientePorDni(@PathVariable Long dni) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorDni(dni);
        return paciente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<String> crearPaciente(@RequestBody Paciente nuevoPaciente) {
        try {
            pacienteService.crearPaciente(nuevoPaciente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Paciente creado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{dni}/diagnosticos")
    public ResponseEntity<List<Diagnostico>> obtenerDiagnosticosDePaciente(@PathVariable Long dni) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorDni(dni);
        if (paciente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(paciente.get().obtenerDiagnosticos());
    }

    // Agregar un diagnóstico
    /*@PostMapping("/{dni}/diagnosticos")
    public ResponseEntity<String> agregarDiagnostico(@PathVariable Long dni, @RequestBody Diagnostico nuevoDiagnostico) {
        try {
            pacienteService.agregarDiagnostico(dni, nuevoDiagnostico.getEnfermedad(), nuevoDiagnostico.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body("Diagnóstico agregado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }*/

    // Agregar evolución
    @PostMapping("/{dni}/diagnosticos/{idDiagnostico}/evoluciones")
    public ResponseEntity<String> agregarEvolucion(
            @PathVariable Long dni,
            @PathVariable Long idDiagnostico,
            @RequestBody Map<String, Object> request) {
        try {
            Long dniMedico = Long.parseLong(request.get("dniMedico").toString());//extraigo el dni de medico de json
            String texto = request.get("texto").toString();//extraigo el texto del json

            pacienteService.agregarEvolucion(dni, idDiagnostico, dniMedico, texto);// llamo al servicio paciente para agregar mi evolucion
            return ResponseEntity.status(HttpStatus.CREATED).body("Evolución agregada exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{dni}/diagnosticos/{idDiagnostico}/evoluciones/pedidoLaboratorio")
    public ResponseEntity<String> agregarEvolucionConPedido(
            @PathVariable Long dni,
            @PathVariable Long idDiagnostico,
            @RequestBody Map<String, Object> request) {
        try {
            String texto = request.get("texto").toString();
            Long dniMedico = Long.parseLong(request.get("dniMedico").toString());
            String textoPedidoLaboratorio = request.get("textoPedidoLaboratorio").toString();
            pacienteService.agregarEvolucionconPedido(dni, idDiagnostico, dniMedico, texto,textoPedidoLaboratorio);
            return ResponseEntity.status(HttpStatus.CREATED).body("Evolución con pedido de laboratorio agregada exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/{dni}/diagnosticos/{idDiagnostico}/evoluciones/receta")
    public ResponseEntity<String> agregarEvolucionConReceta(
            @PathVariable Long dni,
            @PathVariable Long idDiagnostico,
            @RequestBody Map<String, Object> request) {
        try {
            String texto = request.get("texto").toString();
            Long dniMedico = Long.parseLong(request.get("dniMedico").toString());
            String dosis = request.get("dosis").toString();  // Dosis común para todos los medicamentos

            // Obtener la lista de medicamentos, donde cada uno es un objeto Medicamento
            List<Map<String, String>> medicamentos =  (List<Map<String, String>>) request.get("medicamento");

            // Procesamos la lógica de la evolución y el pedido de laboratorio
            pacienteService.agregarEvolucionconReceta(dni, idDiagnostico, dniMedico, texto, dosis, medicamentos);

            return ResponseEntity.status(HttpStatus.CREATED).body("Evolución con pedido de laboratorio agregada exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
