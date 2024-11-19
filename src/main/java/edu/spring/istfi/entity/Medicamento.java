package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;
@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    private String nombreComercial;
    private String nombreGenerico;
    private String presentacion;

    @OneToMany(mappedBy = "medicamento")
    private List<RecetaDigital> recetasDigitales;


    public Medicamento(Long idMedicamento, String nombreComercial, String nombreGenerico, String presentacion, List<RecetaDigital> recetasDigitales) {
        this.idMedicamento = idMedicamento;
        this.nombreComercial = nombreComercial;
        this.nombreGenerico = nombreGenerico;
        this.presentacion = presentacion;
        this.recetasDigitales = recetasDigitales;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public List<RecetaDigital> getRecetasDigitales() {
        return recetasDigitales;
    }

    public void setRecetasDigitales(List<RecetaDigital> recetasDigitales) {
        this.recetasDigitales = recetasDigitales;
    }
}
