package edu.spring.istfi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;


public class Diagnostico {
    private static Long contador = 0L;
    private Long id;
    private String enfermedad;
    private String observaciones;
    private List<EvolucionClinica> evoluciones;

    public Diagnostico(Long id, String enfermedad, String observaciones) {
        this.id = generarId();
        this.enfermedad = enfermedad;
        this.observaciones = observaciones;
        this.evoluciones = new ArrayList<>();
    }
    private synchronized static Long generarId() {
        return ++contador;
    }

    public Long getId() {
        return id;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public List<EvolucionClinica> getEvoluciones() {
        return Collections.unmodifiableList(evoluciones);
    }


    public void agregarEvolucion(String texto, Medico doctor) {
        EvolucionClinica evolucion = new EvolucionClinica(texto, doctor);

        evoluciones.add(evolucion);
    }
    public void agregarEvolucionConPedido(String texto, Medico medico, String textoPedidoLaboratorio) {

        EvolucionClinica evolucion = new EvolucionClinica(texto, medico);
        PedidoLaboratorio pedidoLaboratorio = new PedidoLaboratorio( textoPedidoLaboratorio);

        evolucion.agregarPedido(pedidoLaboratorio);

        evoluciones.add(evolucion);
    }

    public void agregarEvolucionConReceta(String texto, Medico medico, String dosis, List<Map<String, String>> medicamentosData) {
        // Crear los objetos Medicamento a partir de los datos recibidos
        List<Medicamento> medicamentos = new ArrayList<>();
        for (Map<String, String> medicamentoData : medicamentosData) {
            String nombreComercial = medicamentoData.get("nombreComercial");
            String nombreGenerico = medicamentoData.get("nombreGenerico");

            // Crear un objeto Medicamento y agregarlo a la lista
            Medicamento medicamento = new Medicamento(nombreComercial, nombreGenerico);
            medicamentos.add(medicamento);

            // Verificar que el medicamento se crea correctamente
            System.out.println("Medicamento creado: " + nombreComercial + " - " + nombreGenerico);
        }

        EvolucionClinica evolucion = new EvolucionClinica(texto, medico);

        RecetaDigital receta = new RecetaDigital(dosis);
        receta.agregarMedicamento(medicamentosData);

        // Agregar la receta a la evolución clínica
        evolucion.agregarReceta(receta);

        // Agregar la evolución clínica a la lista de evoluciones
        evoluciones.add(evolucion);
    }
}
