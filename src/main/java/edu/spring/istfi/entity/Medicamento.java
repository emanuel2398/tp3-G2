package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;
public class Medicamento {
    private Long idMedicamento;
    private String nombreComercial;
    private String nombreGenerico;
    private String presentacion;

    public Medicamento(Long idMedicamento, String nombreComercial, String nombreGenerico, String presentacion) {
        if (nombreComercial == null || nombreComercial.isEmpty()) {
            throw new IllegalArgumentException("El nombre comercial no puede estar vacío.");
        }
        if (nombreGenerico == null || nombreGenerico.isEmpty()) {
            throw new IllegalArgumentException("El nombre genérico no puede estar vacío.");
        }
        this.idMedicamento = idMedicamento;
        this.nombreComercial = nombreComercial;
        this.nombreGenerico = nombreGenerico;
        this.presentacion = presentacion;
    }

    public Medicamento() {
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public String getPresentacion() {
        return presentacion;
    }
}
