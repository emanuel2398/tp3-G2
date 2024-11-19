package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
@Entity
public class RecetaDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaHora;
    private String codigoBarras;
    private String firmaElectronica;
    private String logoEmpresa;
    private String piePagina;
    private String qr;

    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    // Getters y Setters


    public RecetaDigital(Long id, Date fechaHora, String codigoBarras, String firmaElectronica, String logoEmpresa, String piePagina, String qr, Medicamento medicamento) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.codigoBarras = codigoBarras;
        this.firmaElectronica = firmaElectronica;
        this.logoEmpresa = logoEmpresa;
        this.piePagina = piePagina;
        this.qr = qr;
        this.medicamento = medicamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getFirmaElectronica() {
        return firmaElectronica;
    }

    public void setFirmaElectronica(String firmaElectronica) {
        this.firmaElectronica = firmaElectronica;
    }

    public String getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(String logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    public String getPiePagina() {
        return piePagina;
    }

    public void setPiePagina(String piePagina) {
        this.piePagina = piePagina;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
