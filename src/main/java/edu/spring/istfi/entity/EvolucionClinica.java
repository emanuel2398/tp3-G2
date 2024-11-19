package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
@Entity
public class EvolucionClinica {
    private String textoLibre;
    private Date fechaYhora;
    private Medico medico;


    public EvolucionClinica(String textoLibre, Medico medico) {
        if (textoLibre == null || textoLibre.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la evolución no puede estar vacía.");
        }
        if (medico == null) {
            throw new IllegalArgumentException("La evolución debe estar asociada a un médico.");
        }
        this.textoLibre = textoLibre;
        this.fechaYhora = new Date();
        this.medico = medico;
    }

    public String getTextoLibre() {
        return textoLibre;
    }

    public Date getFechaYhora() {
        return fechaYhora;
    }

    public Medico getMedico() {
        return medico;
    }
}