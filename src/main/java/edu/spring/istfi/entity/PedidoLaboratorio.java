package edu.spring.istfi.entity;

import java.util.Date;

public class PedidoLaboratorio {
    private static Long contador = 0L;
    private Long id;
    private String texto;

    public PedidoLaboratorio(String texto) {
        this.id = generarId();
        this.texto = texto;
    }
    private synchronized static Long generarId() {
        return ++contador;
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
