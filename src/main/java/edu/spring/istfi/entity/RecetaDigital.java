package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.*;

public class RecetaDigital {
    private Long id;
    private Date fechaHora;
    private List<Medicamento> medicamentos;

    public RecetaDigital(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo.");
        }
        this.id = id;
        this.fechaHora = new Date();
        this.medicamentos = new ArrayList<>();
    }

    public RecetaDigital() {
    }

    public Long getId() {
        return id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Medicamento> getMedicamentos() {
        return Collections.unmodifiableList(medicamentos);
    }

    // Agregar un medicamento a la receta
    public void agregarMedicamento(Medicamento medicamento) {
        if (medicamento == null) {
            throw new IllegalArgumentException("El medicamento no puede ser nulo.");
        }
        medicamentos.add(medicamento);
    }

    // Opcional: Método para obtener información de todos los medicamentos
    public String listarMedicamentos() {
        StringBuilder sb = new StringBuilder();
        for (Medicamento med : medicamentos) {
            sb.append("ID: ").append(med.getIdMedicamento())
                    .append(", Nombre: ").append(med.getNombreComercial())
                    .append("\n");
        }
        return sb.toString();
    }
}
