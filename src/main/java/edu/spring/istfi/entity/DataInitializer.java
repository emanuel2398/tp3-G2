package edu.spring.istfi.entity;


import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
   /* public static List<Paciente> inicializarDatos() {
        List<Paciente> pacientes = new ArrayList<>();

        Paciente paciente1 = new Paciente(12345678L, "Juan Pérez");
        Paciente paciente2 = new Paciente(87654321L, "María López");

        Medico medico1 = new Medico(87654323L, "Ana Martínez", "d56s4ad", "Cirujano");
        Medico medico2 = new Medico(87654325L, "Carlos Gómez", "d56s5ad", "Cardiólogo");

        Diagnostico diagnostico1 = new Diagnostico(1L, "Gripe", "Fiebre y malestar general");
        Diagnostico diagnostico2 = new Diagnostico(2L, "Hipertensión", "Presión arterial elevada");

        //EvolucionClinica evolucion1 = new EvolucionClinica("Mejora en síntomas tras tratamiento inicial.", medico1);
       // EvolucionClinica evolucion2 = new EvolucionClinica("Paciente reporta reducción de fiebre.", medico2);


        diagnostico1.agregarEvolucion("Mejora en síntomas tras tratamiento inicial.", medico1);
        diagnostico1.agregarEvolucion("Paciente reporta reducción de fiebre.", medico2);


        RecetaDigital receta1 = new RecetaDigital(1L);
        receta1.agregarMedicamento(new Medicamento(1L, "Paracetamol", "Paracetamol", "Tabletas 500 mg"));
        receta1.agregarMedicamento(new Medicamento(2L, "Ibuprofeno", "Ibuprofeno", "Cápsulas 200 mg"));
        //evolucion1.agregarReceta(receta1);

        PedidoLaboratorio pedido1 = new PedidoLaboratorio(1L, "Hemograma completo");
        //evolucion2.agregarPedido(pedido1);

        paciente1.agregarDiagnostico(diagnostico1);
        paciente1.agregarDiagnostico(diagnostico2);

        Diagnostico diagnostico3 = new Diagnostico(3L, "Diabetes", "Nivel alto de glucosa en sangre");

       // EvolucionClinica evolucion3 = new EvolucionClinica("Control inicial con dieta y ejercicio.", medico1);
        diagnostico3.agregarEvolucion("Control inicial con dieta y ejercicio.", medico1);

        RecetaDigital receta2 = new RecetaDigital(2L);
        receta2.agregarMedicamento(new Medicamento(3L, "Metformina", "Metformina", "Tabletas 850 mg"));
        //evolucion3.agregarReceta(receta2);

        PedidoLaboratorio pedido2 = new PedidoLaboratorio(2L, "Prueba de glucosa en ayunas");
        //evolucion3.agregarPedido(pedido2);

        paciente2.agregarDiagnostico(diagnostico3);

        pacientes.add(paciente1);
        pacientes.add(paciente2);

        return pacientes;
    }*/
   public static List<Paciente> inicializarPacientes(List<Medico> medicos) {
       List<Paciente> pacientes = new ArrayList<>();

       // Crear pacientes
       Paciente paciente1 = new Paciente(12345678L, "Juan Pérez");
       Paciente paciente2 = new Paciente(87654321L, "María López");

       // Crear diagnósticos
       Diagnostico diagnostico1 = new Diagnostico(1L, "Gripe", "Fiebre y malestar general");
       Diagnostico diagnostico2 = new Diagnostico(2L, "Hipertensión", "Presión arterial elevada");

       // Asociar médicos a las evoluciones clínicas de los diagnósticos
       diagnostico1.agregarEvolucion("Mejora en síntomas tras tratamiento inicial.", medicos.get(0));  // medico1
       diagnostico1.agregarEvolucion("Paciente reporta reducción de fiebre.", medicos.get(1));  // medico2

       paciente1.agregarDiagnostico(diagnostico1);
       paciente1.agregarDiagnostico(diagnostico2);

       Diagnostico diagnostico3 = new Diagnostico(3L, "Diabetes", "Nivel alto de glucosa en sangre");
       diagnostico3.agregarEvolucion("Control inicial con dieta y ejercicio.", medicos.get(0)); // medico1

       paciente2.agregarDiagnostico(diagnostico3);

       pacientes.add(paciente1);
       pacientes.add(paciente2);

       return pacientes;
   }

    // Método para inicializar médicos
    public static List<Medico> inicializarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        Medico medico1 = new Medico(87654323L, "Ana Martínez", "d56s4ad", "Cirujano");
        Medico medico2 = new Medico(87654325L, "Carlos Gómez", "d56s5ad", "Cardiólogo");

        medicos.add(medico1);
        medicos.add(medico2);

        return medicos;
    }
}