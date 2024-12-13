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
import java.util.Map;
import java.util.Optional;

public class PacienteServiceTest {
    @Mock
    private Repositorio repositorio;
    @Mock
    private Paciente paciente;
    @Mock
    private Medico medico;
    @Mock
    private Diagnostico diagnostico;
    @Mock
    private EvolucionClinica evolucion;

    private PacienteService pacienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pacienteService = new PacienteService(repositorio);
    }

    @Test
    public void testAgregarEvolucion() {
        Long dni = 123456L;
        Long idDiagnostico = 1L;
        String usernameMedico = "medico1";
        String textoEvolucion = "Mejoría notable en el paciente.";

        when(repositorio.buscarPacientePorDni(dni)).thenReturn(Optional.of(paciente));
        when(repositorio.buscarMedicoPorUsername(usernameMedico)).thenReturn(Optional.of(medico));
        when(paciente.obtenerDiagnosticos()).thenReturn(List.of(diagnostico));

        pacienteService.agregarEvolucion(dni, idDiagnostico, usernameMedico, textoEvolucion);

        verify(paciente).agregarEvolucionADiagnostico(idDiagnostico, textoEvolucion, medico);
        verify(repositorio).actualizarPaciente(paciente);
    }

    @Test
    public void testAgregarEvolucionConPedido() {
        Long dni = 123456L;
        Long idDiagnostico = 1L;
        String usernameMedico = "medico1";
        String textoEvolucion = "Nuevo pedido de laboratorio.";
        String textoPedido = "Pedido para análisis de sangre";

        when(repositorio.buscarPacientePorDni(dni)).thenReturn(Optional.of(paciente));
        when(repositorio.buscarMedicoPorUsername(usernameMedico)).thenReturn(Optional.of(medico));

        pacienteService.agregarEvolucionConPedido(dni, idDiagnostico, usernameMedico, textoEvolucion, textoPedido);

        verify(paciente).agregarEvolucionADiagnosticoConPedido(idDiagnostico, textoEvolucion, medico, textoPedido);
        verify(repositorio).actualizarPaciente(paciente);
    }

    @Test
    public void testAgregarEvolucionConReceta() {
        Long dni = 123456L;
        Long idDiagnostico = 1L;
        String usernameMedico = "medico1";
        String textoEvolucion = "Receta médica";
        String dosis = "500mg";
        List<Map<String, String>> medicamentos = List.of(Map.of("nombreComercial", "Paracetamol", "nombreGenerico", "Paracetamol"));

        when(repositorio.buscarPacientePorDni(dni)).thenReturn(Optional.of(paciente));
        when(repositorio.buscarMedicoPorUsername(usernameMedico)).thenReturn(Optional.of(medico));

        pacienteService.agregarEvolucionConReceta(dni, idDiagnostico, usernameMedico, textoEvolucion, dosis, medicamentos);

        verify(paciente).agregarEvolucionADiagnosticoConReceta(idDiagnostico, textoEvolucion, medico, dosis, medicamentos);
        verify(repositorio).actualizarPaciente(paciente);
    }

    @Test
    public void testPacienteNoEncontrado() {
        Long dni = 123456L;
        Long idDiagnostico = 1L;
        String usernameMedico = "medico1";
        String textoEvolucion = "Evolución de paciente no encontrado.";

        when(repositorio.buscarPacientePorDni(dni)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pacienteService.agregarEvolucion(dni, idDiagnostico, usernameMedico, textoEvolucion);
        });

        assertEquals("Paciente con DNI 123456 no encontrado.", exception.getMessage());
    }


}
