package edu.spring.istfi.entity;

import java.util.Date;

public class PedidoLaboratorio {
    private Long id;
    private String texto;

    public PedidoLaboratorio(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
