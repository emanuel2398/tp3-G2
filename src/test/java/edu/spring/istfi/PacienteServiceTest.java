package edu.spring.istfi;
import edu.spring.istfi.entity.*;

import edu.spring.istfi.repository.Repositorio;
import edu.spring.istfi.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

public class PacienteServiceTest {
    @Mock
    private Repositorio repositorio;

    @InjectMocks
    private PacienteService pacienteService;

    private Paciente paciente;
    private Medico medico;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        List<Medico> medicos = DataInitializer.inicializarMedicos();
        
        List<Paciente> pacientes = DataInitializer.inicializarPacientes(medicos);

        // Asumimos que estamos trabajando con el primer paciente
        paciente = pacientes.get(0); // Juan Pérez
        medico = medicos.get(0); // Ana Martínez

        // Simular el comportamiento del repositorio
        when(repositorio.buscarPacientePorDni(12345678L)).thenReturn(Optional.of(paciente));
        when(repositorio.buscarMedicoPorUsername("medic1")).thenReturn(Optional.of(medico));
    }

    @Test
    public void testAgregarEvolucion() {
        String textoEvolucion = "Evolución positiva.";
        Long idDiagnostico = 1L; // Asumimos que este ID ya existe en el paciente

        pacienteService.agregarEvolucion(12345678L, idDiagnostico, "medic1", textoEvolucion);

        // Verificar que se actualizó el paciente en el repositorio
        verify(repositorio).actualizarPaciente(paciente);

        // Verificar que la evolución se ha agregado correctamente
        assertEquals(3, paciente.getHistoriaClinica().getDiagnosticos().get(0).getEvoluciones().size()); // 2 evoluciones previas + 1 nueva
        assertEquals(textoEvolucion, paciente.getHistoriaClinica().getDiagnosticos().get(0).getEvoluciones().get(2).getTextoLibre());
    }
    @Test
    public void testAgregarEvolucionConPedido() {
        String textoEvolucion = "Evolución con pedido.";
        String textoPedido = "Pedido de laboratorio.";
        Long idDiagnostico = 1L;

        pacienteService.agregarEvolucionConPedido(12345678L, idDiagnostico, "medic1", textoEvolucion, textoPedido);

        // Verificar que se actualizó el paciente en el repositorio
        verify(repositorio).actualizarPaciente(paciente);

        // Verificar que la evolución con pedido se ha agregado correctamente (ajusta según tu implementación)
        assertEquals(textoPedido, paciente.getHistoriaClinica().getDiagnosticos().get(0).getEvoluciones().getTextoPedido());
    }
}
