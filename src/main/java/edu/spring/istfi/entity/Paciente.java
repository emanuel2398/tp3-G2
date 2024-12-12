package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

public class Paciente {
    private Long dni;
    private String nombreApellido;
    private HistoriaClinica historiaClinica;
    private String direccion;
    private String telefono;
    private String email;

    private ObraSocial obraSocial;


    public Paciente(Long dni, String nombreApellido,String direccion,String telefono,String email,ObraSocial obraSocial) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.historiaClinica = new HistoriaClinica();
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
        this.obraSocial=obraSocial;

    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }




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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }
}

