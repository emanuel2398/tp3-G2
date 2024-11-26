package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;

public class EvolucionClinica {
    private String textoLibre;
    private Date fechaYhora;
    private RecetaDigital recetaDigital;
    private PedidoLaboratorio pedidoLaboratorio;

    public EvolucionClinica(String textoLibre) {
        if (textoLibre == null || textoLibre.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la evolución no puede estar vacía.");
        }
        this.textoLibre = textoLibre;
        this.fechaYhora = new Date();
    }

    public String getTextoLibre() {
        return textoLibre;
    }

    public Date getFechaYhora() {
        return fechaYhora;
    }

    public RecetaDigital getRecetaDigital() {
        return recetaDigital;
    }

    public PedidoLaboratorio getPedidoLaboratorio() {
        return pedidoLaboratorio;
    }
    public EvolucionClinica() {}

    // Agregar receta a la evolución
    public void agregarReceta(RecetaDigital receta) {
        if (receta == null) {
            throw new IllegalArgumentException("La receta no puede ser nula.");
        }
        this.recetaDigital = receta;
    }

    // Agregar pedido a la evolución
    public void agregarPedido(PedidoLaboratorio pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        this.pedidoLaboratorio = pedido;
    }
}