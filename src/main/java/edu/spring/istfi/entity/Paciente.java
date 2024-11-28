package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

public class Paciente {
    private Long dni;
    private String nombreApellido;
    private HistoriaClinica historiaClinica;
    //private String estado;

    public Paciente(Long dni, String nombreApellido) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.historiaClinica = new HistoriaClinica();
     //   this.estado = "Activo";
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

/* public String getEstado() {
        return estado;
    }*/

  /*  public void setEstado(String estado) {
        this.estado = estado;
    }*/

    public Long getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }
    public void agregarDiagnostico(Diagnostico diagnostico) {
        historiaClinica.agregarDiagnostico(diagnostico);
    }

    public void agregarEvolucionADiagnostico(Long idDiagnostico, String texto, Medico medico) {
        historiaClinica.agregarEvolucionADiagnostico(idDiagnostico, texto, medico);
    }
    public void agregarEvolucionADiagnosticoConPedido(Long idDiagnostico, String texto, Medico medico,String textoPedidoLaboratorio) {
        this.historiaClinica.agregarEvolucionADiagnosticoConPedido(idDiagnostico, texto, medico,textoPedidoLaboratorio);
    }
    public void agregarEvolucionADiagnosticoConReceta(Long idDiagnostico, String texto, Medico medico,String dosis,List<Map<String, String>>medicamentos) {
        this.historiaClinica.agregarEvolucionADiagnosticoConReceta(idDiagnostico, texto, medico,dosis,medicamentos);
    }

    public List<Diagnostico> obtenerDiagnosticos() {
        return this.historiaClinica.getDiagnosticos();
    }
}

