package edu.spring.istfi.entity;


import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
   public static List<Paciente> inicializarPacientes(List<Medico> medicos) {
       List<Paciente> pacientes = new ArrayList<>();

       Paciente paciente1 = new Paciente(12345678L, "Juan Pérez", "Rivadavia 1050","3886529722","juanperez@gmail.com");
       Paciente paciente2 = new Paciente(87654321L, "María López","España 1400","3863512902","marialopez@gmail.com");

       Diagnostico diagnostico1 = new Diagnostico(1L, "Gripe", "Fiebre y malestar general");
       Diagnostico diagnostico2 = new Diagnostico(2L, "Hipertensión", "Presión arterial elevada");

       diagnostico1.agregarEvolucion("Mejora en síntomas tras tratamiento inicial.", medicos.get(0));
       diagnostico1.agregarEvolucion("Paciente reporta reducción de fiebre.", medicos.get(0));

       paciente1.agregarDiagnostico(diagnostico1);


       Diagnostico diagnostico3 = new Diagnostico(3L, "Diabetes", "Nivel alto de glucosa en sangre");
       diagnostico3.agregarEvolucion("Presión arterial 140/90 mmHg en promedio según monitoreo. ", medicos.get(1));

       paciente2.agregarDiagnostico(diagnostico2);
       paciente2.agregarDiagnostico(diagnostico3);

       pacientes.add(paciente1);
       pacientes.add(paciente2);

       return pacientes;
   }

    public static List<Medico> inicializarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        Medico medico1 = new Medico(87654323L, "Ana Martínez", "d56s4ad", "Medico Clinico");
        Medico medico2 = new Medico(87654325L, "Carlos Gómez", "d56s5ad", "Cardiólogo");
        medicos.add(medico1);
        medicos.add(medico2);
        return medicos;
    }
}