package edu.spring.istfi.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;
public class Medicamento {

    private String nombreComercial;
    private String nombreGenerico;


    public Medicamento( String nombreComercial, String nombreGenerico) {
        this.nombreComercial = nombreComercial;
        this.nombreGenerico = nombreGenerico;

    }

    public Medicamento() {
    }


    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }


}
