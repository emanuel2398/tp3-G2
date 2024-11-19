package edu.spring.istfi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
@Entity

public class Recepcionista extends Usuario {
    public Recepcionista() {}

    public Recepcionista(String cuil, String dni, String nombreApellido, String email, String telefono, String direccion,
                         Date fechaDeNacimiento, String username, String password) {
        super(cuil, dni, nombreApellido, email, telefono, direccion, fechaDeNacimiento, username, password);
    }

    @Override
    public String getRole() {
        return "Recepcionista";
    }


}