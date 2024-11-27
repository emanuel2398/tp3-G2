package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.*;

public class RecetaDigital {
    private Long id;
    private Date fechaHora;
    private List<Medicamento> medicamentos;

    public RecetaDigital(Long id) {
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

    public void agregarMedicamento(Medicamento medicamento) {
        if (medicamento == null) {
            throw new IllegalArgumentException("El medicamento no puede ser nulo.");
        }
        medicamentos.add(medicamento);
    }


}
