package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.*;

public class RecetaDigital {
    private static Long contador = 0L;
    private Long id;
    private Date fechaHora;
    private String dosis;
    private List<Medicamento> medicamentos;

    public RecetaDigital(String dosis) {
        this.id = generarId();
        this.dosis=dosis;
        this.fechaHora = new Date();
        this.medicamentos = new ArrayList<>();
    }

    public RecetaDigital() {
    }
    private synchronized static Long generarId() {
        return ++contador;
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

    public void agregarMedicamento(List<Map<String, String>> medicamentosData) {
        List<Medicamento> medi = new ArrayList<>();

        for (Map<String, String> medicamentoData : medicamentosData) {
            String nombreComercial = medicamentoData.get("nombreComercial");
            String nombreGenerico = medicamentoData.get("nombreGenerico");
            Medicamento medicamento = new Medicamento(nombreComercial, nombreGenerico);
            medi.add(medicamento);
        }
        medicamentos.addAll(medi);
    }

    public String getDosis() {
        return dosis;
    }
}
