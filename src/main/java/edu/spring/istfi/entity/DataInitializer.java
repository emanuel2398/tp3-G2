package edu.spring.istfi.entity;


import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
    public static List<Paciente> inicializarDatos() {
        List<Paciente> pacientes = new ArrayList<>();

        // Crear pacientes
        Paciente paciente1 = new Paciente(12345678L, "Juan Pérez");
        Paciente paciente2 = new Paciente(87654321L, "María López");

        // Crear diagnósticos para el primer paciente
        Diagnostico diagnostico1 = new Diagnostico(1L, "Gripe", "Fiebre y malestar general");
        Diagnostico diagnostico2 = new Diagnostico(2L, "Hipertensión", "Presión arterial elevada");

        // Crear evoluciones para el diagnóstico de gripe
        EvolucionClinica evolucion1 = new EvolucionClinica("Mejora en síntomas tras tratamiento inicial.");
        EvolucionClinica evolucion2 = new EvolucionClinica("Paciente reporta reducción de fiebre.");

        diagnostico1.agregarEvolucion(evolucion1);
        diagnostico1.agregarEvolucion(evolucion2);

        // Crear recetas digitales para la primera evolución
        RecetaDigital receta1 = new RecetaDigital(1L);
        receta1.agregarMedicamento(new Medicamento(1L, "Paracetamol", "Paracetamol", "Tabletas 500 mg"));
        receta1.agregarMedicamento(new Medicamento(2L, "Ibuprofeno", "Ibuprofeno", "Cápsulas 200 mg"));
        evolucion1.agregarReceta(receta1);

        // Crear un pedido de laboratorio para la segunda evolución
        PedidoLaboratorio pedido1 = new PedidoLaboratorio(1L, "Hemograma completo");
        evolucion2.agregarPedido(pedido1);

        // Agregar diagnósticos al paciente 1
        paciente1.agregarDiagnostico(diagnostico1);
        paciente1.agregarDiagnostico(diagnostico2);

        // Crear diagnóstico para el paciente 2
        Diagnostico diagnostico3 = new Diagnostico(3L, "Diabetes", "Nivel alto de glucosa en sangre");

        // Crear evolución para el diagnóstico de diabetes
        EvolucionClinica evolucion3 = new EvolucionClinica("Control inicial con dieta y ejercicio.");
        diagnostico3.agregarEvolucion(evolucion3);

        // Crear recetas digitales para la evolución del paciente 2
        RecetaDigital receta2 = new RecetaDigital(2L);
        receta2.agregarMedicamento(new Medicamento(3L, "Metformina", "Metformina", "Tabletas 850 mg"));
        evolucion3.agregarReceta(receta2);

        // Crear un pedido de laboratorio para la evolución del paciente 2
        PedidoLaboratorio pedido2 = new PedidoLaboratorio(2L, "Prueba de glucosa en ayunas");
        evolucion3.agregarPedido(pedido2);

        // Agregar diagnóstico al paciente 2
        paciente2.agregarDiagnostico(diagnostico3);

        // Agregar pacientes a la lista
        pacientes.add(paciente1);
        pacientes.add(paciente2);

        return pacientes;
    }
}