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

    public Diagnostico(String enfermedad, String observaciones) {
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


    public void agregarEvolucion(String texto, Medico medico) {
        EvolucionClinica evolucion = new EvolucionClinica(texto, medico);

        evoluciones.add(evolucion);
    }
    public void agregarEvolucionConPedido(String texto, Medico medico, String textoPedidoLaboratorio) {

        EvolucionClinica evolucion = new EvolucionClinica(texto, medico);
        PedidoLaboratorio pedidoLaboratorio = new PedidoLaboratorio( textoPedidoLaboratorio);

        evolucion.agregarPedido(pedidoLaboratorio);

        evoluciones.add(evolucion);
    }

    public void agregarEvolucionConReceta(String texto, Medico medico, String dosis, List<Map<String, String>> medicamentosData) {
        List<Medicamento> medicamentos = new ArrayList<>();
        for (Map<String, String> medicamentoData : medicamentosData) {
            String nombreComercial = medicamentoData.get("nombreComercial");
            String nombreGenerico = medicamentoData.get("nombreGenerico");

            Medicamento medicamento = new Medicamento(nombreComercial, nombreGenerico);
            medicamentos.add(medicamento);
        }

        EvolucionClinica evolucion = new EvolucionClinica(texto, medico);

        RecetaDigital receta = new RecetaDigital(dosis);
        receta.agregarMedicamento(medicamentosData);

        evolucion.agregarReceta(receta);
        evoluciones.add(evolucion);
    }
}
