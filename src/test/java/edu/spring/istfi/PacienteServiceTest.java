package edu.spring.istfi;
import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.EvolucionClinica;
import edu.spring.istfi.entity.Paciente;

import edu.spring.istfi.repository.Repositorio;
import edu.spring.istfi.service.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

public class PacienteServiceTest {
    private Repositorio repositorioPaciente;
    private PacienteService servicio;

    @BeforeEach
    public void before() {
        repositorioPaciente = mock(Repositorio.class);
        servicio = new PacienteService(repositorioPaciente);
    }

    @Test
    public void testAgregarDiagnostico() {
        Paciente paciente = new Paciente("12345678", "Juan Pérez");
        when(repositorioPaciente.buscarPacientePorDni(12345678L)).thenReturn(Optional.of(paciente));
        servicio.agregarDiagnostico(12345678L, "Dengue", "Fiebre alta y dolor de cabeza");
        assertEquals(1, paciente.getHistoriaClinica().getDiagnosticos().size());
        assertEquals("Dengue", paciente.getHistoriaClinica().getDiagnosticos().get(0).getEnfermedad());
        verify(repositorioPaciente, never()).guardarPaciente(any());
    }

    @Test
    public void testAgregarDiagnosticoConEnfermedadVacia() {
        Paciente paciente = new Paciente("12345678", "Juan Pérez");
        when(repositorioPaciente.buscarPacientePorDni(12345678L)).thenReturn(Optional.of(paciente));
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                servicio.agregarDiagnostico(12345678L, "", "Fiebre alta y dolor de cabeza")
        );

        assertEquals("Datos incompletos: el diagnóstico debe tener una enfermedad (CIE10).", exception.getMessage());

        verify(repositorioPaciente, never()).guardarPaciente(any());
    }
}
