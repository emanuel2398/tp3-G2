package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;


public class HistoriaClinica {
    private List<Diagnostico> diagnosticos;

    public HistoriaClinica() {
        this.diagnosticos = new ArrayList<>();
    }

    public void agregarDiagnostico(Diagnostico diagnostico) {
        this.diagnosticos.add(diagnostico);
    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }
}
