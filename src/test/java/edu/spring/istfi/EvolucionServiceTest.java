package edu.spring.istfi;




import edu.spring.istfi.entity.Diagnostico;
import edu.spring.istfi.entity.Medico;
import edu.spring.istfi.repository.Repositorio;
import edu.spring.istfi.service.EvolucionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;
import java.util.Optional;


public class EvolucionServiceTest {
    private Repositorio repositorioMock;
    private EvolucionService evolucionService;

    @BeforeEach
    public void setUp() {
        repositorioMock = mock(Repositorio.class);
        evolucionService = new EvolucionService(repositorioMock);
    }

    @Test
    public void testRegistrarEvolucionExitosamente() {
        // Configurar datos simulados
        Diagnostico diagnostico = new Diagnostico("Neumonía", "Inflamación de los pulmones", new Date());

        // Crear un médico con todos los atributos
        Medico medico = new Medico(
                "20-12345678-9", "12345678","Dr. Martínez","dr.martinez@example.com",  "1234567890", "Calle Ficticia 123",new Date(), "drmartinez", "password123", "12345", "Cardiología"
        );

        when(repositorioMock.buscarDiagnosticoPorId(1L)).thenReturn(Optional.of(diagnostico));


        evolucionService.registrarEvolucion(1L, "El paciente muestra mejoría.", medico);

        verify(repositorioMock).guardarDiagnostico(diagnostico);

        assertEquals(1, diagnostico.getEvoluciones().size());
        assertEquals("El paciente muestra mejoría.", diagnostico.getEvoluciones().get(0).getTextoLibre());
        assertEquals("Dr. Martínez", diagnostico.getEvoluciones().get(0).getMedico().getNombreApellido());
    }
}
