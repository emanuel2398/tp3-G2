package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

public class Medico extends Persona {
    private String matricula;
    private String especialidad;


    public Medico() {}

    public Medico(String cuil, String dni, String nombreApellido, String email, String telefono, String direccion,
                  Date fechaDeNacimiento, String username, String password, String matricula, String especialidad) {
        super(cuil, dni, nombreApellido, email, telefono, direccion, fechaDeNacimiento);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}